package com.example.services

import com.example.model.Person

trait PersonService {

  def getPersonList():List[Person]
  def getPersonById(id:Long):Option[Person]
  def addPerson(person:Person):Person

}
