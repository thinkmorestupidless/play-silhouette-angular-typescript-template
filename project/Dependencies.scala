import sbt._

object Dependencies {

  object Version {
    val silhouette = "6.1.0"
    val playVersion = play.core.PlayVersion.current
    val playMailerVersion = "7.0.0"
    val ficus = "1.4.3"
  }

  val resolvers = Seq(
    Resolver.jcenterRepo
  )

  val common = Seq(
    "com.mohiva" %% "play-silhouette" % Version.silhouette,
    "com.mohiva" %% "play-silhouette-password-bcrypt" % Version.silhouette,
    "com.mohiva" %% "play-silhouette-persistence" % Version.silhouette,
    "com.mohiva" %% "play-silhouette-crypto-jca" % Version.silhouette,
    "com.mohiva" %% "play-silhouette-testkit" % Version.silhouette,

    "com.typesafe.play" %% "play-mailer" % Version.playMailerVersion,
    "com.typesafe.play" %% "play-mailer-guice" % Version.playMailerVersion,
    "com.enragedginger" %% "akka-quartz-scheduler" % "1.6.1-akka-2.5.x",

    "com.iheart" %% "ficus" % Version.ficus,
    "net.codingwell" %% "scala-guice" % "4.2.0"
  )
}