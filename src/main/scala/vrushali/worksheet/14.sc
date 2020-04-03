// designing enum

sealed trait Day //----
object Day { // ------  same name for type and wrapper called companion type
case object Weekday extends Day

  case object Weekend extends Day

}


// sealed : only objects in this file can extend and not any other component outside

def m(day: Day) = {}

m(Day.Weekday)
m(Day.Weekend)

Day.Weekend
Day.Weekday


var flag: Boolean = true

trait Base

class D1 extends Base

class D2 extends Base

def x = if (flag) new D1 else new D2
def x1 = if (flag) new D1 else new Base {}
def x2 = if (flag) new D1 else ""
// scala everything is value and value has a type
def x3 = null
def x4 = if (flag) new D1 else null
def x5 = if (flag) new D2 else null
def x6 = if (flag) true else 9.8
def x7 = if (flag) 8.0 else 9.8
def x8 = if (flag) 8 else 9
def x9 = if (flag) false else "xxx"
def x10 = () // represents UNIT or void in scala
def x11 = {}
def x12 = (100)
def x13 = if (flag) false else ()
def x14 = if (flag) 10 else null
def x15 = if (flag) "kdkjfkd"
def x16 = if (flag) 10
def x17 = if (flag) "fdfd" else throw new RuntimeException
def x18 = if (flag) 10 else throw new RuntimeException
def x19 = throw new RuntimeException
def x20 = if (flag) null else throw new RuntimeException
def x21 :Int = 20
def x22 : Unit = 100 // marking int as unit, we are discarding type
def x23 : Any = 100

x23.asInstanceOf[Int]
 //x22.asInstanceOf[Int] : gives class cast exception


//                        Any
//        /                         \
//    AnyVal                      AnyRef(Object)
//      /                            /            \
//  Bool,Float,Int,Unit           CustomObj     String
//                                      \         /
//                                        Null
//              \ \                       /
//                      Nothing
