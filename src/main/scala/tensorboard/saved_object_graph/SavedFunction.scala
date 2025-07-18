// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!

package tensorboard.saved_object_graph

/** A function with multiple signatures, possibly with non-Tensor arguments.
  */
@SerialVersionUID(0L)
final case class SavedFunction(
    concreteFunctions: _root_.scala.Seq[_root_.scala.Predef.String] = _root_.scala.Seq.empty,
    functionSpec: _root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec] = _root_.scala.None,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[SavedFunction] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      concreteFunctions.foreach { __item =>
        val __value = __item
        __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
      }
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
      concreteFunctions.foreach { __v =>
        val __m = __v
        _output__.writeString(1, __m)
      };
      functionSpec.foreach { __v =>
        val __m = __v
        _output__.writeTag(2, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def clearConcreteFunctions = copy(concreteFunctions = _root_.scala.Seq.empty)
    def addConcreteFunctions(__vs: _root_.scala.Predef.String *): SavedFunction = addAllConcreteFunctions(__vs)
    def addAllConcreteFunctions(__vs: Iterable[_root_.scala.Predef.String]): SavedFunction = copy(concreteFunctions = concreteFunctions ++ __vs)
    def withConcreteFunctions(__v: _root_.scala.Seq[_root_.scala.Predef.String]): SavedFunction = copy(concreteFunctions = __v)
    def getFunctionSpec: tensorboard.saved_object_graph.FunctionSpec = functionSpec.getOrElse(tensorboard.saved_object_graph.FunctionSpec.defaultInstance)
    def clearFunctionSpec: SavedFunction = copy(functionSpec = _root_.scala.None)
    def withFunctionSpec(__v: tensorboard.saved_object_graph.FunctionSpec): SavedFunction = copy(functionSpec = Option(__v))
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => concreteFunctions
        case 2 => functionSpec.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PRepeated(concreteFunctions.iterator.map(_root_.scalapb.descriptors.PString(_)).toVector)
        case 2 => functionSpec.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: tensorboard.saved_object_graph.SavedFunction.type = tensorboard.saved_object_graph.SavedFunction
    // @@protoc_insertion_point(GeneratedMessage[tensorboard.SavedFunction])
}

object SavedFunction extends scalapb.GeneratedMessageCompanion[tensorboard.saved_object_graph.SavedFunction] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[tensorboard.saved_object_graph.SavedFunction] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): tensorboard.saved_object_graph.SavedFunction = {
    val __concreteFunctions: _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Predef.String] = new _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Predef.String]
    var __functionSpec: _root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec] = _root_.scala.None
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __concreteFunctions += _input__.readStringRequireUtf8()
        case 18 =>
          __functionSpec = _root_.scala.Option(__functionSpec.fold(_root_.scalapb.LiteParser.readMessage[tensorboard.saved_object_graph.FunctionSpec](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    tensorboard.saved_object_graph.SavedFunction(
        concreteFunctions = __concreteFunctions.result(),
        functionSpec = __functionSpec,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[tensorboard.saved_object_graph.SavedFunction] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      tensorboard.saved_object_graph.SavedFunction(
        concreteFunctions = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Seq[_root_.scala.Predef.String]]).getOrElse(_root_.scala.Seq.empty),
        functionSpec = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec]])
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = tensorboard.saved_object_graph.SavedObjectGraphProto.javaDescriptor.getMessageTypes().get(4)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = tensorboard.saved_object_graph.SavedObjectGraphProto.scalaDescriptor.messages(4)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[?]= {
    var __out: _root_.scalapb.GeneratedMessageCompanion[?]= null
    (__number: @_root_.scala.unchecked) match {
      case 2 => __out = tensorboard.saved_object_graph.FunctionSpec
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[? <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[?]= throw new MatchError(__fieldNumber)
  lazy val defaultInstance = tensorboard.saved_object_graph.SavedFunction(
    concreteFunctions = _root_.scala.Seq.empty,
    functionSpec = _root_.scala.None
  )
  implicit class SavedFunctionLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, tensorboard.saved_object_graph.SavedFunction]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, tensorboard.saved_object_graph.SavedFunction](_l) {
    def concreteFunctions: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[_root_.scala.Predef.String]] = field(_.concreteFunctions)((c_, f_) => c_.copy(concreteFunctions = f_))
    def functionSpec: _root_.scalapb.lenses.Lens[UpperPB, tensorboard.saved_object_graph.FunctionSpec] = field(_.getFunctionSpec)((c_, f_) => c_.copy(functionSpec = _root_.scala.Option(f_)))
    def optionalFunctionSpec: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec]] = field(_.functionSpec)((c_, f_) => c_.copy(functionSpec = f_))
  }
  final val CONCRETE_FUNCTIONS_FIELD_NUMBER = 1
  final val FUNCTION_SPEC_FIELD_NUMBER = 2
  def of(
    concreteFunctions: _root_.scala.Seq[_root_.scala.Predef.String],
    functionSpec: _root_.scala.Option[tensorboard.saved_object_graph.FunctionSpec]
  ): _root_.tensorboard.saved_object_graph.SavedFunction = _root_.tensorboard.saved_object_graph.SavedFunction(
    concreteFunctions,
    functionSpec
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[tensorboard.SavedFunction])
}
