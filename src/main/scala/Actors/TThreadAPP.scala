package Actors

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
 * Created by maatary on 2/23/15.
 */
object TThreadAPP extends App {

  import scala.concurrent.ExecutionContext.Implicits.global


  //implicit val timeout = Timeout(5 seconds)
  val future: Future[String] = Future {

    println("done with the future"); "hello"

  }

  Await.result(future, Duration.Inf)

  future foreach println
}
