package example

import org.tensorflow.framework.summary.{DataClass, Summary, SummaryMetadata}
import org.tensorflow.framework.tensor.TensorProto
import org.tensorflow.framework.tensor_shape.TensorShapeProto
import org.tensorflow.framework.types.DataType
import org.tensorflow.util.event.Event
import torch.tensorboard.{TFEventReader, TFEventWriter}

import java.io.{DataInputStream, DataOutputStream, FileInputStream, FileOutputStream}

object TFRecordExample extends App {
  val logDir = "./logs"
  val logFilePath = s"$logDir/train.out"

  // 写入日志文件
  writeToLogFile(logFilePath)

  // 读取日志文件
  readFromLogFile(logFilePath)

  def writeToLogFile(filePath: String): Unit = {
    val fileOutputStream = new FileOutputStream(filePath)
    val dataOutputStream = new DataOutputStream(fileOutputStream)
    val writer = new TFEventWriter(dataOutputStream)

    try {
      // 模拟训练过程
      val numSteps = 10
      for (step <- 0L until numSteps) {
        // 模拟 loss 和 accuracy
        val loss = Math.exp(-step / 10.0)
        val accuracy = 1 - 0.5 * Math.exp(-step / 20.0)

        // 记录 loss
        writeScalarEvent(writer, "loss", loss, step)
        // 记录 accuracy
        writeScalarEvent(writer, "accuracy", accuracy, step)
      }
    } finally {
      dataOutputStream.close()
    }
  }

  private def writeScalarEvent(writer: TFEventWriter, tag: String, value: Double, step: Long): Unit = {
    // 创建 TensorProto 表示标量值
    val tensorProto = TensorProto(
      dtype = DataType.DT_FLOAT,
      tensorShape = Some(TensorShapeProto()),
      floatVal = Seq(value.toFloat)
    )

    // 创建 SummaryMetadata 并设置 dataClass
    val metadata = SummaryMetadata(
      dataClass = DataClass.DATA_CLASS_SCALAR
    )

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
    ) //.withFileVersion("brain.Event:2")
//
    // 序列化 Event 为字节数组
    val serializedEvent = event.toByteArray

    // 使用 TFRecordWriter 写入 Event
    writer.write(serializedEvent)
  }

  def readFromLogFile(filePath: String): Unit = {
    val fileInputStream = new FileInputStream(filePath)
    val dataInputStream = new DataInputStream(fileInputStream)
    val reader = new TFEventReader(dataInputStream, true)

    try {
      var record: Array[Byte] = reader.read
      while (record != null) {
        val event = Event.parseFrom(record).withFileVersion("brain.Event:2")
        event.what match {
          case Event.What.Summary(summary) =>
            summary.value.foreach { summaryValue =>
              summaryValue.value match {
                case Summary.Value.Value.Tensor(tensorProto) =>
                  tensorProto.floatVal.headOption.foreach { floatValue =>
                    println(s"Step: ${event.step}, time: ${event.wallTime.floatValue} Tag: ${summaryValue.tag}, Value: $floatValue")
                  }
                case _ =>
                  println(s"Unsupported value type for tag: ${summaryValue.tag}")
              }
            }
          case _ =>
            println("No summary found in the event")
        }
        record = reader.read
      }
    } catch {
      case e: Exception =>
        println(s"Error reading events: ${e.getMessage}")
    } finally {
      dataInputStream.close()
    }
  }
}
