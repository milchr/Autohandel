package com.company.mechanics;

import com.company.store.Dealer;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Janusz extends Mechanic{
    private static final Double DEFAULT_ENGINE_PRICE = 50000.0;
    private static final Double DEFAULT_GEARBOX_PRICE = 25000.0;
    private static final Double DEFAULT_CARBODY_PRICE = 25000.0;
    private static final Double DEFAULT_SUSPENSION_PRICE = 7000.0;
    private static final Double DEFAULT_BRAKES_PRICE = 4000.0;
    private static final Double DEFAULT_REPAIR_PREMIUM_MULTIPLIER= 1.5;
    private static final Double DEFAULT_REPAIR_STANDARD_MULTIPLIER= 1.25;
    private static final Double DEFAULT_REPAIR_BUDGET_MULTIPLIER= 1.0;
    public ArrayList<RepairHistory> repairHistory = new ArrayList<>();

    public Janusz(String name) {
        super(name);
    }

    public Double getPriceOfRepair(Dealer car, int i, String part){
        return priceOfRepair(car, i, part);
    }

    public void addRepairCosts(Dealer car, int i, Double price){
        car.getCar(i).addRepairCosts(price);
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


    @Override
    public void repair(Dealer car, int i, String part) {

        switch(part){
            case "engine":
                if(car.getCar(i).getParts().isInGoodCondition(car.getCar(i).getParts().getEngine())){
                car.getCar(i).getParts().setEngine();
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                car.getCar(i).setValue(car.getCar(i).getValue()*2);
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                addRepairCosts(car,i,priceOfRepair(car,i,part));
                repairHistory.add(new RepairHistory(this,car,car.getCar(i),part,priceOfRepair(car,i,part), LocalDateTime.now()));}
                break;
            case "gearbox":
                if(car.getCar(i).getParts().isInGoodCondition(car.getCar(i).getParts().getGearbox())){
                car.getCar(i).getParts().setGearbox();
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                addRepairCosts(car,i,priceOfRepair(car,i,part));
                repairHistory.add(new RepairHistory(this,car,car.getCar(i),part,priceOfRepair(car,i,part), LocalDateTime.now()));}
                break;
            case "suspension":
                if(car.getCar(i).getParts().isInGoodCondition(car.getCar(i).getParts().getSuspension())){
                car.getCar(i).getParts().setSuspension();
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                car.getCar(i).setValue(car.getCar(i).getValue()*1.2);
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                addRepairCosts(car,i,priceOfRepair(car,i,part));
                repairHistory.add(new RepairHistory(this,car,car.getCar(i),part,priceOfRepair(car,i,part), LocalDateTime.now()));}
                break;
            case "carbody":
                if(car.getCar(i).getParts().isInGoodCondition(car.getCar(i).getParts().getCarBody())){
                car.getCar(i).getParts().setCarBody();
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair car body");
                addRepairCosts(car,i,priceOfRepair(car,i,part));
                repairHistory.add(new RepairHistory(this,car,car.getCar(i),part,priceOfRepair(car,i,part), LocalDateTime.now()));}
                break;
            case "brakes":
                if(car.getCar(i).getParts().isInGoodCondition(car.getCar(i).getParts().getBrakes())){
                car.getCar(i).getParts().setBrakes();
                car.setCash(car.getCash() - priceOfRepair(car,i,part));
                car.getCar(i).setValue(car.getCar(i).getValue()*1.1);
                System.out.println("You spent "+priceOfRepair(car,i,part)+" to repair the "+part);
                addRepairCosts(car,i,priceOfRepair(car,i,part));
                repairHistory.add(new RepairHistory(this,car,car.getCar(i),part,priceOfRepair(car,i,part), LocalDateTime.now()));}
                break;
            default:
                System.out.println("Invalid number");
        }


    }

}
