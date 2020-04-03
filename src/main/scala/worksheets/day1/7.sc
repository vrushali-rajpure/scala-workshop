
val list: List[Int] = List(1, 2, 3)

list(1)
list.apply(1)

list: List[Int]

list: Int => Int


val s: Set[Int] = Set(1, 2, 2, 1)
s.contains(2)
s.contains(20)
s.apply(20)
s.apply(2)
s(2)
s(20)

s: Set[Int]
s: Int => Boolean

val m = Map(1 -> "a", 2 -> "b")
m(1)
m(2)

m: Map[Int, String]
m: Int => String
