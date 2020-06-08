package com.company.store;

import com.company.Buy;
import com.company.Sell;
import com.company.humans.Human;
import com.company.vehicles.Car;
import com.company.vehicles.Parts;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Dealer implements Buy, Sell {
    private String name;
    private Double cash;
    private Car car;
    public ArrayList<Transaction> transactionHistory = new ArrayList<>();
    public Set<Car> dealerCars;

    public Dealer(String name,Double cash){
        this.name=name;
        this.cash=cash;
        this.dealerCars=new HashSet<Car>();

    }
    public String getName() {
        return this.name;

    }

    public Car getCar(Integer i) {
        Car[] myArray = new Car[dealerCars.size()];
        dealerCars.toArray(myArray);
        return myArray[i];
    }
    public Double getValue(Integer i){
        Car[] myArray = new Car[dealerCars.size()];
        dealerCars.toArray(myArray);
        return myArray[i].getValue();
    }

    public void addCar(Car car) {
        this.car = car;
        this.dealerCars.add(car);
    }

    public void removeCar(Car car) {
        this.dealerCars.remove(car);
    }

    public Double getCash() {
        return cash;
    }


    public void setCash(Double cash) {
        this.cash = cash;
    }
    public String toString() {
        return this.name;
    }



    @Override
    public void buy(Database carDb, int i) throws Exception {
        if (this.getCash()< carDb.getValue(i)) {
            throw new Exception("Not enough money");
        }
        this.setCash(this.getCash() - carDb.getValue(i));
        this.dealerCars.add(carDb.getCar(i));
        System.out.println("You bought a "+carDb.getCar(i)+" to your store for "+ carDb.getValue(i) );
        transactionHistory.add(new Transaction(this, carDb,carDb.getCar(i),carDb.getValue(i),LocalDateTime.now()));
        carDb.removeCar(carDb.getCar(i));
        carDb.carsDB.add(new Car());
    }

    @Override
    public void sell( Database clientDb, int carId, int clientId) throws Exception {

        if (clientDb.getCash(clientId) < this.getValue(carId)) {
            throw new Exception("Not enough money");
        }

        this.setCash(this.getCash() + this.getValue(carId));
        clientDb.setCash(clientDb.getCash(clientId)-this.getValue(carId),clientId);
        System.out.println("You sold the "+this.getCar(carId)+" to "+clientDb.getClient(clientId));
        transactionHistory.add(new Transaction(this,clientDb.getClient(clientId),this.getCar(carId),this.getValue(carId),LocalDateTime.now()));
        this.removeCar(this.getCar(carId));
        clientDb.clientDB.add(new Human());
        clientDb.clientDB.add(new Human());
        System.out.println("You've gained two new potential customers");
    }

}
