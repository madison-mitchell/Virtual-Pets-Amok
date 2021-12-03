package pets_amok;

public class RoboticCat extends RobotPet implements Cat{
    protected final String petSpecies = "cat";


    public RoboticCat(String inputPetName, String inputPetSize, String inputPetColor, String petType, String petSpecies, int healthLevel, int oilLevel, int happinessLevel, int activityLevel) {
        super(inputPetName, inputPetSize, inputPetColor, petType, petSpecies, healthLevel, oilLevel, happinessLevel, activityLevel);
    }

    public String getSpecies() {
        return petSpecies;
    }

    public String getDescription() {
        return petSize + " " + petColor + " " + petType + " " + petSpecies;
    }

    public void playWithCatToy(){
        happinessLevel += 25;
        activityLevel += 15;
    }

    public void tick() {
        healthLevel -=2;
        oilLevel -= 3;
        happinessLevel -= 5;
        activityLevel -= 2;
    }
}
