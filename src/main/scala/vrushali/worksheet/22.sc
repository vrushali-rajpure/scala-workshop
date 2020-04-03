
case class Person(name: String, age: Int) // it is pattern matchable as it's a case class

val list = List(1, 2, 3, 4, 5, 6)
val (pre, post) = list.splitAt(3) // this (pre,post) is a pattern match


val person = Person("abc", 2)
val Person(n, a) = person
n
a

// now let's try to achieve pattern matching without case class
// for example Refer JSBoolean' : as it's a abstract class which we want to make extendable
// and hence can't mark it as case class

// 1) Create a companion object with apply to able to construct object and unapply to unable deconstruct
// 2) mark class argument as 'val' to provide getter for properties

class Student(val name: String, val age: Int)

object Student {
  def apply(name: String, age: Int): Student = new Student(name, age)

  def unapply(arg: Student): Option[(String, Int)] = Some(arg.name, arg.age)
}

val student = Student("abc-student", 20)
val Student(nm, ag) = student
nm
ag

def hello(email: String): String = email.split("@") match {
  case Array(user, domain) => s"Hello $user from $domain"
  case _ => "Error"
}

hello("vru@gm.com")
hello("vru@gm@gm.com")
hello("vr")
hello("")

object @@ {
  def unapply(arg: String): Option[(String, String)] = arg.split("@") match {
    case Array(user, domain) => Some(user, domain)
    case _ => None
  }
}

def hello2(input: String): String = input match {
  case user @@ domain => s"Hello $user from $domain"
  case _ => "Error"
}

hello2("vru@gm.com")
hello2("vru@gm@gm.com")
hello2("vr")
hello2("")
