package com.company.mechanics;

import com.company.store.Dealer;
import com.company.vehicles.Car;

public class Marian extends Mechanic {
    public Marian(String name, Double guarantee) {
        super(name, guarantee);
    }


    @Override
    public void repair(Dealer car, int i, String part) {

    }
}
