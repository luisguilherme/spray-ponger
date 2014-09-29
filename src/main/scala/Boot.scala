package net.luisguilherme.ponger

import scala.concurrent._
import scala.concurrent.duration._
import scala.language.postfixOps

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http

object Boot extends App {
  implicit val system = ActorSystem("ponger")

  val serviceActor = system.actorOf(Props[Entry], "controller")

  implicit val timeout = Timeout(20 seconds)
  IO(Http) ? Http.Bind(serviceActor, interface = "0.0.0.0", port = 8080)
}
