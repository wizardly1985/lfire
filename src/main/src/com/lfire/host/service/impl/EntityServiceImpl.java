package com.lfire.host.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfire.host.dao.impl.demo.EntityDaoImpl;
import com.lfire.host.entity.demo.Entity;
import com.lfire.host.service.EntityService;
@Service("entityServiceImpl")
public class EntityServiceImpl implements EntityService{
	
	@Autowired
	private EntityDaoImpl entityDao;
	public boolean add(Entity e) {
		return entityDao.insert(e);
	}
	public Entity findById(Serializable id) {
		return entityDao.findById(id);
	}
	
	public boolean del(Serializable id){
		Entity en = null;
		en = entityDao.findById(id);
		if(en == null)
			return false;
		return entityDao.delete(en);
	}
	public boolean update(Entity e){
		boolean flag = true;
		Entity en = null;
		en = entityDao.findById(e.getId());
		if(en == null){
			flag = false;
			return flag;
		}
		entityDao.update(en);
		return flag;
	}
	public List<Entity> getListByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return entityDao.getListByPage(pageNo, pageSize);
	}

}
