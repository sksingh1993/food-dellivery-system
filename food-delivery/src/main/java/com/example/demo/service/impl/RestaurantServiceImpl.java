package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FilterCriteria;
import com.example.demo.model.Food;
import com.example.demo.model.OrderBook;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.intf.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Override
	public Restaurant add(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	@Override
	public Restaurant addFoodItem(Integer id, List<Food> foods) {
		 Restaurant restaurant = restaurantRepository.findById(id).get();
		 restaurant.getFoods().addAll(foods);
		 
		return restaurantRepository.save(restaurant);
	}
	@Override
	public List<Restaurant> searchFood(FilterCriteria filterCriteria) {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		List<Restaurant> result = restaurants.stream()
		.filter(search->{
			return null!=filterCriteria.getStateName() && ""!=filterCriteria.getStateName()?search.getState().equals(filterCriteria.getStateName().trim()):""==filterCriteria.getStateName();
		})
		.filter(search->{
			return null!=filterCriteria.getAreaName() && ""!=filterCriteria.getAreaName()?search.getArea().equals(filterCriteria.getAreaName().trim()):""==filterCriteria.getAreaName();
		})
		.filter(search->{
			return null!=filterCriteria.getPinCode() && 0!=filterCriteria.getPinCode()?search.getPinCode().equals(filterCriteria.getPinCode()):0==filterCriteria.getPinCode();
		})
		.filter(search->{
			return null!=filterCriteria.getRating() && ""!=filterCriteria.getRating()?search.getRating().equals(filterCriteria.getRating()):""==filterCriteria.getRating();
		})
		.collect(Collectors.toList());
		return result;
	}
	@Override
	public OrderBook orderFood(Integer id, List<String> orderList) {
		List<Food> foods = restaurantRepository.findById(id).get().getFoods();
		List<Food>result=new ArrayList<>();
		Integer billAmount=0;
//		List<Food> orderedFoods = foods.stream().map(food->{
//			return orderList.contains(food.getName())?food:null;
//		})
//		.collect(Collectors.toList());
//		
//		List<Object> collect = foods.stream().map(food->{
//			return orderList.contains(food.getName())?result.add(food):result;
//		}).collect(Collectors.toList());
		for(String order:orderList) {
			for(Food food:foods) {
				if(order.equals(food.getName())) {
					result.add(food);
					billAmount+=food.getPrice();
				}
			}
		}
		OrderBook orderBook=new OrderBook();
		if(!result.isEmpty()) {
			orderBook.setMessage("Your order has been successfully placed! \n Please visit again.");
		}else {
			orderBook.setMessage("There is some issue in order or you don't have selected any item");
		}
		orderBook.setBillAmount(billAmount);
		orderBook.setFoods(result);
		return orderBook;
	}
	

}
