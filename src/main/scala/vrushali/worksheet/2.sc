import scala.collection.mutable

//Function Literal : (x : Int) => x * x

trait Op {
  def apply(x: Int): Int
}

// Using Classes
class IncrementOperation extends Op {
  override def apply(x: Int) = x + 1
}

class SquareOperation extends Op {
  override def apply(x: Int) = x * x
}

def performOperationUsingClass(xs: List[Int], operation: Op): List[Int] = {
  val buffer = mutable.Buffer.empty[Int]
  val iterator = xs.iterator
  while (iterator.hasNext) {
    buffer += operation.apply(iterator.next())
  }
  buffer.toList
}

performOperationUsingClass(List(3, 4, 5), new SquareOperation)
performOperationUsingClass(List(3, 4, 5), new IncrementOperation)

// Using Function Literal
def squareAll(xs: List[Int]): List[Int] = {
  performOperationUsingClass(xs, (x: Int) => x * x)
}

def incrementAll(xs: List[Int]): List[Int] = {
  performOperationUsingClass(xs, (x: Int) => x + 1)
}

squareAll(List(5, 6, 7))
incrementAll(List(5, 6, 7))

// Using passing function
def performOperation(xs: List[Int], f: Int => Int): List[Int] = {
  val buffer = mutable.Buffer.empty[Int]
  val iterator = xs.iterator
  while (iterator.hasNext) {
    buffer += f(iterator.next())
  }
  buffer.toList
}


performOperation(List(1, 2, 3), x => x * x)
performOperation(List(1, 2, 3), x => x + 1)

val square: Int => Int  = x =>  x * x // it's a value
val increment: Int => Int  = x =>  x + 1

performOperation(List(1, 2, 3), increment)
performOperation(List(1, 2, 3), square)

