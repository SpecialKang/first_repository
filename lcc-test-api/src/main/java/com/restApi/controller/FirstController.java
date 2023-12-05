package com.restApi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.service.FirstService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "회원", description = "member api 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class FirstController {

	
	private final FirstService firstService;
	
	@Operation(summary = "회원 조회", description = "회원 조회 메서드입니다.")
	@GetMapping("/getTest")
	public Map<String, Object> postTest() {
		return firstService.getFirstData();
	}
	
	@Operation(summary = "회원 tset조회", description = "회원 조회 메서드입니다.")
	@Parameter(name = "requestMap", description = "Map<String, Object>")
	@PostMapping("/postTest")
	private Map<String, Object> getPostTest(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		responseMap = null;//agentBotService.getTalkAnswer(requestMap);
		
		return responseMap;
	}
	
}
