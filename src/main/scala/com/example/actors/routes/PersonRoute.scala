package com.example.actors.routes

import com.example.model.Person
import com.example.model.PersonJsonProtocol._
import com.example.services.PersonService

import akka.actor.Props
import spray.http.StatusCodes
import spray.httpx.SprayJsonSupport._
import spray.routing.HttpService
import spray.httpx.SprayJsonSupport
import akka.actor.Actor

object PersonRoute {
  def props: Props = Props(new PersonRoute())
}

class PersonRoute() extends Actor with PersonRouteTrait {
  def actorRefFactory = context
  def receive = runRoute(personRoute)
}

trait PersonRouteTrait extends HttpService with SprayJsonSupport{

  private val personService = PersonService

  val personRoute = {
    get {
      pathEnd {
        complete {
          val persons = personService.getPersons
          persons match {
            case head :: tail => persons
            case nil => StatusCodes.NoContent
          }
        }
      } ~
      path(LongNumber) { personId =>
        val person = personService.getPersonById(personId)
        complete(person)
      }
    } ~
    (post & pathEnd) {
      entity(as[Person]) { person =>
        val newPerson = personService.addPerson(person)
        complete(StatusCodes.Created, newPerson)
      }
    } ~
    (put & path(LongNumber) & pathEnd) { personId =>
      entity(as[Person]) { person =>
        val updatedPerson = personService.updatePerson(person.copy(id = Some(personId)))
        updatedPerson match {
          case true => complete(StatusCodes.NoContent)
          case false => complete(StatusCodes.NotFound)
        }
      }
    } ~
    (delete & path(LongNumber) & pathEnd) { personId =>
      personService.deletePerson(personId)
      complete(StatusCodes.NoContent)
    }
  }

}
