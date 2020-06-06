package com.company.store;

import com.company.humans.Human;
import com.company.vehicles.Car;

import java.util.HashSet;
import java.util.Set;

public class Database {
    public Set<Human> clientDB;
    public Set<Car> carsDB;

    public Database(){
        this.clientDB=new HashSet<Human>();
        this.carsDB=new HashSet<Car>();
    }


}
