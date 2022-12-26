package com.ericsouza.designpatterns.abstractchain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ericsouza.designpatterns.commons.UserRepository;

@Configuration
public class CartPriceModifierChainFactory {

	private final UserRepository userRepository;

	CartPriceModifierChainFactory(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Bean
	CartPriceModifierAbstractChain create() {
		CartOwnerModifier ownerModifier = new CartOwnerModifier(userRepository);

		return ownerModifier;
	}

}
