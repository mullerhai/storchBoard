import org.tensorflow.util.event.Event
import torch.tensorboard.EventIO
import java.io.File

object testEvent {

  def main(args: Array[String]): Unit = {
    // 示例用法
    val logDir = "logz"
    val logFilePath = s"$logDir/train32R.tfevents"
    val fname = File.createTempFile(s"$logDir/tfevents", ".out")
    val tag = "Loss/train"
    EventIO.createEventStream(logFilePath)
    val events = (0 until 10).map(i => EventIO.makeEvent(tag, i.toDouble))
    EventIO.appendEvents(logFilePath, events)
    val resp = EventIO.slurpEvents(true, logFilePath)

    val tags = (0 until 10).map(i => resp(i + 1).asInstanceOf[Map[String, Any]]
      .get("summary").asInstanceOf[Map[String, Any]]
      .get("value").asInstanceOf[Seq[Map[String, Any]]](0)
      .get("tag").asInstanceOf[String])

    // 写入日志文件
//    writeToLogFile(logFilePath)
//    // 读取日志文件
//    readFromLogFile(logFilePath)
  }
}
