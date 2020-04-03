


object Logger {
  private val PI = 3.142
  def log(x: String) = println(x)
  def m(l: Logger) = l.x
}

class Logger {
  private val x = 10
  Logger.PI
}

Logger.log("hello")
Logger.log("hello")

