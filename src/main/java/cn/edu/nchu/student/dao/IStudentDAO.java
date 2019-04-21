package cn.edu.nchu.student.dao;

import cn.edu.nchu.student.vo.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO extends IDAO<String,Student> {
	/**
	 * 实现登录查询操作
	 * @param vo 包含要执行查询的字段：（email password）
	 * @return 成功返回最后一次登录日期
	 * @throws SQLException
	 */
	public Student findLogin(Student vo)throws SQLException;

	/**
	 * 实现班级名称查询操作
	 * @param st_number 表示要执行的查询的班级名称
	 * @return
	 * @throws SQLException
	 */
	public Student findById(String st_number) throws SQLException;
	public void doUpdateStuInfo(Student vo) throws Exception ;

	public void delete(String st_number) throws SQLException;

    public List<Student> search(String search) throws SQLException;
}
