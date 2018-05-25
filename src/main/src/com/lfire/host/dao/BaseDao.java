package com.lfire.host.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	/**
	 * 
	 * @function 增加
	 * @author lyl
	 * @time 2016-2-14 下午3:30:17
	 */
	public boolean insert(T t);
	/**
	 * 
	 * @function 删除
	 * @author lyl
	 * @time 2016-2-14 下午3:30:26
	 */
	public boolean delete(T t);
	/**
	 * 
	 * @function 更新
	 * @author lyl
	 * @time 2016-2-14 下午3:30:32
	 */
	/**
	 * 
	 * @function 批量删除
	 * @author lyl
	 * @time 2016-2-14 下午3:30:26
	 */
	public boolean deleteAll(String ids);
	public boolean update(T t);
	/**
	 * 
	 * @function 查找
	 * @author lyl
	 * @time 2016-2-14 下午3:30:39
	 */
	public T findById(Serializable id);
	/**
	 * 
	 * @function 全列表
	 * @author lyl
	 * @time 2016-2-14 下午3:30:46
	 */
	public List<T> findAll();
	/**
	 * 
	 * @function 分页列表
	 * @author lyl
	 * @time 2016-2-14 下午3:28:06
	 */
	public List<T> getListByPage(Integer pageNo,Integer pageSize);
	/**
	 * 
	 * @function 分页列表数据条数
	 * @author lyl
	 * @time 2016-2-14 下午3:28:22
	 */
	public Integer getListCount();
	
	/**
	 * 
	 * @function 分页加模糊
	 * @author lyl
	 * @time 2016-2-14 下午3:28:38
	 */
	public List<T> getQueryListByPage(Integer pageNo,Integer pageSize,String ... queryEle);
	
	/**
	 * 
	 * @function 模糊查询列表条数
	 * @author lyl
	 * @time 2016-2-14 下午3:28:52
	 */
	public Integer getQueryListCount(String ... queryEle);
}
