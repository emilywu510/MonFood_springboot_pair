package com.monfood.boot.pairlist.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.monfood.boot.location.LocationVO;
import com.monfood.boot.pairlist.PairListVO;
import com.monfood.boot.pairlist.UserVO;
import com.monfood.boot.pairlist.dao.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}


//	// 使用會員編號查詢一筆資料
//	private static final String SELECTBYUSERID = "SELECT * FROM MonFood.USER WHERE USER_ID = ? ";
//	
//	// 查詢全部會員編號
//	private static final String DETALLUSERID = "SELECT USER_ID FROM MonFood.USER ORDER BY USER_ID";
	


	@Override
	public UserVO selectByUserId(Integer userId){

		
			if(userId!=null) {
				return this.getSession().get(UserVO.class, userId);
			}
			return null;



	}

	
	@Override
	public List getAllUserId(){
		String hql = "select userId from UserVO order by userId";
		return getSession().createQuery(hql, Integer.class)
				.list();
	}
	


	
}
