package com.monfood.boot.pairlist.service;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.monfood.boot.pairlist.UserVO;

@SpringBootTest
public class PairListServiceTests {

	@Autowired
	private PairListService pairListService;
	
	
//	//ok
//	@Test
//	@Transactional
//	public void testFindFriends() {
//		List<UserVO> result = pairListService.findFriends(2);
//		System.out.println("result = " + result);
//	}
//	
//	//ok
//	@Test
//	@Transactional
//	public void testFindPairInfo() {
//		java.util.Date date = new java.util.Date();
//		java.sql.Date today = new java.sql.Date(date.getTime());
//		List<UserVO> result = pairListService.findPairInfo(3,today);
//		System.out.println("result2 = " + result);
//	}
	
	@Test
	@Transactional
	public void testMatch() {
		pairListService.match();
	}

}
