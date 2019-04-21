package cn.edu.nchu.student.dao.impl;

import cn.edu.nchu.student.dao.INoticeDAO;
import cn.edu.nchu.student.vo.Notice;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class NoticeDAOImpl extends SqlSessionDaoSupport implements INoticeDAO {
	@Autowired
	public NoticeDAOImpl(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public boolean doCreate(Notice vo) throws SQLException {
		return super.getSqlSession().insert("noticeNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Notice vo) throws SQLException {
		return super.getSqlSession().update("noticeNS.doUpdateLastDate",vo) > 0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Notice findById(String title) throws SQLException {
		return super.getSqlSession().selectOne("noticeNS.findById",title);
	}

	@Override
	public List<Notice> findAll() throws SQLException {
		return super.getSqlSession().selectList("noticeNS.findAll");
	}

	@Override
	public List<Notice> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return null;
	}
	@Override
	public void doUpdateNotInfo(Notice vo) throws Exception {
		super.getSqlSession().update("noticeNS.doUpdateNotInfo",vo);
	}
	@Override
	public void delete(String title) throws SQLException {
		super.getSqlSession().selectOne("noticeNS.doremove",title);
	}
}
