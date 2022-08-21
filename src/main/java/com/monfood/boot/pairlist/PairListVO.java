package com.monfood.boot.pairlist;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="PAIR_LIST")
public class PairListVO {
	
	@Id
	@Column(name="PAIR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pairId;
	
	@Column(name="USER_A_ID")
	private Integer useraId;
	
	@Column(name="USER_B_ID")
	private Integer userbId;
	
//為何要設定columnDefinition = "BIT"才可!!!!!
	@Column(name="USER_A_ANSWER",columnDefinition = "BIT")
	private Integer useraAnswer;
	

	@Column(name="USER_B_ANSWER",columnDefinition = "BIT")
	private Integer userbAnswer;
	
	@Column(name="STATUS")
	private Integer status;
	
	@Column(name="PAIRED_DATE")
	private java.sql.Date pairedDate;

	public PairListVO() {

	}
	
	
	
	public PairListVO(Integer pairId, Integer useraId, Integer userbId, Integer useraAnswer, Integer userbAnswer,
			Integer status, Date pairedDate) {
		super();
		this.pairId = pairId;
		this.useraId = useraId;
		this.userbId = userbId;
		this.useraAnswer = useraAnswer;
		this.userbAnswer = userbAnswer;
		this.status = status;
		this.pairedDate = pairedDate;
	}

	


	public Integer getPairId() {
		return pairId;
	}



	public void setPairId(Integer pairId) {
		this.pairId = pairId;
	}



	public Integer getUseraId() {
		return useraId;
	}



	public void setUseraId(Integer useraId) {
		this.useraId = useraId;
	}



	public Integer getUserbId() {
		return userbId;
	}



	public void setUserbId(Integer userbId) {
		this.userbId = userbId;
	}



	public Integer getUseraAnswer() {
		return useraAnswer;
	}



	public void setUseraAnswer(Integer useraAnswer) {
		this.useraAnswer = useraAnswer;
	}



	public Integer getUserbAnswer() {
		return userbAnswer;
	}



	public void setUserbAnswer(Integer userbAnswer) {
		this.userbAnswer = userbAnswer;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public java.sql.Date getPairedDate() {
		return pairedDate;
	}



	public void setPairedDate(java.sql.Date pairedDate) {
		this.pairedDate = pairedDate;
	}



	@Override
	public String toString() {
		return "PairListVo [pairId=" + pairId + ", useraId=" + useraId + ", userbId=" + userbId + ", useraAnswer="
				+ useraAnswer + ", userbAnswer=" + userbAnswer + ", status=" + status + ", pairedDate=" + pairedDate
				+ "]";
	}

	
}
