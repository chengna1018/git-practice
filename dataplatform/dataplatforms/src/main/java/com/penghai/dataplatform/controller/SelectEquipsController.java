package com.penghai.dataplatform.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.penghai.dataplatform.bo.Equip;
import com.penghai.dataplatform.service.EquipService;

@Controller
public class SelectEquipsController extends BaseController {
	@Autowired
	private EquipService equipService;

	/**
	 * 查询某一工厂的所有设备-起始页
	 * 
	 * @return Equip的列表
	 */
	@RequestMapping("/equips")
	public String selectEquips() {
		
		Integer eid = Integer.parseInt(request.getParameter("id"));
	
		// 查询出所有设备
		List<Equip> equips = equipService.selectAllEquips(eid);
		JSONArray jsonArray = new JSONArray();
		// 起始页面显示8个设备
		for (int i = 0; i < 8; i++) {
			Equip e = equips.get(i);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", e.getId());
			jsonObject.put("ename", e.getEname());
			jsonObject.put("desc", e.getDesc());
			jsonObject.put("picture", e.getPicture());
			jsonArray.add(jsonObject);
		}
		// 求所有设备所占的页数
		int num = (int) Math.ceil(equips.size() / 8.0);
		// 把所得的数据传入请求中，带入下一页面
		request.setAttribute("equipList", jsonArray);
		request.setAttribute("pageNum", num);
		request.setAttribute("id", eid);
		return "equips";
	}

	/**
	 * 分页查询，ajax请求
	 */

	@RequestMapping("/equips/page")
	@ResponseBody
	public Map<String, Object> selectDataByPage() {
		Map<String, Object> result = new HashMap<String, Object>();

		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		Integer start = (page - 1) * 8;
		List<Equip> equips = equipService.selectEquipsByPage(id, start);
		JSONArray jsonArray = new JSONArray();
		for (Equip e : equips) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", e.getId());
			jsonObject.put("ename", e.getEname());
			jsonObject.put("desc", e.getDesc());
			jsonObject.put("picture", e.getPicture());
			jsonArray.add(jsonObject);
		}
		// 保存返回的data关键字数据
		List<Equip> exList = new ArrayList<Equip>();
		exList = JSONArray.parseArray(JSON.toJSONString(jsonArray), Equip.class);
		result.put("result", exList);
		// 返回界面结果
		return result;

	}
}
