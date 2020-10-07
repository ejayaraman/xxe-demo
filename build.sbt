name := "xxe-demo"
 
version := "1.0" 
      
lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(ws, specs2 % Test , guice )

PlayKeys.devSettings += "play.server.http.port" -> "12345"
PlayKeys.devSettings += "play.server.akka.requestTimeout" -> "20s"
PlayKeys.devSettings += "play.server.http.idleTimeout" -> "20s"