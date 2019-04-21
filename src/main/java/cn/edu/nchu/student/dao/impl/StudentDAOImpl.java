package cn.edu.nchu.student.dao.impl;

import cn.edu.nchu.student.dao.IStudentDAO;
import cn.edu.nchu.student.vo.Student;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class StudentDAOImpl extends SqlSessionDaoSupport implements IStudentDAO {
	@Autowired
	public StudentDAOImpl(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	@Override
	public Student findLogin(Student vo) throws SQLException {
		return super.getSqlSession().selectOne("studentNS.findLogin",vo);
	}

	@Override
	public boolean doCreate(Student vo) throws SQLException {
		return super.getSqlSession().insert("studentNS.doCreate",vo) > 0;
	}

	@Override
	public boolean doUpdate(Student vo) throws SQLException {
		return super.getSqlSession().update("studentNS.doUpdateLastDate",vo) > 0;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}


	@Override
	public Student findById(String st_number) throws SQLException {
		return super.getSqlSession().selectOne("studentNS.findById",st_number);
	}

	@Override
	public void doUpdateStuInfo(Student vo) throws Exception {
		super.getSqlSession().update("studentNS.doUpdateStuInfo",vo);
	}

	@Override
	public List<Student> findAll() throws SQLException {
		return super.getSqlSession().selectList("studentNS.findAll");
	}

	@Override
	public List<Student> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return null;
	}
	@Override
	public void delete(String st_number) throws SQLException {
		super.getSqlSession().selectOne("studentNS.doremove",st_number);
	}

	@Override
	public List<Student> search(String student) throws SQLException{
		return super.getSqlSession().selectList("studentNS.search",student);
	}
}
