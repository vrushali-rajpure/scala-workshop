
// Immutable Data Structures
// it's a cons list, it's a recursive list

// cons operator is right associated

1 :: 2 :: 3 :: 4 :: Nil

// above will start from Nil , as it's right associated

var xs : List[Int] = List.empty

10 :: xs

var t = 10 :: xs


val l = List(1,2,3,4,5)

l.head
l.tail

