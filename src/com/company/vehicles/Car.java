package com.company.vehicles;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Car {

    private final String producer;
    private final String color;
    private final String segment;

    private Integer mileage;
    private Double value;
    public String[] producers ={"Fiat", "Audi", "Opel","BMW","Mercedes","Honda","Toyota","Skoda","Ferrari","Porsche","Ford","Lexus"};
    public String[] colors ={"Red", "Blue", "Green","White","Yellow","Black","Orange","Pink","Purple","Grey"};
    public String[] segments ={"Premium", "Standard", "Budget"};

    public Parts parts;
    double randomValue = ThreadLocalRandom.current().nextDouble(8000.0, 500000.0 + 1);
    int randomMileage = ThreadLocalRandom.current().nextInt(1000, 300000 + 1);


    public Car() {
        this.producer = producers[new Random().nextInt(producers.length)];
        this.color = colors[new Random().nextInt(colors.length)];;
        this.value = randomValue;
        this.mileage = randomMileage;
        this.segment = segments[new Random().nextInt(segments.length)];
        this.parts = new Parts();
    }
    public void setParts(){
        new Parts();
   }
    public Double getValue(){
        return this.value;
    }
    public void setValue(Double price)
    {
        this.value=price;
    }

    public String toString() {
        return "\n"+this.producer + ", color: " + this.color + ", value: " + decimalFormat(this.value)+"$";
    }
    public Parts getParts(){
        return  this.parts;
    }

    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }



}
