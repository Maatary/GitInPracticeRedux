/**
 * Created by maatary on 2/12/15.
 */


import akka.util.Timeout
import akka.util.Timeout._

import scala.concurrent.duration._

import scala.concurrent.{Await, Future}

object TThreadAPP extends App {

  import scala.concurrent.ExecutionContext.Implicits.global


  //implicit val timeout = Timeout(5 seconds)
  val future: Future[String] = Future {

    println("done with the future"); "hello"

  }

  Await.result(future, Duration.Inf)

  future foreach println
}
