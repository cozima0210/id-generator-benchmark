
name := """id-generator-benchmark"""
organization := "cozima0210"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(JmhPlugin, PlayScala)

scalaVersion := "2.12.8"

crossScalaVersions := Seq("2.12.8", "2.11.12")

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.2" % Test
libraryDependencies += "mysql"          % "mysql-connector-java"             % "8.0.16"
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc"                    % "3.3.2"
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc-config"             % "3.3.2"
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc-play-dbapi-adapter" % "2.7.0-scalikejdbc-3.3"
