import java.io.File

import scala.collection.immutable.Stream.cons
import scala.concurrent.Future

/*private def scanFiles(docRoot: String): Future[Seq[String]] = Future {
  new File(docRoot).list().map(docRoot + _)
}*/


def receive: PartialFunction[String, Unit] = {

  case e:String => ()

}

var stream = Map(6 -> 2, 3 -> 4, 4 -> 6).toStream.map(e => (e._1 * e._2, 0))

//Stream.cons(Map(18 -> 19), stream)

//stream foreach(println (_))

