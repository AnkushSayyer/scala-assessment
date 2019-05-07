package com.hashmap.asessment

import com.hashmap.asessment.model.Item
import com.hashmap.asessment.service.{AdminService, Database}
import org.scalatest.{BeforeAndAfter, FunSuite}

class AdminServiceTest extends FunSuite with BeforeAndAfter{
  var adminService : AdminService = _
  before{
    adminService = new AdminService()
  }

  test("AdminServiceTest.addItem"){
    assert(adminService.addItem(Item("Chips", 20, 5)) == true)
  }

  test("AdminService.addMoney"){
    assert(adminService.addAcceptedMoney(Coin("Five", 5)) == true)
    assert(adminService.addAcceptedMoney(Note("10", 10)) == true)
  }
}
