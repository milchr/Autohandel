package com.company.store;

import com.company.humans.Human;
import com.company.vehicles.Car;

import java.util.HashSet;
import java.util.Random;
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
    public String getInterested(Integer i){
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        return myArray[i].getInterestedIn();
    }
    public String getInterested2(Integer i){
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        return myArray[i].getInterestedIn2();
    }
    public boolean getWants(Integer i){
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        return myArray[i].getWantsFullyFunctionalCar();
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

    public void setParts(){
        for(Car car : this.carsDB)
        {
            car.setParts();
        }
    }

    public void waitAWeek(){
        removeCar(getCar(new Random().nextInt(9)));
        removeCar(getCar(new Random().nextInt(9)));
        this.carsDB.add(new Car());
        this.carsDB.add(new Car());
        System.out.println("Two new cars have appeared in the database!\n");
    }

    public String toString(){
        return "Database";
    }

}
