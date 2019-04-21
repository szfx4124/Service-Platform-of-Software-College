package cn.edu.nchu.student.action;

import cn.edu.nchu.util.action.DefaultAction;
import cn.edu.nchu.student.service.IAdminService;
import cn.edu.nchu.student.vo.Admin;
import cn.edu.nchu.util.MD5Code;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/pages/back/*" )

public class AdminLoginAction extends DefaultAction {
	@Resource
	private IAdminService adminService;

	@RequestMapping(value = "admin_login")
	public ModelAndView login(Admin admin){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			//实现登录密码加盐操作
			admin.setAd_password(new MD5Code().getMD5ofStr(admin.getAd_password()+admin.getAd_number()));
			Admin vo = this.adminService.login(admin); // 登录成功后还要取得最后一次登录日期
			if (vo != null ){
				request.getSession().setAttribute("ad_number",vo.getAd_number());
				request.getSession().setAttribute("ad_lastdate",vo.getAd_lastdate()); // 取得最后一次登录日期操作
				request.getSession().setAttribute("ad_name",vo.getAd_name());
				super.setMsgAndPath(mav,"account.login.success","admin.login_ad.success");
			}else{
				super.setMsgAndPath(mav,"account.login.failure","account.login_ad.failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "admin_logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		request.getSession().invalidate(); // 表示session失效
		super.setMsgAndPath(mav,"account.logout_m.success","account.logout_p.success");
		return mav;
	}

	@Override
	public String getText() {
		return "管理员";
	}
}
