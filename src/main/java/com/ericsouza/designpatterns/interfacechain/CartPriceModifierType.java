package com.ericsouza.designpatterns.interfacechain;

public enum CartPriceModifierType {
	COUPON_DISCOUNT(100),
	CART_CAMPAIGN(200),
	PRICE_BIGGER_THAN_ONE_HUNDRED(400),
	COMPANY_OWNER_DISCOUNT(300);

	private Integer priority;

	private CartPriceModifierType(Integer priority) {
		this.priority = priority;
	}

	Integer getPriority() {
		return priority;
	}

}
