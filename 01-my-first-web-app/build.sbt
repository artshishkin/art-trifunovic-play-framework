name := """01-my-first-web-app"""
organization := "net.shyshkin"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.15"

libraryDependencies ++=Seq(
  guice,
  evolutions,
  jdbc,
  javaJpa,
  "org.hibernate.orm" % "hibernate-core" % "6.6.1.Final",
  "org.webjars" %% "webjars-play" % "3.0.2",
  "org.webjars" % "bootstrap" % "5.3.3",
  "com.h2database" % "h2" % "2.3.232"
)

resolvers ++=Seq(
  "sonatype snapshots".at("https://oss.sonatype.org/content/repositories/snapshots/"),
  "local maven".at(s"file:///${Path.userHome.absolutePath}/.m2/repository")
)

fork := true
javaOptions += "-Dplay.editor=http://localhost:63342/api/file/?file=%s&line=%s"

PlayKeys.externalizeResourcesExcludes += baseDirectory.value / "conf" / "META-INF" /  "persistence.xml"
// This will make sure the persistence.xml will always be in the build jar file which is important  when it comes to deploying the application somewhere
