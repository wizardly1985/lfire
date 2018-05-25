package com.lfire.host.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfire.host.dao.impl.demo.TypeDaoImpl;
import com.lfire.host.entity.Type;
import com.lfire.host.service.TypeService;
@Service("typeServiceImpl")
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDaoImpl typeDaoimpl;
	public List<Type> findAll() {
		return typeDaoimpl.findAll();
	}

}
