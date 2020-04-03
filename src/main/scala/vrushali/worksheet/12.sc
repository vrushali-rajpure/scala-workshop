
// Singleton

trait DD

object Logger extends DD

val x = Logger
x: Object
x: AnyRef
x: DD

// every instance in scala are associated with it's name
x: Logger.type
x: x.type


val a = "abc"
val b = "abc"

a : String
a : a.type
//b : a.type