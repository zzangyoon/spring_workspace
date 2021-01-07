package com.koreait.fashionshop.model.payment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;

@Repository
public class MybatisCartDAO implements CartDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll(int member_id) {
		return sqlSessionTemplate.selectList("Cart.selectAll", member_id);
	}

	@Override
	public Cart select(int cart_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void duplicateCheck(Cart cart) throws CartException{
		List list = sqlSessionTemplate.selectList("Cart.duplicateCheck", cart);	//결과값이 1이라도 있으면 중복이 있다는 얘기!
		if(list.size()>0) {	//이미 담겨진 상품이 있다는 의미
			throw new CartException("장바구니에 이미 담겨진 상품입니다");
		}
	}

	@Override
	public void insert(Cart cart) throws CartException{
		int result = sqlSessionTemplate.insert("Cart.insert", cart);
		if(result==0) {
			throw new CartException("장바구니에 담지 못했습니다");
		}
	}

	@Override
	public void update(Cart cart) throws CartException{
		int result = sqlSessionTemplate.update("Cart.update", cart);
		if(result==0) {
			throw new CartException("장바구니 수정 실패");
		}
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Member member) throws CartException{
		int result = sqlSessionTemplate.delete("Cart.delete", member.getMember_id());
		if(result==0) {
			throw new CartException("장바구니 삭제 실패");
		}
		
	}

}
