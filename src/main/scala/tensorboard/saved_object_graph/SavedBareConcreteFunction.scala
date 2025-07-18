// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!

package tensorboard.saved_object_graph

/** @param concreteFunctionName
  *   Identifies a SavedConcreteFunction.
  * @param argumentKeywords
  *   A sequence of unique strings, one per Tensor argument.
  * @param allowedPositionalArguments
  *   The prefix of `argument_keywords` which may be identified by position.
  * @param functionSpec
  *   The spec of the function that this ConcreteFunction is traced from. This
  *   allows the ConcreteFunction to be called with nest structure inputs. This
  *   field may not be populated. If this field is absent, the concrete function
  *   can only be called with flat inputs.
  *   TODO(b/169361281): support calling saved ConcreteFunction with structured
  *   inputs in C++ SavedModel API.
  */
@SerialVersionUID(0L)
final case class SavedBareConcreteFunction(
    concreteFunctionName: _root_.scala.Predef.String = "",
    argumentKeywords: _root_.scala.Seq[_root_.scala.Predef.String] = _root_.scala.Seq.empty,
    allowedPositionalArguments: _root_.scala.Long = 0L,
    functionSpec: _root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec] = _root_.scala.None,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[SavedBareConcreteFunction] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = concreteFunctionName
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      argumentKeywords.foreach { __item =>
        val __value = __item
        __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
      }
      
      {
        val __value = allowedPositionalArguments
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(3, __value)
        }
      };
      if (functionSpec.isDefined) {
        val __value = functionSpec.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
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
        val __v = concreteFunctionName
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      argumentKeywords.foreach { __v =>
        val __m = __v
        _output__.writeString(2, __m)
      };
      {
        val __v = allowedPositionalArguments
        if (__v != 0L) {
          _output__.writeInt64(3, __v)
        }
      };
      functionSpec.foreach { __v =>
        val __m = __v
        _output__.writeTag(4, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def withConcreteFunctionName(__v: _root_.scala.Predef.String): SavedBareConcreteFunction = copy(concreteFunctionName = __v)
    def clearArgumentKeywords = copy(argumentKeywords = _root_.scala.Seq.empty)
    def addArgumentKeywords(__vs: _root_.scala.Predef.String *): SavedBareConcreteFunction = addAllArgumentKeywords(__vs)
    def addAllArgumentKeywords(__vs: Iterable[_root_.scala.Predef.String]): SavedBareConcreteFunction = copy(argumentKeywords = argumentKeywords ++ __vs)
    def withArgumentKeywords(__v: _root_.scala.Seq[_root_.scala.Predef.String]): SavedBareConcreteFunction = copy(argumentKeywords = __v)
    def withAllowedPositionalArguments(__v: _root_.scala.Long): SavedBareConcreteFunction = copy(allowedPositionalArguments = __v)
    def getFunctionSpec: tensorboard.saved_object_graph.FunctionSpec = functionSpec.getOrElse(tensorboard.saved_object_graph.FunctionSpec.defaultInstance)
    def clearFunctionSpec: SavedBareConcreteFunction = copy(functionSpec = _root_.scala.None)
    def withFunctionSpec(__v: tensorboard.saved_object_graph.FunctionSpec): SavedBareConcreteFunction = copy(functionSpec = Option(__v))
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = concreteFunctionName
          if (__t != "") __t else null
        }
        case 2 => argumentKeywords
        case 3 => {
          val __t = allowedPositionalArguments
          if (__t != 0L) __t else null
        }
        case 4 => functionSpec.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(concreteFunctionName)
        case 2 => _root_.scalapb.descriptors.PRepeated(argumentKeywords.iterator.map(_root_.scalapb.descriptors.PString(_)).toVector)
        case 3 => _root_.scalapb.descriptors.PLong(allowedPositionalArguments)
        case 4 => functionSpec.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: tensorboard.saved_object_graph.SavedBareConcreteFunction.type = tensorboard.saved_object_graph.SavedBareConcreteFunction
    // @@protoc_insertion_point(GeneratedMessage[tensorboard.SavedBareConcreteFunction])
}

object SavedBareConcreteFunction extends scalapb.GeneratedMessageCompanion[tensorboard.saved_object_graph.SavedBareConcreteFunction] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[tensorboard.saved_object_graph.SavedBareConcreteFunction] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): tensorboard.saved_object_graph.SavedBareConcreteFunction = {
    var __concreteFunctionName: _root_.scala.Predef.String = ""
    val __argumentKeywords: _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Predef.String] = new _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Predef.String]
    var __allowedPositionalArguments: _root_.scala.Long = 0L
    var __functionSpec: _root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec] = _root_.scala.None
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __concreteFunctionName = _input__.readStringRequireUtf8()
        case 18 =>
          __argumentKeywords += _input__.readStringRequireUtf8()
        case 24 =>
          __allowedPositionalArguments = _input__.readInt64()
        case 34 =>
          __functionSpec = _root_.scala.Option(__functionSpec.fold(_root_.scalapb.LiteParser.readMessage[tensorboard.saved_object_graph.FunctionSpec](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    tensorboard.saved_object_graph.SavedBareConcreteFunction(
        concreteFunctionName = __concreteFunctionName,
        argumentKeywords = __argumentKeywords.result(),
        allowedPositionalArguments = __allowedPositionalArguments,
        functionSpec = __functionSpec,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[tensorboard.saved_object_graph.SavedBareConcreteFunction] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      tensorboard.saved_object_graph.SavedBareConcreteFunction(
        concreteFunctionName = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        argumentKeywords = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Seq[_root_.scala.Predef.String]]).getOrElse(_root_.scala.Seq.empty),
        allowedPositionalArguments = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
        functionSpec = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).flatMap(_.as[_root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec]])
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = tensorboard.saved_object_graph.SavedObjectGraphProto.javaDescriptor.getMessageTypes().get(7)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = tensorboard.saved_object_graph.SavedObjectGraphProto.scalaDescriptor.messages(7)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[?]= {
    var __out: _root_.scalapb.GeneratedMessageCompanion[?]= null
    (__number: @_root_.scala.unchecked) match {
      case 4 => __out = tensorboard.saved_object_graph.FunctionSpec
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[? <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[?]= throw new MatchError(__fieldNumber)
  lazy val defaultInstance = tensorboard.saved_object_graph.SavedBareConcreteFunction(
    concreteFunctionName = "",
    argumentKeywords = _root_.scala.Seq.empty,
    allowedPositionalArguments = 0L,
    functionSpec = _root_.scala.None
  )
  implicit class SavedBareConcreteFunctionLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, tensorboard.saved_object_graph.SavedBareConcreteFunction]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, tensorboard.saved_object_graph.SavedBareConcreteFunction](_l) {
    def concreteFunctionName: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.concreteFunctionName)((c_, f_) => c_.copy(concreteFunctionName = f_))
    def argumentKeywords: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[_root_.scala.Predef.String]] = field(_.argumentKeywords)((c_, f_) => c_.copy(argumentKeywords = f_))
    def allowedPositionalArguments: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.allowedPositionalArguments)((c_, f_) => c_.copy(allowedPositionalArguments = f_))
    def functionSpec: _root_.scalapb.lenses.Lens[UpperPB, tensorboard.saved_object_graph.FunctionSpec] = field(_.getFunctionSpec)((c_, f_) => c_.copy(functionSpec = _root_.scala.Option(f_)))
    def optionalFunctionSpec: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec]] = field(_.functionSpec)((c_, f_) => c_.copy(functionSpec = f_))
  }
  final val CONCRETE_FUNCTION_NAME_FIELD_NUMBER = 1
  final val ARGUMENT_KEYWORDS_FIELD_NUMBER = 2
  final val ALLOWED_POSITIONAL_ARGUMENTS_FIELD_NUMBER = 3
  final val FUNCTION_SPEC_FIELD_NUMBER = 4
  def of(
    concreteFunctionName: _root_.scala.Predef.String,
    argumentKeywords: _root_.scala.Seq[_root_.scala.Predef.String],
    allowedPositionalArguments: _root_.scala.Long,
    functionSpec: _root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec]
  ): _root_.tensorboard.saved_object_graph.SavedBareConcreteFunction = _root_.tensorboard.saved_object_graph.SavedBareConcreteFunction(
    concreteFunctionName,
    argumentKeywords,
    allowedPositionalArguments,
    functionSpec
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[tensorboard.SavedBareConcreteFunction])
}
