package com.company.vehicles;


import java.util.Random;

public class Parts {

    private boolean engine;
    private boolean gearbox;
    private boolean suspension;
    private boolean tires;
    private boolean brakes;



    public Parts(){
        this.engine = isDamaged(new Random().nextBoolean());
        this.gearbox = isDamaged(new Random().nextBoolean());
        this.suspension = isDamaged(new Random().nextBoolean());
        this.tires = isDamaged(new Random().nextBoolean());
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
    public void setTires(){
        this.tires = isDamaged(true);
    }
    public void setBrakes(){
        this.brakes = isDamaged(true);
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
    public String getTires(){
        if(!this.suspension){
            return "Damaged";
        }else{
            return "Good";
        }
    }
    public String getBrakes(){
        if(!this.suspension){
            return "Damaged";
        }else{
            return "Good";
        }
    }

    public String getAllParts(){
        return " Engine: " + getEngine() + " | Gearbox: " + getGearbox()+ " | Suspension: " + getSuspension()+ " | Tires: " + getTires() + " | Brakes: " + getBrakes();
    }

    public String toString() {

        return getAllParts();
    }

}
