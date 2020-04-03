
def add(a: Int = 1, b: Int = 3): Int = a + b
add(10, 20)
add()
add(10)
add(b = 23)

case class Person(name: String, age: Int) {
  def grow(by: Int): Person = copy(age = age + by)
}

val person1: Person = Person("mushtaq", 53)
val person2 = new Person("mushtaq", 53)

val person1U = person1.grow(11)

person1 == person2
person1 eq person2
person1 == person1U

person1.hashCode()
person2.hashCode()
person1U.hashCode()

person1.age
person1.name

person2
val person3 = person2.copy(age = 100)
person2



