

object @@ {
  def unapply(arg: String): Option[(String, String)] = arg.split("@") match {
    case Array(user, domain) => Some(user, domain)
    case _                   => None
  }
}

def hello(string: String): String = string match {
  case user @@ domain => s"Hello $user from $domain"
  case _              => "error"
}

hello("mushtaq@tw.com")
hello("mushtaq@tw.com@asdas")
hello("mushtaq")
hello("")
