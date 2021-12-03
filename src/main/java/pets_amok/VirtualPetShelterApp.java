package pets_amok;

import java.util.Locale;
import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userPetMapChoice;
        String userChoice;
        String petChoice;
        String userPetSpecies;
        String userPetType;
        String inputPetName;
        String inputPetSize;
        String inputPetColor;

        OrganicDog organicDogOne = new OrganicDog("Buddy", "small", "white", "", "", 91, 121, 99, 21, 79, 111, 39, 64);
        OrganicCat organicCatOne = new OrganicCat("Scar", "tiny", "black", "", "", 76, 99, 121, 13, 82, 87, 27, 36);
        RoboticDog roboticDogOne = new RoboticDog("Fido", "large", "pink", "", "", 92, 99, 97, 51);
        RoboticCat roboticCatOne = new RoboticCat("Simba", "medium", "purple", "", "", 77, 92, 82, 19);
        VirtualPetShelter myShelter = new VirtualPetShelter();
        myShelter.add(organicDogOne);
        myShelter.add(organicCatOne);
        myShelter.add(roboticDogOne);
        myShelter.add(roboticCatOne);


        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\tThank you for volunteering at Big Al's Virtual Pet Shelter and Delicatessen!\n");
        System.out.println("" +
                "\t\t\t\t\t\t                                   +&-\n" +
                "\t\t\t\t\t\t                                                            _.-^-._    .--.\n" +
                "\t\t\t\t\t\t                                                         .-'   _   '-. |__|\n" +
                "\t\t\t\t\t\t                                                        /     |_|     \\|  |\n" +
                "\t\t\t\t\t\t                                                       /               \\  |\n" +
                "\t\t\t\t\t\t                                                      /|     _____     |\\ |\n" +
                "\t\t\t\t\t\t                                                       |    |==|==|    |  |\n" +
                "\t\t\t\t\t\t                                   |---|---|---|---|---|    |--|--|    |  |\n" +
                "\t\t\t\t\t\t                                   |---|---|---|---|---|    |==|==|    |  |\n\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Let's get started!");

        System.out.println("How do you wish to view your shelter? With numbers or statuses? Or both?\n" +
                "1. Numbers only\n" +
                "2. Statuses only\n" +
                "3. Combination");
        userPetMapChoice = input.nextLine();

        do {
            //Choose Pet Map Format
            if (userPetMapChoice.equals("1")) {
                myShelter.showPetMapAsNumbers();
            } else if (userPetMapChoice.equals("2")) {
                myShelter.showPetMapAsStatuses();
            } else {
                myShelter.showPetMapAsStatusesWithHealthPercentage();
            }

            System.out.println("\t\t >>> What would you like to do next? <<<");
            System.out.println("1.  Feed all organic pets\t\t8.  Admit a pet\n" +
                    "2.  Water all organic pets\t\t9.  Heal or repair pet(s)\n" +
                    "3.  Walk all dogs\t\t\t\t10. Oil all robotic pets\n" +
                    "4.  Bring out the cat toys\t\t11. Let the pets out to go potty\n" +
                    "5.  Play with pet(s)\t\t\t12. Clean all dog cages\n" +
                    "6.  Cuddle with pet(s)\t\t\t13. Clean all cat litter boxes\n" +
                    "7.  Adopt a pet\t\t\t\t\t14. Lights out! Organic pet bed time\n" +
                    "\t\t\t\t\t\t15. Quit");

            userChoice = input.nextLine();
            System.out.println("\n");

            //Feed All Pets
            if (userChoice.equals("1")) {
                myShelter.feedAll();
                System.out.println("You've fed the pets! Their bellies are happy!");
            }

            //Water All Pets
            if (userChoice.equals("2")) {
                myShelter.waterAll();
                System.out.println("You've watered the pets! Feeling hydrated!");
            }

            //Walk All Dogs
            if (userChoice.equals("3")) {
                myShelter.walkAllDogs();
                System.out.println("All the doggys are happy, worn out and less likely to soil their cages after their walk.");
            }

            //Play with cat toys
            if (userChoice.equals("4")) {
                myShelter.playWithAllCatsToy();
                System.out.println("The cats stare curiously at the fake mouse slinking across the floor, tails wag. Ready to pounce.");
            }

            //Play with Pets
            if (userChoice.equals("5")) {
                System.out.println("Ok, so you'd like to play with a pet. Please choose a pet by typing in the pet's name or type \"all\": \n");
                myShelter.getDescriptionsOfAllPets();

                petChoice = input.nextLine();
                System.out.println("\n");

                if (petChoice.equals("all")) {
                    myShelter.playAll();
                    System.out.println("Your pets love playing with you!");
                } else {
                    myShelter.petList.get(petChoice).play();
                    if (myShelter.petList.get(petChoice) instanceof Dog) {
                        myShelter.petList.get(petChoice).play();
                        System.out.println(petChoice + "'s tails wagging as they chase the frisbee.");
                    } else {
                        System.out.println(petChoice + "'s rubbing against your leg, purring.");
                    }
                }
            }

            // Cuddle pet
            if (userChoice.equals("6")) {
                System.out.println("Which pet needs some cuddles? Please choose a pet by typing in the pet's name or type \"all\": \n");
                for (VirtualPet pet : myShelter.getAllPetValues()) {
                    System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase() + ".");
                }
                petChoice = input.nextLine();
                System.out.println("\n");

                if (petChoice.equals("all")) {
                    myShelter.cuddleAll();
                    System.out.println("Your pets loves snuggling with you!");
                } else {
                    myShelter.petList.get(petChoice).cuddle();
                    System.out.println(petChoice + " is snuggling closer to you, never wanting to leave your side!");
                }
            }

            //Adopt a Pet
            if (userChoice.equals("7")) {
                System.out.println("Ok, so you'd like to adopt a pet. Please enter the name of the pet you wish to adopt.");
                myShelter.getDescriptionsOfAllPets();
                String petToAdoptName = input.nextLine();
                System.out.println("\n");

                VirtualPet petToAdopt = myShelter.getPetByName(petToAdoptName);
                myShelter.adopt(petToAdopt);
                System.out.println("You've adopted " + petToAdoptName + "!");
            }

            //Admit a Pet
            if (userChoice.equals("8")) {
                System.out.println("Are you admitting an organic pet or a robot pet?\n" +
                        "1. Organic Pet\n" +
                        "2. Robot Pet");
                userPetType = input.nextLine();
                System.out.println("\n");

                System.out.println("Is this pet a dog or cat? " +
                        "Enter either \"dog\" or \"cat\" to make your selection.");
                userPetSpecies = input.nextLine();
                System.out.println("\n");

                System.out.println("Please enter your " + userPetSpecies + "'s name: ");
                inputPetName = input.nextLine();
                System.out.println("\n");

                System.out.println("Enter " + inputPetName + "'s description in the following order, pressing \"Enter\" after each requirement: " +
                        "\nSize" +
                        "\nColor");
                inputPetSize = input.nextLine();
                inputPetColor = input.nextLine();
                System.out.println("\n");

                // Admit Organic Pet
                if (userPetType.equals("1")) {
                    if (userPetSpecies.equals("dog")) { // Admit Organic Dog
                        OrganicDog newOrganicDog = new OrganicDog(inputPetName, inputPetSize, inputPetColor, "", "", 100, 100, 100, 0, 100, 100, 0, 25);
                        myShelter.add(newOrganicDog);
                    } else if (userPetSpecies.equals("cat")) { // Admit Organic Cat
                        OrganicCat newOrganicCat = new OrganicCat(inputPetName, inputPetSize, inputPetColor, "", "", 100, 100, 100, 0, 100, 70, 40, 15);
                        myShelter.add(newOrganicCat);
                    }
                }

                // Admit Robot Pet
                else if (userPetType.equals("2")) {
                    if (userPetSpecies.equals("dog")) { // Admit Robotic Dog
                        RoboticDog newRoboticDog = new RoboticDog(inputPetName, inputPetSize, inputPetColor, "", "", 100, 100, 100, 25);
                        myShelter.add(newRoboticDog);
                    } else if (userPetSpecies.equals("2")) { // Admit Robotic Cat
                        RoboticCat newRoboticCat = new RoboticCat(inputPetName, inputPetSize, inputPetColor, "", "", 100, 100, 100, 0);
                        myShelter.add(newRoboticCat);
                    }
                }
            }

            // Heal pets
            if (userChoice.equals("9")) {
                System.out.println("Do you need to heal an organic pet, or repair a robotic pet?\n" +
                        "1. Heal Organic Pet\n" +
                        "2. Repair Robotic Pet");
                userChoice = input.nextLine();
                System.out.println("\n");

                // Heal Organic Pet
                if (userChoice.equals("1")) {
                    System.out.println("\nWhich organic pet needs a vet visit? Please choose one by typing in the pet's name or type \"all\": \n");
                    for (VirtualPet pet : myShelter.getAllPetValues()) {
                        if (pet instanceof OrganicPet) {
                            System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase(Locale.ROOT) + ".");
                        }
                    }
                    petChoice = input.nextLine();
                    System.out.println("\n");

                    // Heal ALL Organic Pets
                    if (petChoice.equals("all")) {
                        myShelter.vetAll();
                        System.out.println("Your organic pets are feeling much better!");
                    } else { // Heal Single Organic Pet
                        for (VirtualPet pet : myShelter.getAllPetValues()) {
                            if (pet instanceof OrganicPet) {
                                ((OrganicPet) pet).goToVet();
                            }
                        }
                        System.out.println("All your organic pets are feeling much better!");
                    }
                }
                // Repair a Robot Pet
                else if (userChoice.equals("2")) {
                        System.out.println("\nWhich robotic pet needs repaired? Please choose one by typing in the pet's name or type \"all\": \n");
                        for (VirtualPet pet : myShelter.getAllPetValues()) {
                            if (pet instanceof RobotPet) {
                                System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase(Locale.ROOT) + ".");
                            }
                        }

                        petChoice = input.nextLine();
                        System.out.println("\n");

                    do {
                        // Repair ALL Robot Pets
                        if (petChoice.equals("all")) {
                            myShelter.repairAll();
                            System.out.println("Your robot pets are all repaired and working well!");
                            break;
                        }

                        // Repair SINGLE Robot Pet
                        else if (myShelter.getPetByName(petChoice).equals(myShelter.petList.get(petChoice))) {
                            ((RobotPet) myShelter.getPetByName(petChoice)).repair();
                            System.out.println(petChoice + " is all repaired and looking brand new!");
                            break;
                        }

                        // Incorrect option, try again
                        else {
                            System.out.println("Which robotic pet needs repaired? Please choose one by typing in the pet's name or type \"all\": \n");
                            for (VirtualPet pet : myShelter.getAllPetValues()) {
                                if (pet instanceof RobotPet) {
                                    System.out.println(" >>> \"" + pet.getName() + "\" is a " + pet.getDescription().toLowerCase(Locale.ROOT) + ".");
                                }
                            }
                            petChoice = input.nextLine();
                            System.out.println("\n");
                        }
                    } while (!petChoice.equals("all") || !myShelter.getPetByName(petChoice).equals(myShelter.petList.get(petChoice)));
                }
            }

            //Oil ALl Robot Pets
            if (userChoice.equals("10")) {
                myShelter.oilAllRobots();
                System.out.println("All robots are well oiled and moving smoothly!");
            }

            // Let pet to outside to potty
            if (userChoice.equals("11")) {
                myShelter.pottyAll();
                System.out.println("Crisis averted! No messes in the shelter. Tanks are empty!");
            }

            //Clean All Dog Cages
            if (userChoice.equals("12")) {
                myShelter.cleanAllCages();
                System.out.println("Dog cages are looking spotless and smell much better!");
            }

            //Clean All Cat Litter Boxes
            if (userChoice.equals("13")) {
                myShelter.cleanAllLitterBoxes();
                System.out.println("Litter boxes are fresh with new kitty litter!");
            }

            // Pet bedtime
            if (userChoice.equals("14")) {
                    myShelter.sleepAll();
                    System.out.println("All pets are all rested up!");
            }
            System.out.println("\n\n\n");
            myShelter.tick();
            myShelter.unAlive();
            myShelter.notFunctioning();
            if (myShelter.getAllPetValues().isEmpty()) {
                break;
            }
        }
        while (!userChoice.equals("15") || myShelter.getAllPetValues().isEmpty());
        if (userChoice.equals("15")) {
            System.out.println("Thank you for volunteering!");
        } else if (myShelter.getAllPetValues().isEmpty()) {
            System.out.println("" +
                    "                               __ _  __ _ _ __ ___   ___      _____   _____ _ __ \n" +
                    "                              / _` |/ _` | '_ ` _ \\ / _ \\    / _ \\ \\ / / _ \\ '__|\n" +
                    "                             | (_| | (_| | | | | | |  __/   | (_) \\ V /  __/ |   \n" +
                    "                              \\__, |\\__,_|_| |_| |_|\\___|    \\___/ \\_/ \\___|_|   \n" +
                    "                               __/ |                                             \n" +
                    "                              |___/         \n");
            System.out.println("\t\t\t\t\t\t\t\t____________________________________________");
            System.out.println("\t\t\t\t\t\t\t\t| YOU HAVE BEEN ARRESTED FOR PET NEGLECT! |");
            System.out.println("\t\t\t\t\t\t\t\t____________________________________________");
            System.out.println("" +
                    "                                          ________________\n" +
                    "                                          \\      __      /         __\n" +
                    "                                           \\_____()_____/         /  )\n" +
                    "                                           '============`        /  /\n" +
                    "                                            #---\\  /---#        /  /\n" +
                    "                                           (# @\\| |/@  #)      /  /\n" +
                    "                                            \\   (_)   /       /  /\n" +
                    "                                            |\\ '---` /|      /  /\n" +
                    "                                    _______/ \\\\_____// \\____/ o_|\n" +
                    "                                   /       \\  /     \\  /   / o_|\n" +
                    "                                  / |           o|        / o_| \\\n" +
                    "                                 /  |  _____     |       / /   \\ \\\n" +
                    "                                /   |  |===|    o|      / /\\    \\ \\\n" +
                    "                               |    |   \\@/      |     / /  \\    \\ \\\n" +
                    "                               |    |___________o|__/----)   \\    \\/\n" +
                    "                               |    '              ||  --)    \\     |\n" +
                    "                               |___________________||  --)     \\    /\n" +
                    "                                    |           o|   ''''   |   \\__/\n" +
                    "                                    |            |          |\n");
        }
    }
}