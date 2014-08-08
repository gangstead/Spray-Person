package com.example.model

import spray.json.DefaultJsonProtocol

case class Person(id:Option[Long],firstName:String, lastName:String, age:Int)

object PersonJsonProtocol extends DefaultJsonProtocol{
    implicit val tacoFormat = jsonFormat4(Person)
}