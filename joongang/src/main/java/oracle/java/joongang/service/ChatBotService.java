package oracle.java.joongang.service;

import java.util.List;

import oracle.java.joongang.model.ChatBot;

public interface ChatBotService {
	void chatbot();
	int insertQuestion(ChatBot chatbot);
	int total();
	int insert(ChatBot chatbot);
	List<ChatBot> list(ChatBot chatbot);
 
}
