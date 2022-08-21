package com.monfood.boot.monster.dao;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Transactional;

import com.monfood.boot.monster.MonsterVO;

public interface MonsterDAO {
	
	@Transactional
    public MonsterVO update(MonsterVO monsterVO) throws SQLException;
    public MonsterVO findByPrimaryKey(Integer monsLevel) throws SQLException;
    
}
