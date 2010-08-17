package com.swipe.server

object Swipe {
	
	private val rulesEngine = new RulesEngine
	
	rulesEngine.start

	def processTransaction(transaction: Transaction) {
		rulesEngine ! transaction
	}

}