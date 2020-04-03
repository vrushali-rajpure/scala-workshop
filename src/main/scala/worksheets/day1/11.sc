import scala.annotation.tailrec

def map(xs: List[Int], f: Int ⇒ Int): List[Int] = {
  if(xs.isEmpty) Nil else f(xs.head) :: map(xs.tail, f)
}

map(List(1, 2, 3, 4), _ + 100)
map((1 to 4).toList, _ + 100)
map((1 to 1000).toList, _ + 100)

def map2(xs: List[Int], f: Int ⇒ Int): List[Int] = {
  @tailrec
  def inner(remaining: List[Int], acc: List[Int]): List[Int] = {
    if(remaining.isEmpty) acc.reverse
    else inner(remaining.tail, f(remaining.head) :: acc)
  }

  inner(xs, Nil)
}


map2((1 to 10000).toList, _ + 100)
