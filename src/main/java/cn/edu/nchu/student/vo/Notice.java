package cn.edu.nchu.student.vo;

import java.io.Serializable;

public class Notice implements Serializable {
	private String title;
	private String name;
	private String file;
	private String time;
	//该字段用于传参，不用存于数据库
	private String old_title;


	public String getOld_title() {
		return old_title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
