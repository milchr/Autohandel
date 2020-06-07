package com.company.store;

import com.company.Buy;
import com.company.Sell;
import com.company.humans.Human;
import com.company.vehicles.Car;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Transaction{
    private Dealer dealer;
    private String name;
    private Human buyer;
    private Database seller;
    private Car car;
    private Double price;
    private LocalDateTime date;


    public Transaction(Dealer dealer, Human buyer,Car car, Double price, LocalDateTime date){
        this.dealer = dealer;
        this.buyer = buyer;
        this.car=car;
        this.price = price;
        this.date = date;


    }
    public Transaction(String name,Database seller, Car car,Double price, LocalDateTime date){
        this.name=name;
        this.car=car;
        this.seller = seller;
        this.price = price;
        this.date = date;

    }


    public String toString() {
        return "Transaction: " + this.name + " bought: " + this.car + " for: "+this.price + ", date: " + this.date;
    }


}
