package com.ericsouza.designpatterns.builder;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class CartContext {

	private Long cartId;
	private Set<Item> items = Collections.emptySet();
	private String couponCode;
	private Long userId;

	public CartContext(Long cartId, Set<Item> items, String couponCode, Long userId) {
		this.cartId = cartId;
		this.items = items;
		this.couponCode = couponCode;
		this.userId = userId;
	}

	public Optional<Long> getCartId() {
		return Optional.ofNullable(cartId);
	}

	public Set<Item> getItems() {
		return items;
	}

	public Optional<String> getCouponCode() {
		return Optional.ofNullable(couponCode);
	}

	public Optional<Long> getUserId() {
		return Optional.ofNullable(userId);
	}

	class Item {
		private BigDecimal price;

		Item(BigDecimal price) {
			this.price = price;
		}

		public BigDecimal getPrice() {
			return price;
		}
	}

	public BigDecimal getTotalPrice() {
		return items.stream()
				.map(Item::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
