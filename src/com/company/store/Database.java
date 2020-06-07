package com.company.store;

import com.company.humans.Human;
import com.company.vehicles.Car;

import java.util.HashSet;

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
        Car[] myArray = new Car[carsDB.size()];
        carsDB.toArray(myArray);
        return myArray[i].getValue();
    }
    public Human getClient(Integer i) {
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        return myArray[i];
    }
    public Double getCash(Integer i){
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        return myArray[i].getCash();
    }
    public void setCash(Double cash, Integer i){
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        myArray[i].setCash(cash);
    }
    public void removeCar(Car car) {
        this.carsDB.remove(car);
    }

    public String toString(){
        return "Database";
    }

}
