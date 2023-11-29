package com.restApi.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.restApi.service.FirstService;

@Service
public class FirstServiceImpl implements FirstService {

	@Override
	public Map<String, Object> getFirstData() {
		// TODO Auto-generated method stub
		
		Map<String, Object> firstData = new HashMap<>();
		firstData.put("label1", "check1");
		firstData.put("label2", "check2");
		firstData.put("label3", "check3");
		
		return firstData;
	}

}
