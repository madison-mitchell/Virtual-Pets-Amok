package pets_amok;

public class RoboticDog extends RobotPet implements Dog {
    private final String petSpecies = "dog";

    public RoboticDog(String inputPetName, String inputPetSize, String inputPetColor, String petType, String petSpecies, int healthLevel, int oilLevel, int happinessLevel, int activityLevel) {
        super(inputPetName, inputPetSize, inputPetColor, petType, petSpecies, healthLevel, oilLevel, happinessLevel, activityLevel);
    }

    public String getSpecies() {
        return petSpecies;
    }

    public String getDescription() {
        return petSize + " " + petColor + " " + petType + " " + petSpecies;
    }

    public void goForAWalk() {
        activityLevel += 50;
        happinessLevel += 30;
    }

    public void tick() {
        healthLevel -=3;
        oilLevel -= 3;
        happinessLevel -= 6;
        activityLevel -= 9;
    }
}
