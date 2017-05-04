package com.penghai.dataplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penghai.dataplatform.bo.Equip;
import com.penghai.dataplatform.dao.EquipMapper;

@Service
public class EquipService {
	@Autowired
	private EquipMapper equipMapper;
	//private Optional<EquipMapper> equipMapper;

	public List<Equip> selectAllEquips(Integer id) {
		List<Equip> equips = equipMapper.selectEquips(id);
		return equips;
	}

	public List<Equip> selectEquipsByPage(Integer id, Integer page) {
		List<Equip> equips = equipMapper.selectEquipsByPage(id, page);
		return equips;
	}

}
