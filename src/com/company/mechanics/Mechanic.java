package com.company.mechanics;

public abstract class Mechanic implements Repair {
    public final String name;
    public Double guarantee;

    protected Mechanic(String name, Double guarantee) {
        this.name = name;
        this.guarantee = guarantee;
    }



    public String toString() {
        return this.name + " repair guarantee:" + this.guarantee;
    }
}
