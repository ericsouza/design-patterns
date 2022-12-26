package com.ericsouza.designpatterns.abstractchain;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.commons.CartPrice;

public abstract class CartPriceModifierAbstractChain {

	private CartPriceModifierAbstractChain next;

	public CartPrice execute(CartContext context, CartPrice price) {
		if(this.shouldApply(context, price)) {
			this.apply(context, price);
		}

		return this.executeNext(context, price);
	}

	protected abstract void apply(CartContext context, CartPrice price);

	protected abstract boolean shouldApply(CartContext context, CartPrice price);

	protected CartPrice executeNext(CartContext context, CartPrice price) {
		if(next == null) return price;

		return next.execute(context, price);
	}

	CartPriceModifierAbstractChain linkWith(CartPriceModifierAbstractChain next) {
		this.next = next;
		return next;
	}

}
