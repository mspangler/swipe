package com.swipe.server

import scala.actors.Actor
import scala.actors.Actor._

import Reward._

class RulesEngine extends Actor {

	private val notifier = new Notifier
	notifier.start
	
	private def runRules(transaction: Transaction) {		
		val amountRewarded = rewardAmount(transaction)
	}
	
	private def rewardAmount(transaction: Transaction) : Boolean = {
		
		val amount = transaction.amount		
		amount match {
			
			case amount if (amount >= 25.00) && (amount <= 50.00) =>
				reward(transaction, Reward.PennyPincher, 1)
				true
			
			case amount if (amount > 50.00) && (amount <= 200.00) =>
				reward(transaction, Reward.BigSpender, 5)
				true
			
			case amount if (amount > 200.00) && (amount <= 300) =>
				reward(transaction, Reward.MoneyMaker, 10)
				true
			
			case amount if (amount > 300.00) =>
				reward(transaction, Reward.Money, 10)
				true
				
			case _ => false 
		}
	}

	private def reward(transaction: Transaction, reward: Reward, amount: Int) {
		val customerReward = new CustomerReward(transaction.customer, reward, amount)
		//persister ! customerReward // save the reward to the db
		notifier ! SendRewardNotification(customerReward)
	}

	override def act() {
		loop {
			react {
				case transaction: Transaction => runRules(transaction)
			}
		}
	}

}