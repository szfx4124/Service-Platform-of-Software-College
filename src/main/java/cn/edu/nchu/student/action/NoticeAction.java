package cn.edu.nchu.student.action;

import cn.edu.nchu.student.service.INoticeService;
import cn.edu.nchu.student.vo.Notice;
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
import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/pages/back/*" )

public class NoticeAction extends DefaultAction {
	@Resource
	private INoticeService noticeService;

	@RequestMapping(value = "notice_insert")
	public ModelAndView insert(Notice vo, @RequestParam("appendix") CommonsMultipartFile appendix,
							   HttpServletRequest request){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		System.out.println("进入action");
		try {
			vo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			System.out.println(vo.getTime());
			String title = request.getParameter("title");
			vo.setTitle(title);
			String name = request.getParameter("name");
			vo.setName(name);

			String file_type = appendix.getOriginalFilename().substring(
					appendix.getOriginalFilename().indexOf("."));// 取文件格式后缀名
			String file_name = new Date().getTime()+ "_file" + file_type;// 取时间戳作为文件名
			vo.setFile(file_name);

			String file_path = request.getSession().getServletContext()
					.getRealPath("/WEB-INF/notice/file/" + file_name);// 存放位置
			File file_destFile = new File(file_path);
			FileUtils.copyInputStreamToFile(appendix.getInputStream(),file_destFile);
			if (this.noticeService.insert(vo)){
				super.setMsgAndPath(mav,"notice.insert_m.success","notice.insert_p.success");
			}
			else
				super.setMsgAndPath(mav,"notice.insert_m.failure","notice.insert_p.failure");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "notice_download")
	public ResponseEntity<byte[]> export(HttpServletRequest request) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		String fileName = request.getParameter("id");
		System.out.println(fileName);
		String filePath = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/notice/file/" + fileName);
		File file = new File(filePath);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}
	@RequestMapping(value = "notice_list")
	public void list(HttpServletResponse response){
		try {
			super.printObjectToList(response,"allNotice",this.noticeService.list());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "notice_delete")
	public ModelAndView delete(Notice notice,HttpServletResponse response) throws SQLException {
		String title = notice.getTitle();
		System.out.println(title);
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		this.noticeService.delete(title);
		super.setMsgAndPath(mav,"delete_m.success","notice.delete_p.success");
		return mav;
	}
	@Override
	public String getText() {
		return "通知文件";
	}
}
