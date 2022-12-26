package com.ericsouza.designpatterns.commons;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {
	@Id
	private Long id;
	private String couponCode;
	private BigDecimal percentualDiscount;

	public Coupon() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public BigDecimal getPercentualDiscount() {
		return percentualDiscount;
	}

	public void setPercentualDiscount(BigDecimal percentualDiscount) {
		this.percentualDiscount = percentualDiscount;
	}


}
