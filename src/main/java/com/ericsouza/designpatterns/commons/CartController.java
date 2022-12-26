package com.ericsouza.designpatterns.commons;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.interfacechain.CartPriceModifierChain;


@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartPriceModifierChain cartPriceModifierChain;


	@GetMapping("/{cartId}")
	public CartDTO getCart(@PathVariable Long cartId) {
		Optional<Cart> cart = cartRepository.findById(cartId);

		if(!cart.isPresent()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "entity not found"
					);
		}

		CartPrice cartPrice = new CartPrice(cart.get().getPrice());

		//new CartContext(1L, Collections.emptySet(), "JAVA17", 3L)

		CartContext cartContext = CartContext.builder()
				.withCartId(1L)
				.withUserId(3L)
				.withCouponCode("JAVA17")
				.withItems(Collections.emptySet())
				.build();

		cartPrice = cartPriceModifierChain.apply(cartContext, cartPrice);

		return new CartDTO(cartPrice);
	}
}
