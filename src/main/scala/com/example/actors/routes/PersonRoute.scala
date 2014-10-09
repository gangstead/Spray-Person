package com.example.actors.routes

import spray.routing.HttpServiceActor
import com.example.config.ActorSystemBean
import akka.actor.ActorLogging
import com.example.model.Person
import com.example.model.PersonJsonProtocol._
import spray.httpx.SprayJsonSupport._
import spray.http.StatusCodes
import com.example.services.PersonService
import akka.actor.Props

object PersonRoute {
	def props(personService: PersonService): Props = Props(new PersonRoute(personService))
}

class PersonRoute(personService: PersonService) extends HttpServiceActor {

   def receive = runRoute {
     get {
        pathEnd {
           val personList = personService.getPersonList
           personList match{
             case head::tail => complete(personList)
             case nil => complete(StatusCodes.NoContent)

           }
            complete(personList)
          }~
          path(LongNumber){personId =>
            val person = personService.getPersonById(personId)
            complete(person)
          }
     }~
     post {
    	 pathEnd {
	        entity(as[Person]) { person =>
	          val newPerson = personService.addPerson(person)
	          complete(newPerson)
        }
      }
    }~
     put{
        path(LongNumber){personId =>
           complete(StatusCodes.NoContent)
        }
      }~
     delete{
        path(LongNumber){pesonId =>
           complete(StatusCodes.NoContent)
        }
      }
   }


}
