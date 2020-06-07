package com.company;

import com.company.humans.Human;
import com.company.store.Database;
import com.company.store.Dealer;
import com.company.store.Transaction;

public interface Buy {

    void buy(Database carDb,int i) throws Exception;
}
