package com.hashmap.asessment.service

import com.hashmap.asessment.model.{Coin, Item, Money, Note}
import com.hashmap.asessment.model

import scala.collection.mutable

object Database {
  private val products = scala.collection.mutable.HashSet[model.Item]()
  private var productsMap = scala.collection.mutable.HashMap[String, Item]()
  private val coins = scala.collection.mutable.HashSet[Coin]()
  private val notes = scala.collection.mutable.HashSet[Note]()
  private val acceptedMoney = scala.collection.mutable.HashSet[Money]()

  def addProduct(item: model.Item): Boolean ={
    val size = productsMap.size
    if(addItemToMap(item).size > size)
      false
    else
      true
  }

  def addItemToMap(item: Item): mutable.Map[String, Item] = {
    productsMap += (item.name -> item)
  }
  def getProduct(itemName: String)={
    productsMap.get(itemName)
  }

  def getProductsMap(): mutable.Map[String, Item] ={
    productsMap
  }

  def getAllProducts(): List[model.Item] ={
    products toList
  }
  def addCoin(coin: Coin): Boolean ={
    coins.add(coin)
  }
  def getCoins(): mutable.HashSet[Coin] ={
    return coins
  }
  def addNote(note: Note): Boolean ={
    notes.add(note)
  }
  def getNotes(): mutable.HashSet[Note] ={
    return notes
  }

  def addAcceptedMoney(money: Money): Boolean ={
    acceptedMoney.add(money)
  }

  def updateItemQuantity(itemName : String, quant : Int): Unit ={
    productsMap.get(itemName).get.quantity = quant
  }

  def decrementQuantity(itemName : String, decr : Int): Unit ={
    productsMap.get(itemName).get.quantity -= 1
  }
}
