package com.company;

import com.company.humans.Human;
import com.company.store.Database;
import com.company.store.Dealer;
import com.company.vehicles.Car;

public class Main {

    public static void main(String[] args) {
        Dealer myShop = new Dealer("Car Shop",25000.0);

        Database database = new Database();
        for(int i=0;i<=10;i++)
        {
            database.carsDB.add(new Car());
            database.clientDB.add(new Human());
        }


        System.out.println(myShop.dealerCars);
        System.out.println(database.carsDB);
        System.out.println(database.clientDB);






    }
}
