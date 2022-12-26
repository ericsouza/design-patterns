package com.ericsouza.designpatterns.interfacechain;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.commons.CartPrice;

public interface CartPriceModifierNode {

	default void execute(CartContext context, CartPrice price) {
		if(this.shouldApply(context)) {
			this.apply(context, price);
		}
	}
	void apply(CartContext context, CartPrice price);
	boolean shouldApply(CartContext context);
	Integer getPriority();

}
