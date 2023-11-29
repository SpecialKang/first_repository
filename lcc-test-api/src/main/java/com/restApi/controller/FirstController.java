package com.restApi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.service.FirstService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/first")
public class FirstController {

	
	private final FirstService firstService;
	
	@GetMapping("/postTest")
	public Map<String, Object> postTest() {
		return firstService.getFirstData();
	}
	
	/*
	@PostMapping("/test")
	private Map<String, Object> getPostTest(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		responseMap = null;//agentBotService.getTalkAnswer(requestMap);
		
		return responseMap;
	}*/
	
}
