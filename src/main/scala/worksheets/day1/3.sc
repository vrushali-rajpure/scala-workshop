
List.empty[Int]

def map(xs: List[Int], f: Int ⇒ Int): List[Int] = {
  var result: List[Int] = Nil
  val iterator = xs.iterator
  while (iterator.hasNext) {
    result = f(iterator.next()) :: result
  }
  result
}

map(List(1, 2, 3), x ⇒ x * x)


val ints = 3 :: Nil
1 :: 2 :: ints

val xs = List(1, 2, 3, 4, 5)

xs.head
xs.tail
