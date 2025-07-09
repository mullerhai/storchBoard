
package torch.tensorboard
object Crc32C {
  private val CRC32C_POLY: Long = 0x82F63B78L
  private val TABLE: Array[Long] = new Array[Long](256)

  // 初始化 CRC32C 表
  for (n <- 0 until 256) {
    var crc = n.toLong
    for (_ <- 0 until 8) {
      if ((crc & 1) == 1) {
        crc = (crc >>> 1) ^ CRC32C_POLY
      } else {
        crc >>>= 1
      }
    }
    TABLE(n) = crc
  }

  def crc32c(data: Array[Byte]): Long = {
    var crc = 0xFFFFFFFFL
    for (b <- data) {
      crc = (crc >>> 8) ^ TABLE(((crc ^ b) & 0xFF).toInt)
    }
    crc ^ 0xFFFFFFFFL
  }

  def maskedCrc32c(data: Array[Byte]): Int = {
    val crc = crc32c(data)
    (((crc >>> 15) | (crc << 17)).toInt + 0xA282EAD8).toInt
  }
}
