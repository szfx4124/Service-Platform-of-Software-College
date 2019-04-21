package cn.edu.nchu.testJson;

import cn.edu.nchu.student.vo.Admin;
import cn.edu.nchu.util.ObjectToJSON;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestAdmin {
	public static void main(String[] args) {
		List<Admin> all = new ArrayList<Admin>();
		for (int x = 0;x < 5;x ++){
			Admin vo = new Admin();
			vo.setAd_number("ylcto@163.com");
			vo.setAd_password("11111111");
			vo.setAd_lastdate(new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date()));
			all.add(vo);
		}
		System.out.println(ObjectToJSON.convertorListToJSON("allAdmin",all));
	}
}
