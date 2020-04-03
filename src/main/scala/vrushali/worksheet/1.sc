import scala.collection.mutable

def square(x : Int) : Int = x * x;

square(10);

def squareAll(xs : List[Int]) : List[Int] = {

  val buffer = mutable.Buffer.empty[Int]
  val iterator = xs.iterator
  while(iterator.hasNext) {
    val res = iterator.next()
    buffer += square(res)
  }
  buffer.toList
}

squareAll(List(1,2,5));

def incrementAll(xs : List[Int]) : List[Int] = {
  val buffer = mutable.Buffer.empty[Int]
  val iterator = xs.iterator
  while ( iterator.hasNext){
    buffer += iterator.next() + 1
  }
  buffer.toList
}

incrementAll(List(2,3,4))


