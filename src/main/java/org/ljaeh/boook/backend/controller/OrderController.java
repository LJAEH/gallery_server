package org.ljaeh.boook.backend.controller;

import java.util.List;

import org.ljaeh.boook.backend.dto.OrderDto;
import org.ljaeh.boook.backend.entity.Order;
import org.ljaeh.boook.backend.repository.OrderRepository;
import org.ljaeh.boook.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	JwtService jwtService;
	
	
	@GetMapping("/api/orders")
	public ResponseEntity getOrder(
			@CookieValue(value = "token", required = false) String token
			){
		
		if(!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		
		List<Order> orders = orderRepository.findAll();
		
		return new ResponseEntity<>(orders , HttpStatus.OK);
	}
	
	@PostMapping("/api/orders")
	public ResponseEntity pushOrder(
			@RequestBody OrderDto dto,
			@CookieValue(value = "token", required = false) String token
			){
		
		if(!jwtService.isValid(token)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		
		Order newOrder = new Order();
		newOrder.setMemberId(jwtService.getId(token));
		newOrder.setAddress(dto.getAddress());
		newOrder.setName(dto.getName());
		newOrder.setCardNumber(dto.getCardNumber());
		newOrder.setItems(dto.getItems());
		newOrder.setPayment(dto.getPayment());
		
		orderRepository.save(newOrder);
		
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
 