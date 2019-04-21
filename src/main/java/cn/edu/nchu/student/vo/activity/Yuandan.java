package cn.edu.nchu.student.vo.activity;

import java.io.Serializable;

public class Yuandan implements Serializable {
	private String st_number;
	private String st_name;
	private String name;
	private String team;
	private String other;
	private String message;
	private String old_st_number;


	public String getold_st_number() {
		return old_st_number;
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
