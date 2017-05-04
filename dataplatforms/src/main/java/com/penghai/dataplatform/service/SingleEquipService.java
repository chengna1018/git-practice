package com.penghai.dataplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penghai.dataplatform.bo.SingleEquip;
import com.penghai.dataplatform.dao.SingleEquipMapper;;

@Service
public class SingleEquipService {
	@Autowired
	private SingleEquipMapper singleEquipMapper;
	
	public List<SingleEquip> getSingleEquip(Integer id){
		List<SingleEquip> singleEquip=singleEquipMapper.selectSingleEquip(id);
		return singleEquip;
	}
	
	/*public SingleEquip getSingleEquip(Integer id){
		SingleEquip singleEquip=singleEquipMapper.selectSingleEquip(id);
		return singleEquip;
	}*/
	
}
