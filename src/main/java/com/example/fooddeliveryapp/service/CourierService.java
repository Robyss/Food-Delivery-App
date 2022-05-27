package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.module.Courier;
import com.example.fooddeliveryapp.module.CourierVehicleEnum;
import com.example.fooddeliveryapp.module.Restaurant;
import com.example.fooddeliveryapp.module.User;
import com.example.fooddeliveryapp.repository.CourierRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourierService {

    @Autowired
    private final CourierRepository courierRepository;

    public List<Courier> getCouriers() {
        return courierRepository.findAll();
    }

    public Courier getCourierById(Integer courierID) {
        return courierRepository.findById(courierID).get();
    }

    public List<Courier> getCouriersByVehicle(CourierVehicleEnum vehicle) {

        return courierRepository.findCourierByVehicleContaining(vehicle);
    }

    public Courier addCourier(Courier courier) {
        return courierRepository.save(courier);
    }

    public Courier updateCourier(Courier courier, Integer courierID) {
        courier.setCourierId(courierID);
        return courierRepository.save(courier);
    }

    public Courier partiallyUpdateCourier(Courier courier, Integer courierID) {
        Courier updatedCourier = courierRepository.findById(courierID).get();
        if(courier.getFirstName() != null) {
            updatedCourier.setFirstName(courier.getFirstName());
        }

        if(courier.getLastName() != null) {
            updatedCourier.setLastName(courier.getLastName());
        }

        if(courier.getAddress() != null) {
            updatedCourier.setAddress(courier.getAddress());
        }

        if(courier.getPhoneNumber() != null) {
            updatedCourier.setPhoneNumber(courier.getPhoneNumber());
        }

        if(courier.getDateOfBirth() != null) {
            updatedCourier.setDateOfBirth(courier.getDateOfBirth());
        }

        if(courier.getVehicle() != null) {
            updatedCourier.setVehicle(courier.getVehicle());
        }
        return courierRepository.save(updatedCourier);

    }

    public void deleteCourier(Integer courierID) {
        Courier courier = courierRepository.findById(courierID).get();
        courierRepository.delete(courier);
    }

}
