// Library functions
import data.Data._

val xs = List(1, 2, 3, 4)

xs.map(x => x * x)
xs.map(x => x * 1)
xs.map(_ + 1) // _ point free notation
xs.foldLeft(0)((acc, ele) => acc + ele)
xs.foldLeft(1)((acc, ele) => acc * ele)
xs.sum
xs.product


// forEach : does has side effect; does not return anything
// map : does not have side effects ; return result

books.foreach(println)
books.map(book => book.basePrice)


books.groupBy(book => book.author).map(pair => (pair._1, pair._2.map(_.basePrice).sum))
  .foreach(println)


books.groupBy(_.author).mapValues(_.map(_.basePrice).sum).foreach(println)