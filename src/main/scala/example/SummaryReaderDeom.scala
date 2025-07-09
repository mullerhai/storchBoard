package example

import torch.tensorboard.SummaryReader

object SummaryReaderDeom {

  def main(args: Array[String]): Unit = {
    // 示例用法
    val logDir = "./logs"
    val tfEventFilePath = "train.tfevents"
    val summaryReader = new SummaryReader(logDir, tfEventFilePath)
    // 添加标量数据
    //    summaryWriter.addScalar("accuracy", 0.95, 100)
    summaryReader.readEvent()
  }
}
