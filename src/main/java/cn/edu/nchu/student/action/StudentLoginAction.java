package cn.edu.nchu.student.action;

import cn.edu.nchu.student.service.IStudentService;
import cn.edu.nchu.student.vo.Student;
import cn.edu.nchu.util.MD5Code;
import cn.edu.nchu.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/pages/back/*" )

public class StudentLoginAction extends DefaultAction {
	@Resource
	private IStudentService studentService;

	@RequestMapping(value = "student_login")
	public ModelAndView login(Student student){
		String v = request.getParameter("s_number");
		System.out.println(v);
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			//实现登录密码加盐操作
			student.setSt_password(new MD5Code().getMD5ofStr(student.getSt_password()+student.getSt_number()));
			Student vo = this.studentService.login(student); // 登录成功后还要取得最后一次登录日期
			if (vo != null ){
				request.getSession().setAttribute("st_number",vo.getSt_number());
				request.getSession().setAttribute("st_lastdate",vo.getSt_lastdate()); // 取得最后一次登录日期操作
				request.getSession().setAttribute("st_name",vo.getSt_name());
				super.setMsgAndPath(mav,"account.login.success","student.login_ad.success");
			}else{
				super.setMsgAndPath(mav,"account.login.failure","account.login_ad.failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "student_insert")
	public ModelAndView insert(Student vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.studentService.insert(vo)){
				super.setMsgAndPath(mav,"student.insert_m.success","student.insert_p.success");
			}else {
				super.setMsgAndPath(mav,"student.insert_m.failure","student.insert_p.failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "student_list")
	public void list(HttpServletResponse response){
		try {
			super.printObjectToList(response,"allStudent",this.studentService.list());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "student_search")
	public ModelAndView search(HttpServletResponse response){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		String search = request.getParameter("search");
		System.out.println(search);
		try {
			super.printObjectToList(response,"searchStudent",this.studentService.search(search));
			super.setMsgAndPath(mav,"student.search_m.failure","student.search_p");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "student_to_edit")
	public ModelAndView toEdit(Student student,HttpServletResponse response){
		ModelAndView mav = new ModelAndView(super.getResource("student.edit_p.success"));
		try {
			Student stu=this.studentService.getByNumber(student.getSt_number());
			mav.addObject("student", stu);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "student_edit")
	public ModelAndView Edit(Student student,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView(super.getResource("student.edit_p.success"));
		try {
			String old_st_number=request.getParameter("old_st_number");
			Student old_stu=this.studentService.getByNumber(old_st_number);
			if(!old_st_number.equals(student.getSt_number())){
				Student new_stu=this.studentService.getByNumber(student.getSt_number());
				if(new_stu!=null){
					mav.addObject("student", old_stu);
					mav.addObject("msg", "账号已经存在，请重新输入！");
					return mav;
				}
			}

			if(student.getSt_password()!=null){
				student.setSt_password(new MD5Code().getMD5ofStr(student.getSt_password()+student.getSt_number()));
			}else{
				student.setSt_password(old_stu.getSt_password());
			}
			student.setOld_st_number(old_st_number);
			this.studentService.updateStuInfo(student);
			mav.addObject("student", student);
			mav.addObject("msg", "修改成功！");


		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "student_logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		request.getSession().invalidate(); // 表示session失效
		super.setMsgAndPath(mav,"account.logout_m.success","account.logout_p.success");
		return mav;
	}

	@RequestMapping(value = "student_delete")
	public ModelAndView delete(Student student,HttpServletResponse response) throws SQLException {
		String st_number = student.getSt_number();
		System.out.println(st_number);
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		this.studentService.delete(st_number);
		super.setMsgAndPath(mav,"delete_m.success","student.delete_p.success");
		return mav;
	}
	@Override
	public String getText() {
		return "学生账号";
	}
}
