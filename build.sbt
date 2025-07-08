ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.4"

lazy val root = (project in file("."))
  .settings(
    name := "storchBoard"
  )
libraryDependencies += "com.google.api.grpc" % "proto-google-common-protos" % "2.54.1"
libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % "1.0.0-alpha.1"
// https://mvnrepository.com/artifact/com.thesamet.scalapb/scalapb-runtime
libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % "1.0.0-alpha.1"
// (optional) If you need scalapb/scalapb.proto or anything from
// google/protobuf/*.proto
//PB.protoSources in Compile := Seq(file("resources/proto"))

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value
)
libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
)
// https://mvnrepository.com/artifact/io.grpc/grpc-all
libraryDependencies += "io.grpc" % "grpc-all" % "1.71.0"

libraryDependencies += "commons-io" % "commons-io" % "2.19.0"
// https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl
libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.17.1" //3.0.0-beta2"
//libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "3.0"

libraryDependencies += "com.google.code.gson" % "gson" % "2.13.0"

libraryDependencies += "org.apache.commons" % "commons-compress" % "1.25.0"
// https://mvnrepository.com/artifact/io.grpc/grpc-protobuf
libraryDependencies += "io.grpc" % "grpc-protobuf" % "1.71.0"
// https://mvnrepository.com/artifact/io.grpc/grpc-api
libraryDependencies += "io.grpc" % "grpc-api" % "1.71.0"
// https://mvnrepository.com/artifact/io.grpc/grpc-netty
libraryDependencies += "io.grpc" % "grpc-netty" % "1.71.0"
// https://mvnrepository.com/artifact/io.grpc/grpc-stub
libraryDependencies += "io.grpc" % "grpc-stub" % "1.71.0"
// https://mvnrepository.com/artifact/io.grpc/grpc-core
libraryDependencies += "io.grpc" % "grpc-core" % "1.71.0"
// https://mvnrepository.com/artifact/io.grpc/grpc-netty-shaded
libraryDependencies += "io.grpc" % "grpc-netty-shaded" % "1.71.0"