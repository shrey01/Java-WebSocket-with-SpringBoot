package com.shrey.getest.demo.ServiceInterface;

import java.util.Map;

import com.shrey.getest.demo.dto.ItemDTO;

public interface ItemService {

	Map<String, Object> getItem(String id);

	ItemDTO getItemBy3rdParty(String id);

	
}
