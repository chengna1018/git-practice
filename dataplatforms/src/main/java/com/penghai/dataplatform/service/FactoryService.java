package com.penghai.dataplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penghai.dataplatform.bo.Factory;
import com.penghai.dataplatform.dao.FactoryMapper;

/*
 * 查询所有的工厂信息的service
 * @author 李浩
 */
@Service
public class FactoryService {
	@Autowired
	private FactoryMapper factoryMapper;

	public List<Factory> getAllfactorys() {
		List<Factory> factorys = factoryMapper.selectAllFactorys();
		return factorys;
	}
}
