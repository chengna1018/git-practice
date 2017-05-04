package com.penghai.dataplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.penghai.dataplatform.bo.Factory;
import com.penghai.dataplatform.service.FactoryService;

/*
 * 百度地图展示工厂位置信息及详情窗口Controller
 * @author 李浩
 *
 */
@Controller
public class SelectFactorysController extends BaseController {
	@Autowired
	private FactoryService factoryService;

	@RequestMapping("/")
	public String select() {
		List<Factory> factories = factoryService.getAllfactorys();
		JSONArray jsonArray = new JSONArray();
		for (Factory f : factories) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", f.getId());
			jsonObject.put("fname", f.getFname());
			jsonObject.put("longitude", f.getLongitude());
			jsonObject.put("latitude", f.getLatitude());
			//jsonObject.put("telephone", f.getTelephone());
			jsonObject.put("address", f.getAddress());
			jsonObject.put("desc", f.getDesc());
			jsonObject.put("picture", f.getPicture());
			jsonArray.add(jsonObject);

		}
		request.setAttribute("factoryList", jsonArray);
		return "maps";
	}
}
