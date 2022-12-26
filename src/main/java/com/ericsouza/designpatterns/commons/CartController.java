package com.ericsouza.designpatterns.commons;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public CartDTO getCart(@PathVariable Long cartId, @RequestParam(required = false) String couponCode) {
		Optional<Cart> optionalCart = cartRepository.findById(cartId);

		if(!optionalCart.isPresent()) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "entity not found"
					);
		}

		Cart cart = optionalCart.get();

		CartPrice cartPrice = new CartPrice(cart.getPrice());

		CartContext cartContext = CartContext.builder()
				.withCartId(cart.getId())
				.withUserId(cart.getOwnerId())
				.withCouponCode(couponCode)
				.withItems(cart.getItems())
				.build();

		cartPrice = cartPriceModifierChain.apply(cartContext, cartPrice);

		return new CartDTO(cartPrice);
	}
}
