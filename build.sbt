
/*
 * BASIC INFORMATION
 ********************************************************/

name := "ubirch-date-utils"
version := "0.5.4"
description := "a collection of date related utils"
organization := "com.ubirch.util"
homepage := Some(url("http://ubirch.com"))
scalaVersion := "2.11.12"
scalacOptions ++= Seq(
  "-feature"
)
scmInfo := Some(ScmInfo(
  url("https://github.com/ubirch/ubirch-date-utils"),
  "https://github.com/ubirch/ubirch-date-utils.git"
))

/*
 * CREDENTIALS
 ********************************************************/

(sys.env.get("CLOUDREPO_USER"), sys.env.get("CLOUDREPO_PW")) match {
  case (Some(username), Some(password)) =>
    println("USERNAME and/or PASSWORD found.")
    credentials += Credentials("ubirch.mycloudrepo.io", "ubirch.mycloudrepo.io", username, password)
  case _ =>
    println("USERNAME and/or PASSWORD is taken from /.sbt/.credentials")
    credentials += Credentials(Path.userHome / ".sbt" / ".credentials")
}

/*
 * RESOLVER
 ********************************************************/


resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"))


/*
 * PUBLISHING
 ********************************************************/

val resolverUbirchUtils = "ubirch.mycloudrepo.io" at "https://ubirch.mycloudrepo.io/repositories/ubirch-utils-mvn"

publishTo := Some(resolverUbirchUtils)
publishMavenStyle := true


/*
 * DEPENDENCIES
 ********************************************************/


val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val jodaTime = "joda-time" % "joda-time" % "2.10"
val jodaConvert = "org.joda" % "joda-convert" % "2.1.1"


libraryDependencies ++= Seq(
  jodaTime,
  jodaConvert,
  scalaTest % "test"
)


