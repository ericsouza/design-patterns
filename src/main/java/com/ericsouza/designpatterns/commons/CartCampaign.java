package com.ericsouza.designpatterns.commons;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_campaign")
public class CartCampaign {
	@Id
	private Long id;
	private Long cartId;
	private String campaignName;
	private BigDecimal absoluteValue;

	public CartCampaign() {

	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public BigDecimal getAbsoluteValue() {
		return absoluteValue;
	}

	public void getAbsoluteValue(BigDecimal absoluteValue) {
		this.absoluteValue = absoluteValue;
	}

}
