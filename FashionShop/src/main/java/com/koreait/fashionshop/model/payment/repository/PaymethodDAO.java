package com.koreait.fashionshop.model.payment.repository;

import java.util.List;

public interface PaymethodDAO {
	public List selectAll();
	public void registOrder();	//여기서 많은 트랜잭션 처리가 요구됨...(주문, 주문상세, 배송정보)

}
