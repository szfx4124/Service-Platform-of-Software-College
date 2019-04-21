package cn.edu.nchu.student.service.impl;

import cn.edu.nchu.student.dao.IAdminDAO;
import cn.edu.nchu.student.service.IAdminService;
import cn.edu.nchu.student.vo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AdminServiceImpl implements IAdminService {
	@Resource
	private IAdminDAO adminDAO;
	@Override
	public Admin login(Admin vo) throws Exception {
		Admin admin = this.adminDAO.findLogin(vo);
		if (admin != null){ //表示登陆成功
			vo.setAd_lastdate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
			this.adminDAO.doUpdate(vo);
		}
		return admin;
	}
}
