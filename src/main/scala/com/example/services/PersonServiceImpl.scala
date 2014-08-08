package com.example.services

import com.example.model.Person
import javax.inject.Inject
import javax.inject.Named
import com.example.config.ActorSystemBean

@Named
class PersonServiceImpl @Inject()(asb: ActorSystemBean) extends PersonService {
  import asb._ // make the implicit ActorSystem available for sendRecieve
  import asb.system.dispatcher // execution context for futures below 
  
  def getPersonList():List[Person] = {
    val person = new Person(Some(1),"Bill", "Smith", 5)
    val secondPerson = new Person(Some(2),"John","Doe", 10)
    List(person,secondPerson)
  }
  
  def getPersonById(PersonId:Long):Person ={
     val person = new Person(Some(1),"John", "Candy", 15)
     println(person)
     person
  }
  
  def addPerson(person:Person):Person ={
    val newPerson = new Person(Some(3), person.firstName,person.lastName,person.age)
    newPerson
  }

}