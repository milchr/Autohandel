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

public class Car implements Sell {

    private final String producer;
    private final String color;
    private Double value;
    public String[] producers ={"Fiat", "Audi", "Opel","BMW","Mercedes","Honda","Toyota","Skoda"};
    public String[] colors ={"Red", "Blue", "Green","White","Yellow","Black","Orange","Pink"};
    double randomValue = ThreadLocalRandom.current().nextDouble(10000.0, 500000.0 + 1);


    public Car() {
        this.producer = producers[new Random().nextInt(producers.length)];
        this.color = colors[new Random().nextInt(colors.length)];;
        this.value = randomValue;
        
    }

    public String toString() {
        return "Car producer: " + this.producer + ", color: " + this.color + ", value: " + decimalFormat(this.value);
    }

    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }


    @Override
    public void sell(Human buyer, Dealer seller, Transaction transaction, double price) {

    }
}
