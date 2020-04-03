
val xs = List(1, 2, 3, 4, 5, 6)

val (pre, post) = xs.splitAt(3)


class Person(val name: String, val age: Int)
object Person {
  def apply(name: String, age: Int): Person = new Person(name, age)

  def unapply(arg: Person): Option[(String, Int)] = Some(arg.name, arg.age)
}

val person = Person("mushtaq", 53)
val Person(name, age) = person
