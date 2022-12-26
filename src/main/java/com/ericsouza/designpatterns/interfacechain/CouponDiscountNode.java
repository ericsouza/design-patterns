package com.ericsouza.designpatterns.interfacechain;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.commons.CartPrice;
import com.ericsouza.designpatterns.commons.Coupon;
import com.ericsouza.designpatterns.commons.CouponRepository;

@Component
public class CouponDiscountNode implements CartPriceModifierNode {

	private static final BigDecimal ONE_HUNDRED = new BigDecimal("100.00");

	private final CouponRepository couponRepository;

	@Autowired
	private CouponDiscountNode(CouponRepository couponRepository) {
		this.couponRepository = couponRepository;
	}

	@Override
	public void apply(CartContext context, CartPrice price) {
		BigDecimal discountPercentual = couponRepository
				.findByCouponCode(context.getCouponCode().get())
				.get()
				.getPercentualDiscount();

		price.setValue(price.getValue().subtract(price.getValue().multiply(discountPercentual.divide(ONE_HUNDRED))));
	}

	@Override
	public boolean shouldApply(CartContext context) {
		if(!context.getCouponCode().isPresent()) return false;

		Optional<Coupon> coupon = couponRepository.findByCouponCode(context.getCouponCode().get());
		if(!coupon.isPresent()) return false;

		return true;
	}

	@Override
	public Integer getPriority() {
		return CartPriceModifierType.COUPON_DISCOUNT.getPriority();
	}

}
