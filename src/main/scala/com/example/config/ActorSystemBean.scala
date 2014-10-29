package com.example.config

<<<<<<< HEAD
import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import akka.actor.ExtensionKey
import akka.actor.ExtendedActorSystem
import com.example.actors.routes.ApiRouterActor
import com.example.actors.routes.PersonRoute
import com.example.services.PersonServiceImpl

=======
import akka.actor.ActorSystem
import com.example.actors.routes.ApiRouterActor
import com.example.actors.routes.PersonRoute

/**
 * Factory method for ActorSystemBean class
 */
>>>>>>> credera/master
object ActorSystemBean {
  def apply(): ActorSystemBean = new ActorSystemBean()
}

<<<<<<< HEAD
=======
/**
 * Defines an actor system with the actors used by
 * the spray-person application
 */
>>>>>>> credera/master
class ActorSystemBean {
  import com.example.actors.routes.PersonRoute._
  import com.example.actors.routes.ApiRouterActor._

  implicit val system = ActorSystem("person")

<<<<<<< HEAD
  lazy val personRoute = system.actorOf(PersonRoute.props(PersonServiceImpl()), "person-route")
  lazy val apiRouterActor = system.actorOf(ApiRouterActor.props(personRoute),"api-router")
=======
  lazy val personRoute = system.actorOf(PersonRoute.props, "person-route")
  lazy val apiRouterActor = system.actorOf(ApiRouterActor.props(personRoute), "api-router")
>>>>>>> credera/master

}
