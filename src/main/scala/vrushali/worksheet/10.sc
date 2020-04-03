// MAP

List.empty[Int]

def map(xs: List[Int], f: Int ⇒ Int): List[Int] = {
  var result: List[Int] = Nil
  val iterator: Iterator[Int] = xs.iterator
  while (iterator.hasNext) {
    result = f(iterator.next()) :: result
  }
  result
}

map(List(1, 2, 3), x ⇒ x * x)


def mapWithRecursion(xs: List[Int], f: Int ⇒ Int): List[Int] = {
  if (xs.isEmpty) Nil else f(xs.head) :: mapWithRecursion(xs.tail, f)
}

"mapWithRecursion--" + mapWithRecursion(List(2, 3, 4), x ⇒ x + 1)
//mapWithRecursion((1 to 1000).toList, _ + 100)

// @railRec : what is it ???
def mapWithRecursionWithStack(xs: List[Int], f: Int ⇒ Int): List[Int] = {

  def inner(remaining: List[Int], accumulator: List[Int]): List[Int] = {
    if (xs.isEmpty) accumulator.reverse
    else inner(xs.tail, f(xs.head) :: accumulator)
  }

  inner(xs, Nil)
}

//mapWithRecursionWithStack((1 to 1000).toList, _ + 100)

//------------------------------
def fold[A, B](xs: List[A], seed: B)(op: (B, A) ⇒ B): B = {
  var result: B = seed
  val iterator = xs.iterator
  while (iterator.hasNext) {
    result = op(result, iterator.next())
  }
  result
}

def foldWithRecursion[A, B](xs: List[A], acc: B)(op: (B, A) ⇒ B): B = {
  if (xs.isEmpty) acc
  else  foldWithRecursion( xs.tail,op(acc,xs.head))(op)
}

def productRecursion(xs: List[Int]): Int = foldWithRecursion(xs, 1)((x, y) ⇒ x * y)
productRecursion(List(1,2,4))
//def stringifyRecursion(xs: List[Int]): String = foldWithRecursion(xs, "")((x, y) ⇒ x + y)

//------------------Reverse------------------

val list: List[Int] = List(1,2,3,4,5)

def reveres[A]( xs : List[A]) : List[A] =
  xs.foldLeft(List.empty[A])((acc,ele) => ele :: acc)

reveres(list)

list.reverse.head
list.reverse.tail.reverse

//---------Remove At------
def removeAt[A]( xs : List[A], index  : Int) : List[A] = {
  val (as,bs) = xs.splitAt(index)
  as ::: bs.tail
}
println("------remove At -----")
removeAt(list,3)
