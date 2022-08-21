package com.monfood.boot.pairlist.dao;

import java.util.List;

import com.monfood.boot.pairlist.UserVO;

public interface UserDAO {
	public UserVO selectByUserId(Integer userId);
	List getAllUserId(); 
}
