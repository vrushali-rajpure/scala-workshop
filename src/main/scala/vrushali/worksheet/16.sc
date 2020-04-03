//implement option using generics


val m = Map(1 -> "a", 2 -> "b")
m(1)
m(2)
//m(20) gives an exception
// Scala methods returning null is not idiomatic

m.get(1)
m.get(2)
val option: scala.Option[String] = m.get(20)

sealed trait Option[+T]

case class Some[+T](t: T) extends Option[T] {
  def isEmpty: Boolean = {
    if (t == null) false else true
  }

  def get: T = {
    t
  }
}

case object None extends Option[Nothing]

val x: Option[Int] = Some(123)
val y: Option[Int] = None

sealed trait Li[+T]

case class ::[+T](head:T, tail : Li[T]) extends Li[T]

case object Nil extends Li[Nothing]

val l1: Li[Int] = ::(1,::(1,Nil))
val l2: Li[Int] = Nil