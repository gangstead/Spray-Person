package com.example.services

import com.example.model.Person
import scala.collection.mutable.ArrayBuffer

object PersonData {
  val testPeople = ArrayBuffer(
    Person(Some(1), "Bill", "Smith", 5),
    Person(Some(2), "John", "Doe", 10),
    Person(Some(3), "Steven", "Gangstead", 30),
    Person(Some(4), "Andrew", "Rubalcaba", 90))
}
