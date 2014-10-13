package com.example.config

import akka.io.IO
import spray.can.Http
import ActorSystemBean._

object Boot extends App {

  val services = ActorSystemBean()
  implicit val system = services.system
  val service = services.apiRouterActor

  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)

}
