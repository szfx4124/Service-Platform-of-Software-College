package cn.edu.nchu.student.service.impl;

import cn.edu.nchu.student.dao.IBoardDAO;
import cn.edu.nchu.student.service.IBoardService;
import cn.edu.nchu.student.vo.Board;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService {
	@Resource
	private IBoardDAO boardDAO;
	@Override
	public boolean insert(Board vo) throws Exception {
		if (this.boardDAO.findById(vo.getTitle())== null){
			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
			System.out.println(time);
			vo.setDate(time);
			return this.boardDAO.doCreate(vo);
		}
		return false;
	}
	@Override
	public List<Board> list() throws SQLException {
		return this.boardDAO.findAll();
	}

	@Override
	public void delete(String title) {
		this.boardDAO.delete(title);
	}
}
