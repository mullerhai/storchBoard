// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!

package tensorboard.tfprof_log

/** It specifies the Python callstack that creates an op.
  */
@SerialVersionUID(0L)
final case class CodeDef(
    traces: _root_.scala.Seq[tensorboard.tfprof_log.CodeDef.Trace] = _root_.scala.Seq.empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[CodeDef] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      traces.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
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
      traces.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def clearTraces = copy(traces = _root_.scala.Seq.empty)
    def addTraces(__vs: tensorboard.tfprof_log.CodeDef.Trace *): CodeDef = addAllTraces(__vs)
    def addAllTraces(__vs: Iterable[tensorboard.tfprof_log.CodeDef.Trace]): CodeDef = copy(traces = traces ++ __vs)
    def withTraces(__v: _root_.scala.Seq[tensorboard.tfprof_log.CodeDef.Trace]): CodeDef = copy(traces = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => traces
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PRepeated(traces.iterator.map(_.toPMessage).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: tensorboard.tfprof_log.CodeDef.type = tensorboard.tfprof_log.CodeDef
    // @@protoc_insertion_point(GeneratedMessage[tensorboard.CodeDef])
}

object CodeDef extends scalapb.GeneratedMessageCompanion[tensorboard.tfprof_log.CodeDef] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[tensorboard.tfprof_log.CodeDef] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): tensorboard.tfprof_log.CodeDef = {
    val __traces: _root_.scala.collection.immutable.VectorBuilder[tensorboard.tfprof_log.CodeDef.Trace] = new _root_.scala.collection.immutable.VectorBuilder[tensorboard.tfprof_log.CodeDef.Trace]
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __traces += _root_.scalapb.LiteParser.readMessage[tensorboard.tfprof_log.CodeDef.Trace](_input__)
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    tensorboard.tfprof_log.CodeDef(
        traces = __traces.result(),
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[tensorboard.tfprof_log.CodeDef] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      tensorboard.tfprof_log.CodeDef(
        traces = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Seq[tensorboard.tfprof_log.CodeDef.Trace]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = tensorboard.tfprof_log.TfprofLogProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = tensorboard.tfprof_log.TfprofLogProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[?]= {
    var __out: _root_.scalapb.GeneratedMessageCompanion[?]= null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = tensorboard.tfprof_log.CodeDef.Trace
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[? <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[? <: _root_.scalapb.GeneratedMessage]](
      _root_.tensorboard.tfprof_log.CodeDef.Trace
    )
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[?]= throw new MatchError(__fieldNumber)
  lazy val defaultInstance = tensorboard.tfprof_log.CodeDef(
    traces = _root_.scala.Seq.empty
  )
  /** @param file
    *   deprecated by file_id.
    * @param function
    *   deprecated by function_id.
    * @param line
    *   deprecated line_id.
    */
  @SerialVersionUID(0L)
  final case class Trace(
      @scala.deprecated(message="Marked as deprecated in proto file", "") file: _root_.scala.Predef.String = "",
      fileId: _root_.scala.Long = 0L,
      lineno: _root_.scala.Int = 0,
      @scala.deprecated(message="Marked as deprecated in proto file", "") function: _root_.scala.Predef.String = "",
      functionId: _root_.scala.Long = 0L,
      @scala.deprecated(message="Marked as deprecated in proto file", "") line: _root_.scala.Predef.String = "",
      lineId: _root_.scala.Long = 0L,
      funcStartLine: _root_.scala.Int = 0,
      unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
      ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Trace] {
      @transient
      private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
      private[this] def __computeSerializedSize(): _root_.scala.Int = {
        var __size = 0
        
        {
          val __value = file
          if (!__value.isEmpty) {
            __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
          }
        };
        
        {
          val __value = fileId
          if (__value != 0L) {
            __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(6, __value)
          }
        };
        
        {
          val __value = lineno
          if (__value != 0) {
            __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, __value)
          }
        };
        
        {
          val __value = function
          if (!__value.isEmpty) {
            __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(3, __value)
          }
        };
        
        {
          val __value = functionId
          if (__value != 0L) {
            __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(7, __value)
          }
        };
        
        {
          val __value = line
          if (!__value.isEmpty) {
            __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(4, __value)
          }
        };
        
        {
          val __value = lineId
          if (__value != 0L) {
            __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(8, __value)
          }
        };
        
        {
          val __value = funcStartLine
          if (__value != 0) {
            __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(5, __value)
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
          val __v = file
          if (!__v.isEmpty) {
            _output__.writeString(1, __v)
          }
        };
        {
          val __v = lineno
          if (__v != 0) {
            _output__.writeInt32(2, __v)
          }
        };
        {
          val __v = function
          if (!__v.isEmpty) {
            _output__.writeString(3, __v)
          }
        };
        {
          val __v = line
          if (!__v.isEmpty) {
            _output__.writeString(4, __v)
          }
        };
        {
          val __v = funcStartLine
          if (__v != 0) {
            _output__.writeInt32(5, __v)
          }
        };
        {
          val __v = fileId
          if (__v != 0L) {
            _output__.writeInt64(6, __v)
          }
        };
        {
          val __v = functionId
          if (__v != 0L) {
            _output__.writeInt64(7, __v)
          }
        };
        {
          val __v = lineId
          if (__v != 0L) {
            _output__.writeInt64(8, __v)
          }
        };
        unknownFields.writeTo(_output__)
      }
      def withFile(__v: _root_.scala.Predef.String): Trace = copy(file = __v)
      def withFileId(__v: _root_.scala.Long): Trace = copy(fileId = __v)
      def withLineno(__v: _root_.scala.Int): Trace = copy(lineno = __v)
      def withFunction(__v: _root_.scala.Predef.String): Trace = copy(function = __v)
      def withFunctionId(__v: _root_.scala.Long): Trace = copy(functionId = __v)
      def withLine(__v: _root_.scala.Predef.String): Trace = copy(line = __v)
      def withLineId(__v: _root_.scala.Long): Trace = copy(lineId = __v)
      def withFuncStartLine(__v: _root_.scala.Int): Trace = copy(funcStartLine = __v)
      def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
      def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
      def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
        (__fieldNumber: @_root_.scala.unchecked) match {
          case 1 => {
            val __t = file
            if (__t != "") __t else null
          }
          case 6 => {
            val __t = fileId
            if (__t != 0L) __t else null
          }
          case 2 => {
            val __t = lineno
            if (__t != 0) __t else null
          }
          case 3 => {
            val __t = function
            if (__t != "") __t else null
          }
          case 7 => {
            val __t = functionId
            if (__t != 0L) __t else null
          }
          case 4 => {
            val __t = line
            if (__t != "") __t else null
          }
          case 8 => {
            val __t = lineId
            if (__t != 0L) __t else null
          }
          case 5 => {
            val __t = funcStartLine
            if (__t != 0) __t else null
          }
        }
      }
      def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
        _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
        (__field.number: @_root_.scala.unchecked) match {
          case 1 => _root_.scalapb.descriptors.PString(file)
          case 6 => _root_.scalapb.descriptors.PLong(fileId)
          case 2 => _root_.scalapb.descriptors.PInt(lineno)
          case 3 => _root_.scalapb.descriptors.PString(function)
          case 7 => _root_.scalapb.descriptors.PLong(functionId)
          case 4 => _root_.scalapb.descriptors.PString(line)
          case 8 => _root_.scalapb.descriptors.PLong(lineId)
          case 5 => _root_.scalapb.descriptors.PInt(funcStartLine)
        }
      }
      def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
      def companion: tensorboard.tfprof_log.CodeDef.Trace.type = tensorboard.tfprof_log.CodeDef.Trace
      // @@protoc_insertion_point(GeneratedMessage[tensorboard.CodeDef.Trace])
  }
  
  object Trace extends scalapb.GeneratedMessageCompanion[tensorboard.tfprof_log.CodeDef.Trace] {
    implicit def messageCompanion: scalapb.GeneratedMessageCompanion[tensorboard.tfprof_log.CodeDef.Trace] = this
    def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): tensorboard.tfprof_log.CodeDef.Trace = {
      var __file: _root_.scala.Predef.String = ""
      var __fileId: _root_.scala.Long = 0L
      var __lineno: _root_.scala.Int = 0
      var __function: _root_.scala.Predef.String = ""
      var __functionId: _root_.scala.Long = 0L
      var __line: _root_.scala.Predef.String = ""
      var __lineId: _root_.scala.Long = 0L
      var __funcStartLine: _root_.scala.Int = 0
      var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __file = _input__.readStringRequireUtf8()
          case 48 =>
            __fileId = _input__.readInt64()
          case 16 =>
            __lineno = _input__.readInt32()
          case 26 =>
            __function = _input__.readStringRequireUtf8()
          case 56 =>
            __functionId = _input__.readInt64()
          case 34 =>
            __line = _input__.readStringRequireUtf8()
          case 64 =>
            __lineId = _input__.readInt64()
          case 40 =>
            __funcStartLine = _input__.readInt32()
          case tag =>
            if (_unknownFields__ == null) {
              _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
            }
            _unknownFields__.parseField(tag, _input__)
        }
      }
      tensorboard.tfprof_log.CodeDef.Trace(
          file = __file,
          fileId = __fileId,
          lineno = __lineno,
          function = __function,
          functionId = __functionId,
          line = __line,
          lineId = __lineId,
          funcStartLine = __funcStartLine,
          unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
      )
    }
    implicit def messageReads: _root_.scalapb.descriptors.Reads[tensorboard.tfprof_log.CodeDef.Trace] = _root_.scalapb.descriptors.Reads{
      case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
        _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
        tensorboard.tfprof_log.CodeDef.Trace(
          file = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
          fileId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
          lineno = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Int]).getOrElse(0),
          function = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
          functionId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
          line = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
          lineId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(8).get).map(_.as[_root_.scala.Long]).getOrElse(0L),
          funcStartLine = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Int]).getOrElse(0)
        )
      case _ => throw new RuntimeException("Expected PMessage")
    }
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = tensorboard.tfprof_log.CodeDef.javaDescriptor.getNestedTypes().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = tensorboard.tfprof_log.CodeDef.scalaDescriptor.nestedMessages(0)
    def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[?]= throw new MatchError(__number)
    lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[? <: _root_.scalapb.GeneratedMessage]] = Seq.empty
    def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[?]= throw new MatchError(__fieldNumber)
    lazy val defaultInstance = tensorboard.tfprof_log.CodeDef.Trace(
      file = "",
      fileId = 0L,
      lineno = 0,
      function = "",
      functionId = 0L,
      line = "",
      lineId = 0L,
      funcStartLine = 0
    )
    implicit class TraceLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, tensorboard.tfprof_log.CodeDef.Trace]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, tensorboard.tfprof_log.CodeDef.Trace](_l) {
      def file: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.file)((c_, f_) => c_.copy(file = f_))
      def fileId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.fileId)((c_, f_) => c_.copy(fileId = f_))
      def lineno: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.lineno)((c_, f_) => c_.copy(lineno = f_))
      def function: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.function)((c_, f_) => c_.copy(function = f_))
      def functionId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.functionId)((c_, f_) => c_.copy(functionId = f_))
      def line: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.line)((c_, f_) => c_.copy(line = f_))
      def lineId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.lineId)((c_, f_) => c_.copy(lineId = f_))
      def funcStartLine: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.funcStartLine)((c_, f_) => c_.copy(funcStartLine = f_))
    }
    final val FILE_FIELD_NUMBER = 1
    final val FILE_ID_FIELD_NUMBER = 6
    final val LINENO_FIELD_NUMBER = 2
    final val FUNCTION_FIELD_NUMBER = 3
    final val FUNCTION_ID_FIELD_NUMBER = 7
    final val LINE_FIELD_NUMBER = 4
    final val LINE_ID_FIELD_NUMBER = 8
    final val FUNC_START_LINE_FIELD_NUMBER = 5
    def of(
      file: _root_.scala.Predef.String,
      fileId: _root_.scala.Long,
      lineno: _root_.scala.Int,
      function: _root_.scala.Predef.String,
      functionId: _root_.scala.Long,
      line: _root_.scala.Predef.String,
      lineId: _root_.scala.Long,
      funcStartLine: _root_.scala.Int
    ): _root_.tensorboard.tfprof_log.CodeDef.Trace = _root_.tensorboard.tfprof_log.CodeDef.Trace(
      file,
      fileId,
      lineno,
      function,
      functionId,
      line,
      lineId,
      funcStartLine
    )
    // @@protoc_insertion_point(GeneratedMessageCompanion[tensorboard.CodeDef.Trace])
  }
  
  implicit class CodeDefLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, tensorboard.tfprof_log.CodeDef]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, tensorboard.tfprof_log.CodeDef](_l) {
    def traces: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[tensorboard.tfprof_log.CodeDef.Trace]] = field(_.traces)((c_, f_) => c_.copy(traces = f_))
  }
  final val TRACES_FIELD_NUMBER = 1
  def of(
    traces: _root_.scala.Seq[tensorboard.tfprof_log.CodeDef.Trace]
  ): _root_.tensorboard.tfprof_log.CodeDef = _root_.tensorboard.tfprof_log.CodeDef(
    traces
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[tensorboard.CodeDef])
}
