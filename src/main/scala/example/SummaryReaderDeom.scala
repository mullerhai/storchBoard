package example

import torch.tensorboard.SummaryReader

object SummaryReaderDeom {

  def main(args: Array[String]): Unit = {
    // 示例用法
    val logDir = "./logs"
    val tfEventFilePath = "train.tfevents"
    val summaryReader = new SummaryReader(logDir, tfEventFilePath)
    summaryReader.readEvent()
  }
}
