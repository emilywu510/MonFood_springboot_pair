package com.monfood.boot.pairlist.service.impl;

import static java.util.stream.Collectors.toList;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monfood.boot.pairlist.PairListVO;
import com.monfood.boot.pairlist.UserVO;
import com.monfood.boot.pairlist.dao.PairListDAO;
import com.monfood.boot.pairlist.dao.UserDAO;
import com.monfood.boot.pairlist.service.PairListService;

@Service
@Transactional
public class PairListServiceImpl implements PairListService {

	@Autowired
	private PairListDAO pairListDAO;
	@Autowired
	private UserDAO userDao;


	// 取好友名單ID並取出資料
	public List<UserVO> findFriends(Integer useraId) {
		// 要拿到的list
		List<UserVO> listUserVO = new ArrayList<UserVO>();
		UserVO userVO = null;
		List<PairListVO> list = pairListDAO.selectByIdAndStatus(useraId);
		for (Object a : list) {			
			// 取出所有好友id的會員資料
			userVO = userDao.selectByUserId((Integer) a);
			// 資料放進list
			listUserVO.add(userVO);
		}

		return listUserVO;

	}


	// 取得當日配對者ID並取出資料
	public List<UserVO> findPairInfo(Integer useraId, java.sql.Date pairedDate) {
		List<UserVO> listUserVO = new ArrayList<UserVO>();
		UserVO userVO = null;
		Integer a = pairListDAO.selectByIdAndPairedDate(useraId, pairedDate);
		userVO = userDao.selectByUserId(a);
		listUserVO.add(userVO);
		return listUserVO;
	}



	// 更新會員答案及狀態
//	public boolean updateAnswerAndStatus(PairListVO pairListVO) {
//		// 雙向查找useraId及userbId欄位，並修改答案
//		pairListDAO.updateUseraAnswer(pairListVO);
//		pairListDAO.updateUserbAnswer(pairListVO);
//		// 如果兩者結果皆為1，將狀態改為1
//		pairListDAO.updateStatus(pairListVO);
//		return true;
//	}
	
	
	public void match() {
		// 取得所有會員ID
		List<Integer> listUserVO = userDao.getAllUserId();
		ArrayList<Integer> user = new ArrayList<>();
		for (Integer userVO1 : listUserVO) {
			int userId = userVO1;
			// 將結果放進user集合中，user集合為所有會員ID的集合
			user.add(userId);
		}
		System.out.println("所有會員ID" + user);

//		user[0]為準備要被配對的使用者ID 
		
		while (user.size() > 1) {
			
	//firstUser準備要配對的使用者集合
		ArrayList<Integer> firstUser = new ArrayList<>();
		firstUser.add(user.get(0));
		System.out.println("要被配對的A會員" + firstUser);
		
//		檢查pairList裡userid = user[0] (代表已經配對過) ，並個別放入集合內
//		pairedId及pairedId2集合
		List pairedIdVo = pairListDAO.selectById(user.get(0));
		ArrayList<Integer> pairedId = new ArrayList<>();
		for(Object id: pairedIdVo) {
			pairedId.add((Integer) id);
		}

		List pairedId2Vo = pairListDAO.selectById2(user.get(0));
		ArrayList<Integer> pairedId2 = new ArrayList<>();
		for(Object id: pairedId2Vo) {
			pairedId2.add((Integer) id);
		}
			
		// 取得pairedId及pairedId2聯集
		// pairedAll為所有已與user[0]配對過的會員名單
		List pairedAll = pairedId.parallelStream().collect(toList());
		List pairedAll2 = pairedId2.parallelStream().collect(toList());
		pairedAll.addAll(pairedAll2);

		System.out.println("已與A會員配對過的會員"+pairedAll);

		//取得user與pairedAll的差集
		List<Integer> reduce = user.stream().filter(item -> !pairedAll.contains(item)).collect(Collectors.toList());
        
        //再扣掉user[0]自己，差集結果為可放進user_b_id欄位的配對者(availblePaired)
        List<Integer> availblePaired = reduce.stream().filter(item -> !firstUser.contains(item)).collect(Collectors.toList());
        System.out.println("可與A會員配對的配對名單"+availblePaired);
        
        //toPairb為被配對到的B會員集合
		ArrayList<Integer> toPairb = new ArrayList<>();
		toPairb.add(availblePaired.get(0));
		System.out.println("被配對到的B會員" + toPairb);
        
        //幫user[0]與availblePaired[0]配對，並加入配對日期
        PairListVO vo = new PairListVO();
        vo.setPairId(1);
		vo.setUseraId(user.get(0));
		vo.setUserbId(availblePaired.get(0));
		java.util.Date today = new java.util.Date();
		java.sql.Date pairedDate = new java.sql.Date(today.getTime());
		vo.setPairedDate(pairedDate);
		boolean result = pairListDAO.insert(vo);
		System.out.println("result=" + result);
		

     
//        從user集合裡將配對好的刪除
        
        //paired為配對好的userID聯集
		List paired = firstUser.parallelStream().collect(toList());
		List pairedb = toPairb.parallelStream().collect(toList());
		paired.addAll(pairedb);

		System.out.println("配對好的userID聯集"+paired);
		
		//將已將配對好的刪除
         user = (ArrayList<Integer>) user.stream().filter(item -> !paired.contains(item)).collect(Collectors.toList());
         System.out.println("當日未被配對過的會員" + user);
					         
         	         
         
		}
		System.out.println("觸發!");

	}
	



	


}
