package com.ericsouza.designpatterns.abstractchain;

import java.math.BigDecimal;
import java.util.Optional;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.commons.CartPrice;
import com.ericsouza.designpatterns.commons.User;
import com.ericsouza.designpatterns.commons.UserRepository;

public class CartOwnerModifier extends CartPriceModifierAbstractChain {

	private final UserRepository userRepository;

	CartOwnerModifier(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void apply(CartContext context, CartPrice price) {
		price.setValue(BigDecimal.ZERO);
	}

	@Override
	public boolean shouldApply(CartContext context, CartPrice price) {
		if(!context.getUserId().isPresent()) return false;

		Optional<User> user = userRepository.findById(context.getUserId().get());

		return user.isPresent() && user.get().isCompanyOwner();
	}

}
