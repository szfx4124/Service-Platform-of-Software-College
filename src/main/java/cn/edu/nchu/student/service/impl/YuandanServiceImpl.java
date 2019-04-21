package cn.edu.nchu.student.service.impl;

import cn.edu.nchu.student.dao.IYuandanDAO;
import cn.edu.nchu.student.service.IYuandanService;
import cn.edu.nchu.student.vo.activity.Yuandan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class YuandanServiceImpl implements IYuandanService {
	@Resource
	private IYuandanDAO yuandanDAO;
	@Override
	public boolean insert(Yuandan vo) throws Exception {
		if (this.yuandanDAO.findById(vo.getSt_number())==null){
			return this.yuandanDAO.doCreate(vo);
		}
		return false;
	}
	@Override
	public List<Yuandan> list() throws SQLException {
		return this.yuandanDAO.findAll();
	}

	@Override
	public void delete(String st_number) throws SQLException {
		this.yuandanDAO.delete(st_number);
	}
}
