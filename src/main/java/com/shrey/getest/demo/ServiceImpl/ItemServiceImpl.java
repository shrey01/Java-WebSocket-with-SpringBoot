package com.shrey.getest.demo.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shrey.getest.demo.ServiceInterface.ItemService;
import com.shrey.getest.demo.dto.ItemDTO;
import com.shrey.getest.demo.utility.SocketTextHandler;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private SocketTextHandler SocketTextHandler;

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@Override
	public Map<String, Object> getItem(String id) {
		Map<String, Object> json = new HashMap();
		if (SocketTextHandler.hashMap.containsKey(id)) {
			json.put("itemCode", id);
			json.put("description", SocketTextHandler.hashMap.get(id));
		} else
			json.put("message", "Item Id Not Found");
		return json;
	}

	//this is just a method as per the requirement to call out an api with unique id and get the response as json from 3rd party
	@Override
	public ItemDTO getItemBy3rdParty(String id) {
		ItemDTO ItemDTO = restTemplate.getForObject("/api/getByItemCode?"+id, null, ItemDTO.class);
		return ItemDTO;
	}

}
