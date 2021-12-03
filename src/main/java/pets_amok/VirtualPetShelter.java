package pets_amok;

import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class VirtualPetShelter {
    ConcurrentHashMap<String, VirtualPet> petList = new ConcurrentHashMap<>();

    public Collection<VirtualPet> getAllPetValues() {
        return petList.values();
    }

    public void getDescriptionsOfAllPets() {
        for (VirtualPet pet : petList.values()) {
            System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase(Locale.ROOT) + " who is currently " + pet.activityStatus().toLowerCase().trim() + " and loves to play.");
        }
    }

    public void add(VirtualPet petToAdd) {
        petList.put(petToAdd.getName(), petToAdd);
    }

    public VirtualPet getPetByName(String petName) {
        return petList.get(petName);
    }

    public void adopt(VirtualPet petToRemove) {
        petList.remove(petToRemove.getName(), petToRemove);
    }

    public void showPetMapAsNumbers() {
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t______________________________________________");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tThis is the status of the pets in the shelter:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("" +
                "|Health\t\t|Oil\t\t|Hunger\t\t|Thirst\t\t |Waste\t\t\t|Cage\t\t|LitterBox\t|Happy\t\t|Sleepy\t\t|Activity\t\t|Type\t\t|Species\t|Name\n" +
                "------------|-----------|-----------|------------|--------------|-----------|-----------|-----------|-----------|---------------|-----------|-----------|-----------");
        for (VirtualPet pet : getAllPetValues()) {
            if (pet instanceof OrganicDog) {
                System.out.println("| " + pet.getHealthLevel() + "\t\t|\t\t\t| " + ((OrganicDog) pet).getHungerLevel() + "\t\t| " + ((OrganicDog) pet).getThirstLevel() + " \t\t | " + ((OrganicDog) pet).getWasteLevel() + "\t\t\t| " + ((OrganicDog) pet).getCageCleanlinessLevel() + "\t\t|\t\t\t| " + pet.getHappinessLevel() + "\t\t| " + ((OrganicDog) pet).getSleepinessLevel() + "\t\t| " + pet.getActivityLevel() + "\t\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof OrganicCat) {
                System.out.println("| " + pet.getHealthLevel() + "\t\t|\t\t\t| " + ((OrganicCat) pet).getHungerLevel() + "\t\t| " + ((OrganicCat) pet).getThirstLevel() + "\t\t | " + ((OrganicCat) pet).getWasteLevel() + "\t\t\t|\t\t\t| " + ((OrganicCat) pet).getLitterBoxCleanlinessLevel() + "\t\t| " + pet.getHappinessLevel() + "\t\t| " + ((OrganicCat) pet).getSleepinessLevel() + "\t\t| " + pet.getActivityLevel() + "\t\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof RoboticDog) {
                System.out.println("| " + pet.getHealthLevel() + "\t\t| " + ((RoboticDog) pet).getOilLevel() + "\t\t|\t\t\t|\t\t\t |\t\t\t\t|\t\t\t|\t\t\t| " + pet.getHappinessLevel() + "\t\t|\t\t\t| " + pet.getActivityLevel() + "\t\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof RoboticCat) {
                System.out.println("| " + pet.getHealthLevel() + "\t\t| " + ((RoboticCat) pet).getOilLevel() + "\t\t|\t\t\t|\t\t\t |\t\t\t\t|\t\t\t|\t\t\t| " + pet.getHappinessLevel() + "\t\t|\t\t\t| " + pet.getActivityLevel() + "\t\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t______________________________________________\n\n");
    }

    public void showPetMapAsStatuses() {
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t______________________________________________");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tThis is the status of the pets in the shelter:");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("" +
                "|Health\t\t|Oil\t\t|Hunger\t\t|Thirst\t\t |Waste\t\t\t|Cage\t\t|LitterBox\t|Happy\t\t|Sleepy\t\t|Activity\t\t|Type\t\t|Species\t|Name\n" +
                "------------|-----------|-----------|------------|--------------|-----------|-----------|-----------|-----------|---------------|-----------|-----------|-----------");
        for (VirtualPet pet : getAllPetValues()) {
            if (pet instanceof OrganicDog) {
                System.out.println("| " + pet.healthStatus() + "\t|\t\t\t| " + ((OrganicDog) pet).hungerStatus() + "\t| " + ((OrganicDog) pet).thirstStatus() + " | " + ((OrganicDog) pet).wasteStatus() + "\t| " + ((OrganicDog) pet).cageStatus() + "\t|\t\t\t| " + pet.happinessStatus() + "\t| " + ((OrganicDog) pet).sleepinessStatus() + "\t| " + pet.activityStatus() + "\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof OrganicCat) {
                System.out.println("| " + pet.healthStatus() + "\t|\t\t\t| " + ((OrganicCat) pet).hungerStatus() + "\t| " + ((OrganicCat) pet).thirstStatus() + " | " + ((OrganicCat) pet).wasteStatus() + "\t|\t\t\t| " + ((OrganicCat) pet).litterBoxStatus() + "\t| " + pet.happinessStatus() + "\t| " + ((OrganicCat) pet).sleepinessStatus() + "\t| " + pet.activityStatus() + "\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof RoboticDog) {
                System.out.println("| " + pet.healthStatus() + "\t| " + ((RoboticDog) pet).getOilStatus() + "\t|\t\t\t|\t\t\t |\t\t\t\t|\t\t\t|\t\t\t| " + pet.happinessStatus() + "\t|\t\t\t| " + pet.activityStatus() + "\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof RoboticCat) {
                System.out.println("| " + pet.healthStatus() + "\t| " + ((RoboticCat) pet).getOilStatus() + "\t|\t\t\t|\t\t\t |\t\t\t\t|\t\t\t|\t\t\t| " + pet.happinessStatus() + "\t|\t\t\t| " + pet.activityStatus() + "\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t______________________________________________\n\n");
    }

    public void showPetMapAsStatusesWithHealthPercentage() {
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t______________________________________________");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tThis is the status of the pets in the shelter:");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("" +
                "|Health\t|Oil\t\t|Hunger\t\t|Thirst\t\t |Waste\t\t\t|Cage\t\t|LitterBox\t|Happy\t\t|Sleepy\t\t|Activity\t\t|Type\t\t|Species\t|Name\n" +
                "--------|-----------|-----------|------------|--------------|-----------|-----------|-----------|-----------|---------------|-----------|-----------|-----------");
        for (VirtualPet pet : getAllPetValues()) {
            if (pet instanceof OrganicDog) {
                System.out.println("| " + pet.getHealthLevel() + "%" + "\t|\t\t\t| " + ((OrganicDog) pet).hungerStatus() + "\t| " + ((OrganicDog) pet).thirstStatus() + " | " + ((OrganicDog) pet).wasteStatus() + "\t| " + ((OrganicDog) pet).cageStatus() + "\t|\t\t\t| " + pet.happinessStatus() + "\t| " + ((OrganicDog) pet).sleepinessStatus() + "\t| " + pet.activityStatus() + "\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof OrganicCat) {
                System.out.println("| " + pet.getHealthLevel() + "%" + "\t|\t\t\t| " + ((OrganicCat) pet).hungerStatus() + "\t| " + ((OrganicCat) pet).thirstStatus() + " | " + ((OrganicCat) pet).wasteStatus() + "\t|\t\t\t| " + ((OrganicCat) pet).litterBoxStatus() + "\t| " + pet.happinessStatus() + "\t| " + ((OrganicCat) pet).sleepinessStatus() + "\t| " + pet.activityStatus() + "\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof RoboticDog) {
                System.out.println("| " + pet.getHealthLevel() + "%" + "\t| " + ((RoboticDog) pet).getOilStatus() + "\t|\t\t\t|\t\t\t |\t\t\t\t|\t\t\t|\t\t\t| " + pet.happinessStatus() + "\t|\t\t\t| " + pet.activityStatus() + "\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
            if (pet instanceof RoboticCat) {
                System.out.println("| " + pet.getHealthLevel() + "%" + "\t| " + ((RoboticCat) pet).getOilStatus() + "\t|\t\t\t|\t\t\t |\t\t\t\t|\t\t\t|\t\t\t| " + pet.happinessStatus() + "\t|\t\t\t| " + pet.activityStatus() + "\t\t| " + pet.getType() + "\t| " + pet.getSpecies() + "\t\t| " + pet.getName());
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t______________________________________________\n\n");
    }

    public void tick() {
        for (VirtualPet pet : petList.values()) {
            pet.tick();
        }
    }

    public void feedAll() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).feed();
            }
        }
    }

    public void waterAll() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).water();
            }
        }
    }

    public void playAll() {
        for (VirtualPet pet : petList.values()) {
            pet.play();

        }
    }

    public void cuddleAll() {
        for (VirtualPet pet : petList.values()) {
            pet.cuddle();

        }
    }

    public void vetAll() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).goToVet();
            }
        }
    }

    public void repairAll() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof RobotPet) {
                ((RobotPet) pet).repair();
            }
        }
    }

    public void pottyAll() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).goPotty();
            }
        }
    }

    public void sleepAll() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).sleep();
            }
        }
    }

    public void notFunctioning() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof RobotPet) {
                if (!((RobotPet) pet).isPetFunctioning()) {
                    petList.remove(pet.getName(), pet);
                    System.out.println("" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\td[x_X]b");
                    System.out.println("\t\t\t\t\t\t\t >>>>>>>>>> OH NO! " + pet.getName().toUpperCase() + " HAS DIED! <<<<<<<<<<<<<<");
                }
            }
        }
    }

    public void oilAllRobots() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof RobotPet) {
                ((RobotPet) pet).addOil();
            }
        }
    }

    public void cleanAllCages() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof OrganicDog) {
                ((OrganicDog) pet).cleanCage();
            }
        }
    }

    public void cleanAllLitterBoxes() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof OrganicCat) {
                ((OrganicCat) pet).cleanLitterBox();
            }
        }
    }

    public void walkAllDogs() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof Dog) {
                ((Dog) pet).goForAWalk();
            }
        }
    }

    public void playWithAllCatsToy() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof Cat) {
                ((Cat) pet).playWithCatToy();
            }
        }
    }

    public void unAlive() {
        for (VirtualPet pet : petList.values()) {
            if (pet instanceof OrganicPet) {
                if (!((OrganicPet) pet).isPetAlive()) {
                    petList.remove(pet.getName(), pet);
                    System.out.println("" +
                            "                                                     ...\n" +
                            "                                                   ;::::;\n" +
                            "                                                 ;::::; :;\n" +
                            "                                               ;:::::'   :;\n" +
                            "                                              ;:::::;     ;.\n" +
                            "                                             ,:::::'       ;           OOO\\\n" +
                            "                                             ::::::;       ;          OOOOO\\\n" +
                            "                                             ;:::::;       ;         OOOOOOOO\n" +
                            "                                            ,;::::::;     ;'         / OOOOOOO\n" +
                            "                                          ;:::::::::`. ,,,;.        /  / DOOOOOO\n" +
                            "                                        .';:::::::::::::::::;,     /  /     DOOOO\n" +
                            "                                       ,::::::;::::::;;;;::::;,   /  /        DOOO\n" +
                            "                                      ;`::::::`'::::::;;;::::: ,#/  /          DOOO\n" +
                            "                                      :`:::::::`;::::::;;::: ;::#  /            DOOO\n" +
                            "                                      ::`:::::::`;:::::::: ;::::# /              DOO\n" +
                            "                                      `:`:::::::`;:::::: ;::::::#/               DOO\n" +
                            "                                       :::`:::::::`;; ;:::::::::##                OO\n" +
                            "                                       ::::`:::::::`;::::::::;:::#                OO\n" +
                            "                                       `:::::`::::::::::::;'`:;::#                O\n" +
                            "                                        `:::::`::::::::;' /  / `:#\n" +
                            "                                         ::::::`:::::;'  /  /   `#");
                    System.out.println("\t\t\t\t\t\t\t >>>>>>>>>> OH NO! " + pet.getName().toUpperCase() + " HAS DIED! <<<<<<<<<<<<<<");
                }
            }
        }
    }
}

