package com.example.demo.model;

public class FilterCriteria {
	private String restaurantName;
	private String stateName;
	private String areaName;
	private Integer pinCode;
	private String rating;
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return String.format("FilterCriteria [restaurantName=%s, stateName=%s, areaName=%s, pinCode=%s, rating=%s]",
				restaurantName, stateName, areaName, pinCode, rating);
	}
	

}
