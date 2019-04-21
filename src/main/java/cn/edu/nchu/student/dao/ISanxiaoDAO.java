package cn.edu.nchu.student.dao;

import cn.edu.nchu.student.vo.activity.Sanxiao;

import java.sql.SQLException;

public interface ISanxiaoDAO extends IDAO<String, Sanxiao> {
	/**
	 * 实现班级名称查询操作
	 * @param st_number 表示要执行的查询的班级名称
	 * @return
	 * @throws SQLException
	 */
	public Sanxiao findById(String st_number) throws SQLException;

    public void delete(String st_number);
}
