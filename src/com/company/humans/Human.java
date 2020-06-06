package com.company.humans;

import com.company.vehicles.Car;

import java.util.HashSet;
import java.util.Set;

public class Human {
    private final String firstName;
    private final String lastName;
    private Double cash;
    private Car car;
    public Set<Car> myCars;

    public Human(String firstName, String lastName, Double cash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
        this.myCars=new HashSet<Car>();
    }
    public void addCar(Car car) {
        this.car = car;
        this.myCars.add(car);
    }
}
