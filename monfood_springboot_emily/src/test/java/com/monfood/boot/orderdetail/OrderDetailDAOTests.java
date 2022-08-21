package com.monfood.boot.orderdetail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.monfood.boot.orderdetail.dao.OrderDetailDAO;

@SpringBootTest
public class OrderDetailDAOTests {

	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Test
	public void testInsert() {
		OrderDetailVO orderDetailVO = new OrderDetailVO();
		orderDetailVO.setOrderId(86);
		orderDetailVO.setProductId(1);
		orderDetailVO.setAmount(1);
		orderDetailVO.setOrderedPrice(10);
		boolean result = orderDetailDAO.insert(orderDetailVO);
		System.out.println(result);
	}
	
}
