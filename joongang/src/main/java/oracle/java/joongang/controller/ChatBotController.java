package oracle.java.joongang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.joongang.model.ChatBot;
import oracle.java.joongang.service.ChatBotService;

@Controller
public class ChatBotController {
	
	@Autowired
	private ChatBotService cbs;
	
	@RequestMapping(value="list")
	public String list(ChatBot chatbot, String curruentPage, Model model ) {
		int total = cbs.total();
		return "list";
	}
	
	@RequestMapping(value="chatbot")
	public String chatbot() { 
		System.out.println("chatbot start");
		return "chatbot";
	}
	
	
	@RequestMapping(value="questionInsert")
	public String questionInsert(Model model) {
		cbs.questionInsert();
		return "redirect:list";
		
	}
}
