package com.monfood.boot.location.dao;

import java.util.List;

import com.monfood.boot.location.LocationVO;

public interface LocationDAO {
	
	public boolean insert(LocationVO locationVO);
	public List<LocationVO> findByPrimaryKey(Integer userId);
	    
}