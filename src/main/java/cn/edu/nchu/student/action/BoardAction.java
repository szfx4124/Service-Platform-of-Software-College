package cn.edu.nchu.student.action;

import cn.edu.nchu.student.service.IBoardService;
import cn.edu.nchu.student.vo.Board;
import cn.edu.nchu.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/pages/back/*" )

public class BoardAction extends DefaultAction {
	@Resource
	private IBoardService boardService;

	@RequestMapping(value = "board_insert")
	public ModelAndView insert(Board vo){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (this.boardService.insert(vo)){
				super.setMsgAndPath(mav,"notice.insert_m.success","board.insert_p.success");
			}else {
				super.setMsgAndPath(mav,"notice.insert_m.failure","board.insert_p.failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "board_list")
	public void list(HttpServletResponse response){
		try {
			super.printObjectToList(response,"allBoard",this.boardService.list());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "board_delete")
	public ModelAndView delete(Board board,HttpServletResponse response) throws SQLException {
		String title = board.getTitle();
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		this.boardService.delete(title);
		super.setMsgAndPath(mav,"delete_m.success","board.delete_p.success");
		return mav;
	}
	@Override
	public String getText() {
		return "内部公告";
	}
}
