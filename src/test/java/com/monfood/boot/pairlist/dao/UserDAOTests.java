package com.monfood.boot.pairlist.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.monfood.boot.pairlist.UserVO;

@SpringBootTest
public class UserDAOTests {
	
	@Autowired
	private UserDAO userDAO;
	
	//ok
	@Test
	public void testSelect() {
		UserVO result = userDAO.selectByUserId(1);
		System.out.println("result=" +result);
		
	}
	
	//ok
	@Test
	public void testGetAllId() {
		List result = userDAO.getAllUserId();
		System.out.println("result2=" +  result);
	}

}
