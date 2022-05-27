package com.example.fooddeliveryapp.module;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "courier")
public class Courier extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id")
    private int courierId;

    @Enumerated(value = EnumType.STRING)
    private CourierVehicleEnum vehicle;

    @OneToMany(mappedBy = "courier")
    @JsonManagedReference
    private List<Order> ordersComplete;

}
