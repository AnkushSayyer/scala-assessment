package com.hashmap.asessment.service

import com.hashmap.asessment._
import com.hashmap.asessment.model._

class AdminService {
  def addItem(product: Product) : Boolean = {
    Database.addProduct(product)
  }

  def addAcceptedMoney(money: Money) : Boolean = {
    Database.addAcceptedMoney(money)
  }
}
