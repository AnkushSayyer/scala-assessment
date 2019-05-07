package com.hashmap.asessment

import com.hashmap.asessment.model.Item
import com.hashmap.asessment.service.{AdminService, UserService}
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
  }

  test("UserService.getAllItems"){
    println(userService.getAllItems())
  }

  test("UserService.getItemPrice"){
    assert(userService.getItemPrice("Burger").get == 50)
    assert(userService.getItemPrice("Coke").get == 50)
    assert(userService.getItemPrice("Cake").get == 50)
  }
}
