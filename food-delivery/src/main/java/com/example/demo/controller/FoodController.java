package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FilterCriteria;
import com.example.demo.model.Food;
import com.example.demo.model.OrderBook;
import com.example.demo.model.Restaurant;
import com.example.demo.service.intf.RestaurantService;

@RestController
public class FoodController {
	
	@Autowired
	private RestaurantService restaurantService; 
	@PostMapping("/add-restaurant")
	public ResponseEntity<Restaurant> add(@RequestBody final Restaurant restaurant) {
		Restaurant result = restaurantService.add(restaurant);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	@PutMapping("/add-food-items/{restaurant-id}")
	public ResponseEntity<Restaurant> addFoodItem(@PathVariable("restaurant-id")Integer id,@RequestBody final List<Food> foods) {
		Restaurant result = restaurantService.addFoodItem(id,foods);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	@PutMapping("/search-food")
	public ResponseEntity<List<Restaurant>> searchFood(@RequestBody final FilterCriteria filterCriteria) {
		List<Restaurant> searchFood = restaurantService.searchFood(filterCriteria);
		return new ResponseEntity<>(searchFood,HttpStatus.CREATED);
	}
	@PutMapping("/order-food/{restaurant-id}")
	public ResponseEntity<OrderBook> orderFood(@PathVariable("restaurant-id")Integer id, @RequestBody final List<String> orderList) {
		OrderBook orderFood = restaurantService.orderFood(id,orderList);
		return new ResponseEntity<>(orderFood,HttpStatus.CREATED);
	}
	

}
