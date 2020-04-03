
// Collection data structures in Scala

val list: List[Int] = List(1, 2, 3, 4)

list(1)
list.apply(1)

list: List[Int] // assert compile type equality
//list: Int => Int // means list implements Function1

val set = Set(1, 2, 2, 1)

set.contains(2)
set.contains(3)
"apply--" + set.apply(1) // check contains, since it is an characteristic function of set
"set(4)--" + set(4)

set: Set[Int]
//set: Int => Boolean // characteristic function of set is a predicate

val m = Map(1 -> "a", 2 -> "b")

"m(1)--" + m(1)
m(2)

m: Map[Int, String]
//m: Int => String

// reduceLeft special form of foldLeft with first element as seeding element
list.foldLeft(0)(_ + _)
list.reduceLeft(_ + _)
list.foldLeft("")(_ + _)

List.empty[Int].foldLeft(0)(_ + _)
//List.empty[Int].reduceLeft(_ + _) : non supported as list does not have any element inside it

//sorting collection

import data.Data._

books.foreach(println)

books.sortBy(_.basePrice)
books.sortBy(_.author)
books.sortBy(book => (book.author, -book.basePrice)).foreach(println)

books.minBy(_.basePrice)
