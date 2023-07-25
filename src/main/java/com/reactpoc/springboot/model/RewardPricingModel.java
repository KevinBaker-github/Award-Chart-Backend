package com.reactpoc.springboot.model;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RewardPricingChart")
public class RewardPricingModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String category;
	
	@Column
	private String roomCategory;
	
	@Column
	private String pricingLevel;
	
	@Column
	private String points;
	
	@UpdateTimestamp
	@Column(name="updateDatetime", nullable=false)
	private Date updateDatetime;
	
	@Column(name = "updateUser")
	private String updateUser;
	
	public RewardPricingModel() {
		
	}

	public RewardPricingModel(String category, String roomCategory, String pricingLevel, String points,
			Date updateDatetime, String updateUser) {
		super();
		this.category = category;
		this.roomCategory = roomCategory;
		this.pricingLevel = pricingLevel;
		this.points = points;
		this.updateDatetime = updateDatetime;
		this.updateUser = updateUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	
}
