package com.lfire.host.service;

import java.io.Serializable;
import java.util.List;

import com.lfire.host.entity.demo.Entity;

public interface EntityService {

	public boolean add(Entity e);
	public Entity findById(Serializable id);
	public List<Entity> getListByPage(Integer pageNo, Integer pageSize);
}
