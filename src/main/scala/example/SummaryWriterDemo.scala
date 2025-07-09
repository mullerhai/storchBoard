package example

import torch.tensorboard.SummaryWriter

object SummaryWriterDemo {
  //  def apply(logDir: String): SummaryWriter = new SummaryWriter(logDir)

  def main(args: Array[String]): Unit = {
    val logDir = "logs"
    val writer = new SummaryWriter(logDir,tfEventFilePath = "train.tfevents")
    val numSteps = 50
    for (step <- 0L until numSteps) {
      val loss = Math.exp(-step / 10.0)
      val accuracy = 1 - 0.5 * Math.exp(-step / 20.0)
      writer.addScalar("Loss/train", loss, step)
      writer.addScalar("Loss/Accuracy", accuracy, step)
      writer.addScalars("scalars", Map("scalar1" -> 10.0, "scalar2" -> 20.0), 1)
      writer.addHistogram("histogram", Array(1.0, 2.0, 3.0, 4.0, 5.0), step)
      writer.addAudio("audio",Array(1, 2, 3, 4, 5, 6),0.45f, step)
      writer.addTensors("tensors",
        Array(4.0, 5.0, 6.0).toSeq,step)
//      writer.addTensors("tensors", Array(
//        Array(1.0, 2.0, 3.0),
//        Array(4.0, 5.0, 6.0)
//      ))
      writer.addImage("image", Array(1, 2, 3, 4, 5, 6), 2, 3, step)
    }
    writer.close()
  }

}
