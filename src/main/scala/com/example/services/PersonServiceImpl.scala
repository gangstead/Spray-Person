package com.example.services

import scala.math
import com.example.model.Person
import com.example.config.ActorSystemBean
import akka.actor.Props

object PersonServiceImpl {
  def apply(): PersonServiceImpl = new PersonServiceImpl()
}

class PersonServiceImpl extends PersonService {
//  import asb._ // make the implicit ActorSystem available for sendRecieve
//  import asb.system.dispatcher // execution context for futures below
  import PersonData._

  def getPersonList():List[Person] = {
    testPeople
  }

  def getPersonById(PersonId:Long):Option[Person] ={
     testPeople find (_.id == Some(PersonId))
  }

  def addPerson(person:Person):Person ={
    val maxId = testPeople collect ({case Person(Some(id),_,_,_) => id}) reduceLeft ( _ max _ )
    val newPerson = new Person(Some(maxId + 1), person.firstName,person.lastName,person.age)
    testPeople = testPeople :+ newPerson
    newPerson
  }

}
