package com.rewardpricing.chart.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "RewardPricingChart")
public class RewardPricingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(updatable = false)
	private String category;
	
	@Column(updatable = false)
	private String roomCategory;
	
	@Column(updatable = false)
	private String pricingLevel;
	
	@Column
	private String points;
	
	@UpdateTimestamp
	@Column(name="updateDatetime", nullable=false)
	private Date updateDatetime;
	
	@Column(name = "updateUser")
	private String updateUser;
	
	public RewardPricingEntity() {
		
	}

	public RewardPricingEntity(String category, String roomCategory, String pricingLevel, String points,
			Date updateDatetime, String updateUser) {
		super();
		this.category = category;
		this.roomCategory = roomCategory;
		this.pricingLevel = pricingLevel;
		this.points = points;
		this.updateDatetime = updateDatetime;
		this.updateUser = updateUser;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public String getPricingLevel() {
		return pricingLevel;
	}

	public void setPricingLevel(String pricingLevel) {
		this.pricingLevel = pricingLevel;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

//	@Override
//	public String toString() {
//		return "points=" + points;
//	}

	
}
