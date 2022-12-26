package com.ericsouza.designpatterns.commons;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	private Long id;

	@OneToMany(mappedBy="cart")
	private Set<CartItem> items;

	private Long ownerId;

	public Cart() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Set<CartItem> getItems() {
		return items;
	}

	public void setItems(Set<CartItem> items) {
		this.items = items;
	}

	public BigDecimal getPrice() {
		return items.stream()
				.map(CartItem::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}


}
