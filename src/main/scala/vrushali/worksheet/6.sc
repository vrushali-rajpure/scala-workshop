//currying effect: grouping of argument so that type
// inference happens due to scala compiler
// folding ?

def operation[A,B](xs: List[A], seed: B)( op: (B, A) => B): B = {
  var result: B = seed
  val iterator = xs.iterator
  while (iterator.hasNext) {
    result = op(result, iterator.next())
  }
  result
}

def productAll1(xs: List[Int]) = operation(xs, 1)((result, element) => result * element)
def sumAll1(xs: List[Int]) = operation(xs, 0)((result, element) => result + element)
sumAll1(List(6, 7, 8))
productAll1(List(6, 7, 8))


def stringify( xs: List[Int]) : String = {
  var str : String = ""
  val iterator = xs.iterator
  while (iterator.hasNext) {
    str = str +  iterator.next()
  }
  str
}

stringify(List(1,2,3,4))

def stringifyAll( xs : List[Int]) : String = operation(xs,"")((result, element) => result + element)

stringifyAll(List(6,7,8))