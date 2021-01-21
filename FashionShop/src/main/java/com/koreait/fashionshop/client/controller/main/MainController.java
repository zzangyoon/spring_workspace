package com.koreait.fashionshop.client.controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.model.product.service.TopCategoryService;

@Controller
public class MainController {
	@Autowired
	private TopCategoryService topCategoryService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, String name) {
		ModelAndView mav = new ModelAndView();
		
		//List topList = topCategoryService.selectAll();	//카테고리 가져오기
		//mav.addObject("topList", topList);	//GlobalDataAspect에서 한번에 해준다!
		mav.setViewName("index");	// 메인페이지
		
		return mav;
	}
}
