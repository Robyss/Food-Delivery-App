package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.module.Restaurant;
import com.example.fooddeliveryapp.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@AllArgsConstructor
public class RestaurantController {

    @Autowired
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return ResponseEntity.ok(restaurantService.getRestaurants());
    }


    @GetMapping("/{restaurantID}")
    public ResponseEntity<Restaurant> getRestaurantByID(@PathVariable Integer restaurantID) {
        return ResponseEntity.ok(restaurantService.getRestaurantByID(restaurantID));
    }


    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCity(@RequestParam String city) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByCity(city));
    }


    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.addRestaurant(restaurant));
    }


    @PutMapping("/{restaurantID}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable Integer restaurantID) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(restaurant, restaurantID));
    }


    @PatchMapping("/{restaurantID}")
    public ResponseEntity<Restaurant> partiallyUpdateRestaurant(@RequestBody Restaurant restaurant, @PathVariable Integer restaurantID) {
        return ResponseEntity.ok(restaurantService.partiallyUpdateRestaurant(restaurant, restaurantID));
    }


    @DeleteMapping("/{restaurantID}")
    public ResponseEntity<String> deleteRestaurant( @PathVariable Integer restaurantID) {
        restaurantService.deleteRestaurant(restaurantID);
        return ResponseEntity.ok("Restaurant has been deleted successfully!");
    }
}
