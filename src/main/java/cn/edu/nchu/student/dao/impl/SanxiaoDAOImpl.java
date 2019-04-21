package cn.edu.nchu.student.dao.impl;

import cn.edu.nchu.student.dao.ISanxiaoDAO;
import cn.edu.nchu.student.vo.activity.Sanxiao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class SanxiaoDAOImpl extends SqlSessionDaoSupport implements ISanxiaoDAO {
	@Autowired
	public SanxiaoDAOImpl(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public boolean doCreate(Sanxiao vo) throws SQLException {
		return super.getSqlSession().insert("sanxiaoNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Sanxiao vo) throws SQLException {
		return super.getSqlSession().update("sanxiaoNS.doUpdateLastDate",vo) > 0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Sanxiao findById(String st_number) throws SQLException {
		return super.getSqlSession().selectOne("sanxiaoNS.findById",st_number);
	}

	@Override
	public void delete(String st_number) {
		super.getSqlSession().selectOne("sanxiaoNS.doremove",st_number);
	}

	@Override
	public List<Sanxiao> findAll() throws SQLException {
		return super.getSqlSession().selectList("sanxiaoNS.findAll");
	}

	@Override
	public List<Sanxiao> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return null;
	}
}
