import com.typesafe.sbt.packager.archetypes.ServerLoader.SystemV
import com.typesafe.sbt.SbtNativePackager._
import NativePackagerKeys._

organization  := "net.luisguilherme"

version       := "0.1"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature", "-Xfatal-warnings")

packageArchetype.java_server

packageDescription in Linux := "Spray Demo"

maintainer in Linux := "Luis Guilherme Fernandes Pereira"

serverLoading in Debian := SystemV

resolvers += "AOL yoava" at "http://repo.jfrog.org/artifactory/repo"

libraryDependencies ++= {
  val akkaV = "2.3.0"
  val sprayV = "1.3.1"
  val kamonV = "0.3.4"
  Seq(
    "com.typesafe.akka"		%% "akka-actor"		% akkaV,
    "com.typesafe.akka"         %% "akka-slf4j"         % akkaV,
    "com.typesafe.akka"   	%% "akka-testkit"  	% akkaV % "test",
    "io.spray"            	% "spray-caching" 	% sprayV,
    "io.spray"            	% "spray-can" 		% sprayV,
    "io.spray"            	% "spray-client" 	% sprayV,
    "io.spray"            	%% "spray-json"   	% "1.3.0",
    "io.spray"            	% "spray-routing" 	% sprayV,
    "io.spray"            	% "spray-testkit" 	% sprayV % "test",
    "org.scalatest"          	%% "scalatest"        	% "2.2.1" % "test",
    "org.slf4j"                 %  "slf4j-api"          % "1.7.7",
    "org.slf4j"                 %  "slf4j-log4j12"      % "1.7.7"
  )
}

Revolver.settings


