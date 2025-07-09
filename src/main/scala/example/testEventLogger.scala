package example

import org.tensorflow.framework.summary.Summary.Value as SummaryValue
import org.tensorflow.framework.summary.{DataClass, Summary, SummaryMetadata}
import org.tensorflow.framework.tensor.TensorProto
import org.tensorflow.framework.tensor_shape.TensorShapeProto
import org.tensorflow.framework.types.DataType
import torch.tensorboard.TFEventWriter

import java.io.{DataOutputStream, FileOutputStream}
import java.nio.ByteBuffer

class TensorBoardLogger(logDir: String) {
  private val logFile = new FileOutputStream(s"$logDir/train11.log")
  private val dataOutputStream = new DataOutputStream(logFile)
  private val writer = new TFEventWriter(dataOutputStream)

  def logScalar(tag: String, value: Double, step: Long): Unit = {
    // 创建 TensorProto 表示标量值
    val tensorProto = TensorProto(
      dtype = DataType.DT_FLOAT,
      tensorShape = Some(TensorShapeProto()),
      floatVal = Seq(value.toFloat)
    )


    // 创建 SummaryValue
    import org.tensorflow.framework.summary.Summary.Value as SummaryValue

    val metadata = SummaryMetadata(
      // 假设 SummaryMetadata 有 dataClass 字段，如果没有需要调整
      // 这里只是示例，实际需要根据 SummaryMetadata 定义修改
      dataClass = DataClass.DATA_CLASS_SCALAR
    )
    val summaryValue = SummaryValue(
      tag = tag,
      metadata = Some(metadata),
//      value = Value.Value.Tensor(tensorProto),
//      tensor = Some(tensorProto),
//      dataClass = DataClass.DATA_CLASS_SCALAR
    )

    // 创建 Summary
    val summary = Summary(
      value = Seq(summaryValue)
    )

    // 序列化 Summary 为字节数组
    val serializedSummary = summary.toByteArray

    // 创建 Event 消息
    val event = org.tensorflow.util.event.Event(
      wallTime = System.currentTimeMillis() / 1000.0,
      step = step,
//      what = Some(org.tensorflow.util.event.Event.What.Summary(summary))
    )

    // 序列化 Event 为字节数组
    val serializedEvent = event.toByteArray

    // 使用 TFRecordWriter 写入 Event
    writer.write(serializedEvent)
  }

  def close(): Unit = {
    logFile.close()
  }
}

object Mains extends App {
  val logDir = ".//logs"
  val logger = new TensorBoardLogger(logDir)

  // 模拟训练过程
  val numSteps = 100
  for (step <- 0L until numSteps) {
    // 模拟 loss 和 accuracy
    val loss = Math.exp(-step / 10.0)
    val accuracy = 1 - 0.5 * Math.exp(-step / 20.0)

    // 记录 loss 和 accuracy
    logger.logScalar("loss", loss, step)
    logger.logScalar("accuracy", accuracy, step)
  }

  logger.close()
  println("Logs written to " + logDir)
}
