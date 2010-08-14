package com.swipe.server

import scala.actors.Actor
import scala.actors.Actor._

case class SendRewardNotification(customerReward: CustomerReward)
case class SendErrorNotification(error: String)

class Notifier extends Actor {

	private def notify(customerReward: CustomerReward) {
		printf("Notifying customer id: %s - Reward Type: %s - Amount: %s\n", customerReward.customer.id, customerReward.reward, customerReward.amount)
	}
	
	private def notify(error: String) {
		println("Notifying admins of error!!!!!!!!!!!!")
	}

	override def act() {
		loop {
			react {
				case SendRewardNotification(customerReward: CustomerReward) => notify(customerReward)
				case SendErrorNotification(error: String) => notify(error)
			}
		}
	}
}