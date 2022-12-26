package com.ericsouza.designpatterns.commons;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartCampaingRepository extends CrudRepository<CartCampaign, Long>{

	public Optional<CartCampaign> findByCartId(Long cartId);

}
