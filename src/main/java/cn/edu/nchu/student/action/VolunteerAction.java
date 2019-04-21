package cn.edu.nchu.student.action;

import cn.edu.nchu.student.service.IVolunteerService;
import cn.edu.nchu.student.vo.afterclass.Volunteer;
import cn.edu.nchu.util.action.DefaultAction;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZJH
 */
@Controller
@RequestMapping(value = "/pages/back/*" )

public class VolunteerAction extends DefaultAction {
	@Resource
	private IVolunteerService volunteerService;

	@RequestMapping(value = "volunteer_insert")
	public ModelAndView insert(Volunteer vo, @RequestParam("InputFile") CommonsMultipartFile file,
							   HttpServletRequest request){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (!file.isEmpty()){
				String type = file.getOriginalFilename().substring(
						file.getOriginalFilename().indexOf("."));
				// 取文件格式后缀名
				String filename = vo.getSt_number() + type;
				// 取学号作为文件名
				vo.setFile(filename);
				String path = request.getSession().getServletContext()
						.getRealPath("/WEB-INF/document/volunteer/" + filename);
				// 存放位置
				File destFile = new File(path);
				FileUtils.copyInputStreamToFile(file.getInputStream(),destFile);
				vo.setScore("2");
				vo.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			}
			else {
				vo.setScore("2");
				vo.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			}
			if (this.volunteerService.insert(vo)){
				super.setMsgAndPath(mav,"activity.insert_m.success","volunteer.insert_p.success");
			}
			else {
				super.setMsgAndPath(mav,"activity.insert_m.failure","volunteer.insert_p.failure");
			}
		} catch (Exception e) {
			super.setMsgAndPath(mav,"insert_m.failure","volunteer.insert_p.failure");
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "volunteer_download")
	public ResponseEntity<byte[]> export(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		String fileName = request.getParameter("id");
		String filePath = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/document/volunteer/" + fileName);
		File file = new File(filePath);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}
	@RequestMapping(value = "volunteer_list")
	public void list(HttpServletResponse response){
		try {
			super.printObjectToList(response,"allVolunteer",this.volunteerService.list());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "volunteer_delete")
	public ModelAndView delete(Volunteer volunteer,HttpServletResponse response) throws SQLException {
		String st_number = volunteer.getSt_number();
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		this.volunteerService.delete(st_number);
		super.setMsgAndPath(mav,"delete_m.success","volunteer.delete_p.success");
		return mav;
	}
	@RequestMapping(value = "volunteer_confirm")
	public ModelAndView confirm(Volunteer vo,HttpServletResponse response) throws SQLException {
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		this.volunteerService.confirm(vo);
			super.setMsgAndPath(mav,"confirm_m.success","volunteer.delete_p.success");
		return mav;
	}
	@RequestMapping(value = "volunteer_confirm_list")
	public void confirm_list(HttpServletResponse response){
		try {
			super.printObjectToList(response,"allVolunteer",this.volunteerService.confirm_list());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "volunteer_confirm_delete")
	public ModelAndView confirm_delete(Volunteer vo,HttpServletResponse response) throws SQLException {
		String st_number = vo.getSt_number();
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		this.volunteerService.confirm_delete(st_number);
		super.setMsgAndPath(mav,"delete_m.success","volunteer.confirm_delete_p.success");
		return mav;
	}
	@Override
	public String getText() {
		return "志愿服务";
	}
}
