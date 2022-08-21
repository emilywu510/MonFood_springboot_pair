package com.monfood.boot.pairlist.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.monfood.boot.pairlist.PairListVO;

@SpringBootTest
public class PairListDAOTests {
	
	@Autowired
	private PairListDAO pairListDAO;
	
	
//	//ok
//	@Test
//	public void testInsert(){
//		PairListVO pairListVO = new PairListVO();
//		pairListVO.setPairId(1);
//		pairListVO.setUseraId(3);
//		pairListVO.setUserbId(2);
//		java.util.Date today = new java.util.Date();
//		java.sql.Date pairedDate = new java.sql.Date(today.getTime());
//		pairListVO.setPairedDate(pairedDate);	
//		boolean result = pairListDAO.insert(pairListVO);
//		System.out.println("insert=" + result);
//	}
	
	//[to be revised]
	@Test
	public void testUpdateUseraAnswer() {
		PairListVO update = new PairListVO();
		update.setUseraAnswer(1);
		update.setUseraId(3);
		java.util.Date date = new java.util.Date();
		java.sql.Date today = new java.sql.Date(date.getTime());
		update.setPairedDate(today);
		boolean result =  pairListDAO.updateUseraAnswer(update);
		System.out.println("update=" + result);
	}

	
//	//ok
//	@Test
//	public void testSelectByIdAndStatus() {
//		List<PairListVO> select = pairListDAO.selectByIdAndStatus(2);
//		System.out.println("select = "+select);
//	}
//	
//	//ok
//	@Test
//	public void testSelectById() {
//		List select = pairListDAO.selectById(2);
//		System.out.println("select2=" + select);
//		
//	}
//	
//	//ok
//	@Test
//	public void testSelectById2() {
//		List select = pairListDAO.selectById2(2);
//		System.out.println("select3=" + select);
//		
//	}
//	
//	//ok
//	@Test
//	public void testSelectByIdAndPairedDate() {
//		java.util.Date date = new java.util.Date();
//		java.sql.Date today = new java.sql.Date(date.getTime());
//		Integer select = pairListDAO.selectByIdAndPairedDate(3,today);
//		System.out.println("select4 = "+select);
//	}
//	
}
