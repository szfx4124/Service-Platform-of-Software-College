package cn.edu.nchu.student.dao.impl;

import cn.edu.nchu.student.dao.IYuandanDAO;
import cn.edu.nchu.student.vo.activity.Yuandan;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class YuandanDAOImpl extends SqlSessionDaoSupport implements IYuandanDAO {
	@Autowired
	public YuandanDAOImpl(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public Yuandan findLogin(Yuandan vo) throws SQLException {
		return super.getSqlSession().selectOne("yuandanNS.findLogin",vo);
	}

	@Override
	public boolean doCreate(Yuandan vo) throws SQLException {
		return super.getSqlSession().insert("yuandanNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Yuandan vo) throws SQLException {
		return super.getSqlSession().update("yuandanNS.doUpdateLastDate",vo) > 0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Yuandan findById(String st_number) throws SQLException {
		return super.getSqlSession().selectOne("yuandanNS.findById",st_number);
	}

	@Override
	public List<Yuandan> findAll() throws SQLException {
		return super.getSqlSession().selectList("yuandanNS.findAll");
	}

	@Override
	public List<Yuandan> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return null;
	}
	@Override
	public void delete(String st_number) throws SQLException {
		super.getSqlSession().selectOne("yuandanNS.doremove",st_number);
	}
}
