package com.hashmap.asessment.service

import com.hashmap.asessment.model.{Coin, Item, Money, Note}

class UserService {
  def getAllItems(): List[Item] ={
    Database.getProductsMap().toList.filter(temp => temp._2.quantity>0).map(temp => temp._2)
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

  def isMoneyAcceptable(money: List[Money]): Boolean = {
    val coins = Database.getCoins()
    val notes = Database.getNotes()
    money forall { money =>
      money match {
        case c: Coin => coins.contains(c)
        case n: Note => notes.contains(n)
        case _ => false
      }
    }
  }

  def calculateValue(money: List[Money]): Int = {
    def calculate(money : List[Money]): Int ={
      if(money==Nil)
        0
      else
        money.head.value + calculate(money.tail)
    }
    calculate(money)
  }

  def buyItem(itemName: String, money: List[Money]): Option[Int] ={
    val itemPrice = getItemPrice(itemName).get
    if(isMoneyAcceptable(money)){
      val moneyGiven = calculateValue(money)
      if(moneyGiven<itemPrice)
        None
      else
        Some(moneyGiven - itemPrice)
    }
    else
     None
  }

  def buyItems(items : List[String], money: List[Money]): Unit ={
    val totalPrice : Int = 0
  }
}
