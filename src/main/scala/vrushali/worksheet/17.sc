// BinaryTree

// mine
sealed trait Node

case class NonLeafNode(left: Node, right: Node) extends Node

case class LeafNode(value: T) extends Node

class T(root: Node)

// correct / session
sealed trait Tree[+T]

case class NodeEle[T](left: Tree[T], right: Tree[T]) extends Tree[T]

case class LeafEle[T](value: T) extends Tree[T]

case object EmptyRoot extends Tree[Nothing]