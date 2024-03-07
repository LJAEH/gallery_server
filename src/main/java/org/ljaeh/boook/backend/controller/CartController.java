package org.ljaeh.boook.backend.controller;

import java.util.List;

import org.ljaeh.boook.backend.entity.Cart;
import org.ljaeh.boook.backend.entity.Item;
import org.ljaeh.boook.backend.repository.CartRepository;
import org.ljaeh.boook.backend.repository.ItemRepository;
import org.ljaeh.boook.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CartController {
	
	@Autowired
	ItemRepository itemRepository;

	@Autowired
	JwtService jwtService;
	
	@Autowired
	CartRepository cartRepository;
	
	@PostMapping("/api/cart/items/{itemId}")
	public ResponseEntity pushCartItem(
			@PathVariable("itemId") int itemId,
			@CookieValue(value = "token", required = false) String token
			){
		
		System.out.println("itemId : " + itemId);
		if(!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		
		int memberId = jwtService.getId(token);
		
		System.out.println("memberId : " + memberId);
		Cart cart = cartRepository.findByMemberIdAndItemId(memberId, itemId);
		
		if (cart == null) {
			Cart newCart = new Cart();
			newCart.setMemberId(memberId);
			newCart.setItemId(itemId);
			cartRepository.save(newCart);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/api/cart/items")
	public ResponseEntity getCartItems( @CookieValue(value = "token" , required = false) String token) {
		
		if(!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		
		int memberId = jwtService.getId(token);
		List<Cart> carts = cartRepository.findByMemberId(memberId);
		List<Integer> itemIds = carts.stream().map(Cart::getItemId).toList();
		List<Item> items = itemRepository.findByIdIn(itemIds);
		
		return new ResponseEntity<>(carts,HttpStatus.OK);
	}
	
	
}
 