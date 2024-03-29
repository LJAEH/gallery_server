package org.ljaeh.boook.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.ljaeh.boook.backend.entity.Item;
import org.ljaeh.boook.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/api/items")
	public List<Item> getItems(){
		List<Item> items = itemRepository.findAll();
		return items;
	}
	
}
 