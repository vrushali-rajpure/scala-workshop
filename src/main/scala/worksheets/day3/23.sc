
def map[A, B](a: Option[A])(f: A => B): Option[B] = a match {
  case Some(value) => Some(f(value))
  case None        => None
}


map(Some(10))(_ + 1)
map(Some(10))(_ + 1)
map(Option.empty[Int])(_ + 1)

def length[A](xs: List[A]): Int = xs match {
  case Nil          => 0
  case head :: tail => 1 + length(tail)
}

::(1, ::(2, Nil))

1 :: 2 :: Nil

