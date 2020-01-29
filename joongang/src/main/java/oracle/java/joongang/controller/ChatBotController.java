package oracle.java.joongang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.joongang.service.ChatBotService;

@Controller
public class ChatBotController {
	
//	@Autowired
//	private ChatBotService cbs;
	
	@RequestMapping(value="chatbot")
	public String chatbot() { 
		System.out.println("chatbot start");
		return "chatbot";
	}
}
