
implicit val y: Int = 5



def findanInt(implicit x: Int): Unit = println(x)


findanInt
trait Foo
object Foo {
   implicit val afoo = new Foo {
    override def toString = "a foo object "
  }

   val me = 2

  implicit val list = List(new Foo {
    override def toString = "a Food List element"
  })
}

def takeFoo(implicit thefoo: Foo) = {
  print(thefoo)
}

takeFoo


import Foo.me

def takeFooList(implicit thefooList: List[Foo]) = {
  println(thefooList)
}

takeFooList
val e = implicitly[List[Foo]]

