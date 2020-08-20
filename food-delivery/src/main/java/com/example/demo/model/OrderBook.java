package com.example.demo.model;

import java.util.List;

public class OrderBook {
	
	private String message;
	private Integer billAmount;
	private List<Food> foods;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}
	public List<Food> getFoods() {
		return foods;
	}
	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billAmount == null) ? 0 : billAmount.hashCode());
		result = prime * result + ((foods == null) ? 0 : foods.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderBook other = (OrderBook) obj;
		if (billAmount == null) {
			if (other.billAmount != null)
				return false;
		} else if (!billAmount.equals(other.billAmount))
			return false;
		if (foods == null) {
			if (other.foods != null)
				return false;
		} else if (!foods.equals(other.foods))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("OrderBook [message=%s, billAmount=%s, foods=%s]", message, billAmount, foods);
	}
	
	

}
