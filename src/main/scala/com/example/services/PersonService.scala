package com.example.services

import com.example.model.Person

trait PersonService {

  def getPersons: List[Person]
  def getPersonById(id: Long): Option[Person]
  def addPerson(person: Person): Person
  def updatePerson(person : Person): Boolean
  def deletePerson(id: Long): Unit

}
