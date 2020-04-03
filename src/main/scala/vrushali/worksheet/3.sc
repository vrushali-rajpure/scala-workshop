

val square: Int => Int  = x =>  x * x // it's a value, function is an object
val increment: Int => Int  = x =>  x + 1

def square1(x : Int) : Int = x * x // it's a method of a object

square(10)
square.apply(10)
square1(10)

// treat a method like a function
//ETA expansion - converting a method to function
// search for ETA language

//ETA expansion example
val square2 : Int => Int = square1

// so when a method is expecting a function , u can pass in method to that method with signature
// fun : Int => Int , as it helps to convert method to function using ETA expansion

