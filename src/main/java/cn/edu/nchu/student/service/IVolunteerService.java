package cn.edu.nchu.student.service;

import cn.edu.nchu.student.vo.afterclass.Volunteer;

import java.sql.SQLException;
import java.util.List;

public interface IVolunteerService {
	/**
	 * 实现班级数据增加操作
	 * @param vo 表示要执行操作的vo对象
	 * @return 成功返回ture，失败返回false
	 * @throws Exception
	 */
	public boolean insert(Volunteer vo) throws Exception;
	/**
	 * 实现全部数据列出操作
	 * @return 成功返回ture 失败返回false
	 * @throws SQLException
	 */
	public List<Volunteer> list()throws SQLException;

    public void delete(String st_number);

    public void confirm(Volunteer vo) throws SQLException;

    public List<Volunteer> confirm_list() throws SQLException;

	public void confirm_delete(String st_number);
}
