package cn.edu.nchu.student.action;

import cn.edu.nchu.student.service.ISanxiaoService;
import cn.edu.nchu.student.vo.activity.Sanxiao;
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

/**
 * @author ZJH
 */
@Controller
@RequestMapping(value = "/pages/back/*" )

public class SanxiaoAction extends DefaultAction {
	@Resource
	private ISanxiaoService sanxiaoService;

	@RequestMapping(value = "sanxiao_insert")
	public ModelAndView insert(Sanxiao vo,@RequestParam("InputFile") CommonsMultipartFile file,
						 HttpServletRequest request){
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		try {
			if (!file.isEmpty()){
				String type = file.getOriginalFilename().substring(
						file.getOriginalFilename().indexOf("."));
				// 取文件格式后缀名
				String filename = vo.getSt_number() + type;
				System.out.println("111111111111111"+filename);
				// 取学号作为文件名
				vo.setFile(filename);
				String path = request.getSession().getServletContext()
						.getRealPath("/WEB-INF/document/sanxiao/" + filename);
				// 存放位置
				File destFile = new File(path);
				FileUtils.copyInputStreamToFile(file.getInputStream(),destFile);
				if (this.sanxiaoService.insert(vo)){
					super.setMsgAndPath(mav,"activity.insert_m.success","sanxiao.insert_p.success");
				}
			}
			else {
				super.setMsgAndPath(mav,"activity.insert_m.failure","sanxiao.insert_p.failure");
			}
		} catch (Exception e) {
			super.setMsgAndPath(mav,"insert_m.failure","sanxiao.insert_p.failure");
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping(value = "download")
	public ResponseEntity<byte[]> export(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		String fileName = request.getParameter("id");
		System.out.println(fileName);
		String filePath = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/document/sanxiao/" + fileName);
		File file = new File(filePath);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}
	@RequestMapping(value = "sanxiao_list")
	public void list(HttpServletResponse response){
		try {
			super.printObjectToList(response,"allSanxiao",this.sanxiaoService.list());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "sanxiao_delete")
	public ModelAndView delete(Sanxiao sanxiao,HttpServletResponse response) throws SQLException {
		String st_number = sanxiao.getSt_number();
		System.out.println(st_number);
		ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
		this.sanxiaoService.delete(st_number);
		super.setMsgAndPath(mav,"delete_m.success","sanxiao.delete_p.success");
		return mav;
	}
	@Override
	public String getText() {
		return "材料";
	}
}
