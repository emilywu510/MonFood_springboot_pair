package com.monfood.boot.pairlist.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monfood.boot.pairlist.UserVO;
import com.monfood.boot.pairlist.service.PairListService;

@RestController
public class PairListController {
	
	@Autowired
	private PairListService pairListService;
	
	// http://localhost:8080/monfood_springboot/FriendInfo>>ok 還沒測前端[to be continue]
	@GetMapping("/FriendInfo")
	public List<UserVO> FriendInfo(HttpSession session) {
//		Integer useraId = (Integer) session.getAttribute("userID");
		Integer useraId = 2;
		List<UserVO> friendInfo = pairListService.findFriends(useraId);
		return friendInfo;
	}
	
	// http://localhost:8080/monfood_springboot/PairInfo>> ok 還沒測前端[to be continue]
	@GetMapping("/PairInfo")
	public List<UserVO> PairInfo(HttpSession session) {
//		Integer useraId = (Integer) session.getAttribute("userID");
		Integer useraId = 2;
		java.util.Date date = new java.util.Date();
		java.sql.Date today = new java.sql.Date(date.getTime());
		List<UserVO> pairInfo = pairListService.findPairInfo(useraId, today);
		return pairInfo;
	}

}
