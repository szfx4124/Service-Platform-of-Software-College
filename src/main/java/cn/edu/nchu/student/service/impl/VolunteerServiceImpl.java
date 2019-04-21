package cn.edu.nchu.student.service.impl;

import cn.edu.nchu.student.dao.IVolunteerDAO;
import cn.edu.nchu.student.service.IVolunteerService;
import cn.edu.nchu.student.vo.afterclass.Volunteer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class VolunteerServiceImpl implements IVolunteerService {
	@Resource
	private IVolunteerDAO volunteerDAO;
	@Override
	public boolean insert(Volunteer vo) throws Exception {
		if (this.volunteerDAO.findById(vo.getSt_number())==null){
			return this.volunteerDAO.doCreate(vo);
		}
		return false;
	}

	@Override
	public List<Volunteer> list() throws SQLException {
		return this.volunteerDAO.findAll();
	}

	@Override
	public void delete(String st_number) {
		this.volunteerDAO.delete(st_number);
	}

	@Override
	public void confirm(Volunteer vo) throws SQLException {
		vo = this.volunteerDAO.findById(vo.getSt_number());
		System.out.println(vo.getSt_number()+vo.getName()+vo.getFile());
		this.volunteerDAO.doCreate_confirm(vo);
		this.volunteerDAO.delete(vo.getSt_number());
	}

	@Override
	public List<Volunteer> confirm_list() throws SQLException{
		return this.volunteerDAO.findConfirmAll();
	}

	@Override
	public void confirm_delete(String st_number) {
		this.volunteerDAO.confirm_delete(st_number);
	}
}
