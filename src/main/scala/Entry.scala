package net.luisguilherme.ponger

import org.slf4j.LoggerFactory
import scala.concurrent._
import scala.language.postfixOps

import akka.actor.Actor
import spray.http._
import spray.routing._

class Entry extends Actor with Service {
  implicit def actorRefFactory = context

  implicit def executionContext = context.dispatcher

  def receive = runRoute(route)
}

trait Service extends HttpService {
  implicit def executionContext : ExecutionContext

  val log = LoggerFactory.getLogger(getClass)

  // Routes:
  //   - /status/health_check: health check (ping) url for the service
  val route =
    get {
      path("status" / "health_check") {
        complete(StatusCodes.OK)
      } 
    }
}
