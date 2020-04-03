// var : is mutable
// val : is immutable

def sum(xs: List[Int]): Int = {
  var sum: Int = 0
  val iterator = xs.iterator
  while (iterator.hasNext) {
    sum += iterator.next()
  }
  sum
}

sum(List(1, 2, 3))

def product(xs: List[Int]): Int = {
  var product: Int = 1
  val iterator = xs.iterator
  while (iterator.hasNext) {
    product *= iterator.next()
  }
  product
}

product(List(1, 2, 3, 4))

// extract common part

def summation(result: Int, element: Int) = result + element
def product1(result: Int, element: Int) = result * element

def operation(xs: List[Int], initialResult: Int, op: (Int, Int) => Int): Int = {
  var result: Int = initialResult
  val iterator = xs.iterator
  while (iterator.hasNext) {
    result = op(result, iterator.next())
  }
  result
}

def sumAll(xs: List[Int]) = {
  operation(xs, 0, summation)
}

def productAll(xs: List[Int]) = {
  operation(xs, 1, product1)
}

sumAll(List(3, 4, 5))
productAll(List(3, 4, 5))


// with function literal
def productAll1(xs: List[Int]) = operation(xs, 1, (result, element) => result * element)
def sumAll1(xs: List[Int]) = operation(xs, 0, (result, element) => result + element)

sumAll1(List(6, 7, 8))
productAll1(List(6, 7, 8))