import scala.collection.mutable

def map(xs: List[Int], op: Int ⇒ Int): List[Int] = {
  val buffer = mutable.Buffer.empty[Int]

  val iterator = xs.iterator
  while (iterator.hasNext) {
    val x = iterator.next()
    buffer += op(x)
  }

  buffer.toList
}

"asdasd"

val square: Int ⇒ Int = x ⇒ x * x

def square1(x: Int): Int = x * x
val square2: Int ⇒ Int = square1
val square3: Int ⇒ Int  = square1


square(10)
square.apply(10)
square1(10)

def squareAll(xs: List[Int]): List[Int] = map(xs, square1)

def incrAll(xs: List[Int]): List[Int] = map(xs, x ⇒ x + 1)

squareAll(List(1, 2, 3))
incrAll(List(1, 2, 3))


123
