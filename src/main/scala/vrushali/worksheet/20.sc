//Methods on ADT (List)


def length[T](list: List[T]): Int = list match {
  case Nil => 0
  case ::(_, tail) => 1 + length(tail)
}

length(List(1, 2, 3))
length(List("a", "b", "c", "d"))
length(List())

::(1, ::(2, Nil)) // Type - 1

1 :: 2 :: Nil // Type - 2

// Type - 1 and Type - 2 are two different ways of constructing list

// insert into the list

def insert(list: List[Int], insertEle: Int): List[Int] = list match {
  case Nil => insertEle :: Nil
  case ::(head, tail) => if (insertEle < head) insertEle :: list else head :: insert(tail, insertEle)
}


insert(List(1, 2, 4), 3)
insert(List(2, 3, 4), 1)
insert(List(2, 3, 4), 5)

// with guard condition inside case

def insertWithGuard(list: List[Int], insertEle: Int): List[Int] = list match {
  case Nil => insertEle :: Nil
  case head :: _ if (insertEle < head) => insertEle :: list
  case head :: tail => head :: insertWithGuard(tail, insertEle)
}

insertWithGuard(List(1, 2, 4), 3)
insertWithGuard(List(2, 3, 4), 1)
insertWithGuard(List(2, 3, 4), 5)

// sort integer :: insertion sort

def sort(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case ::(head, tail) => insert(sort(tail), head)
}

sort(List(11, 10, 1))

