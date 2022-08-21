package com.monfood.boot.pairlist.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.monfood.boot.pairlist.PairListVO;

public interface PairListDAO {

	boolean insert(PairListVO pairListVO);
	boolean updateUseraAnswer(PairListVO pairListVO);
	boolean updateUserbAnswer(PairListVO pairListVO);
	boolean updateStatus(PairListVO pairListVO);
	List selectByIdAndStatus(Integer useraId) ;
	List selectById(Integer useraId);
	List<PairListVO> selectById2(Integer useraId);
	Integer selectByIdAndPairedDate(Integer useraId, java.sql.Date pairedDate );



}
