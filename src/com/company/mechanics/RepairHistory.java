package com.company.mechanics;

import com.company.store.Database;
import com.company.store.Dealer;
import com.company.vehicles.Car;
import com.company.vehicles.Parts;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class RepairHistory {
    private Dealer dealer;
    private Janusz mechanic1;
    private Marian mechanic2;
    private Adrian mechanic3;
    private Double price;
    private Car car;
    private String part;
    private LocalDateTime date;


    public RepairHistory(Janusz mechanic1,Dealer dealer,Car car,String part,Double price,LocalDateTime date) {
        this.mechanic1=mechanic1;
        this.dealer=dealer;
        this.car=car;
        this.part=part;
        this.date=date;
        this.price=price;
    }
    public RepairHistory(Marian mechanic2,Dealer dealer,Car car,String part,Double price,LocalDateTime date) {
        this.mechanic2=mechanic2;
        this.dealer=dealer;
        this.car=car;
        this.part=part;
        this.date=date;
        this.price=price;
    }
    public RepairHistory(Adrian mechanic3,Dealer dealer,Car car,String part,Double price,LocalDateTime date) {
        this.mechanic3=mechanic3;
        this.dealer=dealer;
        this.car=car;
        this.part=part;
        this.date=date;
        this.price=price;
    }
    public String toString() {

            return "\n" + "Repaired car: "+ this.car +" Part: "+ this.part + "   price: " +decimalFormat(this.price) + "$, date: " + this.date;


    }
    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }


}
