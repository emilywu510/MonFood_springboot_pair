package com.monfood.boot.monster;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.monfood.boot.monster.dao.MonsterDAO;

@SpringBootTest
class MonsterDAOTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MonsterDAO monsterDAO;
	
	@Test
	public void testFindByPrimaryKey() throws SQLException {
		MonsterVO select = monsterDAO.findByPrimaryKey(1);
		System.out.println(select.getDiscount());
	}
	
	@Test
	public void testUpdate() throws SQLException {
		MonsterVO vo = new MonsterVO();
		vo.setDiscount(11);
		vo.setMonsPic("1".getBytes());
		vo.setMonsLevel(5);
		MonsterVO result = monsterDAO.update(vo);
		System.out.println(result);
	}

}
