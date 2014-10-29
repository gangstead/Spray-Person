package com.example.config

<<<<<<< HEAD
import spray.servlet.WebBoot
import ActorSystemBean._

class Boot extends WebBoot{

  val services = ActorSystemBean()
  val system = services.system
  override val serviceActor = services.apiRouterActor
=======
import akka.io.IO
import spray.can.Http
import ActorSystemBean._

/**
 * Gets an actor system from the ActorSystemBean and initializes
 * a stand alone spray-can http server with it.
 *
 * @see [[com.example.actors.config.ActorSystemBean]]
 */
object Boot extends App {

  val services = ActorSystemBean()
  implicit val system = services.system
  val service = services.apiRouterActor

  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)
>>>>>>> credera/master

}
