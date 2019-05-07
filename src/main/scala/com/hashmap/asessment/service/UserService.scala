package com.hashmap.asessment.service

import com.hashmap.asessment.model.Item

class UserService {
  def getAllItems(): List[Item] ={
    Database getAllProducts() filter(product => product.quantity>0)
  }

  def getItemPrice(itemName : String): Option[Int] = {
    Database getProduct(itemName) match {
      case Some(value) => Some(value.price)
      case _ => None
    }
  }

  def getItems(items : List[String]): Unit ={
    val itemSet = items.toSet
    Database.getProductsMap().toList.filter(temp => itemSet.contains(temp._1))
  }
}
