package com.swipe

import scala.actors.Actor
import scala.actors.Actor._

/**
 * Rules engine that determines if the customer qualifies for a reward.
 * The entity to run the rules against could be a transaction, some kind of payment, etc.
 * TODO: Maybe have a set of hardcoded rules but get the threshold values for that bank from the database?
 * 
 * @author mspangler
 */
class RulesEngine extends Actor {
	
	private val notifier = new Notifier
	
	// Start up the Notifier
	notifier.start()
	
	/**
	 * Determine if the transaction triggers a Reward using pattern matching
	 * 
	 * @param transaction
	 */
	def runRules(transaction: Transaction) {
		println("Running rules for transaction id: " + transaction.id)
		
		transaction match {
			case transaction if (transaction.amount > 100.00) => {
				println("Reward - Transaction $: " + transaction.amount)
				reward(transaction.customer)
			}
			case _ => { /* ignore: did not qualify for reward */ }
		}
	}
	
	/**
	 * Create an Reward and sent to the Notifier
	 * 
	 * @param customer
	 */
	def reward(customer: Customer) {
		notifier ! new Reward(customer)
	}
	
	/**
	 * Receives messages that need to be ran through the rules engine
	 */
	override def act() {
		loop {
			react {
				case transaction: Transaction => runRules(transaction)
				// could easily say
			 // case payment: Payment => runRules(payment)
			}
		}
	}
	
}