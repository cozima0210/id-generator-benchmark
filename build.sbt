name := """id-generator-benchmark"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.0"

libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += "mysql"             %  "mysql-connector-java" % "8.0.16"
libraryDependencies += "com.typesafe.play" %% "play-slick"           % "4.0.2"
