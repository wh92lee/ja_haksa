package oracle.java.joongang.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Program {

	private int upload_num;
	private String savefile_name;
	private String original_name;
	private Date reg_date;
	public int getUpload_num() {
		return upload_num;
	}
	public void setUpload_num(int upload_num) {
		this.upload_num = upload_num;
	}
	public String getSavefile_name() {
		return savefile_name;
	}
	public void setSavefile_name(String savefile_name) {
		this.savefile_name = savefile_name;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
	
	
}
