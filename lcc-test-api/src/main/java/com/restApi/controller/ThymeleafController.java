package com.restApi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//value : localhost:8080/posts로 접근할 경우 이 controller에 접근한다.
//produces : 생산 가능한 미디어 타입을 지정해서 일치할 때만 요청을 매칭함. (매핑 제한용)
//comsumes : 소비 가능한 미디어 타입을 지정해서 때만 요청을 매칭함. (매핑 제한용)
//@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ThymeleafController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	/*
	//글 목록 조회
	@GetMapping(value = "/")
	public String getPostList(@RequestParam(value = "postId", required = false) Long postId, Model model){
	    List<Post> posts= postRepository.findAll();
	    model.addAttribute("posts", posts);
	    return "index";
	}
	
	
	
	@GetMapping(value = "/add-post-page")
    public String getAddPostPage(@RequestParam(value = "state", required = false, defaultValue = "create")String state,
                                 @RequestParam(value = "postId", required = false) Long postId, Model model){
        if(state.equals("update")){
            Post post = postRepository.findById(postId).get();
            model.addAttribute("post", post);
        }

        model.addAttribute("state", state);
        model.addAttribute("postId", postId);

        return "add-post-page";
    }
    
    */
}
