package com.example.demo.service.intf;

import java.util.List;

import com.example.demo.model.FilterCriteria;
import com.example.demo.model.Food;
import com.example.demo.model.OrderBook;
import com.example.demo.model.Restaurant;

public interface RestaurantService {

	Restaurant add(Restaurant restaurant);

	Restaurant addFoodItem(Integer id, List<Food> foods);

	List<Restaurant> searchFood(FilterCriteria filterCriteria);

	OrderBook orderFood(Integer id, List<String> orderList);

}
