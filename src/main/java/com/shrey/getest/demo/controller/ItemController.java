package com.shrey.getest.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.getest.demo.ServiceInterface.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService ItemService;

	@GetMapping("/api/getByItemCode")
	public Map<String, Object> getItemDetails(@RequestParam String id) {
		return ItemService.getItem(id);
	}

}
