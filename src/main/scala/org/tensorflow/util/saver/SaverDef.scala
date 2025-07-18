// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!

package org.tensorflow.util.saver

/** Protocol buffer representing the configuration of a Saver.
  *
  * @param filenameTensorName
  *   The name of the tensor in which to specify the filename when saving or
  *   restoring a model checkpoint.
  * @param saveTensorName
  *   The operation to run when saving a model checkpoint.
  * @param restoreOpName
  *   The operation to run when restoring a model checkpoint.
  * @param maxToKeep
  *   Maximum number of checkpoints to keep.  If 0, no checkpoints are deleted.
  * @param sharded
  *   Shard the save files, one per device that has Variable nodes.
  * @param keepCheckpointEveryNHours
  *   How often to keep an additional checkpoint. If not specified, only the last
  *   "max_to_keep" checkpoints are kept; if specified, in addition to keeping
  *   the last "max_to_keep" checkpoints, an additional checkpoint will be kept
  *   for every n hours of training.
  */
@SerialVersionUID(0L)
final case class SaverDef(
    filenameTensorName: _root_.scala.Predef.String = "",
    saveTensorName: _root_.scala.Predef.String = "",
    restoreOpName: _root_.scala.Predef.String = "",
    maxToKeep: _root_.scala.Int = 0,
    sharded: _root_.scala.Boolean = false,
    keepCheckpointEveryNHours: _root_.scala.Float = 0.0f,
    version: org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion = org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.LEGACY,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[SaverDef] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = filenameTensorName
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      
      {
        val __value = saveTensorName
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      
      {
        val __value = restoreOpName
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(3, __value)
        }
      };
      
      {
        val __value = maxToKeep
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(4, __value)
        }
      };
      
      {
        val __value = sharded
        if (__value != false) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeBoolSize(5, __value)
        }
      };
      
      {
        val __value = keepCheckpointEveryNHours
        if (__value != 0.0f) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeFloatSize(6, __value)
        }
      };
      
      {
        val __value = version.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(7, __value)
        }
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var __size = __serializedSizeMemoized
      if (__size == 0) {
        __size = __computeSerializedSize() + 1
        __serializedSizeMemoized = __size
      }
      __size - 1
      
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = filenameTensorName
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = saveTensorName
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      {
        val __v = restoreOpName
        if (!__v.isEmpty) {
          _output__.writeString(3, __v)
        }
      };
      {
        val __v = maxToKeep
        if (__v != 0) {
          _output__.writeInt32(4, __v)
        }
      };
      {
        val __v = sharded
        if (__v != false) {
          _output__.writeBool(5, __v)
        }
      };
      {
        val __v = keepCheckpointEveryNHours
        if (__v != 0.0f) {
          _output__.writeFloat(6, __v)
        }
      };
      {
        val __v = version.value
        if (__v != 0) {
          _output__.writeEnum(7, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withFilenameTensorName(__v: _root_.scala.Predef.String): SaverDef = copy(filenameTensorName = __v)
    def withSaveTensorName(__v: _root_.scala.Predef.String): SaverDef = copy(saveTensorName = __v)
    def withRestoreOpName(__v: _root_.scala.Predef.String): SaverDef = copy(restoreOpName = __v)
    def withMaxToKeep(__v: _root_.scala.Int): SaverDef = copy(maxToKeep = __v)
    def withSharded(__v: _root_.scala.Boolean): SaverDef = copy(sharded = __v)
    def withKeepCheckpointEveryNHours(__v: _root_.scala.Float): SaverDef = copy(keepCheckpointEveryNHours = __v)
    def withVersion(__v: org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion): SaverDef = copy(version = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = filenameTensorName
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = saveTensorName
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = restoreOpName
          if (__t != "") __t else null
        }
        case 4 => {
          val __t = maxToKeep
          if (__t != 0) __t else null
        }
        case 5 => {
          val __t = sharded
          if (__t != false) __t else null
        }
        case 6 => {
          val __t = keepCheckpointEveryNHours
          if (__t != 0.0f) __t else null
        }
        case 7 => {
          val __t = version.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(filenameTensorName)
        case 2 => _root_.scalapb.descriptors.PString(saveTensorName)
        case 3 => _root_.scalapb.descriptors.PString(restoreOpName)
        case 4 => _root_.scalapb.descriptors.PInt(maxToKeep)
        case 5 => _root_.scalapb.descriptors.PBoolean(sharded)
        case 6 => _root_.scalapb.descriptors.PFloat(keepCheckpointEveryNHours)
        case 7 => _root_.scalapb.descriptors.PEnum(version.scalaValueDescriptor)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: org.tensorflow.util.saver.SaverDef.type = org.tensorflow.util.saver.SaverDef
    // @@protoc_insertion_point(GeneratedMessage[tensorboard.SaverDef])
}

object SaverDef extends scalapb.GeneratedMessageCompanion[org.tensorflow.util.saver.SaverDef] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[org.tensorflow.util.saver.SaverDef] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): org.tensorflow.util.saver.SaverDef = {
    var __filenameTensorName: _root_.scala.Predef.String = ""
    var __saveTensorName: _root_.scala.Predef.String = ""
    var __restoreOpName: _root_.scala.Predef.String = ""
    var __maxToKeep: _root_.scala.Int = 0
    var __sharded: _root_.scala.Boolean = false
    var __keepCheckpointEveryNHours: _root_.scala.Float = 0.0f
    var __version: org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion = org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.LEGACY
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __filenameTensorName = _input__.readStringRequireUtf8()
        case 18 =>
          __saveTensorName = _input__.readStringRequireUtf8()
        case 26 =>
          __restoreOpName = _input__.readStringRequireUtf8()
        case 32 =>
          __maxToKeep = _input__.readInt32()
        case 40 =>
          __sharded = _input__.readBool()
        case 53 =>
          __keepCheckpointEveryNHours = _input__.readFloat()
        case 56 =>
          __version = org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.fromValue(_input__.readEnum())
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    org.tensorflow.util.saver.SaverDef(
        filenameTensorName = __filenameTensorName,
        saveTensorName = __saveTensorName,
        restoreOpName = __restoreOpName,
        maxToKeep = __maxToKeep,
        sharded = __sharded,
        keepCheckpointEveryNHours = __keepCheckpointEveryNHours,
        version = __version,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[org.tensorflow.util.saver.SaverDef] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      org.tensorflow.util.saver.SaverDef(
        filenameTensorName = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        saveTensorName = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        restoreOpName = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        maxToKeep = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        sharded = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Boolean]).getOrElse(false),
        keepCheckpointEveryNHours = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Float]).getOrElse(0.0f),
        version = org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.LEGACY.scalaValueDescriptor).number)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = org.tensorflow.util.saver.SaverProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = org.tensorflow.util.saver.SaverProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[?]= throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[? <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[?]= {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 7 => org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion
    }
  }
  lazy val defaultInstance = org.tensorflow.util.saver.SaverDef(
    filenameTensorName = "",
    saveTensorName = "",
    restoreOpName = "",
    maxToKeep = 0,
    sharded = false,
    keepCheckpointEveryNHours = 0.0f,
    version = org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.LEGACY
  )
  /** A version number that identifies a different on-disk checkpoint format.
    * Usually, each subclass of BaseSaverBuilder works with a particular
    * version/format.  However, it is possible that the same builder may be
    * upgraded to support a newer checkpoint format in the future.
    */
  sealed abstract class CheckpointFormatVersion(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
    type EnumType = org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion
    type RecognizedType = org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.Recognized
    def isLegacy: _root_.scala.Boolean = false
    def isV1: _root_.scala.Boolean = false
    def isV2: _root_.scala.Boolean = false
    def companion: _root_.scalapb.GeneratedEnumCompanion[CheckpointFormatVersion] = org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion
    final def asRecognized: _root_.scala.Option[org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion.Recognized])
  }
  
  object CheckpointFormatVersion extends _root_.scalapb.GeneratedEnumCompanion[CheckpointFormatVersion] {
    sealed trait Recognized extends CheckpointFormatVersion
    implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[CheckpointFormatVersion] = this
    
    /** Internal legacy format.
      */
    @SerialVersionUID(0L)
    case object LEGACY extends CheckpointFormatVersion(0) with CheckpointFormatVersion.Recognized {
      val index = 0
      val name = "LEGACY"
      override def isLegacy: _root_.scala.Boolean = true
    }
    
    /** Deprecated format: tf.Saver() which works with tensorflow::table::Table.
      */
    @SerialVersionUID(0L)
    case object V1 extends CheckpointFormatVersion(1) with CheckpointFormatVersion.Recognized {
      val index = 1
      val name = "V1"
      override def isV1: _root_.scala.Boolean = true
    }
    
    /** Current format: more efficient.
      */
    @SerialVersionUID(0L)
    case object V2 extends CheckpointFormatVersion(2) with CheckpointFormatVersion.Recognized {
      val index = 2
      val name = "V2"
      override def isV2: _root_.scala.Boolean = true
    }
    
    @SerialVersionUID(0L)
    final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends CheckpointFormatVersion(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
    lazy val values: scala.collection.immutable.Seq[ValueType] = scala.collection.immutable.Seq(LEGACY, V1, V2)
    def fromValue(__value: _root_.scala.Int): CheckpointFormatVersion = __value match {
      case 0 => LEGACY
      case 1 => V1
      case 2 => V2
      case __other => Unrecognized(__other)
    }
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = org.tensorflow.util.saver.SaverDef.javaDescriptor.getEnumTypes().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = org.tensorflow.util.saver.SaverDef.scalaDescriptor.enums(0)
  }
  implicit class SaverDefLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, org.tensorflow.util.saver.SaverDef]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, org.tensorflow.util.saver.SaverDef](_l) {
    def filenameTensorName: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.filenameTensorName)((c_, f_) => c_.copy(filenameTensorName = f_))
    def saveTensorName: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.saveTensorName)((c_, f_) => c_.copy(saveTensorName = f_))
    def restoreOpName: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.restoreOpName)((c_, f_) => c_.copy(restoreOpName = f_))
    def maxToKeep: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.maxToKeep)((c_, f_) => c_.copy(maxToKeep = f_))
    def sharded: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Boolean] = field(_.sharded)((c_, f_) => c_.copy(sharded = f_))
    def keepCheckpointEveryNHours: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Float] = field(_.keepCheckpointEveryNHours)((c_, f_) => c_.copy(keepCheckpointEveryNHours = f_))
    def version: _root_.scalapb.lenses.Lens[UpperPB, org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion] = field(_.version)((c_, f_) => c_.copy(version = f_))
  }
  final val FILENAME_TENSOR_NAME_FIELD_NUMBER = 1
  final val SAVE_TENSOR_NAME_FIELD_NUMBER = 2
  final val RESTORE_OP_NAME_FIELD_NUMBER = 3
  final val MAX_TO_KEEP_FIELD_NUMBER = 4
  final val SHARDED_FIELD_NUMBER = 5
  final val KEEP_CHECKPOINT_EVERY_N_HOURS_FIELD_NUMBER = 6
  final val VERSION_FIELD_NUMBER = 7
  def of(
    filenameTensorName: _root_.scala.Predef.String,
    saveTensorName: _root_.scala.Predef.String,
    restoreOpName: _root_.scala.Predef.String,
    maxToKeep: _root_.scala.Int,
    sharded: _root_.scala.Boolean,
    keepCheckpointEveryNHours: _root_.scala.Float,
    version: org.tensorflow.util.saver.SaverDef.CheckpointFormatVersion
  ): _root_.org.tensorflow.util.saver.SaverDef = _root_.org.tensorflow.util.saver.SaverDef(
    filenameTensorName,
    saveTensorName,
    restoreOpName,
    maxToKeep,
    sharded,
    keepCheckpointEveryNHours,
    version
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[tensorboard.SaverDef])
}
