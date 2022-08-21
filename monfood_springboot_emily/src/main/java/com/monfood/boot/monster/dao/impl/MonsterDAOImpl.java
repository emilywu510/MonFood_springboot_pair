package com.monfood.boot.monster.dao.impl;

import java.sql.SQLException;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.monfood.boot.monster.MonsterVO;
import com.monfood.boot.monster.dao.MonsterDAO;

@Repository
public class MonsterDAOImpl implements MonsterDAO {
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return this.session;
	}
	
	@Override
	public MonsterVO update(MonsterVO monsterVO) throws SQLException {
		
		final Integer monsLevel = monsterVO.getMonsLevel();
		
		if (monsLevel != null && monsterVO != null) {
			MonsterVO temp = this.getSession().get(MonsterVO.class, monsLevel);
			if (temp != null) {
				return (MonsterVO)this.getSession().merge(monsterVO);
			}
		}
		return null;
	}
	
	@Override
	public MonsterVO findByPrimaryKey(Integer monsLevel) throws SQLException {
		
		if (monsLevel != null) {
			return this.getSession().get(MonsterVO.class, monsLevel);
		}
		return null;
	}

}
