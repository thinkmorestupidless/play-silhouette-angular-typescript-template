import java.io.File
import java.net.InetSocketAddress

import play.sbt.PlayRunHook

import scala.sys.process.Process

object WebpackServer {
  def apply(base: File): PlayRunHook = {

    object WebpackServerScript extends PlayRunHook {

      var process: Option[scala.sys.process.Process] = None // This is really ugly, how can I do this functionally?

      override def afterStarted(): Unit = {
        process = if (System.getProperty("os.name").toUpperCase().indexOf("WIN") >= 0)
          Option(Process("cmd /c npm start", base).run)
        else
          Option(Process("npm start", base).run)
      }

      override def afterStopped(): Unit = {
        process.foreach(p => { p.destroy() })
        process = None
      }
    }

    WebpackServerScript
  }
}