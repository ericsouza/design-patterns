package com.ericsouza.designpatterns.interfacechain;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.commons.CartPrice;
import com.ericsouza.designpatterns.commons.User;
import com.ericsouza.designpatterns.commons.UserRepository;

@Component
public class CompanyOwnerNode implements CartPriceModifierNode {

	private final UserRepository userRepository;

	@Autowired
	private CompanyOwnerNode(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void apply(CartContext context, CartPrice price) {
		price.setValue(BigDecimal.ZERO);
	}

	@Override
	public boolean shouldApply(CartContext context) {
		if(!context.getUserId().isPresent()) return false;

		Optional<User> user = userRepository.findById(context.getUserId().get());

		return user.isPresent() && user.get().isCompanyOwner();

	}

	@Override
	public Integer getPriority() {
		return CartPriceModifierType.COMPANY_OWNER_DISCOUNT.getPriority();
	}

}
