package com.company.humans;

import com.company.vehicles.Car;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Human {
    private final String firstName;
    private static int nextId = 1;
    private Double cash;
    private Car car;
    double randomCash = ThreadLocalRandom.current().nextDouble(10000.0, 300000.0 + 1);
    public Set<Car> myCars;

    public Human() {
        this.firstName = "client " + Human.nextId++;
        this.cash = randomCash;
        this.myCars=new HashSet<Car>();
    }
    public void addCar(Car car) {
        this.car = car;
        this.myCars.add(car);
    }
    public String toString() {
        return "Client: " + this.firstName + ", cash: " + decimalFormat(this.cash);
    }
    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }

}
