package com.company;

import com.company.humans.Human;
import com.company.store.Dealer;
import com.company.store.Transaction;
import com.company.vehicles.Car;

public interface Sell {
    void sell(Human buyer, Dealer seller, Transaction transaction, double price);
}
