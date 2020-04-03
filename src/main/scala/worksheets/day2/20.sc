
val m = Map(1 -> "a", 2 -> "b")

m(1)
m(2)
//m(20)

m.get(1)
m.get(2)
m.get(20)

sealed trait Option[+A]
case class Some[A](value: A) extends Option[A]
case object None extends Option[Nothing]

object Option {
  def apply[T](x: T): Option[T] = if(x == null) None else Some(x)
  def empty[T]: Option[T] = None
}

Option(102)
Option(null)

None
Option.empty[Int]

val x: Option[Int] = Some(123)
val y: Option[Int] = None

sealed trait List[+A]
case object Nil extends List[Nothing]
case class ::[A](head: A, tail: List[A]) extends List[A]

val value: List[Int] = ::(1, ::(2, Nil))

sealed trait Tree[+T]
case class Node[T](left: Tree[T], right: Tree[T]) extends Tree[T]
case class Leaf[T](value: T) extends Tree[T]
case object Empty extends Tree[Nothing]
