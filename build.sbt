name := """play-java-akka-camel"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "com.typesafe.akka" %% "akka-camel" % "2.4.0",
  "org.apache.camel"  % "camel-jetty" % "2.16.0",
  "org.apache.camel"  % "camel-jms" % "2.16.0",
  "org.apache.camel"  % "camel-stream" % "2.16.0",
  "org.apache.camel"  % "camel-restlet" % "2.16.0",
  "org.apache.activemq"  % "activemq-core" % "5.7.0",
  "org.apache.activemq"  % "activemq-camel" % "5.12.1"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// need for the restlet stuff
resolvers += "Spring.io milestones" at "http://repo.spring.io/libs-milestone"