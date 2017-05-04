package com.penghai.dataplatform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.penghai.dataplatform.bo.SingleEquip;
import com.penghai.dataplatform.service.SingleEquipService;


@Controller
public class SelectSingleEquipController extends BaseController{
	@Autowired
	private SingleEquipService singleEquipService;
	
	@RequestMapping("/singleEquip")
	public String selectSingleEquip(){
		Integer gid = Integer.parseInt(request.getParameter("id"));
		List<SingleEquip> singleEquip=singleEquipService.getSingleEquip(gid);
		JSONArray jsonArray=new JSONArray();
		for(SingleEquip e:singleEquip){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", e.getId());
			jsonObject.put("eid", e.getEid());
			jsonObject.put("ename", e.getEname());
			jsonObject.put("kn", e.getKn());
			jsonObject.put("max_mohou", e.getMax_mohou());
			jsonObject.put("min_mohou", e.getMin_mohou());
			jsonObject.put("ejection_stroke", e.getEjection_stroke());
			jsonObject.put("ejection_pressure", e.getEjection_pressure());
			jsonObject.put("picture", e.getPicture());
			jsonArray.add(jsonObject);
		}
		request.setAttribute("singleEquipList", jsonArray);
		return "singleEquip";
	}
	/*public String selectSingleEquip(){
		Integer gid=Integer.parseInt(request.getParameter("id"));
		SingleEquip singleEquip=singleEquipService.getSingleEquip(gid);
		SingleEquip s=singleEquip;
		Map<String, Object> jsonObject=new HashMap<String,Object>();
		jsonObject.put("id", s.getId());
		jsonObject.put("eid", s.getEid());
		jsonObject.put("ename", s.getEname());
		jsonObject.put("kn", s.getKn());
		jsonObject.put("max_mohou", s.getMax_mohou());
		jsonObject.put("min_mohou", s.getMin_mohou());
		jsonObject.put("ejection_stroke", s.getEjection_stroke());
		jsonObject.put("ejection_pressure", s.getEjection_pressure());
		jsonObject.put("picture", s.getPicture());
		
		request.setAttribute("singleEquipList", jsonObject);
		return "singleEquip";
	}*/
}
