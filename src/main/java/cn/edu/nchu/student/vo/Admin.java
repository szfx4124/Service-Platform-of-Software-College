package cn.edu.nchu.student.vo;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
	private String ad_name;
	private String ad_number;
	private String ad_password;
	private String ad_lastdate;

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}

	public String getAd_number() {
		return ad_number;
	}

	public void setAd_number(String ad_number) {
		this.ad_number = ad_number;
	}

	public String getAd_password() {
		return ad_password;
	}

	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}

	public String getAd_lastdate() {
		return ad_lastdate;
	}

	public void setAd_lastdate(String ad_lastdate) {
		this.ad_lastdate = ad_lastdate;
	}

}
