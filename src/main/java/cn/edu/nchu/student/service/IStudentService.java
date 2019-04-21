package cn.edu.nchu.student.service;

import cn.edu.nchu.student.vo.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
	/**
	 * 实现班级数据增加操作
	 * @param vo 表示要执行操作的vo对象
	 * @return 成功返回ture，失败返回false
	 * @throws Exception
	 */
	public boolean insert(Student vo) throws Exception;
	/**
	 * 实现全部数据列出操作
	 * @return 成功返回ture 失败返回false
	 * @throws SQLException
	 */
	public List<Student> list()throws SQLException;
	/**
	 * 实现管理员登录
	 * @param vo 包含要执行登录检查的字段 email password
	 * @return
	 * @throws Exception
	 */
	public Student login(Student vo)throws Exception;
	public Student getByNumber(String  st_number)throws Exception;
	public void updateStuInfo(Student vo)throws Exception;

    void delete(String st_number) throws SQLException;


    public List<Student> search(String student) throws SQLException;
}
