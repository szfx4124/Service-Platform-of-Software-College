package cn.edu.nchu.student.action;

import cn.edu.nchu.student.service.IYuandanService;
import cn.edu.nchu.student.vo.activity.Yuandan;
import cn.edu.nchu.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/pages/back/*" )

public class YuandanAction extends DefaultAction {
	@Resource
	private IYuandanService activityService;

	@RequestMapping(value = "yuandan_insert")
	public ModelAndView insert(Yuandan vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.activityService.insert(vo)){
				super.setMsgAndPath(mav,"activity.insert_m.success","yuandan.insert_p.success");
			}else {
				super.setMsgAndPath(mav,"activity.insert_m.failure","yuandan.insert_p.failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "yuandan_list")
	public void list(HttpServletResponse response){
		try {
			super.printObjectToList(response,"allYuandan",this.activityService.list());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "yuandan_delete")
	public ModelAndView delete(Yuandan notice,HttpServletResponse response) throws SQLException {
		String st_number = notice.getSt_number();
		System.out.println(st_number);
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		this.activityService.delete(st_number);
		super.setMsgAndPath(mav,"delete_m.success","yuandan.delete_p.success");
		return mav;
	}
	@Override
	public String getText() {
		return "活动信息";
	}
}
