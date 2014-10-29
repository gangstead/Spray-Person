<<<<<<< HEAD
=======
name := """spray-person"""

>>>>>>> credera/master
organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.10.3"

<<<<<<< HEAD
jetty()

=======
>>>>>>> credera/master
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaV = "2.2.3"
  val sprayV = "1.2.0"
  Seq(
    "io.spray"            %   "spray-servlet"     % sprayV,
    "io.spray"            %   "spray-routing"     % sprayV,
    "io.spray"            %   "spray-testkit"     % sprayV,
    "io.spray"            %   "spray-client"      % sprayV,
    "io.spray"            %   "spray-util"        % sprayV,
    "io.spray"            %   "spray-caching"     % sprayV,
<<<<<<< HEAD
    "io.spray"            %%  "spray-json"        % "1.2.5",
    "com.typesafe.akka"   %%  "akka-slf4j"        % "2.1.4",
    "ch.qos.logback"      %   "logback-classic"   % "1.0.13",
    "org.eclipse.jetty"       %   "jetty-webapp"  % "8.1.13.v20130916" ,
    "org.eclipse.jetty"       %   "jetty-plus"    % "8.1.13.v20130916" ,
    "org.eclipse.jetty.orbit" %   "javax.servlet" % "3.0.0.v201112011016" artifacts Artifact("javax.servlet", "jar", "jar"),
=======
    "io.spray"            %   "spray-can"         % sprayV,
    "io.spray"            %%  "spray-json"        % "1.2.5",
    "com.typesafe.akka"   %%  "akka-slf4j"        % "2.1.4",
    "ch.qos.logback"      %   "logback-classic"   % "1.0.13",
>>>>>>> credera/master
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV,
    "org.specs2"          %%  "specs2"        % "2.2.3" % "test"
  )
}

<<<<<<< HEAD
webappSrc in webapp := baseDirectory.value / "app"
=======
//sbt-revolver plugin allows restarting the application when files change (including angular files in the /app folder)
//Just run sbt or activator with the command `~ re-start` instead of `run`
Revolver.settings

unmanagedResourceDirectories in Compile <+= (baseDirectory)

excludeFilter in unmanagedResources := HiddenFileFilter || "node_modules*" || "project*" || "target*"
>>>>>>> credera/master
