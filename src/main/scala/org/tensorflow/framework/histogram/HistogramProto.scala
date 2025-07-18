// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!

package org.tensorflow.framework.histogram

/** Serialization format for histogram module in
  * tsl/lib/histogram/histogram.h
  *
  * @param bucketLimit
  *   Parallel arrays encoding the bucket boundaries and the bucket values.
  *   bucket(i) is the count for the bucket i.  The range for
  *   a bucket is:
  *     i == 0:  -DBL_MAX .. bucket_limit(0)
  *     i != 0:  bucket_limit(i-1) .. bucket_limit(i)
  */
@SerialVersionUID(0L)
final case class HistogramProto(
    min: _root_.scala.Double = 0.0,
    max: _root_.scala.Double = 0.0,
    num: _root_.scala.Double = 0.0,
    sum: _root_.scala.Double = 0.0,
    sumSquares: _root_.scala.Double = 0.0,
    bucketLimit: _root_.scala.Seq[_root_.scala.Double] = _root_.scala.Seq.empty,
    bucket: _root_.scala.Seq[_root_.scala.Double] = _root_.scala.Seq.empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[HistogramProto] {
    private[this] def bucketLimitSerializedSize = {
      8 * bucketLimit.size
    }
    private[this] def bucketSerializedSize = {
      8 * bucket.size
    }
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = min
        if (__value != 0.0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeDoubleSize(1, __value)
        }
      };
      
      {
        val __value = max
        if (__value != 0.0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeDoubleSize(2, __value)
        }
      };
      
      {
        val __value = num
        if (__value != 0.0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeDoubleSize(3, __value)
        }
      };
      
      {
        val __value = sum
        if (__value != 0.0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeDoubleSize(4, __value)
        }
      };
      
      {
        val __value = sumSquares
        if (__value != 0.0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeDoubleSize(5, __value)
        }
      };
      if (bucketLimit.nonEmpty) {
        val __localsize = bucketLimitSerializedSize
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__localsize) + __localsize
      }
      if (bucket.nonEmpty) {
        val __localsize = bucketSerializedSize
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__localsize) + __localsize
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
      {
        val __v = min
        if (__v != 0.0) {
          _output__.writeDouble(1, __v)
        }
      };
      {
        val __v = max
        if (__v != 0.0) {
          _output__.writeDouble(2, __v)
        }
      };
      {
        val __v = num
        if (__v != 0.0) {
          _output__.writeDouble(3, __v)
        }
      };
      {
        val __v = sum
        if (__v != 0.0) {
          _output__.writeDouble(4, __v)
        }
      };
      {
        val __v = sumSquares
        if (__v != 0.0) {
          _output__.writeDouble(5, __v)
        }
      };
      if (bucketLimit.nonEmpty) {
        _output__.writeTag(6, 2)
        _output__.writeUInt32NoTag(bucketLimitSerializedSize)
        bucketLimit.foreach(_output__.writeDoubleNoTag)
      };
      if (bucket.nonEmpty) {
        _output__.writeTag(7, 2)
        _output__.writeUInt32NoTag(bucketSerializedSize)
        bucket.foreach(_output__.writeDoubleNoTag)
      };
      unknownFields.writeTo(_output__)
    }
    def withMin(__v: _root_.scala.Double): HistogramProto = copy(min = __v)
    def withMax(__v: _root_.scala.Double): HistogramProto = copy(max = __v)
    def withNum(__v: _root_.scala.Double): HistogramProto = copy(num = __v)
    def withSum(__v: _root_.scala.Double): HistogramProto = copy(sum = __v)
    def withSumSquares(__v: _root_.scala.Double): HistogramProto = copy(sumSquares = __v)
    def clearBucketLimit = copy(bucketLimit = _root_.scala.Seq.empty)
    def addBucketLimit(__vs: _root_.scala.Double *): HistogramProto = addAllBucketLimit(__vs)
    def addAllBucketLimit(__vs: Iterable[_root_.scala.Double]): HistogramProto = copy(bucketLimit = bucketLimit ++ __vs)
    def withBucketLimit(__v: _root_.scala.Seq[_root_.scala.Double]): HistogramProto = copy(bucketLimit = __v)
    def clearBucket = copy(bucket = _root_.scala.Seq.empty)
    def addBucket(__vs: _root_.scala.Double *): HistogramProto = addAllBucket(__vs)
    def addAllBucket(__vs: Iterable[_root_.scala.Double]): HistogramProto = copy(bucket = bucket ++ __vs)
    def withBucket(__v: _root_.scala.Seq[_root_.scala.Double]): HistogramProto = copy(bucket = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = min
          if (__t != 0.0) __t else null
        }
        case 2 => {
          val __t = max
          if (__t != 0.0) __t else null
        }
        case 3 => {
          val __t = num
          if (__t != 0.0) __t else null
        }
        case 4 => {
          val __t = sum
          if (__t != 0.0) __t else null
        }
        case 5 => {
          val __t = sumSquares
          if (__t != 0.0) __t else null
        }
        case 6 => bucketLimit
        case 7 => bucket
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PDouble(min)
        case 2 => _root_.scalapb.descriptors.PDouble(max)
        case 3 => _root_.scalapb.descriptors.PDouble(num)
        case 4 => _root_.scalapb.descriptors.PDouble(sum)
        case 5 => _root_.scalapb.descriptors.PDouble(sumSquares)
        case 6 => _root_.scalapb.descriptors.PRepeated(bucketLimit.iterator.map(_root_.scalapb.descriptors.PDouble(_)).toVector)
        case 7 => _root_.scalapb.descriptors.PRepeated(bucket.iterator.map(_root_.scalapb.descriptors.PDouble(_)).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: org.tensorflow.framework.histogram.HistogramProto.type = org.tensorflow.framework.histogram.HistogramProto
    // @@protoc_insertion_point(GeneratedMessage[tensorboard.HistogramProto])
}

object HistogramProto extends scalapb.GeneratedMessageCompanion[org.tensorflow.framework.histogram.HistogramProto] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[org.tensorflow.framework.histogram.HistogramProto] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): org.tensorflow.framework.histogram.HistogramProto = {
    var __min: _root_.scala.Double = 0.0
    var __max: _root_.scala.Double = 0.0
    var __num: _root_.scala.Double = 0.0
    var __sum: _root_.scala.Double = 0.0
    var __sumSquares: _root_.scala.Double = 0.0
    val __bucketLimit: _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Double] = new _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Double]
    val __bucket: _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Double] = new _root_.scala.collection.immutable.VectorBuilder[_root_.scala.Double]
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 9 =>
          __min = _input__.readDouble()
        case 17 =>
          __max = _input__.readDouble()
        case 25 =>
          __num = _input__.readDouble()
        case 33 =>
          __sum = _input__.readDouble()
        case 41 =>
          __sumSquares = _input__.readDouble()
        case 49 =>
          __bucketLimit += _input__.readDouble()
        case 50 => {
          val length = _input__.readRawVarint32()
          val oldLimit = _input__.pushLimit(length)
          while (_input__.getBytesUntilLimit > 0) {
            __bucketLimit += _input__.readDouble()
          }
          _input__.popLimit(oldLimit)
        }
        case 57 =>
          __bucket += _input__.readDouble()
        case 58 => {
          val length = _input__.readRawVarint32()
          val oldLimit = _input__.pushLimit(length)
          while (_input__.getBytesUntilLimit > 0) {
            __bucket += _input__.readDouble()
          }
          _input__.popLimit(oldLimit)
        }
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    org.tensorflow.framework.histogram.HistogramProto(
        min = __min,
        max = __max,
        num = __num,
        sum = __sum,
        sumSquares = __sumSquares,
        bucketLimit = __bucketLimit.result(),
        bucket = __bucket.result(),
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[org.tensorflow.framework.histogram.HistogramProto] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      org.tensorflow.framework.histogram.HistogramProto(
        min = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Double]).getOrElse(0.0),
        max = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Double]).getOrElse(0.0),
        num = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Double]).getOrElse(0.0),
        sum = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Double]).getOrElse(0.0),
        sumSquares = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Double]).getOrElse(0.0),
        bucketLimit = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Seq[_root_.scala.Double]]).getOrElse(_root_.scala.Seq.empty),
        bucket = __fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).map(_.as[_root_.scala.Seq[_root_.scala.Double]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = org.tensorflow.framework.histogram.HistogramProtoCompanion.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = org.tensorflow.framework.histogram.HistogramProtoCompanion.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[?]= throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[? <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[?]= throw new MatchError(__fieldNumber)
  lazy val defaultInstance = org.tensorflow.framework.histogram.HistogramProto(
    min = 0.0,
    max = 0.0,
    num = 0.0,
    sum = 0.0,
    sumSquares = 0.0,
    bucketLimit = _root_.scala.Seq.empty,
    bucket = _root_.scala.Seq.empty
  )
  implicit class HistogramProtoLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, org.tensorflow.framework.histogram.HistogramProto]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, org.tensorflow.framework.histogram.HistogramProto](_l) {
    def min: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Double] = field(_.min)((c_, f_) => c_.copy(min = f_))
    def max: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Double] = field(_.max)((c_, f_) => c_.copy(max = f_))
    def num: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Double] = field(_.num)((c_, f_) => c_.copy(num = f_))
    def sum: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Double] = field(_.sum)((c_, f_) => c_.copy(sum = f_))
    def sumSquares: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Double] = field(_.sumSquares)((c_, f_) => c_.copy(sumSquares = f_))
    def bucketLimit: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[_root_.scala.Double]] = field(_.bucketLimit)((c_, f_) => c_.copy(bucketLimit = f_))
    def bucket: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[_root_.scala.Double]] = field(_.bucket)((c_, f_) => c_.copy(bucket = f_))
  }
  final val MIN_FIELD_NUMBER = 1
  final val MAX_FIELD_NUMBER = 2
  final val NUM_FIELD_NUMBER = 3
  final val SUM_FIELD_NUMBER = 4
  final val SUM_SQUARES_FIELD_NUMBER = 5
  final val BUCKET_LIMIT_FIELD_NUMBER = 6
  final val BUCKET_FIELD_NUMBER = 7
  def of(
    min: _root_.scala.Double,
    max: _root_.scala.Double,
    num: _root_.scala.Double,
    sum: _root_.scala.Double,
    sumSquares: _root_.scala.Double,
    bucketLimit: _root_.scala.Seq[_root_.scala.Double],
    bucket: _root_.scala.Seq[_root_.scala.Double]
  ): _root_.org.tensorflow.framework.histogram.HistogramProto = _root_.org.tensorflow.framework.histogram.HistogramProto(
    min,
    max,
    num,
    sum,
    sumSquares,
    bucketLimit,
    bucket
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[tensorboard.HistogramProto])
}
