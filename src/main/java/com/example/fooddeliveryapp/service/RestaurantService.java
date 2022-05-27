package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.module.Restaurant;
import com.example.fooddeliveryapp.module.User;
import com.example.fooddeliveryapp.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {

    @Autowired
    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantByID(Integer restaurantID) {
        return restaurantRepository.findById(restaurantID).get();
    }

    public List<Restaurant> getRestaurantsByCity(String city) {
        return restaurantRepository.findAllByCity(city);
    }


    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant, Integer restaurantID) {
        restaurant.setRestaurantId(restaurantID);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant partiallyUpdateRestaurant(Restaurant restaurant, Integer restaurantID) {
        Restaurant updatedRestaurant = restaurantRepository.findById(restaurantID).get();
        if(restaurant.getName() != null) {
            updatedRestaurant.setName(restaurant.getName());
        }

        if(restaurant.getCity() != null) {
            updatedRestaurant.setCity(restaurant.getCity());
        }

        if(restaurant.getLocationAddress() != null) {
            updatedRestaurant.setLocationAddress(restaurant.getLocationAddress());
        }
        return restaurantRepository.save(updatedRestaurant);
    }

    public void deleteRestaurant(Integer restaurantID) {
        Restaurant restaurant = restaurantRepository.findById(restaurantID).get();
        restaurantRepository.delete(restaurant);
    }

}
