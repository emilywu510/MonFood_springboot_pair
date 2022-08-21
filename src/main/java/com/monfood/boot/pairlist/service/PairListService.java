package com.monfood.boot.pairlist.service;



import java.util.List;

import com.monfood.boot.pairlist.PairListVO;
import com.monfood.boot.pairlist.UserVO;

public interface PairListService {
	
	// 取好友名單ID並取出資料
	List<UserVO> findFriends(Integer useraId);
	
	//取得當日配對者ID並取出資料
	List<UserVO> findPairInfo(Integer useraId, java.sql.Date pairedDate);
	
	//更新會員答案及狀態
//	boolean updateAnswerAndStatus(PairListVO pairListVO);
	
	void match();

	
	

}
