import akka.actor.Actor.Receive
import akka.actor.{Props, Actor, ActorSystem}

import scala.concurrent.duration.Duration
import scala.concurrent._
import scala.util.{Success, Try}

/**
 * Created by maatary on 2/18/15.
 */



class PromiseSeterActor() extends Actor {



  override def receive: Receive = {

    case e:Promise[String] => e.success("Done")
    case _ =>
  }
}


object PromiseApp extends App{


  val system = ActorSystem("Promise-system");

  import system.dispatcher

  val promise = Promise[String]()

  //promise.success("hello")

  promise.future onComplete{

    case Success(e) => println(s"the value is: $e")

  }

  val promiseSeterActor = system.actorOf(Props[PromiseSeterActor], "PromiseSeterActor")

  promiseSeterActor ! promise





}
