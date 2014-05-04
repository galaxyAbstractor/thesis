name := "dbtest"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.google.code.gson" % "gson" % "2.2.4",
  "mysql" % "mysql-connector-java" % "5.1.30"
)     

play.Project.playJavaSettings
