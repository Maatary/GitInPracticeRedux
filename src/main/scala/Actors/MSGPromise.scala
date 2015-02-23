package Actors

import scala.concurrent.Promise

/**
 * Created by maatary on 2/18/15.
 */


case class MSGPromise(msg: String, promise: Promise[String])
