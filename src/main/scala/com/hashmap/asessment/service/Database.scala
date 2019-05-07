package com.hashmap.asessment.service

import com.hashmap.asessment.model.Item
import com.hashmap.asessment.{Coin, Money, Note, model}

import scala.collection.mutable

object Database {
  private val products = scala.collection.mutable.HashSet[model.Item]()
  private var productsMap = scala.collection.mutable.HashMap[String, Item]()
  private val coins = scala.collection.mutable.HashSet[Coin]()
  private val notes = scala.collection.mutable.HashSet[Note]()
  private val acceptedMoney = scala.collection.mutable.HashSet[Money]()

  def addProduct(item: model.Item): Boolean ={
    addItemToMap(item)
    products.add(item)
    //productsMap += (name -> product)
  }

  def addItemToMap(item: Item) = {
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
  def getCoin() ={

  }
  def addNote(note: Note): Boolean ={
    notes.add(note)
  }
  def getNote() ={

  }

  def addAcceptedMoney(money: Money): Boolean ={
    acceptedMoney.add(money)
  }
}
