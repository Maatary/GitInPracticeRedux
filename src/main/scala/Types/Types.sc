import scala.collection.immutable.List

type callback[T] = Function1[T, Unit]

val callback : callback[Int] = x => println(x)
callback(2)
def foo[A](x:A):Unit = {println(x)}
val fooInt = foo[Int] _
foo[String]("hello1")
foo("hello2")
foo[Int](2)
def callback2[T] = (t:T) =>println(t)
 def fooList[T <: Int](x: List[T]) = x.map{e => e + 1}

def fooList[A <: Traversable[Int]](x: A) =  x.map{ (e:Int) => e + 1 }
class Paramclass[A >: Int] {

  val x: A = 2
}
class T[ +A] {}
var x = new T[Any]
val y = new T[String]
 x = y
class U [-A]
val u1: U[String] = new U[AnyRef]

def f : Function1[String, AnyRef] = (x:AnyRef) => x.toString

val list:List[_ <: Int] = List()

1 :: list

implicit def totoString(x: Int) = x.toString

def printString(x: String) = x.toString

val tostringView = 2

printString(tostringView)