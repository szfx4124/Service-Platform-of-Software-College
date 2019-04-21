package cn.edu.nchu.student.service.impl;

import cn.edu.nchu.student.dao.IStudentDAO;
import cn.edu.nchu.student.service.IStudentService;
import cn.edu.nchu.student.vo.Student;
import cn.edu.nchu.util.MD5Code;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
	@Resource
	private IStudentDAO studentDAO;
	@Override
	public Student login(Student vo) throws Exception {
		Student student = this.studentDAO.findLogin(vo);
		if (student != null){ //表示登陆成功
			vo.setSt_lastdate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			this.studentDAO.doUpdate(vo);
		}
		return student;
	}
	@Override
	public boolean insert(Student vo) throws Exception {
		if (this.studentDAO.findById(vo.getSt_number())==null){
			vo.setSt_password(new MD5Code().getMD5ofStr(vo.getSt_password()+vo.getSt_number()));
			vo.setSt_lastdate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			return this.studentDAO.doCreate(vo);
		}
		return false;
	}
	@Override
	public List<Student> list() throws SQLException {
		return this.studentDAO.findAll();
	}
	@Override
	public Student getByNumber(String st_number) throws Exception {
		return this.studentDAO.findById(st_number);
	}
	@Override
	public void updateStuInfo(Student vo) throws Exception {
		this.studentDAO.doUpdateStuInfo(vo);
	}

	@Override
	public void delete(String st_number) throws SQLException {
		this.studentDAO.delete(st_number);
	}

	@Override
	public List<Student> search(String student) throws SQLException {
		return this.studentDAO.search(student);
	}
}
