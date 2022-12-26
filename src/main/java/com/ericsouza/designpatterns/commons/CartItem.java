package com.ericsouza.designpatterns.commons;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem {

	@Id
	private Long id;
	private Integer quantity;
	private BigDecimal unitPrice;

	@ManyToOne
	@JoinColumn(name="cart_id", nullable=false)
	private Cart cart;

	public CartItem() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public BigDecimal getPrice() {
		return unitPrice.multiply(new BigDecimal(quantity));
	}

	public Cart getCart() {
		return cart;
	}

}
