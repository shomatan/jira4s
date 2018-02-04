name := "jira4s-core"

libraryDependencies ++= Seq(
  "io.spray"      %% "spray-json"   % "1.3.3",
  "org.typelevel" %% "cats-core"    % "1.0.0-RC1",
  "org.typelevel" %% "cats-kernel"  % "1.0.0-RC1",
  "org.typelevel" %% "cats-macros"  % "1.0.0-RC1",
  "org.typelevel" %% "cats-free"    % "1.0.0-RC1",
  "co.fs2"        %% "fs2-core"     % "0.10.0-RC1",
  "co.fs2"        %% "fs2-io"       % "0.10.0-RC1",
  "org.scalatest" %% "scalatest"    % "3.0.1"       % "test"
)