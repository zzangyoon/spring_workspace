package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.domain.OrderDetail;
import com.koreait.fashionshop.model.domain.OrderSummary;
import com.koreait.fashionshop.model.domain.Receiver;

public interface PaymentService {
	//장바구니 관련 업무
	public List selectCartList();	//회원 구분없이 모든 데이터 가져오기
	public List selectCartList(int member_id);	//특정 회원의 장바구니 내역
	public Cart selectCart(int cart_id);
	public void insert(Cart cart);
	public void update(List<Cart> cartList);	//일괄 수정
	public void delete(Cart cart);	//pk에 속한 데이터 삭제할 예정
	public void delete(Member member);	//회원에 속한 데이터 삭제할 예정
	
	//결제 업무
	public List selectPaymethodList();
	public void registOrder(OrderSummary orderSummary, Receiver receiver);	//트랜잭션 처리가 요구되는 메서드
}
