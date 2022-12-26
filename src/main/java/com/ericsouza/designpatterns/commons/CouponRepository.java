package com.ericsouza.designpatterns.commons;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {

	public Optional<Coupon> findByCouponCode(String couponCode);

}
