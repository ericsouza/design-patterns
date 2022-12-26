package com.ericsouza.designpatterns.commons;

import java.math.BigDecimal;

public class CartPrice {
	BigDecimal value;
	BigDecimal originalValue;

	public CartPrice(BigDecimal price) {
		this.value = price;
		this.originalValue = price;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getOriginalValue() {
		return originalValue;
	}

}
