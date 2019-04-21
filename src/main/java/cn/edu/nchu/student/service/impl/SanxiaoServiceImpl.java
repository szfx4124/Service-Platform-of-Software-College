package cn.edu.nchu.student.service.impl;

import cn.edu.nchu.student.dao.ISanxiaoDAO;
import cn.edu.nchu.student.service.ISanxiaoService;
import cn.edu.nchu.student.vo.activity.Sanxiao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class SanxiaoServiceImpl implements ISanxiaoService {
	@Resource
	private ISanxiaoDAO sanxiaoDAO;
	@Override
	public boolean insert(Sanxiao vo) throws Exception {
		if (this.sanxiaoDAO.findById(vo.getSt_number())==null){
			return this.sanxiaoDAO.doCreate(vo);
		}
		return false;
	}
	@Override
	public List<Sanxiao> list() throws SQLException {
		return this.sanxiaoDAO.findAll();
	}

	@Override
	public void delete(String st_number) {
		this.sanxiaoDAO.delete(st_number);
	}
}
