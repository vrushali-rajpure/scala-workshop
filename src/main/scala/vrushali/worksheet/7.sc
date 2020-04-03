// folding

def operation[A,B](xs: List[A], seed: B)( op: (B, A) => B): B = {
  var result: B = seed
  val iterator = xs.iterator
  while (iterator.hasNext) {
    result = op(result, iterator.next())
  }
  result
}

def map(xs : List[Int], op : Int => Int) = {
  operation(xs,List.empty[Int])((accumulator,ele) => op(ele) :: accumulator).reverse
}

map(List(1,2,3), x => x * x)
