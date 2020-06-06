package com.company.store;

import com.company.vehicles.Car;

import java.util.HashSet;
import java.util.Set;

public class Dealer {
    private String name;
    private Double cash;
    private Car car;
    public Set<Car> dealerCars;

    public Dealer(String name,Double cash){
        this.name=name;
        this.cash=cash;
        this.dealerCars=new HashSet<Car>();

    }

    public Car getCar() {
        return car;

    }


    public void addCar(Car car) {
        this.car = car;
        this.dealerCars.add(car);
    }

    public void removeCar(Car car) {
        this.dealerCars.remove(car);
    }
}
