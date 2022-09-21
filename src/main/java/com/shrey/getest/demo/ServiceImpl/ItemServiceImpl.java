package com.shrey.getest.demo.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrey.getest.demo.ServiceInterface.ItemService;
import com.shrey.getest.demo.utility.SocketTextHandler;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private SocketTextHandler SocketTextHandler;

	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@Override
	public Map<String, Object> getItem(String id) {
		Map<String, Object> json = new HashMap();
		if (SocketTextHandler.hashMap.containsKey(id))
			json.put(id, SocketTextHandler.hashMap.get(id));
		else
			json.put("message", "Item Id Not Found");
		return json;
	}

}
