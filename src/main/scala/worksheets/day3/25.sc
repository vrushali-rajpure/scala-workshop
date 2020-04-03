

import data.Data._

books.sortBy(_.basePrice).foreach(println)
books.sortBy(_.author).foreach(println)
books.sortBy(book => (book.author, book.basePrice)).foreach(println)
books.minBy(book => (book.author, book.basePrice))

List(2, 3, 1, 5, 100).sorted


List(2, 3, 1, 5, 100).map(_ + 10)
