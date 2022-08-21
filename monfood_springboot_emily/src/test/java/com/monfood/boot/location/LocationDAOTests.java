package com.monfood.boot.location;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.monfood.boot.location.dao.LocationDAO;

@SpringBootTest
public class LocationDAOTests {
	
	@Autowired
	private LocationDAO locationDAO;
	
	@Test
	public void testInsert(){
		LocationVO locationVO = new LocationVO();
		locationVO.setUserId(6);
		locationVO.setLocation("test");
		boolean result = locationDAO.insert(locationVO);
		System.out.println(result);
	}
	
	@Test
	public void testFindByPrimaryKey(){
		List<LocationVO> result = locationDAO.findByPrimaryKey(6);
		System.out.println(result);
	}
}
