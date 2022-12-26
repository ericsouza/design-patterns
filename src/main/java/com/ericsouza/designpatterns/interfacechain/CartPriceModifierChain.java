package com.ericsouza.designpatterns.interfacechain;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsouza.designpatterns.builder.CartContext;
import com.ericsouza.designpatterns.commons.CartPrice;

@Component
public class CartPriceModifierChain {

	private List<CartPriceModifierNode> modifiers;

	@Autowired
	public CartPriceModifierChain(List<CartPriceModifierNode> modifiers) {
		this.modifiers = modifiers.stream().sorted(Comparator.comparing(CartPriceModifierNode::getPriority)).collect(Collectors.toCollection(LinkedList::new));
	}

	public CartPrice apply(CartContext context, CartPrice price) {
		modifiers.forEach(m -> m.execute(context, price));

		return price;
	}
}
