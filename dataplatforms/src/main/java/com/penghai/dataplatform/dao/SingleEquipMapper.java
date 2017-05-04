package com.penghai.dataplatform.dao;

import java.util.List;

import com.penghai.dataplatform.bo.SingleEquip;

public interface SingleEquipMapper {
	public List<SingleEquip> selectSingleEquip(Integer id);
	//public SingleEquip selectSingleEquip(Integer id);
}
