package com.example.config

import spray.servlet.WebBoot
import ActorSystemBean._

class Boot extends WebBoot{

  val services = ActorSystemBean()
  val system = services.system
  override val serviceActor = services.apiRouterActor

}
