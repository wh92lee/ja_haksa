package oracle.java.joongang.controller;



import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.java.joongang.model.ChatBot;
import oracle.java.joongang.model.Person;
import oracle.java.joongang.service.ChatBotService;
import oracle.java.joongang.service.Paging;

@Controller
public class ChatBotController {
	
	@Autowired
	private ChatBotService cbs;
//	private HttpServletRequest request;
	
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
		return "student_main";
	}
	
	
//	@RequestMapping(value="insertQuestion")
//	public String insertQuestion(String user_question, Model model) {
//		cbs.insertQuestion();
//		return "redirect:ChatbotList.do";
	//}
	
	@RequestMapping(value="iq", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String iq(HttpServletRequest request, ChatBot chatbot, Model model,
			                       String user_question, int gubun, int yymm, int pnum, String pid) {
		HttpSession session = request.getSession();		
//		gubun = (int)session.getAttribute("gubun");
//		yymm = (int)session.getAttribute("yymm");
//		pnum = (int)session.getAttribute("pnum");
//		pid = (String)session.getAttribute("pid");
		System.out.println("iq gubun " + gubun);
		System.out.println("iq yymm -> "+ yymm);
		System.out.println("iq pnum -> "+ pnum);
		System.out.println("iq pid -> "+ pid);
		System.out.println("iq userQuestion-> "+user_question);
		int result = cbs.insert(chatbot);		
		if(result > 0) {
			return user_question;
		}
		else
		return user_question;		
	}
	}


