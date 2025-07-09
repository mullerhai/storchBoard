import sbt.*
import Keys.*
import sbt.Def.settings

import scala.collection.immutable.Seq

ThisBuild / tlBaseVersion := "0.1.2" // your current series x.y
//ThisBuild / CoursierCache := file("D:\\coursier")
ThisBuild / organization := "io.github.mullerhai" //"dev.storch"
ThisBuild / organizationName := "storch.dev"
ThisBuild / startYear := Some(2024)
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers := List(
  // your GitHub handle and name
  tlGitHubDev("mullerhai", "mullerhai")
)
ThisBuild / version := "0.1.2"

ThisBuild / scalaVersion := "3.6.4"
ThisBuild / tlSonatypeUseLegacyHost := false

import xerial.sbt.Sonatype.sonatypeCentralHost
ThisBuild / sonatypeCredentialHost := sonatypeCentralHost

import ReleaseTransformations._
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("+publishSigned"),
  releaseStepCommandAndRemaining("sonatypeBundleRelease"),
  setNextVersion,
  commitNextVersion,
  pushChanges,
)

lazy val root = (project in file("."))
  .settings(
    name := "storch-tensorboard",

  )
ThisBuild / tlSitePublishBranch := Some("main")

ThisBuild / apiURL := Some(new URL("https://storch.dev/api/"))
libraryDependencies += "com.google.api.grpc" % "proto-google-common-protos" % "2.54.1"
libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % "1.0.0-alpha.1"
// https://mvnrepository.com/artifact/com.thesamet.scalapb/scalapb-runtime
libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % "1.0.0-alpha.1"
//// (optional) If you need scalapb/scalapb.proto or anything from
//// google/protobuf/*.proto
//PB.protoSources in Compile := Seq(file("resources/proto"))
//
//Compile / PB.targets := Seq(
//  scalapb.gen() -> (Compile / sourceManaged).value
//)
libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
)
// https://mvnrepository.com/artifact/io.grpc/grpc-all
libraryDependencies += "io.grpc" % "grpc-all" % "1.71.0"
libraryDependencies += "com.google.code.gson" % "gson" % "2.13.0"
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
libraryDependencies += "commons-io" % "commons-io" % "2.19.0"
// https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl
libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.17.1" //3.0.0-beta2"
//libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "3.0"
libraryDependencies += "org.apache.commons" % "commons-compress" % "1.25.0"

ThisBuild  / assemblyMergeStrategy := {
  case v if v.contains("module-info.class")   => MergeStrategy.discard
  case v if v.contains("UnusedStub")          => MergeStrategy.first
  case v if v.contains("aopalliance")         => MergeStrategy.first
  case v if v.contains("inject")              => MergeStrategy.first
  case v if v.contains("jline")               => MergeStrategy.discard
  case v if v.contains("scala-asm")           => MergeStrategy.discard
  case v if v.contains("asm")                 => MergeStrategy.discard
  case v if v.contains("scala-compiler")      => MergeStrategy.deduplicate
  case v if v.contains("reflect-config.json") => MergeStrategy.discard
  case v if v.contains("jni-config.json")     => MergeStrategy.discard
  case v if v.contains("git.properties")      => MergeStrategy.discard
  case v if v.contains("reflect.properties")      => MergeStrategy.discard
  case v if v.contains("compiler.properties")      => MergeStrategy.discard
  case v if v.contains("scala-collection-compat.properties")      => MergeStrategy.discard
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}