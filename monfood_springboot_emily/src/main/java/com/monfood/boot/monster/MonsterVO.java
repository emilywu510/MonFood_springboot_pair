package com.monfood.boot.monster;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "MONSTER")
public class MonsterVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MONS_LEVEL")
	private Integer monsLevel;
	
	@Column(name = "DISCOUNT")
	private Integer discount;
	
	@Column(name = "MONS_PIC")
	@Type(type="org.hibernate.type.ImageType")
	private byte[] monsPic;
	
	public MonsterVO() {
	}

	public MonsterVO(Integer monsLevel, Integer discount, byte[] monsPic) {
		this.monsLevel = monsLevel;
		this.discount = discount;
		this.monsPic = monsPic;
	}

	public Integer getMonsLevel() {
		return monsLevel;
	}

	public void setMonsLevel(Integer monsLevel) {
		this.monsLevel = monsLevel;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public byte[] getMonsPic() {
		return monsPic;
	}

	public void setMonsPic(byte[] monsPic) {
		this.monsPic = monsPic;
	}

	
}
