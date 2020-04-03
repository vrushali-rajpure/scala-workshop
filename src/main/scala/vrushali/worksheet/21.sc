//Composition : Generic sort and Insert

trait Ord[A] {
  def lt(a: A, b: A): Boolean
}


object Ord {
  val intOrd: Ord[Int] = (a: Int, b: Int) => a < b
  val stringOrd: Ord[String] = (a: String, b: String) => a < b

  val optionIntOrd: Ord[Option[Int]] = (a: Option[Int], b: Option[Int]) => (a, b) match {
    case (Some(x), Some(y)) => intOrd.lt(x, y)
    case (None, _) => true
    case (_, None) => false
  }
  val optionStringOrd: Ord[Option[String]] = (a: Option[String], b: Option[String]) => (a, b) match {
    case (Some(x), Some(y)) => x < y
    case (None, _) => true
    case (_, None) => false
  }

  def optionOrd[A](ord: Ord[A]): Ord[Option[A]] = (a: Option[A], b: Option[A]) => (a, b) match {
    case (Some(x), Some(y)) => ord.lt(x, y)
    case (None, _) => true
    case (_, None) => false
  }

  def pairOrd[A, B](ordA: Ord[A])(ordB: Ord[B]): Ord[(A, B)] = (a: (A, B), b: (A, B)) => {
    if (ordA.lt(a._1, b._1)) true
    else if (ordA.lt(b._1, a._1)) false
    else ordB.lt(a._2, b._2)
  }
}

def insertWithGuardWithComparator[T](list: List[T], insertEle: T)(ord: Ord[T]): List[T] = list match {
  case Nil => insertEle :: Nil
  case head :: _ if ord.lt(insertEle, head) => insertEle :: list
  case head :: tail => head :: insertWithGuardWithComparator(tail, insertEle)(ord)
}

def sortWithComparator[T](xs: List[T])(ord: Ord[T]): List[T] = xs match {
  case Nil => Nil
  case ::(head, tail) => insertWithGuardWithComparator(sortWithComparator(tail)(ord), head)(ord)
}

insertWithGuardWithComparator(List(1, 2, 4), 3)(Ord.intOrd)
insertWithGuardWithComparator(List(2, 3, 4), 1)(Ord.intOrd)
insertWithGuardWithComparator(List(2, 3, 4), 5)(Ord.intOrd)

sortWithComparator(List(11, 8, 3, 5, 1))(Ord.intOrd)
sortWithComparator(List("s", "t", "a"))(Ord.stringOrd)
sortWithComparator(List("s", "t", "a", "b"))(Ord.stringOrd)
sortWithComparator(List())(Ord.stringOrd)

sortWithComparator(List(Option(10), Option.empty[Int], Option(3)))(Ord.optionIntOrd)

sortWithComparator(List(Option("s"), Option.empty[String], Option("a")))(Ord.optionStringOrd)

sortWithComparator(List(Option(11), Option.empty[Int], Option(4)))(Ord.optionOrd(Ord.intOrd))

sortWithComparator(List(Option("t"), Option.empty[String], Option("b")))(Ord.optionOrd(Ord.stringOrd))

sortWithComparator(List((10, "z"), (10, "a"), (1, "m")))(Ord.pairOrd(Ord.intOrd)(Ord.stringOrd))

//sortWithComparator(List(Option(10, "t"), Option.empty[String], Option(20, "b")))(Ord.pairOrd(Ord.optionOrd(Ord.optionIntOrd))(Ord.optionOrd(Ord.optionStringOrd)))

// implicit : strategy composition is lexically scoped not global scoped
// no natural ordering in scala
