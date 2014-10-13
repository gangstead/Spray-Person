package com.example.services

import com.example.model.Person

object PersonServiceImpl {
  def apply(): PersonServiceImpl = new PersonServiceImpl()
}

class PersonServiceImpl extends PersonService {
  import PersonData.testPeople

  def getPersons: List[Person] = {
    testPeople.toList
  }

  def getPersonById(personId: Long): Option[Person] = {
    testPeople find (_.id == Some(personId))
  }

  def addPerson(person: Person): Person = {
    val maxId = testPeople.map(_.id).flatten.max + 1
    val newPerson = person.copy(id = Some(maxId))
    testPeople += newPerson
    newPerson
  }

  def updatePerson(person: Person): Boolean = {
    testPeople.indexWhere(_.id == person.id) match {
      case -1 => false
      case i => testPeople.update(i, person); true
    }
  }

  def deletePerson(id: Long): Unit = {
    getPersonById(id) match {
      case Some(person) => testPeople -= person
      case None =>
    }
  }

}
