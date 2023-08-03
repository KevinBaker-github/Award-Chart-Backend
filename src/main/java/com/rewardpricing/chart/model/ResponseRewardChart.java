package com.rewardpricing.chart.model;

import java.util.List;

public class ResponseRewardChart {
	
	private int category;
	private List<RoomCategory> roomCategories;
	 
	public ResponseRewardChart() {
		
	}

	public ResponseRewardChart(int category, List<RoomCategory> roomCategories) {
		super();
		this.category = category;
		this.roomCategories = roomCategories;
	}
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public List<RoomCategory> getRoomCategories() {
		return roomCategories;
	}

	public void setRoomCategories(List<RoomCategory> roomCategories) {
		this.roomCategories = roomCategories;
	}
}
