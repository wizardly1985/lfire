package com.lfire.host.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lfire.host.dao.BaseDao;


@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	public BaseDaoImpl() {
		super();
	}

	public boolean insert(T t) {
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean flag = true;
		try {
			session.save(t);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("HibernateUtils：数据库增加发生错误");
			transaction.rollback();
			flag = false;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return flag;
	}

	public boolean delete(T t) {
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean flag = true;
		try {
			session.delete(t);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("HibernateUtils：数据库删除发生错误");
			transaction.rollback();
			flag = false;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return flag;
	}

	public boolean deleteAll(String ids) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(T t) {
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean flag = true;
		try {
			session.update(t);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("HibernateUtils：数据库增加发生错误");
			transaction.rollback();
			flag = false;
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return flag;
	}

	public T findById(Serializable id) {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) type;
		Class clazz = (Class<T>) pt.getActualTypeArguments()[0];
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Object targetObject = null;
		try {
			targetObject = session.get(clazz, id);
			System.out.println("class:" + clazz.getClass());
			System.out.println("id:" + id);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("HibernateUtils：数据库查找发生错误");
			transaction.rollback();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return (T)targetObject;
	}

	public List<T> findAll() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)type ;
		Class<T> beanClass = (Class<T>) pt.getActualTypeArguments()[0];
		Session session = sessionFactory.openSession();
		List<T> list = null;
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery("from "+beanClass.getSimpleName());
			list = query.list();
		
		}catch(Exception e){
			System.out.println("HibernateUtils：数据库列表查询操作发生错误：");
			transaction.rollback();
			
		}finally{
			
			if(session!=null){
				session.close();
			}
		}
		
		return (List<T>) list;
	}

	@SuppressWarnings("unchecked")
	public List<T> getListByPage(Integer pageNo, Integer pageSize) {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)type ;
		Class<T> beanClass = (Class<T>) pt.getActualTypeArguments()[0];
		Session session = sessionFactory.openSession();
		List<T> list = null;
		Transaction transaction = session.beginTransaction();
		try{
			Query query = session.createQuery("from "+beanClass.getSimpleName()).
			setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize);
			list = query.list();
		
		}catch(Exception e){
			System.out.println("HibernateUtils：数据库列表查询操作发生错误：");
			transaction.rollback();
			
		}finally{
			
			if(session!=null){
				session.close();
			}
		}
		
		return (List<T>) list;
	}

	public Integer getListCount() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getQueryListByPage(Integer pageNo, Integer pageSize, String... queryEle) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getQueryListCount(String... queryEle) {
		// TODO Auto-generated method stub
		return null;
	}

}
