package com.swipe.server

import scala.collection.mutable

object Swipe {
	
	private val webService = new WebService
	private val rulesEngine = new RulesEngine
	
	rulesEngine.start

	def start() {
		val transactions: mutable.ArrayBuffer[Transaction] = this.webService.getTransactions()		
		transactions.foreach(transaction => {
			// TODO: verify if the transaction should be sent to the rules engine; meaning is it tied to one of our customers
			// if so, then save to db first
			rulesEngine ! transaction
		})
	}

}