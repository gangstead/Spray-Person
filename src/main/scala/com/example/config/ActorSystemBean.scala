package com.example.config

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import javax.inject.Named
import javax.inject.Inject
import org.springframework.context.ApplicationContext
import akka.actor.ExtensionKey
import akka.actor.ExtendedActorSystem
import com.example.actors.routes.ApiRouterActor
import com.example.actors.routes.PersonRoute


/**
 * An Akka Extension which holds the ApplicationContext for creating actors from bean templates.
 */
object SpringExt extends ExtensionKey[SpringExt]
class SpringExt(system: ExtendedActorSystem) extends Extension {
  @volatile var ctx: ApplicationContext = _
}

@Named
class ActorSystemBean  @Inject() (ctx: ApplicationContext) {
  
   implicit val system = ActorSystem("person")

  /**
   * This stores the ApplicationContext within the ActorSystem’s Spring
   * extension for later use.
   */
  SpringExt(system).ctx = ctx
  lazy val personRoute = system.actorOf(Props(SpringExt(system).ctx.getBean(classOf[PersonRoute])))
  lazy val apiRouterActor = system.actorOf(Props(SpringExt(system).ctx.getBean(classOf[ApiRouterActor])))
  

}