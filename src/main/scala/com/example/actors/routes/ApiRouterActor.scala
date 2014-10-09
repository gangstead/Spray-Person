package com.example.actors.routes

import scala.concurrent.duration.Duration
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorLogging
import akka.actor.Props
import spray.routing.Directive.pimpApply
import spray.routing.HttpService
import spray.routing.HttpService
import spray.routing.directives.CachingDirectives._

object ApiRouterActor{
  def props(personRoute: ActorRef): Props = Props(new ApiRouterActor(personRoute))
}

class ApiRouterActor(personRoute: ActorRef)extends Actor
												with HttpService
												with ActorLogging{

  def actorRefFactory = context
  val simpleCache = routeCache(maxCapacity = 1000, timeToIdle = Duration("30 min"))
  def receive = runRoute {
     compressResponseIfRequested(){
         pathPrefix("person") { ctx => personRoute ! ctx }
				 //~ pathPrefix("app") { getFromResourceDirectory("app") }
     }

  }

}
