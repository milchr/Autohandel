package com.company;

import com.company.humans.Human;
import com.company.store.Dealer;
import com.company.store.Transaction;
import com.company.vehicles.Car;
import com.company.vehicles.CarsDB;

public class Main {

    public static void main(String[] args) {
        Dealer myShop = new Dealer("Car Shop",25000.0);

        CarsDB db = new CarsDB();
        for(int i=0;i<=10;i++)
        {
            db.carsDB.add(new Car());
        }

        myShop.addCar(new Car());
        System.out.println(myShop.dealerCars);
        System.out.println(db.carsDB);






    }
}
