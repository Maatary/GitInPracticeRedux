import java.io.File

import scala.collection.immutable.Stream.cons
import scala.concurrent.{Promise, Future}

/*private def scanFiles(docRoot: String): Future[Seq[String]] = Future {
  new File(docRoot).list().map(docRoot + _)
}*/


def receive: PartialFunction[String, Unit] = {

  case e:String => ()

}

var stream = Map(6 -> 2, 3 -> 4, 4 -> 6).toStream.map(e => (e._1 * e._2, 0))

//Stream.cons(Map(18 -> 19), stream)

//stream foreach(println (_))

def printname (name:  => Unit, flag: Boolean) = {

  if (flag == true)  name else "no mame"


}



printname(println("Maatari"), true)
class Person (val name:String)
object Person {
  def apply(name:String) = new Person(name.toString)
}



Person("4").name
//val seq:Map[String, Int] = Seq(2)


val pairs = for (x <- 0 until 4; y <- 0 until 4) yield (x, y)
(0 until 4).flatMap (x => (0 until 4).map(y => (x,y)))
val me = "Daniel"
println(s"hey there i am $me")
val code : Unit = { println("Block of code") }

def runCode (code: => Unit, flag: Boolean) = {

  if (flag == true)
    code

}

runCode(code, true)


val p = Promise[String]

p.success("")

