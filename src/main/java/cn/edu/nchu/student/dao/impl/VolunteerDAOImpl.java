package cn.edu.nchu.student.dao.impl;

import cn.edu.nchu.student.dao.IVolunteerDAO;
import cn.edu.nchu.student.vo.afterclass.Volunteer;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class VolunteerDAOImpl extends SqlSessionDaoSupport implements IVolunteerDAO {
	@Autowired
	public VolunteerDAOImpl(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public boolean doCreate(Volunteer vo) throws SQLException {
		return super.getSqlSession().insert("volunteerNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Volunteer vo) throws SQLException {
		return super.getSqlSession().update("volunteerNS.doUpdateLastDate",vo) > 0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public Volunteer findById(String st_number) throws SQLException {
		return super.getSqlSession().selectOne("volunteerNS.findById",st_number);
	}

	@Override
	public void delete(String st_number) {
		super.getSqlSession().selectOne("volunteerNS.doRemove",st_number);
	}

	@Override
	public boolean doCreate_confirm(Volunteer vo) {
		return super.getSqlSession().insert("volunteerNS.doConfirm",vo) > 0;
	}

	@Override
	public List<Volunteer> findConfirmAll() throws SQLException {
		return super.getSqlSession().selectList("volunteerNS.findConfirmAll");
	}

	@Override
	public void confirm_delete(String st_number) {
		super.getSqlSession().selectOne("volunteerNS.doRemoveConfirm",st_number);
	}

	@Override
	public List<Volunteer> findAll() throws SQLException {
		return super.getSqlSession().selectList("volunteerNS.findAll");
	}

	@Override
	public List<Volunteer> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return null;
	}
}
