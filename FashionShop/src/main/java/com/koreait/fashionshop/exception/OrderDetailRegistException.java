package com.koreait.fashionshop.exception;

public class OrderDetailRegistException extends RuntimeException{

	public OrderDetailRegistException(String msg) {
		super(msg);
	}
	public OrderDetailRegistException(String msg, Throwable e) {
		super(msg, e);
	}
}

