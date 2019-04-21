package cn.edu.nchu.test;

import cn.edu.nchu.student.service.IAdminService;
import cn.edu.nchu.student.vo.Admin;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class AdminServiceTest {
	@Resource
	private static ApplicationContext ctx;
	private static IAdminService adminService;

	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		adminService = ctx.getBean("adminServiceImpl",IAdminService.class);
	}

	@Test
	public void login() throws Exception {
		Admin admin = new Admin();
		admin.setAd_number("16207231");
		admin.setAd_password("1BB890D9371B43CD327A18F40D136FE2");
		System.out.println(this.adminService.login(admin));

	}

}
