package com.swipe.server

import scala.collection.mutable

class WebService {
	
	private val transactions = new mutable.ArrayBuffer[Transaction]()
	
	def getTransactions() : mutable.ArrayBuffer[Transaction] = {
		for (i <- 1 to 20) {
			val transaction = this.getMockTransaction(i, (i * 10.00), i)
			transactions += transaction
		}
		transactions
	}
	
	private def getMockTransaction(transactionId: Int, amount: Double, customerId: Int) : Transaction = {
		val notification = if (customerId % 2 == 0) Notification.Email else Notification.Text
		return new Transaction(transactionId, amount, new Customer(customerId, notification))
	}

}