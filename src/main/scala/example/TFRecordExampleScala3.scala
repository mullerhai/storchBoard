package example

import org.tensorflow.framework.summary.{Summary, SummaryMetadata}
import org.tensorflow.framework.tensor.TensorProto
import org.tensorflow.framework.tensor_shape.TensorShapeProto
import org.tensorflow.framework.types.DataType
import org.tensorflow.util.event.Event
import java.io.{DataInputStream, DataOutputStream, FileInputStream, FileOutputStream}
import java.nio.ByteBuffer
import java.util.zip.CRC32

object TFRecordExampleScala3 extends App {
  val logDir = "logz"
  val logFilePath = s"$logDir/train_scala3.tfevents"

  // 写入日志文件
  writeToLogFile(logFilePath)

  // 读取日志文件
  readFromLogFile(logFilePath)

  def writeToLogFile(filePath: String): Unit = {
    val fileOutputStream = new FileOutputStream(filePath)
    val dataOutputStream = new DataOutputStream(fileOutputStream)

    try {
      // 模拟训练过程
      val numSteps = 50
      for (step <- 0L until numSteps) {
        // 模拟 loss 和 accuracy
        val loss = Math.exp(-step / 10.0)
        val accuracy = 1 - 0.5 * Math.exp(-step / 20.0)

        // 记录 loss
        writeEvent(dataOutputStream, "Loss/train", loss, step)
        // 记录 accuracy
        writeEvent(dataOutputStream, "Accuracy/train", accuracy, step)
      }
    } finally {
      dataOutputStream.close()
    }
  }

  private def writeEvent(outputStream: DataOutputStream, tag: String, value: Double, step: Long): Unit = {
    // 创建 TensorProto 表示标量值
    val tensorProto = TensorProto(
      dtype = DataType.DT_FLOAT,
      tensorShape = Some(TensorShapeProto()),
      floatVal = Seq(value.toFloat)
    )

    // 创建 SummaryMetadata
    val metadata = SummaryMetadata()

    // 创建 SummaryValue
    val summaryValue = Summary.Value(
      tag = tag,
      metadata = Some(metadata),
      value = Summary.Value.Value.Tensor(tensorProto)
    )

    // 创建 Summary
    val summary = Summary(
      value = Seq(summaryValue)
    )

    // 创建 Event 消息
    val event = Event(
      wallTime = System.currentTimeMillis() / 1000.0,
      step = step,
      what = Event.What.Summary(summary)
    )

    // 序列化 Event 为字节数组
    val serializedEvent = event.toByteArray

    // 写入记录长度
    val length = serializedEvent.length.toLong
    val lengthBytes = ByteBuffer.allocate(8).putLong(length).array()
    outputStream.write(lengthBytes)

    // 写入长度的 CRC 校验
    val lengthCrc = calculateCrc(lengthBytes)
    outputStream.writeInt(lengthCrc)

    // 写入数据
    outputStream.write(serializedEvent)

    // 写入数据的 CRC 校验
    val dataCrc = calculateCrc(serializedEvent)
    outputStream.writeInt(dataCrc)
  }

  private def calculateCrc(data: Array[Byte]): Int = {
    val crc32 = new CRC32()
    crc32.update(data)
    (crc32.getValue & 0xFFFFFFFFL).toInt
  }

  def readFromLogFile(filePath: String): Unit = {
    val fileInputStream = new FileInputStream(filePath)
    val dataInputStream = new DataInputStream(fileInputStream)

    try {
      while (dataInputStream.available() > 0) {
        // 读取记录长度
        val lengthBytes = new Array[Byte](8)
        dataInputStream.readFully(lengthBytes)
        val lengthBuffer = ByteBuffer.wrap(lengthBytes)
        val length = lengthBuffer.getLong()

        // 读取长度的 CRC 校验
        val expectedLengthCrc = dataInputStream.readInt()
        val actualLengthCrc = calculateCrc(lengthBytes)
        if (expectedLengthCrc != actualLengthCrc) {
          throw new RuntimeException("Length CRC mismatch")
        }

        // 读取数据
        val data = new Array[Byte](length.toInt)
        dataInputStream.readFully(data)

        // 读取数据的 CRC 校验
        val expectedDataCrc = dataInputStream.readInt()
        val actualDataCrc = calculateCrc(data)
        if (expectedDataCrc != actualDataCrc) {
          throw new RuntimeException("Data CRC mismatch")
        }

        // 解析 Event
        val event = Event.parseFrom(data)
        event.what match {
          case Event.What.Summary(summary) =>
            summary.value.foreach { summaryValue =>
              summaryValue.value match {
                case Summary.Value.Value.Tensor(tensorProto) =>
                  tensorProto.floatVal.headOption.foreach { floatValue =>
                    println(s"Step: ${event.step}, Tag: ${summaryValue.tag}, Value: $floatValue")
                  }
                case _ =>
                  println(s"Unsupported value type for tag: ${summaryValue.tag}")
              }
            }
          case _ =>
            println("No summary found in the event")
        }
      }
    } catch {
      case e: Exception =>
        println(s"Error reading events: ${e.getMessage}")
    } finally {
      dataInputStream.close()
    }
  }
}
