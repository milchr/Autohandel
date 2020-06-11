package com.company.mechanics;

public abstract class Mechanic implements Repair {
    public final String name;


    protected Mechanic(String name) {
        this.name = name;

    }



    public String toString() {
        return this.name;
    }
}
