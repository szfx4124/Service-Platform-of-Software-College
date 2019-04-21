package cn.edu.nchu.student.dao;

import cn.edu.nchu.student.vo.Notice;

import java.sql.SQLException;

public interface INoticeDAO extends IDAO<String, Notice> {
	/**
	 * 实现班级名称查询操作
	 * @param st_number 表示要执行的查询的班级名称
	 * @return
	 * @throws SQLException
	 */
	public Notice findById(String st_number) throws SQLException;

    void doUpdateNotInfo(Notice vo) throws Exception;

	void delete(String title) throws SQLException;
}
