package com.springmvc.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*	�� Ŭ������ ��û�� ���������� ó���ϴ� ��Ʈ�ѷ� ���� ��� @�ּ��� �̿�!!! �ּ��� �о�鿩�� controller�� ��������
	�߱��ϴ� ��ǥ : POJO(Plain Old Java Object) ������� ������ ������ ����!
*/

public class TestController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//3�ܰ� : �˸´� ���� ��ü�� �Ͻ�Ų��
		String msg = "�ȳ�";
		
		//4�ܰ� : ������ ���� �ִٸ� request ��ü�� ����! (request�� �����ϰ������ �ִٸ� mav �ȿ� ������ �ȴ�!)
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		
		//���� ��Ʈ�ѷ��� � �������� ������������� ���� ������ ������
		mav.setViewName("test/result");	//Ű���� �ذ��̰�, ����� dispatcher-servlet��!
		return mav;
	}
	
}
