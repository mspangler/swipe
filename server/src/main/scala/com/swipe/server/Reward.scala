package com.swipe.server

import RewardType._

object Reward extends Enumeration {
	
	type Reward = Value
	
	case class RewardVal(name: String, rewardType: RewardType) extends Val(name) {}
	
	val Money = RewardVal("Money", RewardType.Money)
	val PennyPincher = RewardVal("Penny Pincher", RewardType.Badge)
	val BigSpender = RewardVal("Big Spender", RewardType.Badge)
	val MoneyMaker = RewardVal("Money Maker", RewardType.Badge)

}