package com.koreait.fashionshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	//관리자모드 메인 요청
	@RequestMapping("/admin")
	public String adminMain() {
		return "admin/main";
	}
}
