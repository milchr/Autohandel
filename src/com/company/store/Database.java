package com.company.store;

import com.company.humans.Human;
import com.company.vehicles.Car;

import java.util.HashSet;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Database{
    public Set<Human> clientDB;
    public Set<Car> carsDB;
    int randomIndex = ThreadLocalRandom.current().nextInt(0, 5 + 1);

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

    public void waitAWeek(){
        removeCar(getCar(randomIndex));
        removeCar(getCar(randomIndex+1));
        this.carsDB.add(new Car());
        this.carsDB.add(new Car());
        System.out.println("Two new cars have appeared in the database");
    }

    public String toString(){
        return "Database";
    }

}
