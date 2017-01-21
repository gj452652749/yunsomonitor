package com.monitor.controller;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.http.util.HttpRest;
import com.monitor.util.CoreResponseParser;
import com.monitor.util.CoreUrlGenerator;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dihStatus")
public class DohStatusController {
	@Autowired
	HttpRest httpRest;
	@ResponseBody
	@RequestMapping(value = "/status")
	public String dihStatus(String userName,String coreName,String dsName,String tbName) {
		if(StringUtils.isEmpty(tbName)) 
			return null;
		String url=CoreUrlGenerator
				.generateDihStatusUrl(userName, coreName, dsName, tbName);
		String json=httpRest.get(url);
		String status=CoreResponseParser.parseStatus(json);
		return status;
	}
}
