package oracle.java.joongang.model;

import java.util.Date;

public class Class {
	private int class_num;
	private int room_num;
	private String class_name;
	private String class_start;
	private String class_end;
	private int max_person;
	private int now_person;
	private Date reg_date;
	
	public int getClass_num() {
		return class_num;
	}
	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_start() {
		return class_start;
	}
	public void setClass_start(String class_start) {
		this.class_start = class_start;
	}
	public String getClass_end() {
		return class_end;
	}
	public void setClass_end(String class_end) {
		this.class_end = class_end;
	}
	public int getMax_person() {
		return max_person;
	}
	public void setMax_person(int max_person) {
		this.max_person = max_person;
	}
	public int getNow_person() {
		return now_person;
	}
	public void setNow_person(int now_person) {
		this.now_person = now_person;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}
