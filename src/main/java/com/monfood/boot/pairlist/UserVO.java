package com.monfood.boot.pairlist;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Entity
@Table(name="USER")
public class UserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_ACCOUNT")
	private String userAccount;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="USER_TEL")
	private String userTel;
	
	@Column(name="USER_PROFILE")
	private String userProfile;
	
	@Column(name="BIRTHDAY")
	private java.sql.Date birthday;
	
	@Column(name="CALORIES")
	private Integer calories;
	
	@Column(name="BUDGET")
	private Integer budget;
	
	@Lob
	@Type(type="org.hibernate.type.ImageType")
	@Column(name="PROFILE_PIC")
	private byte[] profilePic;
	
	@Column(name="MONS_LEVEL")
	private Integer monsLevel;
	
	@Column(name="MONS_NAME")
	private String monsName;
	
	@Column(name="USER_ACCOUNT_STATUS")
	private Integer userAccountStatus;
	
	@Column(name="UPDATE_TIME")
	private java.sql.Timestamp updateTime;
	
	public UserVO() {

	}

	public UserVO(Integer userId, String userName, String userAccount, String userPassword, String userTel,
			String userProfile, Date birthday, Integer calories, Integer budget, byte[] profilePic, Integer monsLevel,
			String monsName, Integer userAccountStatus, Timestamp updateTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userTel = userTel;
		this.userProfile = userProfile;
		this.birthday = birthday;
		this.calories = calories;
		this.budget = budget;
		this.profilePic = profilePic;
		this.monsLevel = monsLevel;
		this.monsName = monsName;
		this.userAccountStatus = userAccountStatus;
		this.updateTime = updateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public byte[] getProfilePic() {
		return profilePic;
	}


	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}

	public Integer getMonsLevel() {
		return monsLevel;
	}

	public void setMonsLevel(Integer monsLevel) {
		this.monsLevel = monsLevel;
	}

	public String getMonsName() {
		return monsName;
	}

	public void setMonsName(String monsName) {
		this.monsName = monsName;
	}

	public Integer getUserAccountStatus() {
		return userAccountStatus;
	}

	public void setUserAccountStatus(Integer userAccountStatus) {
		this.userAccountStatus = userAccountStatus;
	}

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userName=" + userName + ", userAccount=" + userAccount
				+ ", userPassword=" + userPassword + ", userTel=" + userTel + ", userProfile=" + userProfile
				+ ", birthday=" + birthday + ", calories=" + calories + ", budget=" + budget + ", profilePic="
				+ Arrays.toString(profilePic) + ", monsLevel=" + monsLevel + ", monsName=" + monsName
				+ ", userAccountStatus=" + userAccountStatus + ", updateTime=" + updateTime + "]";
	}
	


	

}
