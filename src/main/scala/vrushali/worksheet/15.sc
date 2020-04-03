trait Animal

class Tiger extends Animal
class Lion extends Animal

val lion: Lion = new Lion
lion: Animal

val lions: Array[Lion] = Array(new Lion)
//lions : Array[Animal] // give u an error

val lionList: List[Lion] = List(new Lion)

val ls2 = new Tiger :: lionList