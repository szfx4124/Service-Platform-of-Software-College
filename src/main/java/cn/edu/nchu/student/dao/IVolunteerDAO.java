package cn.edu.nchu.student.dao;

import cn.edu.nchu.student.vo.afterclass.Volunteer;

import java.sql.SQLException;
import java.util.List;

public interface IVolunteerDAO extends IDAO<String, Volunteer> {
	/**
	 * 实现班级名称查询操作
	 * @param st_number 表示要执行的查询的班级名称
	 * @return
	 * @throws SQLException
	 */
	public Volunteer findById(String st_number) throws SQLException;

    public void delete(String st_number);

    public boolean doCreate_confirm(Volunteer vo);

    public List<Volunteer> findConfirmAll() throws SQLException;

    public void confirm_delete(String st_number);
}
