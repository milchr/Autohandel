package com.company.vehicles;

import com.company.Sell;
import com.company.humans.Human;
import com.company.store.Dealer;
import com.company.store.Transaction;


import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Car {

    private final String producer;
    private final String color;
    private final String segment;
    private String engine;
    private String gearbox;
    private String suspension;
    private String tires;
    private String brakes;
    private Integer mileage;
    private Double value;
    public String[] producers ={"Fiat", "Audi", "Opel","BMW","Mercedes","Honda","Toyota","Skoda","Ferrari","Porsche","Ford","Lexus"};
    public String[] colors ={"Red", "Blue", "Green","White","Yellow","Black","Orange","Pink","Purple","Grey"};
    public String[] segments ={"Premium", "Standard", "Budget"};
    public String[] condition ={"damaged", "good"};
    double randomValue = ThreadLocalRandom.current().nextDouble(10000.0, 500000.0 + 1);
    int randomMileage = ThreadLocalRandom.current().nextInt(1000, 300000 + 1);


    public Car() {
        this.producer = producers[new Random().nextInt(producers.length)];
        this.color = colors[new Random().nextInt(colors.length)];;
        this.value = randomValue;
        this.mileage = randomMileage;
        this.segment = segments[new Random().nextInt(segments.length)];
        this.engine = condition[new Random().nextInt(condition.length)];
        this.gearbox = condition[new Random().nextInt(condition.length)];
        this.suspension = condition[new Random().nextInt(condition.length)];
        this.tires = condition[new Random().nextInt(condition.length)];
        this.brakes = condition[new Random().nextInt(condition.length)];

    }

    public Double getValue(){
        return this.value;
    }

    public String toString() {
        return this.producer + ", color: " + this.color + ", value: " + decimalFormat(this.value);
    }


    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }



}
