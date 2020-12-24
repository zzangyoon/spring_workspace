package com.springmvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;

public class ListController implements Controller{
	//DI�� �ܺο��� ��ü�� �ν��Ͻ��� ���Թ޴� ��� (������ ��������, setter or �����ڸ� �غ��ؾ���)
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3�ܰ� : ���� ��ü�� �Ͻ�Ų��
		List boardList = boardDAO.selectAll();
		
		System.out.println("�Խù� ��"+boardList.size());
		
		//4�ܰ� : ��� ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("board/list");	//(/board/list.jsp ���� '/' ������ ���ξ��! '.jsp'�� ���̾��!)
		//dispatcher-servlet.xml ���� ���� �������ֱ�! props /bean
		
		return mav;
	}

}
