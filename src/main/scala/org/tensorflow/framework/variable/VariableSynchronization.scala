// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!

package org.tensorflow.framework.variable

/** Indicates when a distributed variable will be synced.
  */
sealed abstract class VariableSynchronization(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = org.tensorflow.framework.variable.VariableSynchronization
  type RecognizedType = org.tensorflow.framework.variable.VariableSynchronization.Recognized
  def isVariableSynchronizationAuto: _root_.scala.Boolean = false
  def isVariableSynchronizationNone: _root_.scala.Boolean = false
  def isVariableSynchronizationOnWrite: _root_.scala.Boolean = false
  def isVariableSynchronizationOnRead: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[VariableSynchronization] = org.tensorflow.framework.variable.VariableSynchronization
  final def asRecognized: _root_.scala.Option[org.tensorflow.framework.variable.VariableSynchronization.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[org.tensorflow.framework.variable.VariableSynchronization.Recognized])
}

object VariableSynchronization extends _root_.scalapb.GeneratedEnumCompanion[VariableSynchronization] {
  sealed trait Recognized extends VariableSynchronization
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[VariableSynchronization] = this
  
  /** `AUTO`: Indicates that the synchronization will be determined by the
    * current `DistributionStrategy` (eg. With `MirroredStrategy` this would be
    * `ON_WRITE`).
    */
  @SerialVersionUID(0L)
  case object VARIABLE_SYNCHRONIZATION_AUTO extends VariableSynchronization(0) with VariableSynchronization.Recognized {
    val index = 0
    val name = "VARIABLE_SYNCHRONIZATION_AUTO"
    override def isVariableSynchronizationAuto: _root_.scala.Boolean = true
  }
  
  /** `NONE`: Indicates that there will only be one copy of the variable, so
    * there is no need to sync.
    */
  @SerialVersionUID(0L)
  case object VARIABLE_SYNCHRONIZATION_NONE extends VariableSynchronization(1) with VariableSynchronization.Recognized {
    val index = 1
    val name = "VARIABLE_SYNCHRONIZATION_NONE"
    override def isVariableSynchronizationNone: _root_.scala.Boolean = true
  }
  
  /** `ON_WRITE`: Indicates that the variable will be updated across devices
    * every time it is written.
    */
  @SerialVersionUID(0L)
  case object VARIABLE_SYNCHRONIZATION_ON_WRITE extends VariableSynchronization(2) with VariableSynchronization.Recognized {
    val index = 2
    val name = "VARIABLE_SYNCHRONIZATION_ON_WRITE"
    override def isVariableSynchronizationOnWrite: _root_.scala.Boolean = true
  }
  
  /** `ON_READ`: Indicates that the variable will be aggregated across devices
    * when it is read (eg. when checkpointing or when evaluating an op that uses
    * the variable).
    */
  @SerialVersionUID(0L)
  case object VARIABLE_SYNCHRONIZATION_ON_READ extends VariableSynchronization(3) with VariableSynchronization.Recognized {
    val index = 3
    val name = "VARIABLE_SYNCHRONIZATION_ON_READ"
    override def isVariableSynchronizationOnRead: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends VariableSynchronization(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  lazy val values: scala.collection.immutable.Seq[ValueType] = scala.collection.immutable.Seq(VARIABLE_SYNCHRONIZATION_AUTO, VARIABLE_SYNCHRONIZATION_NONE, VARIABLE_SYNCHRONIZATION_ON_WRITE, VARIABLE_SYNCHRONIZATION_ON_READ)
  def fromValue(__value: _root_.scala.Int): VariableSynchronization = __value match {
    case 0 => VARIABLE_SYNCHRONIZATION_AUTO
    case 1 => VARIABLE_SYNCHRONIZATION_NONE
    case 2 => VARIABLE_SYNCHRONIZATION_ON_WRITE
    case 3 => VARIABLE_SYNCHRONIZATION_ON_READ
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = org.tensorflow.framework.variable.VariableProto.javaDescriptor.getEnumTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = org.tensorflow.framework.variable.VariableProto.scalaDescriptor.enums(0)
}