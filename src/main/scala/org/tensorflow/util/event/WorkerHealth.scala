// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!

package org.tensorflow.util.event

/** Current health status of a worker.
  */
sealed abstract class WorkerHealth(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = org.tensorflow.util.event.WorkerHealth
  type RecognizedType = org.tensorflow.util.event.WorkerHealth.Recognized
  def isOk: _root_.scala.Boolean = false
  def isReceivedShutdownSignal: _root_.scala.Boolean = false
  def isInternalError: _root_.scala.Boolean = false
  def isShuttingDown: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[WorkerHealth] = org.tensorflow.util.event.WorkerHealth
  final def asRecognized: _root_.scala.Option[org.tensorflow.util.event.WorkerHealth.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[org.tensorflow.util.event.WorkerHealth.Recognized])
}

object WorkerHealth extends _root_.scalapb.GeneratedEnumCompanion[WorkerHealth] {
  sealed trait Recognized extends WorkerHealth
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[WorkerHealth] = this
  
  /** By default a worker is healthy.
    */
  @SerialVersionUID(0L)
  case object OK extends WorkerHealth(0) with WorkerHealth.Recognized {
    val index = 0
    val name = "OK"
    override def isOk: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object RECEIVED_SHUTDOWN_SIGNAL extends WorkerHealth(1) with WorkerHealth.Recognized {
    val index = 1
    val name = "RECEIVED_SHUTDOWN_SIGNAL"
    override def isReceivedShutdownSignal: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object INTERNAL_ERROR extends WorkerHealth(2) with WorkerHealth.Recognized {
    val index = 2
    val name = "INTERNAL_ERROR"
    override def isInternalError: _root_.scala.Boolean = true
  }
  
  /** Worker has been instructed to shutdown after a timeout.
    */
  @SerialVersionUID(0L)
  case object SHUTTING_DOWN extends WorkerHealth(3) with WorkerHealth.Recognized {
    val index = 3
    val name = "SHUTTING_DOWN"
    override def isShuttingDown: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends WorkerHealth(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  lazy val values: scala.collection.immutable.Seq[ValueType] = scala.collection.immutable.Seq(OK, RECEIVED_SHUTDOWN_SIGNAL, INTERNAL_ERROR, SHUTTING_DOWN)
  def fromValue(__value: _root_.scala.Int): WorkerHealth = __value match {
    case 0 => OK
    case 1 => RECEIVED_SHUTDOWN_SIGNAL
    case 2 => INTERNAL_ERROR
    case 3 => SHUTTING_DOWN
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = org.tensorflow.util.event.EventProto.javaDescriptor.getEnumTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = org.tensorflow.util.event.EventProto.scalaDescriptor.enums(0)
}