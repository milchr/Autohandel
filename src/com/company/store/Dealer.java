package com.company.store;

import com.company.Buy;
import com.company.Sell;
import com.company.advertisement.Ad;
import com.company.humans.Human;
import com.company.mechanics.RepairHistory;
import com.company.vehicles.Car;

import java.time.LocalDateTime;
import java.util.*;

public class Dealer implements Buy, Sell, Ad {
    private String name;
    private Double cash;
    private Car car;
    public ArrayList<Transaction> transactionHistory = new ArrayList<>();
    public Set<Car> dealerCars;
    private static final Double DEFAULT_TAX = 0.02;
    public ArrayList<RepairHistory> allRepairHistory = new ArrayList<>();

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
    public Double getCarRepairCosts(int i){
        return getCar(i).getSumOfRepairCosts();
    }
    public Double getCarWashCosts(int i){
        return getCar(i).getSumCarWashCosts();
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

    public int randomNumberOfClients(){
        Random random = new Random();
        return random.nextInt(4)+1;
    }

    public void carWash(Integer i){
        this.setCash(getCash()-30.0);
        getCar(i).addCarWashCosts(30.0);
        System.out.println("You washed the car");
    }


    @Override
    public void buy(Database carDb, int i) throws Exception {
        if (this.getCash()< carDb.getValue(i)) {
            throw new Exception("Not enough money");
        }
        this.setCash(this.getCash() - carDb.getValue(i));
        this.setCash(this.getCash() - carDb.getValue(i)*DEFAULT_TAX);
        this.dealerCars.add(carDb.getCar(i));
        System.out.println("You bought a "+carDb.getCar(i)+" to your store for "+ carDb.getValue(i) );
        transactionHistory.add(new Transaction(this, carDb,carDb.getCar(i),carDb.getValue(i),LocalDateTime.now()));
        carDb.removeCar(carDb.getCar(i));
        carDb.carsDB.add(new Car());
    }

    @Override
    public void sell( Database clientDb, int carId, int clientId) throws Exception {

        if(!clientDb.getInterested(clientId).equals(this.getCar(carId).getProducer())||!clientDb.getInterested2(clientId).equals(this.getCar(carId).getProducer())){
            throw new Exception("Client is not interested in this car");
        }
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

    @Override
    public void ad(String type, Database clientDB) {
        if(type.equals("Newspaper"))
        {
            System.out.println("You bought an advertisement in a local newspaper!");
            this.setCash(this.getCash() - 30000.0);
            for(int i=0;i<randomNumberOfClients();i++){
                clientDB.clientDB.add(new Human());
            }
            System.out.println("You've gained "+randomNumberOfClients()+" new customers!");
        }
        if(type.equals("Internet"))
        {
            System.out.println("You bought online advertising!");
            this.setCash(this.getCash() - 5000.0);
            clientDB.clientDB.add(new Human());
            System.out.println("You've gained one new customer");
        }
    }
    public void allRepairs(ArrayList<RepairHistory> c1, ArrayList<RepairHistory> c2, ArrayList<RepairHistory> c3){
        allRepairHistory.addAll(c1);
        allRepairHistory.addAll(c2);
        allRepairHistory.addAll(c3);

    }

}
