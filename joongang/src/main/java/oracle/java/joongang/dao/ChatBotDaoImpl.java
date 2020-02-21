package oracle.java.joongang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.joongang.model.ChatBot;

@Repository
public class ChatBotDaoImpl implements ChatBotDao {
	@Autowired
	private SqlSession session;

	@Override
	public void chatbot() {
		// TODO Auto-generated method stub

	}

	@Override
	public int insertQuestion(ChatBot chatbot) {
//		ChatBot chatbot = new ChatBot();
//		for (int i = 1112; i <= 9999; i++) {
//			chatbot.setPnum(i);
//			chatbot.setGubun(123);
//			chatbot.setYymm(1234);
//			chatbot.setPid("스트링");
//			chatbot.setUser_question("스트링");
//			session.insert("insert", chatbot);
	//	}
		return 0;
		// return session.insert("insert", chatbot);
//
	}

	@Override
	public int total() {
		return session.selectOne("total");
	}

	@Override
	public int insert(ChatBot chatbot) {
		return session.insert("insert", chatbot);
	}

	@Override
	public List<ChatBot> list(ChatBot chatbot) {
		return session.selectList("listAll", chatbot);
	}

	
}
