package com.koreait.mylegacy.controller.emp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.mylegacy.model.domain.Dept;
import com.koreait.mylegacy.model.domain.Emp;
import com.koreait.mylegacy.model.service.JdbcEmpService;
import com.koreait.mylegacy.model.service.MybatisEmpService;

//component-scan의 대상이 되려면 어노테이션을 지정해야 한다
@Controller
public class EmpController {
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);	//memo28
	
	/* memo18. Service로 옮기기!
	//4.
	@Autowired
	private JdbcDeptDAO jdbcDeptDAO;
	
	//6.
	@Autowired
	private JdbcEmpDAO jdbcEmpDAO;
	*/
	
	//memo22
	@Autowired
	private JdbcEmpService empService;
	
	//memo41
	@Autowired
	private MybatisEmpService mybatisEmpService;
	
	//2. 사원등록 폼요청
	@RequestMapping("/emp/registform")
	public String registForm() {
		//저장할 것이 없고, 그냥 뷰만 반환하고 싶을때는 String도 가능
		return "emp/regist_form";	//(/WEB-INF/views/emp/regist_form.jsp)
	}
	
	//1. 사원등록 요청을 처리하는 메서드
	@RequestMapping(value="/emp/regist", method=RequestMethod.POST)
	public String regist(Dept dept, Emp emp) {
		//System.out.println("등록 원해?");
		/*
		//3. 파라미터 받아와 출력해보기
		System.out.println(dept.getDeptno());
		System.out.println(dept.getDname());
		System.out.println(dept.getLoc());
		
		System.out.println(emp.getEmpno());
		System.out.println(emp.getEname());
		System.out.println(emp.getSal());
		//System.out.println(emp.getDept().getDeptno());
		*/
		
		//로거 사용해보기! memo29
		//log4j라는 라이브러리는 우리가 개발시 디버그목적으로 사용하는 콘솔 출력보다도 훨씬 다양하며
		//복잡한 기능을 지원하는 로그 라이브러리이다
		//특히 출력 로그 레벨이라는 기능을 둬서, 개발자가 원하는 레벨을 선택하여 출력을 제어할 수 있도록 지원해준다 
		//All(모든로깅) < DEBUG(확인) < INFO(강조) < WARN(경고) < ERROR(오류) < FATAL(심각한 오류) < OFF(로깅 해제)
		
		//만약에 info 수준으로 세팅한다면 debug로 세팅된것은 안찍힌다
		logger.debug(""+dept.getDeptno());
		logger.debug(dept.getDname());
		logger.debug(dept.getLoc());
		
		logger.info(""+emp.getEmpno());
		logger.debug(emp.getEname());
		logger.debug(""+emp.getSal());
		//System.out.println(emp.getDept().getDeptno());
		
		//System.out.println("jdbcDeptDAO는 "+jdbcDeptDAO);	//memo12
		
		/*
		//5. DB에 등록!
		//부서등록과 사원등록이라는 두개의 업무가 모두 성공되어야, 전체를 성공으로 간주하는 트랜잭션 상황!!!
		int result = jdbcDeptDAO.regist(dept);
		System.out.println("result : "+result);
		//7
		int result2 = jdbcEmpDAO.regist(emp);
		System.out.println("result2 : "+result2);
		*/
		
		//서비스에게 사원등록 요청 (memo23)
		emp.setDept(dept);	//emp와 부서를 합체!
		
		int result = mybatisEmpService.regist(emp);
		//System.out.println("등록결과 "+result);
		logger.debug("등록결과 "+result);
		
		return "redirect:/emp/list";
	}
	
	//사원목록 (memo31)
	@RequestMapping(value="/emp/list", method=RequestMethod.GET)
	public ModelAndView selectAll() {
		ModelAndView mav = new ModelAndView();
		
		//3단계 일시킨다(memo 34)
		//List empList = empService.selectAll();
		List empList = mybatisEmpService.selectAll();	//memo41. 이것만 바꾸면 됨!!!
		
		//4단계 : 저장
		mav.addObject("empList", empList);
		mav.setViewName("emp/list");
		
		return mav;
	}
}










