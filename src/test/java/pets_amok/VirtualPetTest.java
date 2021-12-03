package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    VirtualPetShelter myShelter = new VirtualPetShelter();
    RoboticDog roboticDogOne = new RoboticDog("Robotic Dog One", "small", "pink", "", "", 80, 110, 75, 75);
    RoboticCat roboticCatOne = new RoboticCat("Robotic Cat One", "small", "pink", "", "", 80, 100, 75, 75);
    RoboticDog roboticDogThree = new RoboticDog("Robotic Cat One", "small", "pink", "", "", 0, 100, 75, 75);
    OrganicDog organicDogOne = new OrganicDog("Organic Dog One", "small", "white", "", "", 100, 100, 100, 0, 10, 100, 10, 100);
    OrganicDog organicDogTwo = new OrganicDog("Organic Dog Two", "small", "white", "", "", 100, 100, 100, 0, 20, 100, 50, 100);
    OrganicCat organicCatOne = new OrganicCat("Organic Cat One", "small", "white", "", "", 100, 100, 100, 0, 100, -10, 30, 0);
    OrganicCat organicCatTwo = new OrganicCat("Organic Cat Two", "small", "white", "", "", 100, 100, 100, 0, 100, 10, 0, 0);


    @Test
    public void shouldReturnDefaultOilLevelOf100() {
        int actualOilLevel = roboticCatOne.getOilLevel();
        assertEquals(100, actualOilLevel);
    }

    @Test
    public void shouldIncreaseOilLevelBy30WhenAddingOil() {
        roboticCatOne.addOil();
        int newOilLevel = roboticCatOne.getOilLevel();
        assertEquals(130, newOilLevel);
    }

    @Test
    public void shouldIncreaseHappinessAndActivityLevelBy25ForBothPetsWhenPlayingTogether() {
        roboticDogOne.playTogether(organicDogOne);
        organicDogOne.playTogether(roboticDogOne);
        int actualHappinessLevelOfDog = organicDogOne.getHappinessLevel();
        int actualActivityLevelOfDog = organicDogOne.getActivityLevel();
        assertEquals(125, actualHappinessLevelOfDog);
        assertEquals(125, actualActivityLevelOfDog);

        int actualHappinessLevelOfRobot = roboticDogOne.getHappinessLevel();
        int actualActivityLevelOfRobot = roboticDogOne.getActivityLevel();
        assertEquals(100, actualHappinessLevelOfRobot);
        assertEquals(100, actualActivityLevelOfRobot);
    }

    @Test
    public void shouldIncreaseHealthLevelTo100AfterRepairingARobotPet() {
        roboticDogOne.repair();
        int actualHealthLevel = roboticDogOne.getHealthLevel();
        assertEquals(100, actualHealthLevel);
    }

    @Test
    public void shouldIncreaseHappinessLevelBy30WhenWalkingADog() {
        organicDogOne.goForAWalk();
        int actualHappinessLevelOfCole = organicDogOne.getHappinessLevel();
        assertEquals(130, actualHappinessLevelOfCole);
    }

    @Test
    public void shouldDecreaseHealthBy5WhenHappinessIsNegative10OrBelow() {
        int actualHealthLevel = organicCatOne.getHealthLevel();
        assertEquals(95, actualHealthLevel);
    }

    @Test
    public void shouldIncreaseHealthBy5WhenHappinessIs200OrAbove() {
        RoboticCat roboticCat = new RoboticCat("Botty", "small", "pink", "", "", 100, 100, 200, 25);
        int actualHealthLevel = roboticCat.getHealthLevel();
        assertEquals(105, actualHealthLevel);
    }

    @Test
    public void shouldOnlyFeedOrganicPets() {
        myShelter.add(organicDogOne);
        myShelter.add(organicCatOne);
        myShelter.add(roboticDogOne);
        organicDogOne.feed();
        int actualHungerLevel = organicDogOne.getHungerLevel();
        assertEquals(20, actualHungerLevel);
    }

    @Test
    public void shouldReturnStringRobotDogAndDescriptionSmallPinkDog() {
        assertEquals("robotic", roboticDogOne.getType());
        assertEquals("small pink robotic dog", roboticDogOne.getDescription());
    }

    @Test
    public void shouldReturnStringDogAndDescriptionSmallWhiteDog() {
        assertEquals("organic", organicDogOne.getType());
        assertEquals("small white organic dog", organicDogOne.getDescription());
    }

    @Test
    public void shouldIncreaseHungerLevelBy3WhenTickMethodCalled() {
        organicDogOne.tick();
        int actualHungerLevel = organicDogOne.getHungerLevel();
        assertEquals(103, actualHungerLevel);
    }

    @Test
    public void shouldDecreaseOilLevelBy3WhenTickMethodCalled() {
        roboticDogOne.tick();
        int actualOilLevel = roboticDogOne.getOilLevel();
        assertEquals(107, actualOilLevel);
    }

    @Test
    public void shouldReturnPetSizeColorTypeAndSpecies() {
        String actualPetDescription = roboticDogOne.getSize() + " " + roboticDogOne.getColor() + " " + roboticDogOne.getType() + " " + roboticDogOne.getSpecies();
        assertEquals("small pink robotic dog", actualPetDescription);
    }

    @Test
    public void shouldDecreaseCageCleanlinessLevelWhenWasteLevelIs150() {
        OrganicDog organicDogOne = new OrganicDog("Cole", "small", "white", "", "", 100, 100, 100, 150, 100, 50, 0, 100);
        int actualCageCleanlinessLevel = organicDogOne.getCageCleanlinessLevel();
        assertEquals(81, actualCageCleanlinessLevel);
    }

    @Test
    public void shouldDecreaseLitterBoxCleanlinessLevelWhenWasteLevelIs150() {
        OrganicCat organicCatOne = new OrganicCat("Cole", "small", "white", "", "", 100, 100, 100, 150, 100, 10, 0, 0);
        int actualLitterBoxCleanlinessLevel = organicCatOne.getLitterBoxCleanlinessLevel();
        assertEquals(51, actualLitterBoxCleanlinessLevel);
    }

    @Test
    public void shouldIncreaseLitterBoxCleanlinessLevelTo100WhenEmptied() {
        OrganicCat organicCatTwo = new OrganicCat("Rocket", "small", "white", "", "", 100, 100, 100, 0, 50, 10, 0, 0);
        organicCatTwo.cleanLitterBox();
        int actualLitterBoxCleanlinessLevel = organicCatTwo.getLitterBoxCleanlinessLevel();
        assertEquals(100, actualLitterBoxCleanlinessLevel);
    }

    @Test
    public void shouldIncreaseCageCleanlinessLevelTo100WhenCleaned() {
        OrganicDog organicDog2 = new OrganicDog("Cole", "small", "white", "", "", 100, 100, 100, 0, 2, 50, 0, 100);
        organicDog2.cleanCage();
        int actualCageCleanlinessLevel = organicDog2.getCageCleanlinessLevel();
        assertEquals(100, actualCageCleanlinessLevel);
    }

    @Test
    public void shouldIncreaseOilLevelForMultipleRobotPets() {
        myShelter.add(roboticCatOne);
        myShelter.add(roboticDogOne);
        myShelter.oilAllRobots();
        int dogOilLevel = roboticDogOne.getOilLevel();
        int catOilLevel = roboticCatOne.getOilLevel();
        assertEquals(140, dogOilLevel);
        assertEquals(130, catOilLevel);
    }

    @Test
    public void shouldSetCageCleanlinessLevelTo100ForMultipleDogsWhenCleaningAllCages() {
        myShelter.add(organicDogOne);
        myShelter.add(organicDogTwo);
        myShelter.cleanAllCages();
        assertEquals(100, organicDogOne.getCageCleanlinessLevel());
        assertEquals(100, organicDogTwo.getCageCleanlinessLevel());
    }

    @Test
    public void shouldSetLitterBoxCleanlinessLevelTo100ForMultipleCatsWhenCleaned() {
        myShelter.add(organicCatOne);
        myShelter.add(organicCatTwo);
        myShelter.cleanAllLitterBoxes();
        int actualLitterBoxLevelOfCatOne = organicCatOne.getLitterBoxCleanlinessLevel();
        int actualLitterBoxLevelOfCatTwo = organicCatTwo.getLitterBoxCleanlinessLevel();
        assertEquals(100, actualLitterBoxLevelOfCatOne);
        assertEquals(100, actualLitterBoxLevelOfCatTwo);
    }

    @Test
    public void shouldBreakPetAndRemoveFromShelterIfRobotPetHas0HealthLevel() {
        myShelter.add(roboticDogThree);
        myShelter.notFunctioning();
        assertEquals(myShelter.getAllPetValues().isEmpty(), !myShelter.getAllPetValues().contains(roboticDogThree));
    }

    @Test
    public void shouldSetOrganicPetsSleepinessLevelTo0WhenPutToSleep() {
        myShelter.add(organicDogOne);
        myShelter.add(organicCatOne);
        myShelter.add(roboticDogOne);
        myShelter.add(roboticCatOne);
        myShelter.sleepAll();
        int actualSleepLevelOrganicDogOne = organicDogOne.getSleepinessLevel();
        int actualSleepLevelOrganicCatTwo = organicCatOne.getSleepinessLevel();
        assertEquals(0, actualSleepLevelOrganicDogOne);
        assertEquals(0, actualSleepLevelOrganicCatTwo);
    }

    @Test
    public void shouldReturnPetSpeciesAsDogAndTypAsRobotic() {
        String actualPetSpecies = roboticDogOne.getSpecies();
        String actualPetType = roboticDogOne.getType();
        assertEquals("dog", actualPetSpecies);
        assertEquals("robotic", actualPetType);
    }

    @Test
    public void shouldEqualPetNameInMap() {
        myShelter.add(roboticDogOne);
        String petChoice = "Robotic Dog One";
        VirtualPet actualPetChoice = myShelter.getPetByName(petChoice);
        assertEquals(roboticDogOne, actualPetChoice);
    }
}