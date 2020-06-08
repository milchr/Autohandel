package com.company;

import com.company.humans.Human;
import com.company.mechanics.Adrian;
import com.company.mechanics.Janusz;
import com.company.mechanics.Marian;
import com.company.store.Database;
import com.company.store.Dealer;
import com.company.vehicles.Car;

import java.util.Scanner;

public class Game {

    public void StartGame(){
        int selection=0;
        int index=0;
        int carId=0;
        int clientId=0;
        int key=0;
        int part=0;
        int numberOfTurns=0;
        String partName;

        Scanner in = new Scanner(System.in);
        Dealer myShop = new Dealer("Car Shop",450000.0);
        Database database = new Database();
        Janusz mechanic1 = new Janusz("Janusz",1.0);
        Marian mechanic2 = new Marian("Marian",0.9);
        Adrian mechanic3 = new Adrian("Adrian",0.8);

        for(int i=0;i<10;i++)
        {
            database.carsDB.add(new Car());
        }
        for(int i=0;i<5;i++)
        {
            database.clientDB.add(new Human());
        }
        database.setParts();

        do{
            System.out.println("[1] My shop");
            System.out.println("[2] Show cars available for purchase");
            System.out.println("[3] Sell a car");
            System.out.println("[4] Car mechanic");
            System.out.println("[5] Wait a week for a new delivery of cars to the database");
            System.out.println("[9] Exit");
            System.out.println();
            System.out.println("Turn: "+ numberOfTurns);
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
                                    numberOfTurns++;
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
                                    numberOfTurns++;
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
                case 4:
                    do{
                        System.out.println("[1] Select car");
                        System.out.println("Pick a mechanic:");
                        System.out.println("[2] Mechanic Janusz");
                        System.out.println("[3] Mechanic Marian");
                        System.out.println("[4] Mechanic Adrian");
                        System.out.println("[5] Back");
                        key=in.nextInt();
                        switch (key){
                            case 1:
                                System.out.println(myShop.dealerCars);
                                System.out.println("Select a car index :");
                                carId=in.nextInt();
                                break;
                            case 2:
                                do{
                                    System.out.println("[1] Show car parts");
                                    System.out.println("Select the part to be repaired:");
                                    System.out.println("[2] Engine");
                                    System.out.println("[3] Gearbox");
                                    System.out.println("[4] Suspension");
                                    System.out.println("[5] Tires");
                                    System.out.println("[6] Brakes");
                                    System.out.println("[7] Back");
                                    part=in.nextInt();
                                    switch (part){
                                        case 1:
                                            System.out.println(myShop.getCar(carId).getParts());
                                            break;
                                        case 2:
                                            partName="engine";
                                            try {
                                                mechanic1.repair(myShop,carId,partName);
                                                numberOfTurns++;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            partName="gearbox";
                                            try {
                                                mechanic1.repair(myShop,carId,partName);
                                                numberOfTurns++;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 4:
                                            partName="suspension";
                                            try {
                                                mechanic1.repair(myShop,carId,partName);
                                                numberOfTurns++;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 5:
                                            partName="tires";
                                            try {
                                                mechanic1.repair(myShop,carId,partName);
                                                numberOfTurns++;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 6:
                                            partName="brakes";
                                            try {
                                                mechanic1.repair(myShop,carId,partName);
                                                numberOfTurns++;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 7:
                                            System.out.println("------------------");
                                            break;

                                        default:
                                            System.out.println("Invalid number");
                                    }
                                }while(part!=7);
                                break;
                            case 3:
                                System.out.println(myShop.dealerCars);
                                System.out.println("Select a car index :");
                                carId=in.nextInt();
                                System.out.println("Select customer index :");
                                clientId=in.nextInt();
                                try {
                                    myShop.sell(database,carId,clientId);
                                    numberOfTurns++;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 4:
                                System.out.println("------------------");
                                break;
                            case 5:
                                System.out.println("------------------");
                                break;
                            default:
                                System.out.println("Invalid number");
                        }
                    }while(key!=5);
                    break;
                case 5:
                    database.waitAWeek();
                    numberOfTurns++;
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
