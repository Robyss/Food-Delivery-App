package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.module.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> findAll();

    List<Restaurant> findAllByCity(String criteria);
}
