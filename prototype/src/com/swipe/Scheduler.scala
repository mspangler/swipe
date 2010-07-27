package com.swipe

import scala.collection.{immutable, mutable}

/**
 * This class would probably run on a fast timer so that it could read the transactions that are
 * being fed into the banks database??
 * 
 * @author mspangler
 */
class Scheduler {
	
	private val transactions = new mutable.ArrayBuffer[Transaction]()
	
	/**
	 * This method would return back transactions from the database.
	 * TODO: Maybe use Spring Batch to send the transactions to the rules engine as they're being returned back from the database to
	 * avoid holding them all in memory??
	 *
	 * @return list of transactions
	 */
	def getTransactions() : mutable.ArrayBuffer[Transaction] = {

		for (i <- 1 to 20) {
			val transaction = getMockTransaction(i, (i * 20.00), i)
			transactions += transaction
		}
		
		return transactions		
	}
	
	/**
	 * Generate a mock Transaction
	 * 
	 * @param transactionId
	 * @param amount
	 * @param customerId
	 * @return
	 */
	def getMockTransaction(transactionId: Int, amount: Double, customerId: Int) : Transaction = {
		// Scala's ternary operator
		val notifyMethod = if (customerId % 2 == 0) NotifyMethod.Email else NotifyMethod.Text
		return new Transaction(transactionId, amount, new Customer(customerId, notifyMethod))
	}

}