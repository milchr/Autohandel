package com.company.mechanics;

import com.company.store.Dealer;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Marian extends Mechanic {
    private static final Double DEFAULT_GUARANTEE = 0.9;

    public Marian(String name, Double guarantee) {
        super(name, guarantee);
        this.guarantee=DEFAULT_GUARANTEE;
    }

    public boolean chanceToRepair(){
        if(new Random().nextInt()>=0 && new Random().nextInt()<=90){
            return true;
        }else
            return false;
    }

    @Override
    public void repair(Dealer car, int i, String part) {
        switch(part){
            case "engine":
                car.setCash(car.getCash() - 30000.0);
                System.out.println("You spent 30,000 to repair the engine");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setEngine();
                    System.out.println(part+" has been successfully repaired");
                    car.getCar(i).setValue(car.getCar(i).getValue()*2);
                }else{
                    System.out.println("Marian failed to repair the "+part);
                }
                break;
            case "gearbox":
                car.setCash(car.getCash() - 15000.0);
                System.out.println("You spent 15,000 to repair the engine");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setGearbox();
                    System.out.println(part+" has been successfully repaired");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                }else{
                    System.out.println("Marian failed to repair the "+part);
                }
                break;
            case "suspension":
                car.setCash(car.getCash() - 4000.0);
                System.out.println("You spent 4,000 to repair the engine");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setSuspension();
                    System.out.println(part+" has been successfully repaired");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.2);
                }else{
                    System.out.println("Marian failed to repair the "+part);
                }
                break;
            case "carbody":
                car.setCash(car.getCash() - 15000.0);
                System.out.println("You spent 15,000 to repair the engine");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setCarBody();
                    System.out.println(part+" has been successfully repaired");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                }else{
                    System.out.println("Marian failed to repair the "+part);
                }
                break;
            case "brakes":
                car.setCash(car.getCash() - 2000.0);
                System.out.println("You spent 2,000 to repair the engine");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setBrakes();
                    System.out.println(part+" has been successfully repaired");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.1);
                }else{
                    System.out.println("Marian failed to repair the "+part);
                }
                break;
            default:
                System.out.println("Invalid number");
        }

    }
}
