import code.{Ord, Sorter}
import data.{Book, Data}

Sorter.sort(List(3, 2, 10, 4 , 100))

Sorter.sort(List("s", "z", "a"))

{
  Sorter.sort(List(Option(10), Option.empty[Int], Option(3)))
}

Sorter.sort(List(Option("s"), Option.empty[String], Option("a")))

Sorter.sort(List((10, "z"), (10, "a"), (1, "m")))

Sorter.sort(List((Some(10), Some("z")), (Some(10), None), (None, Some("m"))))

Sorter.sort(Data.books).foreach(println)
