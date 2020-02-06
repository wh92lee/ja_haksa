package oracle.java.joongang.dao;

import java.util.List;

import oracle.java.joongang.model.ChatBot;

public interface ChatBotDao {
	
	void chatbot();
	void insertQuestion();
	int total();
	int insert(ChatBot chatbot);
	List<ChatBot> list(ChatBot chatbot);

}
