package com.company;

import com.company.humans.Human;
import com.company.store.Database;
import com.company.store.Dealer;
import com.company.store.Transaction;
import com.company.vehicles.Car;

public interface Sell {
    void sell( Database clientDb, int carId, int clientId) throws Exception;
}
