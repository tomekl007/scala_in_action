name := "Nano Http server"

version := "1.0"

organization := "Scala in Action"

scalaVersion := "2.10.0"

// append options passed to the Scala compiler
scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.13" % "test"
)

libraryDependencies += "commons-logging" % "commons-logging" % "1.1.1"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.1.2"
