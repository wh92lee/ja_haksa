package oracle.java.joongang.model;

import java.util.Date;

public class Person {
	private int pnum;
	private String pid;
	private String ppw;
	private String pname;
	private String pprofile;
	private String ptel; 
	private String pbirth;
	private String pgender;
	private String paddress;
	private String pemail;
	private String class_name; 
	private String class_start;
	private String class_end;
	private int class_method;
	private int ppeval;
	private int pteval;
	private Date reg_date;
	
	
	public int getPpeval() {
		return ppeval;
	}
	public void setPpeval(int ppeval) {
		this.ppeval = ppeval;
	}
	public int getPteval() {
		return pteval;
	}
	public void setPteval(int pteval) {
		this.pteval = pteval;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPpw() {
		return ppw;
	}
	public void setPpw(String ppw) {
		this.ppw = ppw;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPprofile() {
		return pprofile;
	}
	public void setPprofile(String pprofile) {
		this.pprofile = pprofile;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	public String getPbirth() {
		return pbirth;
	}
	public void setPbirth(String pbirth) {
		this.pbirth = pbirth;
	}
	public String getPgender() {
		return pgender;
	}
	public void setPgender(String pgender) {
		this.pgender = pgender;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
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
	public int getClass_method() {
		return class_method;
	}
	public void setClass_method(int class_method) {
		this.class_method = class_method;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}
