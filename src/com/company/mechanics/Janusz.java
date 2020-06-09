package com.company.mechanics;

import com.company.store.Dealer;

public class Janusz extends Mechanic{
    public Janusz(String name, Double guarantee) {
        super(name, guarantee);
    }

    @Override
    public void repair(Dealer car, int i, String part) {

        switch(part){
            case "engine":
                car.getCar(i).getParts().setEngine();
                car.setCash(car.getCash() - 50000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*2);
                System.out.println("You spent 50,000 to repair the engine");
                break;
            case "gearbox":
                car.getCar(i).getParts().setGearbox();
                car.setCash(car.getCash() - 25000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                System.out.println("You spent 25,000 to repair the gearbox");
                break;
            case "suspension":
                car.getCar(i).getParts().setSuspension();
                car.setCash(car.getCash() - 7000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*1.2);
                System.out.println("You spent 7,000 to repair the suspension");
                break;
            case "carbody":
                car.getCar(i).getParts().setCarBody();
                car.setCash(car.getCash() - 25000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                System.out.println("You spent 25,000 to repair car body");
                break;
            case "brakes":
                car.getCar(i).getParts().setBrakes();
                car.setCash(car.getCash() - 4000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*1.1);
                System.out.println("You spent 4,000 to repair the brakes");
                break;
            default:
                System.out.println("Invalid number");
        }
    }
}
