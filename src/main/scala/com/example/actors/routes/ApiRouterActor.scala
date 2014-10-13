package com.example.actors.routes

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorLogging
import akka.actor.Props
import spray.routing.HttpService

object ApiRouterActor {
  def props(personRoute: ActorRef): Props = Props(new ApiRouterActor(personRoute))
}

class ApiRouterActor(personRoute: ActorRef) extends Actor
  with HttpService
  with ActorLogging {

  def actorRefFactory = context
  def receive = runRoute {
    compressResponseIfRequested() {
      pathPrefix("api") {
        pathPrefix("person") { ctx => personRoute ! ctx }
      } ~
        getFromResourceDirectory("app")
    }

  }

}
