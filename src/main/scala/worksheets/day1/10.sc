
val xs = List(1, 2, 3, 4, 5)

xs.foldLeft(0)(_ + _)
xs.reduceLeft(_ + _)

List.empty[Int].foldLeft(0)(_ + _)
List.empty[Int].reduceLeft(_ + _)

xs.foldLeft("")(_ + _)
