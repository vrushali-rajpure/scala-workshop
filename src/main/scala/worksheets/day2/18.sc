val flag: Boolean = true

trait Base
class D1 extends Base
class D2 extends Base

def x = if(flag) new D1 else new D2
def x1 = if(flag) new D1 else new Base {}
def x2 = if(flag) new D1 else "asdads"
def x3 = null
def x4 = if(flag) new D1 else null
def x4a = if(flag) 10 else null
def x5 = if(flag) new D2 else null

def x6 = if(flag) true else 9.8
def x7 = if(flag) false else "asdasd"

def x8 = ()
def x9 = if(flag) true else ()
def x10 = if(flag) "asdasd"
def x11 = if(flag) 10

def x12: String = if(flag) "asdasd" else throw new RuntimeException
def x13 = if(flag) 100 else throw new RuntimeException
def x14 = throw new RuntimeException
def x15 = if(flag) null else throw new RuntimeException
def x16: Int = 100
def x17: Unit = 100
def x18: Any = 100

x17.asInstanceOf[Int]
x18.asInstanceOf[Int]


















