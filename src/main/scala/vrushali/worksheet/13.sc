

object Logger {
  private val PI = 3.14
  def log(x: String) = println(x)
}

Logger.log("ABC")
Logger.log("XYZ")

// Logger.PI - not visible


class Logger{
  Logger.PI // companion has special visibility access
  // and they can access private member
}
