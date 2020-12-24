package com.springmvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;

public class ListController implements Controller{
	//DI란 외부에서 객체의 인스턴스를 주입받는 방법 (주입을 받으려면, setter or 생성자를 준비해야함)
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계 : 로직 객체에 일시킨다
		List boardList = boardDAO.selectAll();
		
		System.out.println("게시물 수"+boardList.size());
		
		//4단계 : 결과 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("board/list");	//(/board/list.jsp 에서 '/' 까지를 접두어로! '.jsp'를 접미어로!)
		//dispatcher-servlet.xml 으로 가서 매핑해주기! props /bean
		
		return mav;
	}

}
