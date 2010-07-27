package com.swipe

import scala.collection.{immutable, mutable}

/**
 * Main class or start of the program
 * 
 * @author mspangler
 */
object Swipe {

	private val scheduler = new Scheduler
	private val rulesEngine = new RulesEngine
	
	// Start up the RulesEngine
	rulesEngine.start()

	/**
	 * Main method where all the magic starts
	 */
	def main(args : Array[String]) : Unit = {
		// Get transactions & send them to the rules engine
		val transactions: mutable.ArrayBuffer[Transaction] = scheduler.getTransactions()
		transactions.foreach(transaction => rulesEngine ! transaction)	    
	}
}
