package com.koreait.fashionshop.model.bank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.DepositFailException;
import com.koreait.fashionshop.model.common.Bell;

@Repository
public class JdbcSbankDAO implements SbankDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	//입금
	public void deposit(int money) throws DepositFailException{
		//System.out.println("딩동♪");	> 음향효과 공통코드는 객체로 빼자!
		//bell.sound();
		
		int result = jdbcTemplate.update("insert into sbank(sbank_id, total) values(seq_sbank.nextval, ?)", money);
		result=0;
		if(result==0) {
			throw new DepositFailException("Sorry Deposit fail");
		}
		
	}

}
