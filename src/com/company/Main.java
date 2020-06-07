package com.company;

import com.company.humans.Human;
import com.company.store.Database;
import com.company.store.Dealer;
import com.company.store.Transaction;
import com.company.vehicles.Car;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int selection=0;
        int index=0;
        int carId=0;
        int clientId=0;
        int key=0;

        Scanner in = new Scanner(System.in);
        Dealer myShop = new Dealer("Car Shop",35000.0);
        Database database = new Database();

        for(int i=0;i<10;i++)
        {
            database.carsDB.add(new Car());
        }
        for(int i=0;i<5;i++)
        {
            database.clientDB.add(new Human());
        }

        do{
            System.out.println("[1] My shop");
            System.out.println("[2] Show cars available for purchase");
            System.out.println("[3] Sell a car");
            System.out.println("[4] Car mechanic");
            System.out.println("[5] Wait a week for a new delivery of cars to the database");
            System.out.println("[9] Exit");
            selection=in.nextInt();
            switch(selection){
                case 1:
                    do{
                    System.out.println("[1] Show my cars");
                    System.out.println("[2] Display balance");
                    System.out.println("[3] Transaction history");
                    System.out.println("[4] Buy advertisement");
                    System.out.println("[5] Back");
                    key=in.nextInt();
                    switch (key){
                        case 1:
                            System.out.println(myShop.dealerCars);
                            break;
                        case 2:
                            System.out.println(myShop.getCash());
                            break;
                        case 3:
                            System.out.println(myShop.transactionHistory);
                            break;
                        case 5:
                            System.out.println("------------------");
                            break;
                        default:
                            System.out.println("Invalid number");
                    }
                    }while(key!=5);
                    break;
                case 2:
                    do{
                    System.out.println("[1] Show cars");
                    System.out.println("[2] Buy a car");
                    System.out.println("[3] Back");
                    key=in.nextInt();
                    switch (key){
                        case 1:
                            System.out.println(database.carsDB);
                            break;
                        case 2:
                            System.out.println("Select a car index :");
                            index=in.nextInt();
                            try {
                                myShop.buy(database,index);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.out.println("------------------");
                            break;
                        default:
                            System.out.println("Invalid number");
                    }
                    }while(key!=3);
                    break;
                case 3:
                    do{
                    System.out.println("[1] Review potential customers");
                    System.out.println("[2] Sell the car to the customer");
                    System.out.println("[3] Back");
                    key=in.nextInt();
                    switch (key){
                        case 1:
                            System.out.println(database.clientDB);
                            break;
                        case 2:
                            System.out.println(myShop.dealerCars);
                            System.out.println("Select a car index :");
                            carId=in.nextInt();
                            System.out.println("Select customer index :");
                            clientId=in.nextInt();
                            try {
                                myShop.sell(database,carId,clientId);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            System.out.println("------------------");
                            break;

                        default:
                            System.out.println("Invalid number");
                    }
                    }while(key!=3);
                    break;
                case 5:
                    database.waitAWeek();
                    break;
                case 9:
                    System.out.println("________________");
                    break;
                default:
                    System.out.println("Invalid number");

            }
        }while(selection!=9);


    }
}
