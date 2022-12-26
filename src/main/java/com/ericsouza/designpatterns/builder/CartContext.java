package com.ericsouza.designpatterns.builder;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.ericsouza.designpatterns.commons.CartItem;

public class CartContext {

	private Long cartId;
	private Set<Item> items = Collections.emptySet();
	private String couponCode;
	private Long userId;

	private CartContext(Long cartId, Set<Item> items, String couponCode, Long userId) {
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

	static class Item {
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

	public static CartContextBuilder builder() {
		return new CartContextBuilder();
	}

	public static class CartContextBuilder {
		private Long cartId;
		private Set<Item> items = Collections.emptySet();
		private String couponCode;
		private Long userId;

		public CartContextBuilder() { };

		public CartContextBuilder withCartId(Long cartId) {
			this.cartId = cartId;
			return this;
		}

		public CartContextBuilder withItems(Set<CartItem> items) {
			this.items = items.stream().map(item -> new Item(item.getPrice())).collect(Collectors.toSet());
			return this;
		}

		public CartContextBuilder withCouponCode(String couponCode) {
			this.couponCode = couponCode;
			return this;
		}

		public CartContextBuilder withUserId(Long userId) {
			this.userId = userId;
			return this;
		}

		public CartContext build() {
			return new CartContext(this.cartId, this.items, this.couponCode, this.userId);
		}
	}
}
