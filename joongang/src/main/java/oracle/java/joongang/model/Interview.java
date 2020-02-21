package oracle.java.joongang.model;

public class Interview {

	private int pnum;
	private int gubun;
	private int yymm;
	private int interview_num;
	private int teacher_num;
	private String interview_content;
	private int interview_count;
	private String reg_date;
	private String pemail;
	private String pname;
	private String pid;
	private String class_num; 
	private int ppeval;
	private int pteval;
	
	
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getClass_num() {
		return class_num;
	}
	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	private String search;       private String keyword;
	private String pageNum;  
	private int start; 		     private int end;

	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getInterview_num() {
		return interview_num;
	}
	public void setInterview_num(int interview_num) {
		this.interview_num = interview_num;
	}
	public int getTeacher_num() {
		return teacher_num;
	}
	public void setTeacher_num(int teacher_num) {
		this.teacher_num = teacher_num;
	}
	public String getInterview_content() {
		return interview_content;
	}
	public void setInterview_content(String interview_content) {
		this.interview_content = interview_content;
	}
	public int getInterview_count() {
		return interview_count;
	}
	public void setInterview_count(int interview_count) {
		this.interview_count = interview_count;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
}
