package com.company;

import com.company.humans.Human;
import com.company.mechanics.Adrian;
import com.company.mechanics.Janusz;
import com.company.mechanics.Marian;
import com.company.store.Database;
import com.company.store.Dealer;
import com.company.vehicles.Car;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Game {


    public void StartGame() {
        int selection = 0;
        int index = 0;
        int carId = -1;
        int clientId = 0;
        int key = 0;
        int part = 0;
        int numberOfTurns = 0;
        String partName;
        String adType;


        Scanner in = new Scanner(System.in);
        Dealer myShop = new Dealer("Car Dealer", 50000.0);
        Database database = new Database();
        Janusz mechanic1 = new Janusz("Janusz");
        Marian mechanic2 = new Marian("Marian");
        Adrian mechanic3 = new Adrian("Adrian");
        double startCash=myShop.getCash();
        for (int i = 0; i < 10; i++) {
            database.carsDB.add(new Car());
        }
        for (int i = 0; i < 5; i++) {
            database.clientDB.add(new Human());
        }
        database.setParts();

        do {
            System.out.println("[1] My shop");
            System.out.println("[2] Show cars available for purchase");
            System.out.println("[3] Sell a car");
            System.out.println("[4] Car mechanic");
            System.out.println("[5] Wait a week for a new delivery of cars to the database");
            System.out.println("[9] Exit");
            System.out.println();
            System.out.println("Turn: " + numberOfTurns);
            selection = in.nextInt();

            switch (selection) {
                case 1:
                    do {
                        System.out.println("[1] Show my cars");
                        System.out.println("[2] Display balance");
                        System.out.println("[3] Transaction history");
                        System.out.println("[4] Buy advertisement");
                        System.out.println("[5] Back");
                        key = in.nextInt();
                        switch (key) {
                            case 1:
                              do{
                                    System.out.println(myShop.dealerCars);
                                    System.out.println();
                                    System.out.println("[1] Select car");
                                    System.out.println("[2] Check car costs");
                                    System.out.println("[3] Repair history of all cars");
                                    System.out.println("[4] Car wash");
                                    System.out.println("[5] Back");
                                    part = in.nextInt();
                                    switch (part) {
                                        case 1:
                                            if(!myShop.dealerCars.isEmpty()) {
                                                System.out.println(myShop.dealerCars);
                                                System.out.println("Select a car index :");
                                                carId = in.nextInt()-1;
                                            }else{
                                                System.out.println("You don't have a car!\n");
                                            }
                                            break;
                                        case 2:
                                            if (carId!=-1) {
                                                do {
                                                    System.out.println("[1] Show costs of car repair");
                                                    System.out.println("[2] Show car washing costs");
                                                    System.out.println("[3] Back");
                                                    index = in.nextInt();
                                                    switch (index) {
                                                        case 1:
                                                            System.out.println("You spent to repair the car: "+ myShop.getCarRepairCosts(carId)+"$\n");
                                                            break;
                                                        case 2:
                                                            System.out.println("You spent on car washing: "+ myShop.getCarWashCosts(carId)+"$\n");
                                                            break;
                                                        case 3:
                                                            System.out.println("------------------");
                                                            break;
                                                        default:
                                                            System.out.println("Invalid number");
                                                    }
                                                } while (index != 3);
                                            } else {
                                                System.out.println("You didn't choose the car!\n");
                                            }
                                        case 3:
                                            System.out.println("Repair history of your cars:");
                                            myShop.allRepairs(mechanic1.repairHistory,mechanic2.repairHistory,mechanic3.repairHistory);
                                            System.out.println(myShop.allRepairHistory);
                                            break;
                                        case 4:
                                            myShop.carWash(carId);
                                            break;
                                        case 5:
                                            System.out.println("------------------");
                                            break;
                                        default:
                                            System.out.println("Invalid number");
                                    }
                                } while (part != 5);
                                break;
                            case 2:
                                System.out.println("You have: "+decimalFormat(myShop.getCash())+"$\n");
                                break;
                            case 3:
                                System.out.println("Your transaction history: ");
                                System.out.println(myShop.transactionHistory);
                                break;
                            case 4:
                                do{
                                    System.out.println("Select the type of ad:         "+ "Your money: " + decimalFormat(myShop.getCash()) + "$");
                                    System.out.println("[1] Advertisement in a local newspaper ---- 30000.0$");
                                    System.out.println("[2] Internet advertising ---- 4000.0$");
                                    System.out.println("[3] Back");
                                    part = in.nextInt();
                                    switch (part) {
                                        case 1:
                                            adType = "Newspaper";
                                            myShop.ad(adType,database);
                                            numberOfTurns++;
                                            break;
                                        case 2:
                                            adType = "Internet";
                                            myShop.ad(adType,database);
                                            numberOfTurns++;
                                            break;
                                        case 3:
                                            System.out.println("------------------");
                                            break;
                                        default:
                                            System.out.println("Invalid number");
                                    }
                                } while (part != 3);
                                break;
                            case 5:
                                System.out.println("------------------");
                                break;
                            default:
                                System.out.println("Invalid number");
                        }
                    } while (key != 5);
                    break;
                case 2:
                    do {
                        System.out.println("[1] Show cars");
                        System.out.println("[2] Buy a car");
                        System.out.println("[3] Back");
                        key = in.nextInt();
                        switch (key) {
                            case 1:
                                System.out.println(database.carsDB);
                                break;
                            case 2:
                                System.out.println("Select a car index:             Your money: "+decimalFormat(myShop.getCash())+"$");
                                index = in.nextInt()-1;
                                try {
                                    myShop.buy(database, index);
                                    numberOfTurns++;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("------------------");
                                break;
                            default:
                                System.out.println("Invalid number");
                        }
                    } while (key != 3);
                    break;
                case 3:
                    do {
                        System.out.println("[1] Review potential customers");
                        System.out.println("[2] Sell the car to the customer");
                        System.out.println("[3] Back");
                        key = in.nextInt();
                        switch (key) {
                            case 1:
                                System.out.println("Your potential customers: ");
                                System.out.println(database.clientDB);
                                break;
                            case 2:
                                System.out.println(myShop.dealerCars);
                                System.out.println("Select a car index :");
                                carId = in.nextInt()-1;
                                System.out.println("Select customer index :");
                                clientId = in.nextInt()-1;
                                try {
                                    myShop.sell(database, carId, clientId);
                                    numberOfTurns++;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("------------------");
                                break;

                            default:
                                System.out.println("Invalid number");
                        }
                    } while (key != 3);
                    break;
                case 4:
                    do {
                        System.out.println("Choose car:");
                        System.out.println("[1] Select car");
                        System.out.println("Pick a mechanic:");
                        System.out.println("[2] Mechanic Janusz");
                        System.out.println("[3] Mechanic Marian");
                        System.out.println("[4] Mechanic Adrian");
                        System.out.println("[5] Back");
                        key = in.nextInt();
                        switch (key) {
                            case 1:
                                System.out.println(myShop.dealerCars);
                                if(!myShop.dealerCars.isEmpty()) {
                                    System.out.println("Select a car index :");
                                    carId = in.nextInt()-1;
                                }else{
                                    System.out.println("You don't have a car!\n");
                                }
                                break;
                            case 2:
                                if (carId!=-1) {
                                    do {
                                        System.out.println("[1] Show car parts");
                                        System.out.println("Select the part to be repaired:    " + "Your money: " + decimalFormat(myShop.getCash()) + "$");
                                        System.out.println("[2] Engine --- " + mechanic1.getPriceOfRepair(myShop,carId,"engine")+"$");
                                        System.out.println("[3] Gearbox --- "+ mechanic1.getPriceOfRepair(myShop,carId,"gearbox")+"$");
                                        System.out.println("[4] Suspension --- "+ mechanic1.getPriceOfRepair(myShop,carId,"suspension")+"$");
                                        System.out.println("[5] Car body --- "+ mechanic1.getPriceOfRepair(myShop,carId,"carbody")+"$");
                                        System.out.println("[6] Brakes --- "+ mechanic1.getPriceOfRepair(myShop,carId,"brakes")+"$");
                                        System.out.println("[7] Janusz repair history");
                                        System.out.println("[8] Back");
                                        part = in.nextInt();
                                        switch (part) {
                                            case 1:
                                                System.out.println(myShop.getCar(carId).getParts());
                                                break;
                                            case 2:
                                                partName = "engine";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 3:
                                                partName = "gearbox";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 4:
                                                partName = "suspension";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 5:
                                                partName = "carbody";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 6:
                                                partName = "brakes";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 7:
                                                System.out.println(mechanic1.repairHistory);
                                                break;
                                            case 8:
                                                System.out.println("------------------");
                                                break;

                                            default:
                                                System.out.println("Invalid number");
                                        }
                                    } while (part != 8);
                                } else {
                                    System.out.println("You didn't choose the car!\n");
                                }
                                break;
                            case 3:
                                if (carId!=-1) {
                                    do {
                                        System.out.println("[1] Show car parts");
                                        System.out.println("Select the part to be repaired:    " + "Your money: " + decimalFormat(myShop.getCash())+ "$");
                                        System.out.println("[2] Engine --- " + mechanic2.getPriceOfRepair(myShop,carId,"engine")+"$");
                                        System.out.println("[3] Gearbox --- "+ mechanic2.getPriceOfRepair(myShop,carId,"gearbox")+"$");
                                        System.out.println("[4] Suspension --- "+ mechanic2.getPriceOfRepair(myShop,carId,"suspension")+"$");
                                        System.out.println("[5] Car body --- "+ mechanic2.getPriceOfRepair(myShop,carId,"carbody")+"$");
                                        System.out.println("[6] Brakes --- "+ mechanic2.getPriceOfRepair(myShop,carId,"brakes")+"$");
                                        System.out.println("[7] Marian repair history");
                                        System.out.println("[8] Back");
                                        part = in.nextInt();
                                        switch (part) {
                                            case 1:
                                                System.out.println(myShop.getCar(carId).getParts());
                                                break;
                                            case 2:
                                                partName = "engine";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 3:
                                                partName = "gearbox";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 4:
                                                partName = "suspension";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 5:
                                                partName = "carbody";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 6:
                                                partName = "brakes";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 7:
                                                System.out.println(mechanic2.repairHistory);
                                                break;
                                            case 8:
                                                System.out.println("------------------");
                                                break;

                                            default:
                                                System.out.println("Invalid number");
                                        }
                                    } while (part != 8);
                                } else {
                                    System.out.println("You didn't choose the car!\n");
                                }
                                break;
                            case 4:
                                if (carId!=-1) {
                                    do {
                                        System.out.println("[1] Show car parts");
                                        System.out.println("Select the part to be repaired:    " + "Your money: " + decimalFormat(myShop.getCash()) + "$");
                                        System.out.println("[2] Engine --- 10,000$");
                                        System.out.println("[3] Gearbox --- 5,000$");
                                        System.out.println("[4] Suspension --- 2,000$");
                                        System.out.println("[5] Car body --- 5,000$");
                                        System.out.println("[6] Brakes --- 1,000$");
                                        System.out.println("[7] Adrian repair history");
                                        System.out.println("[8] Back");
                                        part = in.nextInt();
                                        switch (part) {
                                            case 1:
                                                System.out.println(myShop.getCar(carId).getParts());
                                                break;
                                            case 2:
                                                partName = "engine";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 3:
                                                partName = "gearbox";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 4:
                                                partName = "suspension";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 5:
                                                partName = "carbody";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 6:
                                                partName = "brakes";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 7:
                                                System.out.println(mechanic1.repairHistory);
                                                break;
                                            case 8:
                                                System.out.println("------------------");
                                                break;

                                            default:
                                                System.out.println("Invalid number");
                                        }
                                    } while (part != 8);
                                } else {
                                    System.out.println("You didn't choose the car!\n");
                                }
                                break;
                            case 5:
                                System.out.println("------------------");
                                break;


                            default:
                                System.out.println("Invalid number");
                        }
                    } while (key != 5);
                    break;
                case 5:
                    database.waitAWeek();
                    numberOfTurns++;
                    break;
                case 9:
                    System.out.println("________________");

                    break;
                default:
                    System.out.println("Invalid number");
            }
            if(myShop.getCash()>=startCash*2)
            {
                System.out.println("~~~~ You won the game! ~~~~");
                System.out.println("Number of turns you have made: "+ numberOfTurns);
                break;

            }
        } while (selection != 9);


    }

    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }

}




