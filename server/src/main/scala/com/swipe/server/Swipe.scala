package com.swipe.server

import scala.collection.mutable

object Swipe {
	
	private val rulesEngine = new RulesEngine
	
	rulesEngine.start

	def processTransaction(transaction: Transaction) {
		rulesEngine ! transaction
	}

}