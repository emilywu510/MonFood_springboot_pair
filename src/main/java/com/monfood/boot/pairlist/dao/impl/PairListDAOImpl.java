package com.monfood.boot.pairlist.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.monfood.boot.pairlist.PairListVO;
import com.monfood.boot.pairlist.dao.PairListDAO;




@Repository
public class PairListDAOImpl implements PairListDAO {

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}
	
	// 將名單放進PairList
	// INSERT INTO `MonFood`.`PAIR_LIST` ( `USER_A_ID`, `USER_B_ID`,`PAIRED_DATE` ) VALUES ( ?, ?, ?);
	@Override
	public boolean insert(PairListVO pairListVO) {
		if (pairListVO != null && pairListVO.getPairId() != null) {
			PairListVO temp = this.getSession().get(PairListVO.class, pairListVO.getPairId());
			if (temp == null) {
				Serializable pk = this.getSession().save(pairListVO);
				return true ;
			}
		}
		return false ;
	}

	// 更新A會員答案
		// update PAIR_LIST set USER_A_ANSWER = ? where USER_A_ID = ? and PAIRED_DATE = ?;
		//where第一個?為A會員ID，後面日期?為當天日期
	@Override
		public boolean updateUseraAnswer(PairListVO pairListVO) {
			String hql = "update PairListVO set useraAnswer = :useraAnswer where useraId = :useraId and pairedDate = :pairedDate";
			getSession().createQuery(hql)
					.setParameter("useraAnswer", pairListVO.getUseraAnswer())
					.setParameter("useraId", pairListVO.getUseraId())
					.setParameter("pairedDate", pairListVO.getPairedDate())
					.executeUpdate();
			return true;		
		}
	

		
		// 更新B會員答案
		// update PAIR_LIST set USER_B_ANSWER = ? where USER_B_ID = ? and PAIRED_DATE = ?;
		//where第一個?為A會員ID，後面日期?為當天日期
	@Override
		public boolean updateUserbAnswer(PairListVO pairListVO) {
			String hql = "update PairListVO set userbAnswer = :userbAnswer where userbId = :userbId and pairedDate = :pairedDate";
			getSession().createQuery(hql)
					.setParameter("userbAnswer", pairListVO.getUserbAnswer())
					.setParameter("userbId", pairListVO.getUserbId())
					.setParameter("pairedDate", pairListVO.getPairedDate())
					.executeUpdate();
			return true;	
		}
		
		// 更改好友狀態>雙方接受配對成為好友
		// update PAIR_LIST set STATUS = 1 where USER_A_ANSWER = 1 and USER_B_ANSWER =1;
	@Override
		public boolean updateStatus(PairListVO pairListVO) {
			String hql = "update PairListVO set status = :status where useraAnswer = :useraAnswer and userbAnswer = :userbAnswer";
			getSession().createQuery(hql)
					.setParameter("status", 1)
					.setParameter("useraAnswer",1)
					.setParameter("userbAnswer",1)
					.executeUpdate();
			return true;	
			
		}
	
	
	
	// 查找A會員好友 ?為A會員ID > 查詢結果為B會員ID 
//	select USER_B_ID from PAIR_LIST where USER_A_ID = ? and STATUS = 1
//	union
//	select USER_A_ID from PAIR_LIST where USER_B_ID = ? and STATUS = 1;
	
	@SuppressWarnings("unchecked")
	@Override
	public List selectByIdAndStatus(Integer useraId) {
		String sql = "select USER_B_ID from Pair_List where USER_A_ID = :useraId and STATUS = :status "
				+ "union "
				+ "select USER_A_ID from Pair_List where USER_B_ID = :userbId and STATUS = :status";
		return getSession().createSQLQuery(sql)
				.setParameter("useraId",useraId)
				.setParameter("status", 1)
				.setParameter("userbId",useraId)
				.list();
	}
	
	//尋找A會員是否已被配對過 (雙向)  ( ?為A會員ID) 
//	select USER_A_ID from PAIR_LIST where USER_B_ID = ?
	@Override
	public List selectById(Integer useraId){
		String hql = "select useraId from PairListVO where userbId = :userbId ";
		List temp  =  getSession().createQuery(hql,Integer.class)
				.setParameter("userbId", useraId)
				.list();
		return temp;
	}
	
	
	//尋找A會員是否已被配對過 (雙向2)  ( ?為A會員ID) 
//	select USER_B_ID from PAIR_LIST where USER_A_ID = ?
	@SuppressWarnings("unchecked")
	@Override
	public List selectById2(Integer useraId) {
		String hql = "select userbId from PairListVO where useraId = :useraId ";
		return getSession().createQuery(hql,Integer.class)
				.setParameter("useraId", useraId)
				.list();
	}
	
	//尋找當日配對者 (修正型別>方法型別要改[to be revised])
	//前面?為A會員ID，後面日期?為當天日期
//	select USER_B_ID from PAIR_LIST where USER_A_ID = ? and PAIRED_DATE = ?
//	union
//	select USER_A_ID from PAIR_LIST where USER_B_ID = ? and PAIRED_DATE = ?;
	@Override
	public Integer selectByIdAndPairedDate(Integer useraId, java.sql.Date pairedDate ) {
		String sql = "select USER_B_ID from PAIR_LIST where USER_A_ID = :useraId and PAIRED_DATE = :pairedDate "
				+ "union "
				+ "select USER_A_ID from PAIR_LIST where USER_B_ID = :userbId and PAIRED_DATE = :pairedDate";
		return (Integer) getSession().createSQLQuery(sql)
				.setParameter("useraId",useraId)
				.setParameter("pairedDate", pairedDate)
				.setParameter("userbId",useraId)
				.uniqueResult();
		
	}



	// 測試
//	public static void main(String[] args) {
//		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
//
//		Session session = sessionFactory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
//
//		PairListDao dao = new PairListDaoImpl(sessionFactory);

//		// insert
//		PairListVo insert = new PairListVo();
//		insert.setPairId(1);
//		insert.setUseraId(3);
//		insert.setUserbId(2);
//		java.util.Date today = new java.util.Date();
//		java.sql.Date pairedDate = new java.sql.Date(today.getTime());
//		insert.setPairedDate(pairedDate);
//		dao.insert(insert);
//		System.out.println("insert= " + insert);
		
		//updateUseraAnswer
//		PairListVo update = new PairListVo();
//		update.setUseraAnswer(1);
//		update.setUseraId(5);
//		java.util.Date date = new java.util.Date();
//		java.sql.Date today = new java.sql.Date(date.getTime());
//		update.setPairedDate(today);
//		dao.updateUseraAnswer(update);
//		System.out.println("update=" + update);
		
		//updateUserbAnswer
//		PairListVo update = new PairListVo();
//		update.setUserbAnswer(1);
//		update.setUserbId(2);
//		java.util.Date date = new java.util.Date();
//		java.sql.Date today = new java.sql.Date(date.getTime());
//		update.setPairedDate(today);
//		dao.updateUserbAnswer(update);
//		System.out.println("update=" + update);
		
		
		//updateStatus
//		PairListVo update = new PairListVo();
//		dao.updateStatus(update);	
		
		// select
		// selectByIdAndStatus
//		List<PairListVo> select = dao.selectByIdAndStatus(1);
//		System.out.println("select = "+select);
		// 單個取出
//		for (Object o : select) {
//			System.out.print(o + ",");
//			}
		//selectById 
//		List<PairListVo> select = dao.selectById(1);
//		System.out.println("select = "+select);
		
		//selectById2 
//		List<PairListVo> select = dao.selectById2(1);
//		System.out.println("select = "+select);
		
		//selectByIdAndPairedDate
//		java.util.Date date = new java.util.Date();
//		java.sql.Date today = new java.sql.Date(date.getTime());
//		Integer select = dao.selectByIdAndPairedDate(3,today);
//		System.out.println("select = "+select);
//
//		transaction.commit();
//		session.close();
//		sessionFactory.close();
//
//	}
}
