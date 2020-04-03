

"asdads".isInstanceOf[String]
"asdads".asInstanceOf[Any]

def combine(a: Option[String], b: Option[String]): Option[String] = {
  if (a == None) b
  else if (b == None) a
  else {
    val x = a.asInstanceOf[Some[String]]
    val y = b.asInstanceOf[Some[String]]
    Some(x.value + y.value)
  }
}

(1, 2) match {
  case (1, b) => b
  case (a, b) => a + b
}

def combine2(a: Option[String], b: Option[String]): Option[String] = (a, b) match {
  //  case t                  =>
  //  case (x, y)             =>
  case (Some(x), Some(y)) => Some(x + y)
  case (None, _)          => b
//  case (_, None)          => a
//  case (None, None)       => None
}
