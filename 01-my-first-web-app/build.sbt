name := """01-my-first-web-app"""
organization := "net.shyshkin"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.15"

libraryDependencies += guice
libraryDependencies ++=Seq(
  guice,
  "org.apache.derby" % "derby" % "10.17.1.0",
  "org.webjars" %% "webjars-play" % "3.0.2",
  "org.webjars" % "bootstrap" % "5.3.3"
)

resolvers ++=Seq(
  "sonatype snapshots".at("https://oss.sonatype.org/content/repositories/snapshots/"),
  "local maven".at(s"file:///${Path.userHome.absolutePath}/.m2/repository")
)

fork := true
javaOptions += "-Dplay.editor=http://localhost:63342/api/file/?file=%s&line=%s"
