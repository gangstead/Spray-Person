package com.example.config

import akka.actor.ActorSystem
import com.example.actors.routes.ApiRouterActor
import com.example.actors.routes.PersonRoute


object ActorSystemBean {
  def apply(): ActorSystemBean = new ActorSystemBean()
}

class ActorSystemBean {
  import com.example.actors.routes.PersonRoute._
  import com.example.actors.routes.ApiRouterActor._

  implicit val system = ActorSystem("person")

  lazy val personRoute = system.actorOf(PersonRoute.props, "person-route")
  lazy val apiRouterActor = system.actorOf(ApiRouterActor.props(personRoute), "api-router")

}
