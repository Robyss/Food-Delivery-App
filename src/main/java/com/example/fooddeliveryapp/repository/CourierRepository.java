package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.module.Courier;
import com.example.fooddeliveryapp.module.CourierVehicleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer> {

    List<Courier> findAll();

    List<Courier> findCourierByVehicleContaining(CourierVehicleEnum vehicle);
}
