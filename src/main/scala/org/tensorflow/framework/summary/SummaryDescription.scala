// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!

package org.tensorflow.framework.summary

/** Metadata associated with a series of Summary data
  *
  * @param typeHint
  *   Hint on how plugins should process the data in this series.
  *   Supported values include "scalar", "histogram", "image", "audio"
  */
@SerialVersionUID(0L)
final case class SummaryDescription(
    typeHint: _root_.scala.Predef.String = "",
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[SummaryDescription] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = typeHint
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
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
        val __v = typeHint
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withTypeHint(__v: _root_.scala.Predef.String): SummaryDescription = copy(typeHint = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = typeHint
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(typeHint)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: org.tensorflow.framework.summary.SummaryDescription.type = org.tensorflow.framework.summary.SummaryDescription
    // @@protoc_insertion_point(GeneratedMessage[tensorboard.SummaryDescription])
}

object SummaryDescription extends scalapb.GeneratedMessageCompanion[org.tensorflow.framework.summary.SummaryDescription] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[org.tensorflow.framework.summary.SummaryDescription] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): org.tensorflow.framework.summary.SummaryDescription = {
    var __typeHint: _root_.scala.Predef.String = ""
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __typeHint = _input__.readStringRequireUtf8()
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    org.tensorflow.framework.summary.SummaryDescription(
        typeHint = __typeHint,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[org.tensorflow.framework.summary.SummaryDescription] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      org.tensorflow.framework.summary.SummaryDescription(
        typeHint = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = org.tensorflow.framework.summary.SummaryProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = org.tensorflow.framework.summary.SummaryProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[?]= throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[? <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[?]= throw new MatchError(__fieldNumber)
  lazy val defaultInstance = org.tensorflow.framework.summary.SummaryDescription(
    typeHint = ""
  )
  implicit class SummaryDescriptionLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, org.tensorflow.framework.summary.SummaryDescription]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, org.tensorflow.framework.summary.SummaryDescription](_l) {
    def typeHint: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.typeHint)((c_, f_) => c_.copy(typeHint = f_))
  }
  final val TYPE_HINT_FIELD_NUMBER = 1
  def of(
    typeHint: _root_.scala.Predef.String
  ): _root_.org.tensorflow.framework.summary.SummaryDescription = _root_.org.tensorflow.framework.summary.SummaryDescription(
    typeHint
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[tensorboard.SummaryDescription])
}
