package com.ericsouza.designpatterns.interfacechain;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.commons.CartPrice;

@Component
public class PriceBiggerThanOneHundreNode implements CartPriceModifierNode {

	private static final BigDecimal ONE_HUNDRED = new BigDecimal("100.00");
	private static final BigDecimal DISCOUNT_VALUE = new BigDecimal("5.00");

	@Override
	public void apply(CartContext context, CartPrice price) {
		BigDecimal newPrice = price.getValue().subtract(DISCOUNT_VALUE);

		if(BigDecimal.ZERO.compareTo(newPrice) > 0) {
			price.setValue(BigDecimal.ZERO);
			return;
		}

		price.setValue(newPrice);

	}

	@Override
	public boolean shouldApply(CartContext context) {
		if (ONE_HUNDRED.compareTo(context.getTotalPrice()) >= 0) return true;

		return false;
	}

	@Override
	public Integer getPriority() {
		return CartPriceModifierType.PRICE_BIGGER_THAN_ONE_HUNDRED.getPriority();
	}


}
