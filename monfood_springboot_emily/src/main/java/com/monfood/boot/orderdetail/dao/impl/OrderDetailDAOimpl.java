package com.monfood.boot.orderdetail.dao.impl;

import java.io.Serializable;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.monfood.boot.orderdetail.OrderDetailVO;
import com.monfood.boot.orderdetail.dao.OrderDetailDAO;

@Repository
public class OrderDetailDAOimpl implements OrderDetailDAO {
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return this.session;
	}
	

	@Override
	public boolean insert(OrderDetailVO orderDetailVO) {
		
		if (orderDetailVO != null) {
			OrderDetailVO temp = this.getSession().get(OrderDetailVO.class, orderDetailVO);
			if (temp == null) {
				Serializable pk = this.getSession().save(orderDetailVO);
				return true;
			}
		}
		
		return false;
	}
}
