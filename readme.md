# Scala 3 TensorBoard SummaryWriter

## Introduction
This project provides a Scala 3 implementation of `SummaryWriter`, which mimics the functionality of `torch.utils.tensorboard.SummaryWriter` in Python. It allows users to write various types of training data, such as scalars, tensors, audio, images, and histograms, to `tfevent` files. These files can then be visualized using TensorBoard.

## Features
- **Multi - type Data Logging**: Support for logging scalars, tensors, audio, images, and histograms.
- **Scala 3 Compatibility**: Specifically designed for Scala 3, leveraging its latest features.
- **TFEvent  Format**: Writes data in the standard TFRecord format, ensuring compatibility with TensorBoard.

## Prerequisites
- **Scala 3**: Ensure that Scala 3 is installed on your system.
- **Protobuf Dependencies**: Add the necessary Protobuf and TensorFlow - related dependencies to your project. For SBT, you can add the following to your `build.sbt`:

```scala 3
libraryDependencies += "io.github.mullerhai" % "storch-tensorboard_3" % "0.1.3"
```

## Useage: 

```scala 3
package torch.tensorboard

import java.nio.file.Files
import java.nio.file.Paths

object ExampleUsage extends App {
  val writer = new SummaryWriter("./data/simulated_training")

  // Simulate training parameters
  val numEpochs = 100
  val stepsPerEpoch = 10

  for (epoch <- 0 until numEpochs) {
    for (step <- 0 until stepsPerEpoch) {
      val globalStep = epoch * stepsPerEpoch + step

      // Simulate loss and accuracy
      val loss = Math.exp(-(epoch * stepsPerEpoch + step) / 100.0) + scala.util.Random.nextGaussian() * 0.1
      val accuracy = 1 - Math.exp(-(epoch * stepsPerEpoch + step) / 100.0) + scala.util.Random.nextGaussian() * 0.05
      val clippedAccuracy = accuracy.max(0).min(1)

      // Write scalar data
      writer.addScalar("Loss/train", loss, globalStep)
      writer.addScalar("Accuracy/train", clippedAccuracy, globalStep)

      // Write multiple scalar data
      writer.addScalars("Metrics", Map("loss" -> loss, "accuracy" -> clippedAccuracy), globalStep)

      // Write tensor data
      val tensors = Seq(1.0, 2.0, 3.0, 4.0, 5.0)
      writer.addTensors("Tensors", tensors, globalStep)

      // Read audio file (replace with actual audio file path)
      val audioData = Files.readAllBytes(Paths.get("path/to/audio.wav"))
      writer.addAudio("Audio", audioData, 44100, globalStep)

      // Read image file (replace with actual image file path)
      val imageData = Files.readAllBytes(Paths.get("path/to/image.png"))
      writer.addImage("Image", imageData, 256, 256, globalStep)

      // Write histogram data
      val histData = Seq.fill(100)(scala.util.Random.nextDouble())
      writer.addHistogram("Histogram", histData, globalStep)
    }
  }

  writer.close()
}
```

```scala 3
package example

import torch.tensorboard.SummaryReader

object SummaryReaderDeom {

  def main(args: Array[String]): Unit = {
    // 示例用法
    val logDir = "./logs"
    val tfEventFilePath = "train.tfevents"
    val summaryReader = new SummaryReader(logDir, tfEventFilePath)
    // 添加标量数据
    summaryReader.readEvent()
  }
}


```

## Visualization

### After running the SummaryWriter demo, you can visualize the logged data using TensorBoard. Run the following command in your terminal:
```shell
tensorboard --logdir ./data/simulated_training
```

## Contributing
Contributions are welcome! If you have any suggestions or find any bugs, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License.