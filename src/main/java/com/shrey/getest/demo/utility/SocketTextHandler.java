package com.shrey.getest.demo.utility;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

	public static HashMap<String, String> hashMap = new HashMap<>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		String payload = message.getPayload();
		Boolean flag = syncTempDB(payload);
		if (flag)
			session.sendMessage(new TextMessage("XML Sync Completed."));
		else
			session.sendMessage(new TextMessage("Duplicate Key found!!. XML Sync Failed."));
	}

	private Boolean syncTempDB(String payload) {
		JSONObject json = XML.toJSONObject(payload);
		System.out.println(json.keys().toString());
		int i = 0;
		while (i < json.getJSONObject("item").getJSONArray("itemCode").length()) {
			JSONObject gs = new JSONObject();
			gs = (JSONObject) json.getJSONObject("item").getJSONArray("itemCode").get(i);
			if (!hashMap.containsKey(gs.get("id").toString())) {
				hashMap.put(gs.get("id").toString(), gs.get("description").toString());
			} else
				return false;
			i++;
		}
		return true;
	}

}