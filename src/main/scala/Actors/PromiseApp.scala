package Actors

import akka.actor.{ActorRef, ActorSystem, Props}

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}

/**
 * Created by maatary on 2/23/15.
 */
object PromiseApp extends App{


  val system = ActorSystem("Promise-system")



  def sendStringMessage (msg: String, actor: ActorRef) (implicit executor: ExecutionContext): Future[String] = {

    val promise = Promise[String]()

    promiseSeterActor ! MSGPromise(msg, promise)

    promise.future
  }


  val promiseSeterActor = system.actorOf(Props[PromiseSeterActor], "PromiseSeterActor")

  import Actors.PromiseApp.system.dispatcher

  sendStringMessage("helloMsg", promiseSeterActor) onComplete{

    case Success(e) => println(s"a successful response: $e has returned")

    case Failure(e) => println("failed")

  }





}
