package com.company.vehicles;

import java.util.Random;

public class Parts {

    private boolean engine;
    private boolean gearbox;
    private boolean suspension;
    private boolean carBody;
    private boolean brakes;



    public Parts(){
        this.engine = isDamaged(new Random().nextBoolean());
        this.gearbox = isDamaged(new Random().nextBoolean());
        this.suspension = isDamaged(new Random().nextBoolean());
        this.carBody = isDamaged(new Random().nextBoolean());
        this.brakes = isDamaged(new Random().nextBoolean());
    }
    public void setEngine(){
        this.engine = isDamaged(true);
    }
    public void setGearbox(){
        this.gearbox = isDamaged(true);
    }
    public void setSuspension(){
        this.suspension = isDamaged(true);
    }
    public void setCarBody(){
        this.carBody = isDamaged(true);
    }
    public void setBrakes(){
        this.brakes = isDamaged(true);
    }

    public void setEngineDamage(){
        this.engine = isDamaged(false);
        System.out.println("Engine has been damaged!");
    }
    public void setGearboxDamage(){
        this.gearbox = isDamaged(false);
        System.out.println("Gearbox has been damaged!");
    }
    public void setSuspensionDamage(){
        this.suspension = isDamaged(false);
        System.out.println("Suspension has been damaged!");
    }
    public void setCarBodyDamage(){
        this.carBody = isDamaged(false);
        System.out.println("CarBody has been damaged!");
    }
    public void setBrakesDamage(){
        this.brakes = isDamaged(false);
        System.out.println("Brakes has been damaged!");
    }

    public boolean isDamaged(boolean a){
        return a;
    }

    public String getEngine(){
        if(!this.engine){
            return "Damaged";
        }else{
            return "Good";
        }
    }
    public String getGearbox(){
        if(!this.gearbox){
            return "Damaged";
        }else{
            return "Good";
        }
    }
    public String getSuspension(){
        if(!this.suspension){
            return "Damaged";
        }else{
            return "Good";
        }
    }
    public String getCarBody(){
        if(!this.carBody){
            return "Damaged";
        }else{
            return "Good";
        }
    }
    public String getBrakes(){
        if(!this.brakes){
            return "Damaged";
        }else{
            return "Good";
        }
    }

    public String getAllParts(){
        return " Engine: " + getEngine() + " | Gearbox: " + getGearbox()+ " | Suspension: " + getSuspension()+ " | Car body: " + getCarBody() + " | Brakes: " + getBrakes();
    }

    public String toString() {

        return getAllParts();
    }

}
