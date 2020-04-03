import data.Data._

books.foreach(println)

books.sortBy(_.author)
books.sortBy(book => (-book.basePrice, book.title)).foreach(println)

books.sortBy(_.basePrice)

books.minBy(_.basePrice)
books.maxBy(_.basePrice)
