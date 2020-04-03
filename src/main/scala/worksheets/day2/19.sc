
trait Animal
class Tiger extends Animal
case class Lion() extends Animal

val lion: Lion = new Lion
val x: Animal = lion

val lions: Array[Lion] = Array(new Lion)
//val ls: Array[Animal] = lions
//
//ls(0)
//ls(0) = new Tiger
//ls(0)

val lions2: List[Lion] = List(new Lion)

val ls2 = new Tiger :: lions2


