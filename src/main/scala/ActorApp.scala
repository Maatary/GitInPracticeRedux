import akka.actor.{Props, ActorSystem, Actor}
import akka.actor.Actor.Receive

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by maatary on 2/10/15.
 */
object ActorApp extends App {



  class MyActor extends Actor {

    def receive  = {

      case e:String => {

        Future { Thread.sleep(5000); println("hey i'm done with the background task: " + e); context.system.shutdown()}


      }
    }
  }


  val actorsytem = ActorSystem("my-system")

  val myactor = actorsytem.actorOf(Props[MyActor])

  myactor ! "do this"

  println("waiting termination")
  actorsytem.awaitTermination();
  println("done waiting")

}
