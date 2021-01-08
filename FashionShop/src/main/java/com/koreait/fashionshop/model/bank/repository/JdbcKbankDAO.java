package com.koreait.fashionshop.model.bank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.WithdrawFailException;
import com.koreait.fashionshop.model.common.Bell;

@Repository
public class JdbcKbankDAO implements KbankDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
		DI란? 의존성 있는 객체는 직접 생성하지 말고, 외부로부터 주입받자
		객체간 결합도를 약화시키기 위함
		그렇다면 결합도 마저도 없애버리는 방법이 있는가? 있다 > AOP
	*/
	
	@Override
	//출금 (> 출금은 update!)
	public void withdraw(int money) throws WithdrawFailException{
		//System.out.println("딩동♪");	> 음향효과 공통코드는 객체로 빼자!
		//bell.sound();
		
		int result = jdbcTemplate.update("update kbank set total = total - ?",money);	//(바인드변수 사용)
		if(result==0) {
			throw new WithdrawFailException("Sorry Withdraw fail");
		}
		
	}

}
