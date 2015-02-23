package Actors

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorSystem, Props}

import scala.concurrent.Future
import scala.concurrent.duration.Duration

//import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by maatary on 2/10/15.
 */



object ActorApp extends App {


  case class Greetings()

  class MyActor extends Actor {



    def receive  = {

      case e:String => {

        import context.dispatcher

        Future { Thread.sleep(5000); println("hey i'm done with the background task: " + e); context.system.shutdown()}

        context.system.scheduler.schedule(Duration.Zero, Duration(1000, TimeUnit.MILLISECONDS), self, Greetings()) (context.dispatcher, self)

      }

      case e: Greetings => println(s"gretting receive $sender")
    }
  }


  val actorsytem = ActorSystem("my-system")

  val myactor = actorsytem.actorOf(Props[MyActor], "Daniel")

  myactor ! "do this"

  println("waiting shutdown signal")
  //actorsytem.awaitTermination();
  println("done waiting")



}



