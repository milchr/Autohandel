package com.company.store;

import com.company.Buy;
import com.company.humans.Human;
import com.company.vehicles.Car;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Database{
    public Set<Human> clientDB;
    public Set<Car> carsDB;

    public Database(){
        this.clientDB=new HashSet<Human>();
        this.carsDB=new HashSet<Car>();
    }
    public Car getCar(Integer i) {
        Car[] myArray = new Car[carsDB.size()];
        carsDB.toArray(myArray);
        return myArray[i];
    }
    public Double getValue(Integer i){
        double value =0.0;
        Car[] myArray = new Car[carsDB.size()];
        carsDB.toArray(myArray);
        return myArray[i].getValue();
    }
    public void removeCar(Car car) {
        this.carsDB.remove(car);
    }



}
