package cn.edu.nchu.student.vo.activity;

import java.io.Serializable;

public class Sanxiao implements Serializable {
	private String st_number;
	private String st_name;
	private String name;
	private String message;
	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getSt_number() {
		return st_number;
	}

	public void setSt_number(String st_number) {
		this.st_number = st_number;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
