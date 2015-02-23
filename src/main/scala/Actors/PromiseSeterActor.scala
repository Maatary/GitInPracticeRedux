package Actors

import akka.actor.Actor

import scala.concurrent.Promise

/**
 * Created by maatary on 2/23/15.
 */
class PromiseSeterActor() extends Actor {



  override def receive: Receive = {

    case MSGPromise(msg:String, p: Promise[String])  => p.success(s"message $msg processed")
    case _ =>
  }
}
