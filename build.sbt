name := "owls"

version := "0.1"

scalaVersion := "2.12.6"

scalacOptions ++= Seq(
  "-encoding", "UTF-8",   // source files are in UTF-8
  "-deprecation",         // warn about use of deprecated APIs
  "-unchecked",           // warn about unchecked type parameters
  "-feature",             // warn about misused language features
  "-language:higherKinds",// allow higher kinded types without `import scala.language.higherKinds`
  "-Xlint",               // enable handy linter warnings
  "-Xfatal-warnings",     // turn compiler warnings into errors
  "-Ypartial-unification" // allow the compiler to unify type constructors of different arities
)

lazy val catsVersion = "1.1.0"
lazy val jenaVersion = "3.7.0"
lazy val scalatestVersion = "3.0.5"

libraryDependencies += "org.typelevel" %% "cats-core" % catsVersion
libraryDependencies += "org.typelevel" %% "cats-laws" % catsVersion
libraryDependencies += "org.apache.jena" % "jena-arq" % jenaVersion
libraryDependencies += "org.apache.jena" % "jena-core" % jenaVersion
libraryDependencies += "org.scalactic" %% "scalactic" % scalatestVersion
libraryDependencies += "org.scalatest" %% "scalatest" % scalatestVersion % "test"
libraryDependencies += "junit" % "junit" % "4.12" % Test


addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.6")