package cn.edu.nchu.student.service;

import cn.edu.nchu.student.vo.activity.Sanxiao;

import java.sql.SQLException;
import java.util.List;

public interface ISanxiaoService {
	/**
	 * 实现班级数据增加操作
	 * @param vo 表示要执行操作的vo对象
	 * @return 成功返回ture，失败返回false
	 * @throws Exception
	 */
	public boolean insert(Sanxiao vo) throws Exception;
	/**
	 * 实现全部数据列出操作
	 * @return 成功返回ture 失败返回false
	 * @throws SQLException
	 */
	public List<Sanxiao> list()throws SQLException;

    public void delete(String st_number);
}
