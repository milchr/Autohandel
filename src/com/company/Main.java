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
        Dealer myShop = new Dealer("Car Shop",25000.0);

        Database database = new Database();
        for(int i=0;i<=10;i++)
        {
            database.carsDB.add(new Car());
        }
        for(int i=0;i<=5;i++)
        {
            database.clientDB.add(new Human());
        }

      // System.out.println(database.carsDB);
       // System.out.println(database.clientDB);
       // System.out.println(myShop.transactionHistory);
       // System.out.println(myShop.dealerCars);

        Scanner in = new Scanner(System.in);

        do{
            System.out.println("[1] Show my cars");
            System.out.println("[2] Display balance");
            System.out.println("[3] Show cars available for purchase");
            System.out.println("[4] Buy a car");
            System.out.println("[5] Review potential customers");
            System.out.println("[6] Sell the car to the customer");
            System.out.println("[8] Transaction history");
            System.out.println("[9] Exit");
            selection=in.nextInt();
            switch(selection){
                case 1:
                    System.out.println(myShop.dealerCars);
                    break;
                case 2:
                    System.out.println(myShop.getCash());
                    break;
                case 3:
                    System.out.println(database.carsDB);
                    break;
                case 4:
                    System.out.println("Select a car index (0-9) :");
                    index=in.nextInt();
                    myShop.buy(database,index);
                    break;
                case 5:
                    System.out.println(database.clientDB);
                    break;
                case 6:
                    System.out.println("Select a car index (0-9) :");
                    carId=in.nextInt();
                    System.out.println("Select customer index (0-9) :");
                    clientId=in.nextInt();
                    myShop.sell(database,carId,clientId);
                    break;
                case 8:
                    System.out.println(myShop.transactionHistory);
                    break;
                case 9:
                    System.out.println("________________");
                    break;
                default:
                    System.out.println("Invalid number");

            }
        }while(selection!=8);


    }
}
