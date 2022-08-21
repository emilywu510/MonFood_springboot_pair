package com.monfood.boot.location.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.monfood.boot.location.LocationVO;
import com.monfood.boot.location.dao.LocationDAO;

@Repository
public class LocationDAOimpl implements LocationDAO{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}

	@Override
	public boolean insert(LocationVO locationVO) {
		
		if (locationVO != null) {
			Serializable pk = this.getSession().save(locationVO);
			return true;
		}
		return false;
	}

	@Override
	public List<LocationVO> findByPrimaryKey(Integer userId){
		
		if (userId != null) {
			return this.getSession().createQuery("FROM LocationVO WHERE userId = :userId").setParameter("userId", userId).list();
		}
		
		return null;
	}
	
}
