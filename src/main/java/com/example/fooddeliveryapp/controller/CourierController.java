package com.example.fooddeliveryapp.controller;

import com.example.fooddeliveryapp.module.Courier;
import com.example.fooddeliveryapp.module.CourierVehicleEnum;
import com.example.fooddeliveryapp.service.CourierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
@AllArgsConstructor
public class CourierController {

    @Autowired
    private final CourierService courierService;

    @GetMapping
    public ResponseEntity<List<Courier>> getCouriers() {
        return ResponseEntity.ok(courierService.getCouriers());
    }

    @GetMapping("/{courierID}")
    public ResponseEntity<Courier> getCourierById(@PathVariable Integer courierID) {
        return ResponseEntity.ok(courierService.getCourierById(courierID));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Courier>> getCouriesByVehicle(@RequestParam("vehicle") CourierVehicleEnum vehicle) {
        return ResponseEntity.ok(courierService.getCouriersByVehicle(vehicle));
    }


    @PostMapping
    public ResponseEntity<Courier> addCourier(@RequestBody Courier courier) {
        return ResponseEntity.ok(courierService.addCourier(courier));
    }

    @PutMapping("/{courierID}")
    public ResponseEntity<Courier> updateCourier(@RequestBody Courier courier, @PathVariable Integer courierID) {
        return ResponseEntity.ok(courierService.updateCourier(courier, courierID));
    }


    @PatchMapping("/{courierID}")
    public ResponseEntity<Courier> partiallyUpdateCourier(@RequestBody Courier courier, @PathVariable Integer courierID) {
        return ResponseEntity.ok(courierService.partiallyUpdateCourier(courier, courierID));
    }


    @DeleteMapping("/{courierID}")
    public ResponseEntity<String> deleteCourier( @PathVariable Integer courierID) {
        courierService.deleteCourier(courierID);
        return ResponseEntity.ok("Courier has been deleted successfully!");
    }
}
