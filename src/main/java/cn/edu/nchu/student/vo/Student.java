package cn.edu.nchu.student.vo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private String st_name;
	private String st_number;
	private String st_password;
	private String st_lastdate;
	//该字段用于传参，不用存于数据库
	private String old_st_number;


	public String getOld_st_number() {
		return old_st_number;
	}

	public void setOld_st_number(String old_st_number) {
		this.old_st_number = old_st_number;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_number() {
		return st_number;
	}

	public void setSt_number(String st_number) {
		this.st_number = st_number;
	}

	public String getSt_password() {
		return st_password;
	}

	public void setSt_password(String st_password) {
		this.st_password = st_password;
	}

	public String getSt_lastdate() {
		return st_lastdate;
	}

	public void setSt_lastdate(String st_lastdate) {
		this.st_lastdate = st_lastdate;
	}
}
