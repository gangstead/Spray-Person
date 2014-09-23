package com.example.actors.routes

import javax.inject.Named
import org.springframework.context.annotation.Scope
import spray.routing.HttpService
import javax.inject.Inject
import com.example.config.ActorSystemBean
import akka.actor.Actor
import spray.routing.Directive.pimpApply
import spray.routing.HttpService
import spray.routing.directives.CachingDirectives._
import akka.actor.ActorLogging

import scala.concurrent.duration.Duration

@Named
@Scope("prototype")
class ApiRouterActor @Inject()(asb: ActorSystemBean)extends Actor 
												with HttpService 
												with ActorLogging{
  
  def actorRefFactory = context
  val simpleCache = routeCache(maxCapacity = 1000, timeToIdle = Duration("30 min"))
  def receive = runRoute {
     compressResponseIfRequested(){
         pathPrefix("person") { ctx => asb.personRoute ! ctx }
     }
    
  }

}