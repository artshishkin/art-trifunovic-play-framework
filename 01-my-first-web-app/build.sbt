name := """01-my-first-web-app"""
organization := "net.shyshkin"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.15"

libraryDependencies += guice

fork := true
javaOptions += "-Dplay.editor=http://localhost:63342/api/file/?file=%s&line=%s"
