package com.company.store;

import com.company.Buy;
import com.company.vehicles.Car;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Dealer implements Buy {
    private String name;
    private Double cash;
    private Car car;
    public ArrayList<Transaction> transactionHistory = new ArrayList<>();
    public Set<Car> dealerCars;

    public Dealer(String name,Double cash){
        this.name=name;
        this.cash=cash;
        this.dealerCars=new HashSet<Car>();

    }
    public String getName() {
        return this.name;

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

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }
    public String toString() {
        return this.name;
    }



    @Override
    public void buy(Database car, int i) {
        this.setCash(this.getCash() - car.getValue(i));
        this.dealerCars.add(car.getCar(i));
        transactionHistory.add(new Transaction(this.name , car,car.getCar(i),car.getValue(i),LocalDateTime.now()));
        car.removeCar(car.getCar(i));
        car.carsDB.add(new Car());
    }

}
