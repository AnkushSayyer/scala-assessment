package com.hashmap.asessment.service

import com.hashmap.asessment.{Coin, Money, Note, model}

object Database {
  private val products = scala.collection.mutable.HashSet[model.Product]()
  private val coins = scala.collection.mutable.HashSet[Coin]()
  private val notes = scala.collection.mutable.HashSet[Note]()
  private val acceptedMoney = scala.collection.mutable.HashSet[Money]()

  def addProduct(product: model.Product): Boolean ={
    products.add(product)

  }
  def getProduct()={

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
