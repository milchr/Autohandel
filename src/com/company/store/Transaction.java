package com.company.store;

import com.company.Sell;
import com.company.humans.Human;
import com.company.vehicles.Car;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Transaction {
    private Dealer dealer;
    private Human buyer;
    private Double price;
    private LocalDateTime date;
    public Set<Transaction> transactionList;

    public Transaction(Dealer dealer, Human buyer, Double price, LocalDateTime date){
        this.dealer = dealer;
        this.buyer = buyer;
        this.price = price;
        this.date = date;
        this.transactionList=new HashSet<Transaction>();

    }

//    @Override
//    public void sell(Human buyer, Dealer seller, Car car, double price) {
//
//
//    }



}
