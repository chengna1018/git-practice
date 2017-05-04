package com.penghai.dataplatform.dao;

import java.util.List;

import com.penghai.dataplatform.bo.Equip;

public interface EquipMapper {
	public List<Equip> selectEquips(Integer id);

	public List<Equip> selectEquipsByPage(Integer id, Integer page);
}
