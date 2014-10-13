package com.example.actors.routes

import com.example.model.Person
import com.example.model.PersonJsonProtocol._
import com.example.services.PersonService

import akka.actor.Props
import spray.http.StatusCodes
import spray.httpx.SprayJsonSupport._
import spray.routing.HttpServiceActor

object PersonRoute {
  def props(personService: PersonService): Props = Props(new PersonRoute(personService))
}

class PersonRoute(personService: PersonService) extends HttpServiceActor {

  def receive = runRoute {
    get {
      pathEnd {
        val persons = personService.getPersons
        persons match {
          case head :: tail => complete(persons)
          case nil => complete(StatusCodes.NoContent)
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
