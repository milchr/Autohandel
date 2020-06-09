package com.company.mechanics;

import com.company.store.Dealer;

import java.util.Random;



public class Adrian extends Mechanic {
    private static final Double DEFAULT_GUARANTEE = 0.8;
    private static final Double DEFAULT_ENGINE_PRICE = 10000.0;
    private static final Double DEFAULT_GEARBOX_PRICE = 5000.0;
    private static final Double DEFAULT_CARBODY_PRICE = 5000.0;
    private static final Double DEFAULT_SUSPENSION_PRICE = 2000.0;
    private static final Double DEFAULT_BRAKES_PRICE = 1000.0;
    private static final Double DEFAULT_REPAIR_PREMIUM_MULTIPLIER= 1.5;
    private static final Double DEFAULT_REPAIR_STANDARD_MULTIPLIER= 1.25;
    private static final Double DEFAULT_REPAIR_BUDGET_MULTIPLIER= 1.0;
    int whichPart=-1;

    public Adrian(String name, Double guarantee) {
        super(name, guarantee);
        this.guarantee=DEFAULT_GUARANTEE;
    }
    public Double getPriceOfRepair(Dealer car, int i, String part){
        return priceOfRepair(car, i, part);
    }

    public Double priceOfRepair(Dealer car, int i, String part){
        Double price=0.0;
        if(car.getCar(i).getSegment().equals("Premium")){
            switch(part){
                case "engine":
                    price =DEFAULT_ENGINE_PRICE*DEFAULT_REPAIR_PREMIUM_MULTIPLIER;
                    break;
                case "gearbox":
                    price =DEFAULT_GEARBOX_PRICE*DEFAULT_REPAIR_PREMIUM_MULTIPLIER;
                    break;
                case "suspension":
                    price =DEFAULT_SUSPENSION_PRICE*DEFAULT_REPAIR_PREMIUM_MULTIPLIER;
                    break;
                case "carbody":
                    price =DEFAULT_CARBODY_PRICE*DEFAULT_REPAIR_PREMIUM_MULTIPLIER;
                    break;
                case "brakes":
                    price =DEFAULT_BRAKES_PRICE*DEFAULT_REPAIR_PREMIUM_MULTIPLIER;
                    break;
            }
            return price;
        }
        if(car.getCar(i).getSegment().equals("Standard")){
            switch(part){
                case "engine":
                    price =DEFAULT_ENGINE_PRICE*DEFAULT_REPAIR_STANDARD_MULTIPLIER;
                    break;
                case "gearbox":
                    price =DEFAULT_GEARBOX_PRICE*DEFAULT_REPAIR_STANDARD_MULTIPLIER;
                    break;
                case "suspension":
                    price =DEFAULT_SUSPENSION_PRICE*DEFAULT_REPAIR_STANDARD_MULTIPLIER;
                    break;
                case "carbody":
                    price =DEFAULT_CARBODY_PRICE*DEFAULT_REPAIR_STANDARD_MULTIPLIER;
                    break;
                case "brakes":
                    price =DEFAULT_BRAKES_PRICE*DEFAULT_REPAIR_STANDARD_MULTIPLIER;
                    break;
            }
            return price;
        }
        if(car.getCar(i).getSegment().equals("Budget")){
            switch(part){
                case "engine":
                    price =DEFAULT_ENGINE_PRICE*DEFAULT_REPAIR_BUDGET_MULTIPLIER;
                    break;
                case "gearbox":
                    price =DEFAULT_GEARBOX_PRICE*DEFAULT_REPAIR_BUDGET_MULTIPLIER;
                    break;
                case "suspension":
                    price =DEFAULT_SUSPENSION_PRICE*DEFAULT_REPAIR_BUDGET_MULTIPLIER;
                    break;
                case "carbody":
                    price =DEFAULT_CARBODY_PRICE*DEFAULT_REPAIR_BUDGET_MULTIPLIER;
                    break;
                case "brakes":
                    price =DEFAULT_BRAKES_PRICE*DEFAULT_REPAIR_BUDGET_MULTIPLIER;
                    break;
            }
            return price;
        }
        return 0.0;

    }

    public boolean chanceToRepair(){
        Random random = new Random();
        int rnd =  random.nextInt(100);

        if(rnd>=0 && rnd<=80){
            return true;
        }else
            return false;
    }
    public boolean chanceToDamage(){
        Random random = new Random();
        int rnd =  random.nextInt(100);
        if(rnd>=0 && rnd<=98){
            return false;
        }else
            return true;
    }
    public int randomNumber(){
        Random random = new Random();
        int rnd =  random.nextInt(3);
        return rnd;
    }


    @Override
    public void repair(Dealer car, int i, String part) {
        switch(part){
            case "engine":
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                if(chanceToRepair()==true){
                    if(chanceToDamage()==true){
                        whichPart=randomNumber();
                        switch(whichPart){
                            case 0:
                                car.getCar(i).getParts().setGearboxDamage();
                                break;
                            case 1:
                                car.getCar(i).getParts().setSuspensionDamage();
                                break;
                            case 2:
                                car.getCar(i).getParts().setCarBodyDamage();
                                break;
                            case 3:
                                car.getCar(i).getParts().setBrakesDamage();
                                break;
                        }
                    }
                    car.getCar(i).getParts().setEngine();
                    System.out.println(part+" has been successfully repaired!");
                    car.getCar(i).setValue(car.getCar(i).getValue()*2);
                }else{
                    System.out.println("Adrian failed to repair the "+part);
                }
                break;
            case "gearbox":
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                if(chanceToRepair()==true){
                    if(chanceToDamage()==true){
                        whichPart=randomNumber();
                        switch(whichPart){
                            case 0:
                                car.getCar(i).getParts().setEngineDamage();
                                break;
                            case 1:
                                car.getCar(i).getParts().setSuspensionDamage();
                                break;
                            case 2:
                                car.getCar(i).getParts().setCarBodyDamage();
                                break;
                            case 3:
                                car.getCar(i).getParts().setBrakesDamage();
                                break;
                        }
                    }
                    car.getCar(i).getParts().setGearbox();
                    System.out.println(part+" has been successfully repaired!");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                }else{
                    System.out.println("Adrian failed to repair the "+part);
                }
                break;
            case "suspension":
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                if(chanceToRepair()==true){
                    if(chanceToDamage()==true){
                        whichPart=randomNumber();
                        switch(whichPart){
                            case 0:
                                car.getCar(i).getParts().setGearboxDamage();
                                break;
                            case 1:
                                car.getCar(i).getParts().setEngineDamage();
                                break;
                            case 2:
                                car.getCar(i).getParts().setCarBodyDamage();
                                break;
                            case 3:
                                car.getCar(i).getParts().setBrakesDamage();
                                break;
                        }
                    }
                    car.getCar(i).getParts().setSuspension();
                    System.out.println(part+" has been successfully repaired");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.2);
                }else{
                    System.out.println("Adrian failed to repair the "+part);
                }
                break;
            case "carbody":
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                if(chanceToRepair()==true){
                    if(chanceToDamage()==true){
                        whichPart=randomNumber();
                        switch(whichPart){
                            case 0:
                                car.getCar(i).getParts().setGearboxDamage();
                                break;
                            case 1:
                                car.getCar(i).getParts().setSuspensionDamage();
                                break;
                            case 2:
                                car.getCar(i).getParts().setEngineDamage();
                                break;
                            case 3:
                                car.getCar(i).getParts().setBrakesDamage();
                                break;
                        }
                    }
                    car.getCar(i).getParts().setCarBody();
                    System.out.println(part+" has been successfully repaired");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                }else{
                    System.out.println("Adrian failed to repair the "+part);
                }
                break;
            case "brakes":
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                if(chanceToRepair()==true){
                    if(chanceToDamage()==true){
                        whichPart=randomNumber();
                        switch(whichPart){
                            case 0:
                                car.getCar(i).getParts().setGearboxDamage();
                                break;
                            case 1:
                                car.getCar(i).getParts().setSuspensionDamage();
                                break;
                            case 2:
                                car.getCar(i).getParts().setCarBodyDamage();
                                break;
                            case 3:
                                car.getCar(i).getParts().setEngineDamage();
                                break;
                        }
                    }
                    car.getCar(i).getParts().setBrakes();
                    System.out.println(part+" has been successfully repaired");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.1);
                }else{
                    System.out.println("Adrian failed to repair the "+part);
                }
                break;
            default:
                System.out.println("Invalid number");
        }

    }
}
