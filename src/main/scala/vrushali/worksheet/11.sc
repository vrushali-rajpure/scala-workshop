

def add(a: Int = 1, b: Int = 2): Int = a + b
add(10, 20)
add()
add(10)
add(b = 30)

//case class Person(name: String, age: Int) :
// it will provide default implementation of getter,
// toString, hashCode, equals and copy constructor

class Person(name: String, val age: Int) {
  def grow(by: Int): Person = new Person(name, age + by)
}

val person1: Person = new Person("abc", 13)
val person2 = new Person("abc", 13)
val person1U = person1.grow(10)

person1U.age
"equal --"
person1 == person2

//-----------------------------------
case class PersonCase(name: String, age: Int) {
  def grow(by: Int): PersonCase = copy(age = age + by)
}

val personCase1: PersonCase = new PersonCase("abc", 13)
val personCase2 = new PersonCase("abc", 13)
val personCase1U = personCase1.grow(10)

personCase1.age
personCase1.name

personCase1 == personCase2
personCase1 eq personCase2 // compared equality by references
personCase1 == personCase1U

personCase1.hashCode()
personCase2.hashCode()
personCase1U.hashCode()

val personCase3 = personCase2.copy(age = 100)
personCase3