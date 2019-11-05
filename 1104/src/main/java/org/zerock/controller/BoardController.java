package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardMapper boardMapper;
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	@GetMapping("/list")
	public void getList(@RequestParam(defaultValue = "1") int page, Model model) {
		
		List<BoardVO> list = boardMapper.selectList((page-1)*10);
		
		model.addAttribute("list", list);
		
	}
	
}
