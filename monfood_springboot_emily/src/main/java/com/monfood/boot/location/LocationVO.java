package com.monfood.boot.location;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION")
//@NamedQueries(
//		value = {
//				@NamedQuery(name = "model.LocationVO.all", query = "FROM LocationVO")
//		}
//)
public class LocationVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "LOCATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;
	
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "DEFAULT_STATUS", nullable = true)
	private Integer defaultStatus;

	public LocationVO() {
	}
	
	public LocationVO(Integer locationId, Integer userId, String location, Integer defaultStatus) {
		super();
		this.locationId = locationId;
		this.userId = userId;
		this.location = location;
		this.defaultStatus = defaultStatus;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(Integer defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	
}
