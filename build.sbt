import AssemblyKeys._ 

assemblySettings

/** Project */
name := "chill-akka-custom"

version := "0.3.6"

organization := "com.twitter"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-optimize", "-Yinline-warnings", "-feature", "-deprecation", "-Xelide-below", "INFO" )

assembleArtifact in packageScala := true

excludedJars in assembly <<= (fullClasspath in assembly) map { cp => 
  cp filter {_.data.getName == "minlog-1.2.jar"}
}

parallelExecution in Test := false

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

EclipseKeys.withSource := true

jarName in assembly := "chill-akka-custom-0.3.6.jar"

/** Dependencies */
libraryDependencies ++= Seq(
  "com.esotericsoftware.kryo" % "kryo" % "2.21" % "compile",
  "com.twitter" %% "chill" % "0.3.6",
  "com.typesafe.akka" %% "akka-actor" % "2.1.4" ,
  "com.typesafe" % "config" % "0.3.1" ,
  "org.scala-lang" % "scala-library" % "2.10.4" % "compile",
  "org.scalacheck" %% "scalacheck" % "1.11.0" % "test",
  "org.scala-tools.testing" %% "specs" % "1.6.9" % "test"
)

resolvers += "Scala-Tools Repository" at "https://oss.sonatype.org/content/groups/scala-tools/"

resolvers += "Sonatype Snapshots Repository" at "https://oss.sonatype.org/content/repositories/snapshots/"

