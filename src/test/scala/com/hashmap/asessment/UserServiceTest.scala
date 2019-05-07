package com.hashmap.asessment

import com.hashmap.asessment.model.{Item, Note}
import com.hashmap.asessment.service.{AdminService, Database, UserService}
import org.scalatest.{BeforeAndAfter, FunSuite}

class UserServiceTest extends FunSuite with BeforeAndAfter{
  var adminService : AdminService = _
  var userService : UserService = _
  before{
    adminService = new AdminService()
    userService = new UserService()
    adminService.addItem(Item("Chips", 20, 5))
    adminService.addItem(Item("Coke", 30, 1))
    adminService.addItem(Item("Cake", 40, 3))
    adminService.addItem(Item("Burger", 50, 0))
    Database.addNote(Note("Fifty", 50))
  }

  test("UserService.getAllItems"){
    println(userService.getAllItems())
  }

  test("UserService.getItemPrice"){
    assert(userService.getItemPrice("Burger").get == 50)
    assert(userService.getItemPrice("Coke").get == 50)
    assert(userService.getItemPrice("Cake").get == 50)
  }

  test("UserService.buyItem"){
    assert(30 == userService.buyItem("Chips", List(Note("Fifty", 50))).get)
  }
}
