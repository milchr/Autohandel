package com.company.store;

import com.company.humans.Human;
import com.company.vehicles.Car;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Transaction{
    private Dealer dealer;
    private Human buyer;
    private Database seller;
    private Car car;
    private Double price;
    private LocalDateTime date;



    public Transaction(Dealer seller, Human buyer, Car car, Double price, LocalDateTime date){
        this.dealer=seller;
        this.buyer = buyer;
        this.car=car;
        this.price = price;
        this.date = date;
    }

    public Transaction(Dealer buyer, Database seller, Car car, Double price, LocalDateTime date){
        this.dealer=buyer;
        this.car=car;
        this.seller = seller;
        this.price = price;
        this.date = date;

    }


    public String toString() {
        if(this.buyer == null){
            return "\n"+"Transaction between: " + this.dealer+" and "+ this.seller + "   Car: " + this.car + " price: " + decimalFormat(this.price) + ", date: " + this.date;
        }else{
            return "\n"+"Transaction between: " + this.dealer+" and "+ this.buyer + "   Car: " + this.car + " price: " + decimalFormat(this.price) + ", date: " + this.date;
        }
    }

    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }

}
