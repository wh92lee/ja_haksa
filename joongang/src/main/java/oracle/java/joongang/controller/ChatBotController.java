package oracle.java.joongang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oracle.java.joongang.model.ChatBot;
import oracle.java.joongang.service.ChatBotService;
import oracle.java.joongang.service.Paging;

@Controller
public class ChatBotController {
	
	@Autowired
	private ChatBotService cbs;
	
	@RequestMapping(value="ChatbotList")
	public String list(ChatBot chatbot, String currentPage, Model model ) {
		int total = cbs.total();
		Paging pg = new Paging(total, currentPage);
		chatbot.setStart(pg.getStart());
		chatbot.setEnd(pg.getEnd());
		List<ChatBot> list = cbs.list(chatbot);
		
		model.addAttribute("list",list);
		model.addAttribute("pg",pg);		
		return "ChatbotList";
	}
	
	@RequestMapping(value="chatbot")
	public String chatbot() { 
		System.out.println("chatbot start");
		return "chatbot";
	}
	
	
	@RequestMapping(value="insertQuestion")
	public String insertQuestion(String user_question, Model model) {
		cbs.insertQuestion();
		return "redirect:ChatbotList.do";
	}
	
	@RequestMapping(value="iq", method=RequestMethod.POST)
	public String iq(ChatBot chatbot, Model model) {
		int result = cbs.insert(chatbot);
		
		if(result >0 ) return "redirect:ChatbotList.do";
			return "forward:ChatbotList.do";
		}
		
	}


