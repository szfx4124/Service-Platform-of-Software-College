package cn.edu.nchu.test;

import cn.edu.nchu.util.MD5Code;

public class TestMD5Code {
	public static void main(String[] args) {
		String number = "16207231";
		String password = "16207231";
		System.out.println(new MD5Code().getMD5ofStr(password+number));
	}
}
