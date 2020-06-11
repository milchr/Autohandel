package com.company.store;

import com.company.Buy;
import com.company.Sell;
import com.company.advertisement.Ad;
import com.company.humans.Human;
import com.company.mechanics.RepairHistory;
import com.company.vehicles.Car;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Dealer implements Buy, Sell, Ad {
    private String name;
    private Double cash;
    private Car car;
    public ArrayList<Transaction> transactionHistory = new ArrayList<>();
    public Set<Car> dealerCars;
    private static final Double DEFAULT_TAX = 0.02;
    private static final Double DEFAULT_NEWSPAPER_PRICE = 30000.0;
    private static final Double DEFAULT_INTERNET_PRICE = 4000.0;
    private static final Double DEFAULT_CAR_WASH_PRICE = 30.0;
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
        this.setCash(getCash()-DEFAULT_CAR_WASH_PRICE);
        getCar(i).addCarWashCosts(DEFAULT_CAR_WASH_PRICE);
        System.out.println("You washed the car");
    }
    public void carWashOnBuy(Database carDb,Integer i){
        this.setCash(getCash()-DEFAULT_CAR_WASH_PRICE);
        carDb.getCar(i).addCarWashCosts(DEFAULT_CAR_WASH_PRICE);
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
        System.out.println("You bought a "+carDb.getCar(i)+" to your store for "+ decimalFormat(carDb.getValue(i))+"$" );
        carWashOnBuy(carDb,i);
        transactionHistory.add(new Transaction(this, carDb,carDb.getCar(i),carDb.getValue(i),LocalDateTime.now()));
        carDb.removeCar(carDb.getCar(i));
        carDb.carsDB.add(new Car());
    }

    @Override
    public void sell( Database clientDb, int carId, int clientId) throws Exception {
        if(!this.dealerCars.isEmpty()) {
            if (!clientDb.getInterested(clientId).equals(this.getCar(carId).getProducer()) && !clientDb.getInterested2(clientId).equals(this.getCar(carId).getProducer())) {
                throw new Exception("Client is not interested in this car\n");
            }
            if (clientDb.getWants(clientId)) {
                if (!this.getCar(carId).getParts().fullyFunctionalCar()) {
                    throw new Exception("Client is not interested in damaged car!\n");
                }
            }
            if (clientDb.getCash(clientId) < this.getValue(carId)) {
                throw new Exception("Client doesn't have that much money!\n");
            }

            this.setCash(this.getCash() + this.getValue(carId));
            clientDb.setCash(clientDb.getCash(clientId) - this.getValue(carId), clientId);
            System.out.println("You sold the " + this.getCar(carId) + " to " + clientDb.getClient(clientId));
            transactionHistory.add(new Transaction(this, clientDb.getClient(clientId), this.getCar(carId), this.getValue(carId), LocalDateTime.now()));
            this.removeCar(this.getCar(carId));
            clientDb.clientDB.add(new Human());
            clientDb.clientDB.add(new Human());
            System.out.println("You've gained two new potential customers");
        }else{
            System.out.println("You don't have a car!\n");
        }

    }

    @Override
    public void ad(String type, Database clientDB) {

        if(type.equals("Newspaper"))
        {
            if (this.getCash() >=DEFAULT_NEWSPAPER_PRICE) {
                System.out.println("You bought an advertisement in a local newspaper!");
                this.setCash(this.getCash() - DEFAULT_NEWSPAPER_PRICE);
                for(int i=0;i<randomNumberOfClients();i++){
                    clientDB.clientDB.add(new Human());
                }
                System.out.println("You've gained "+randomNumberOfClients()+" new customers!");
            }else{
                System.out.println("You don't have enough money!\n");
            }

        }
        if(type.equals("Internet"))
        {
            if (this.getCash() >= DEFAULT_INTERNET_PRICE) {
                System.out.println("You bought online advertising!");
                this.setCash(this.getCash() - DEFAULT_INTERNET_PRICE);
                clientDB.clientDB.add(new Human());
                System.out.println("You've gained one new customer");

            }else{
                System.out.println("You don't have enough money!\n");
            }

        }
    }
    public void allRepairs(ArrayList<RepairHistory> c1, ArrayList<RepairHistory> c2, ArrayList<RepairHistory> c3){
        allRepairHistory.addAll(c1);
        allRepairHistory.addAll(c2);
        allRepairHistory.addAll(c3);

    }
    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }

}
