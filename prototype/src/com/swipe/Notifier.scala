package com.swipe

import scala.actors.Actor
import scala.actors.Actor._

/**
 * This class would be able to notify anyone whether it be email, text, etc on any particular situation (reward, error, etc)
 * 
 * @author mspangler
 */
class Notifier extends Actor {
	
	/**
	 * Notify the customer that they can redeem a reward.
	 * 
	 * @param reward
	 */
	def notify(reward: Reward) {
		println("Notifying customer id: " + reward.customer.id + " of reward via " + reward.customer.notifyMethod)
	}
	
	/**
	 * Receives messages that need some sort of notification
	 */	
	override def act() {
		loop {
			react {
				case reward: Reward => notify(reward)
				// could easily say
			 // case error: Error => notify(error)
			}
		}
	}

}