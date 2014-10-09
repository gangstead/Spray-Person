package com.example.config

import spray.servlet.WebBoot

class Boot extends WebBoot{

  val services = new ActorSystemBean()
  val system = services.system
  override val serviceActor = services.apiRouterActor

}
