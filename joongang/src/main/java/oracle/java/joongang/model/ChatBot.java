package oracle.java.joongang.model;

import java.util.Date;

public class ChatBot {
	private String user_question, pid, chatbot;
	private int pnum, gubun, yymm, question_num;
	private Date reg_date;
	
	public ChatBot() {
		
	}
	
	public ChatBot(String user_question, String pid, String chatbot, int pnum, int gubun, int yymm, int question_num, Date reg_date) {
		this.user_question = user_question;
		this.pid = pid;
		this.chatbot = chatbot;
		this.pnum = pnum;
		this.gubun = gubun;
		this.yymm = yymm;
		this.question_num = question_num;
		this.reg_date = reg_date;		
	}
	
	public String getChatbot() {
		return chatbot;
	}

	public void setChatbot(String chatbot) {
		this.chatbot = chatbot;
	}	

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public int getGubun() {
		return gubun;
	}

	public void setGubun(int gubun) {
		this.gubun = gubun;
	}

	public int getYymm() {
		return yymm;
	}

	public void setYymm(int yymm) {
		this.yymm = yymm;
	}

	public int getQuestion_num() {
		return question_num;
	}

	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getUser_question() {
		return user_question;
	}

	public void setUser_question(String user_question) {
		this.user_question = user_question;
	}

}
