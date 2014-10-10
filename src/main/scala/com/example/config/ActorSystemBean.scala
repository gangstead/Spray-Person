package com.example.config

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import akka.actor.ExtensionKey
import akka.actor.ExtendedActorSystem
import com.example.actors.routes.ApiRouterActor
import com.example.actors.routes.PersonRoute
import com.example.services.PersonServiceImpl

object ActorSystemBean {
  def apply(): ActorSystemBean = new ActorSystemBean()
}

class ActorSystemBean {
  import com.example.actors.routes.PersonRoute._
  import com.example.actors.routes.ApiRouterActor._

  implicit val system = ActorSystem("person")

  lazy val personRoute = system.actorOf(PersonRoute.props(PersonServiceImpl()), "person-route")
  lazy val apiRouterActor = system.actorOf(ApiRouterActor.props(personRoute),"api-router")

}
