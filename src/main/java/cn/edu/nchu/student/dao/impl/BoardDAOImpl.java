package cn.edu.nchu.student.dao.impl;

import cn.edu.nchu.student.dao.IBoardDAO;
import cn.edu.nchu.student.vo.Board;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class BoardDAOImpl extends SqlSessionDaoSupport implements IBoardDAO {
	@Autowired
	public BoardDAOImpl(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public Board findLogin(Board vo) throws SQLException {
		return super.getSqlSession().selectOne("boardNS.findLogin",vo);
	}

	@Override
	public boolean doCreate(Board vo) throws SQLException {
		return super.getSqlSession().insert("boardNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Board vo) throws SQLException {
		return super.getSqlSession().update("boardNS.doUpdateLastDate",vo) > 0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Board findById(String title) throws SQLException {
		return super.getSqlSession().selectOne("boardNS.findById",title);
	}

	@Override
	public void delete(String title) {
		super.getSqlSession().selectOne("boardNS.doremove",title);
	}

	@Override
	public List<Board> findAll() throws SQLException {
		return super.getSqlSession().selectList("boardNS.findAll");
	}

	@Override
	public List<Board> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return null;
	}
}
