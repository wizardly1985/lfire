package com.lfire.host.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfire.host.dao.impl.demo.DeptDaoImpl;
import com.lfire.host.entity.demo.Dept;
import com.lfire.host.service.DeptService;
@Service("deptServiceImpl")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDaoImpl deptDaoImpl;
	public List<Dept> findAll() {
		return deptDaoImpl.findAll();
	}

}
