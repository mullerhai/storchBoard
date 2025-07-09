package example

import org.tensorflow.framework.summary.SummaryMetadata.PluginData
import org.tensorflow.framework.summary.{DataClass, Summary, SummaryMetadata}
import org.tensorflow.framework.tensor.TensorProto
import org.tensorflow.framework.tensor_shape.TensorShapeProto
import org.tensorflow.framework.types.DataType
import org.tensorflow.util.event.SessionLog.SessionStatus
import org.tensorflow.util.event.{Event, SessionLog, SourceMetadata}
import torch.tensorboard.{TFRecordReader, TFRecordWriter}

import java.io.{DataInputStream, DataOutputStream, FileInputStream, FileOutputStream}

object TFRecordExample3 extends App {
  val logDir = "logz"
//  val logFilePath = s"$logDir/events.out.tfevents"
  val logFilePath = s"$logDir/train29.tfevents"

  // 写入日志文件
  writeToLogFile(logFilePath)

  // 读取日志文件
  readFromLogFile(logFilePath)

  def writeToLogFile(filePath: String): Unit = {
    val fileOutputStream = new FileOutputStream(filePath)
    val dataOutputStream = new DataOutputStream(fileOutputStream)
    val writer = new TFRecordWriter(dataOutputStream)
    val sourceMetadata = SourceMetadata(
      writer = "tensorboard.summary.writer.event_file_writer" //"tensorflow.core.util.events_writer"
    )
    // 创建 Event 消息，添加 fileVersion 字段  Event.What.Summary(summary)
    val eventMeta = Event(
      what = Event.What.FileVersion("brain.Event:2"),
      sourceMetadata = Some(sourceMetadata)
    )
    val eventSession = Event(
      what = Event.What.SessionLog(SessionLog(status = SessionStatus.START)),
      sourceMetadata = Some(sourceMetadata)
    )
    writer.write(eventMeta.toByteArray)
    writer.write(eventSession.toByteArray)
    try {
      // 模拟训练过程
      val numSteps = 50
      for (step <- 0L until numSteps) {
        // 模拟 loss 和 accuracy
        val loss = Math.exp(-step / 10.0)
        val accuracy = 1 - 0.5 * Math.exp(-step / 20.0)

        // 记录 loss
        writeScalarEvent(writer, "Loss/train", loss, step)
        // 记录 accuracy
        writeScalarEvent(writer, "Accuracy/train", accuracy, step)
      }
    } finally {
      dataOutputStream.close()
    }
  }

  private def writeScalarEvent(writer: TFRecordWriter, tag: String, value: Double, step: Long): Unit = {
    // 创建 TensorProto 表示标量值
    val tensorProto = TensorProto(
      dtype = DataType.DT_FLOAT,
      tensorShape = Some(TensorShapeProto()),
      floatVal = Seq(value.toFloat)
    )
    val simpleValue = Summary.Value.Value.SimpleValue(
      value = value.toFloat
    )

    // 创建 PluginData 并设置 plugin_name 为 scalars
    val pluginData = PluginData(
      pluginName = "scalars"
    )

    // 创建 SummaryMetadata 并设置 plugin_data
    val metadata = SummaryMetadata(
      pluginData = Some(pluginData),
      dataClass = DataClass.DATA_CLASS_SCALAR
    )

    // 创建 SummaryValue
    val summaryValue = Summary.Value(
      tag = tag,
      metadata = Some(metadata),
      value = Summary.Value.Value.SimpleValue(value.toFloat)
    )
//    val summaryValue = Summary.Value(
//      tag = tag,
//      metadata = Some(metadata),
//      value = Summary.Value.Value.Tensor(tensorProto)
//    )

    // 创建 Summary
    val summary = Summary(
      value = Seq(summaryValue)
    )

    val sourceMetadata = SourceMetadata(
      writer = "tensorboard.summary.writer.event_file_writer" //"tensorflow.core.util.events_writer"
    )
    // 创建 Event 消息，添加 fileVersion 字段  Event.What.Summary(summary)
    val eventMeta = Event(
      wallTime = System.currentTimeMillis() / 1000.0,
      step = step,
      what = Event.What.FileVersion("brain.Event:2"),
      sourceMetadata = Some(sourceMetadata)
    )//.withFileVersion("brain.Event:2")

    val eventData = Event(
      wallTime = System.currentTimeMillis() / 1000.0,
      step = step,
      what = Event.What.Summary(summary),
//      sourceMetadata = Some(sourceMetadata)
    )
    // 序列化 Event 为字节数组 if step == 0 then  eventMeta.toByteArray else
    val serializedEvent = eventData.toByteArray

    // 使用 TFRecordWriter 写入 Event
    writer.write(serializedEvent)
  }

  def readFromLogFile(filePath: String): Unit = {
    val fileInputStream = new FileInputStream(filePath)
    val dataInputStream = new DataInputStream(fileInputStream)
    val reader = new TFRecordReader(dataInputStream, false)

    try {
      var record: Array[Byte] = reader.read
      while (record != null) {
        val event = Event.parseFrom(record)
        event.what match {
          case Event.What.Summary(summary) =>
            summary.value.foreach { summaryValue =>
              println(summaryValue.value.getClass.getName)
              summaryValue.value match {
                case Summary.Value.Value.Tensor(tensorProto) =>
                  tensorProto.floatVal.headOption.foreach { floatValue =>
                    println(s"Step: ${event.step}, Tag: ${summaryValue.tag}, Value: $floatValue")
                  }
                case  sv : Summary.Value.Value.SimpleValue  =>
                  //Event(1.752052453297E9,48,Summary(Summary(Vector(Value(,accuracy/train,Some(SummaryMetadata(Some(PluginData(scalars,<ByteString@30b8a058 size=0 contents="">,UnknownFieldSet(Map()))),,,DATA_CLASS_SCALAR,UnknownFieldSet(Map()))),SimpleValue(0.95464104),UnknownFieldSet(Map()))),UnknownFieldSet(Map()))),Some(SourceMetadata(tensorflow.core.util.events_writer,UnknownFieldSet(Map()))),UnknownFieldSet(Map()))
                  //Event(1.7520443742588904E9,999,Summary(Summary(Vector(Value(,Accuracy/train,None,SimpleValue(1.0)
                  println(s"sv Step: ${event.step} event tag ${event} ,summary Tag: ${summaryValue.tag}, Value: ${summaryValue.value.simpleValue.get}")
//                  tensorProto.floatVal.headOption.foreach { floatValue =>
//                    println(s"Step: ${event.step}, Tag: ${summaryValue.tag}, Value: $floatValue")
//                  }
                case _ =>
                  println(s"Unsupported value type for Step ${event.step} tag: ${summaryValue.tag} value ${summaryValue.value.simpleValue.get}")
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
