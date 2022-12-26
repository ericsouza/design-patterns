package com.ericsouza.designpatterns.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CartDTO {
	private BigDecimal originalPrice;
	private BigDecimal totalPrice;

	public CartDTO(CartPrice cartPrice) {
		this.totalPrice = cartPrice.getValue();
		this.originalPrice = cartPrice.getOriginalValue();
	}

	public BigDecimal getTotalPrice() {
		return totalPrice.setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice.setScale(2, RoundingMode.HALF_EVEN);
	}

}
