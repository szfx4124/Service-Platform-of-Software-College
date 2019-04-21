package cn.edu.nchu.student.service.impl;

import cn.edu.nchu.student.dao.INoticeDAO;
import cn.edu.nchu.student.service.INoticeService;
import cn.edu.nchu.student.vo.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class NoticeServiceImpl implements INoticeService {
	@Resource
	private INoticeDAO noticeDAO;
	@Override
	public boolean insert(Notice vo) throws Exception {
		return this.noticeDAO.doCreate(vo);
	}
	@Override
	public List<Notice> list() throws SQLException {
		return this.noticeDAO.findAll();
	}
	@Override
	public void updateNotInfo(Notice vo) throws Exception {
		this.noticeDAO.doUpdateNotInfo(vo);
	}

	@Override
	public void delete(String title) throws SQLException {
		this.noticeDAO.delete(title);
	}
	@Override
	public Notice getByNumber(String title) throws Exception {
		return this.noticeDAO.findById(title);
	}
}
