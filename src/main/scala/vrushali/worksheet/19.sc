
"abcss".isInstanceOf[String] // this is check for instance type
"asasa".asInstanceOf[Any] // this is to cast the instance

def combine(a: Option[String], b: Option[String]): Option[String] = {

  if (a.isEmpty) return b
  else if (b.isEmpty) return a
  else Some(a.get.concat(b.get))
}

def combine2(a: Option[String], b: Option[String]): Option[String] = {

  if (a == None) b
  else if (b == None) a
  else {
    val x = a.asInstanceOf[Some[String]]
    val y = b.asInstanceOf[Some[String]]
    Some(x.value + y.value)
  }
}

// pattern matching use construct

(1, 2) match {
  case (a: Int, b) => a + b
}

// with pattern matching

def combineWithPatternMatching(a: Option[String], b: Option[String]): Option[String] = (a, b) match {
  case (Some(x), Some(y)) => Some(x + y)
  case (None, _) => b // here '_' is ignore... if first is None so I don't care what comes in second
  case (_, None) => a
  //  case (None, None) => None // unreachable code

}

// map on option

def map[S, T](a: Option[S])(f: S => T): Option[T] = a match {
  case Some(value) => Some(f(value))
  case None => None
}

map(Some(10))(_ + 1)
map(Some(10))(_ * 2)
map(Some(10))(a => a * a)
// map(Option.empty(Int))(_ + 1) // check why this does not compile

// companion for Option
object Option {
  def apply[T](x: T): Option[T] = if (x == null) None else Some(x)

  def empty[T](x: T): Option[T] = None
}

Option(100)
Option(null) // this gives option if Null which is not very useful where we want type of what we passed in

Option.empty(Int)