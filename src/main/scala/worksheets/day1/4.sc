



def fold[A, B](xs: List[A], seed: B)(op: (B, A) ⇒ B): B = {
  var result: B = seed
  val iterator = xs.iterator
  while (iterator.hasNext) {
    result = op(result, iterator.next())
  }
  result
}

def fold2[A, B](xs: List[A], acc: B)(op: (B, A) ⇒ B): B = {
  if(xs.isEmpty) acc else fold2(xs.tail, op(acc, xs.head))(op)
}

def add(a: Int, b: Int) = a + b

def sum(xs: List[Int]): Int = fold(xs, 0)(add)

def product(xs: List[Int]): Int = fold(xs, 1)((x, y) ⇒ x * y)

def stringify(xs: List[Int]): String = fold(xs, "")((x, y) ⇒ x + y)

def map(xs: List[Int], f: Int ⇒ Int): List[Int] =
  fold(xs, List.empty[Int])((acc, elm) ⇒ f(elm) :: acc).reverse

sum(List(1, 2, 3, 4))
product(List(1, 2, 3, 4))
stringify(List(1, 2, 3, 4))
map(List(1, 2, 3, 4), x ⇒ x * x)
