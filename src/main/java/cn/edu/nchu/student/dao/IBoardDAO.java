package cn.edu.nchu.student.dao;

import cn.edu.nchu.student.vo.Board;

import java.sql.SQLException;

public interface IBoardDAO extends IDAO<String,Board> {
	/**
	 * 实现登录查询操作
	 * @param vo 包含要执行查询的字段：（email password）
	 * @return 成功返回最后一次登录日期
	 * @throws SQLException
	 */
	public Board findLogin(Board vo)throws SQLException;
	/**
	 * 实现班级名称查询操作
	 * @param title 表示要执行的查询的班级名称
	 * @return
	 * @throws SQLException
	 */
	public Board findById(String title) throws SQLException;

    public void delete(String title);
}
