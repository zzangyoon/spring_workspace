package com.koreait.fashionshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.ProductRegistException;
import com.koreait.fashionshop.model.domain.Product;

@Repository
public class MybatisProductDAO implements ProductDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Product.selectAll");
	}

	@Override
	public List selectById(int subcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product select(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Product product) throws ProductRegistException{
		int result = sqlSessionTemplate.insert("Product.insert", product);
		if(result==0) {
			throw new ProductRegistException("상품테이블에 입력실패");
		}
	}

	@Override
	public void update(Product product) throws ProductRegistException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) throws ProductRegistException{
		// TODO Auto-generated method stub
		
	}

}
