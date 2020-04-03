val xs = List(1, 2, 3, 4, 5)

xs.init
xs.last


def reverse[A](xs: List[A]): List[A] =
  xs.foldLeft(List.empty[A])((acc, elm) => elm :: acc)

reverse(xs)

xs.reverse.head
xs.reverse.tail.reverse

xs.splitAt(3)

def removeAt[A](xs: List[A], index:Int): List[A] = {
  val (as, bs) = xs.splitAt(index)
  as ::: bs.tail
}

removeAt(xs, 3)
