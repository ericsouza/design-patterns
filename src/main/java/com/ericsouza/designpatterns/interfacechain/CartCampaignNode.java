package com.ericsouza.designpatterns.interfacechain;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.commons.CartCampaingRepository;
import com.ericsouza.designpatterns.commons.CartPrice;

@Component
public class CartCampaignNode implements CartPriceModifierNode {

	private final CartCampaingRepository campaingRepository;

	@Autowired
	private CartCampaignNode(CartCampaingRepository campaingRepository) {
		this.campaingRepository = campaingRepository;
	}

	@Override
	public void apply(CartContext context, CartPrice price) {
		BigDecimal discount = campaingRepository
				.findByCartId(context.getCartId().get())
				.get()
				.getAbsoluteValue();

		BigDecimal newPrice = price.getValue().subtract(discount);

		if (BigDecimal.ZERO.compareTo(newPrice) > 0) {
			price.setValue(BigDecimal.ZERO);
			return;
		}

		price.setValue(newPrice);

	}

	@Override
	public boolean shouldApply(CartContext context) {
		if(!context.getCartId().isPresent()) return false;
		if(!campaingRepository.findByCartId(context.getCartId().get()).isPresent()) return false;

		return true;
	}

	@Override
	public Integer getPriority() {
		return CartPriceModifierType.CART_CAMPAIGN.getPriority();
	}

}
