package com.company.humans;

import com.company.store.Database;
import com.company.store.Dealer;
import com.company.vehicles.Car;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Human {
    private final String firstName;
    private static int nextId = 1;
    private Double cash;
    private String interestedIn;
    private String interestedIn2;
    private Car car;
    public String[] producers ={"Fiat", "Audi", "Opel","BMW","Mercedes","Honda","Toyota","Skoda","Ferrari","Porsche","Ford","Lexus","Maserati","McLaren"};
    double randomCash = ThreadLocalRandom.current().nextDouble(10000.0, 300000.0 + 1);
    public Set<Car> myCars;

    public Human() {
        this.firstName = "client " + Human.nextId++;
        this.cash = randomCash;
        this.myCars=new HashSet<Car>();
        this.interestedIn = producers[new Random().nextInt(producers.length)];
        this.interestedIn2 = producers[new Random().nextInt(producers.length)];
        if(this.interestedIn.equals(getInterestedIn2())){this.interestedIn2 = producers[new Random().nextInt(producers.length)];}
    }
    public void addCar(Car car) {
        this.car = car;
        this.myCars.add(car);
    }
    public String getInterestedIn(){
        return this.interestedIn;
    }
    public String getInterestedIn2(){
        return this.interestedIn2;
    }
    public Double getCash(){
        return this.cash;
    }
    public void setCash(Double cash){
        this.cash=cash;
    }
    public String toString() {
        return "Client: " + this.firstName + ", cash: " + decimalFormat(this.cash) +" Interested in: "+ this.interestedIn+" or "+this.interestedIn2;
    }

    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }


}
