package pets_amok;

public class OrganicDog extends OrganicPet implements Dog {
    private final String petSpecies = "dog";
    private int cageCleanlinessLevel;

    public OrganicDog(String inputPetName, String inputPetSize, String inputPetColor, String petType, String petSpecies, int healthLevel, int hungerLevel, int thirstLevel, int wasteLevel, int cageCleanlinessLevel, int happinessLevel, int sleepinessLevel, int activityLevel) {
        super(inputPetName, inputPetSize, inputPetColor, petType, petSpecies, healthLevel, hungerLevel, thirstLevel, wasteLevel, happinessLevel, sleepinessLevel, activityLevel);
        this.cageCleanlinessLevel = cageCleanlinessLevel;
    }

    public String getSpecies() {
        return petSpecies;
    }

    public String getDescription() {
        return petSize + " " + petColor + " " + petType + " " + petSpecies;
    }

    public int getCageCleanlinessLevel() {
        if (wasteLevel >= 150) {
            cageCleanlinessLevel -= 19;
            wasteLevel -= 23;
        } else if (wasteLevel >= 100) {
            cageCleanlinessLevel -= 17;
        } else if (cageCleanlinessLevel < -15) {
            cageCleanlinessLevel = -15;
        }
        return cageCleanlinessLevel;
    }

    public void goForAWalk() {
        activityLevel += 50;
        happinessLevel += 30;
        wasteLevel -= 10;
    }

    public void playTogether(VirtualPet petToPlayWith) {
        happinessLevel += 25;
        activityLevel += 25;
    }


    public void cleanCage() {
        cageCleanlinessLevel = 100;
    }

    public String sleepinessStatus() {
        if (sleepinessLevel >= 150) {
            return "EXHAUSTED";
        }
        if (sleepinessLevel > 120) {
            return "TRIED\t";
        }
        return "ok\t";
    }

    public String cageStatus() {
        if (cageCleanlinessLevel <= 15) {
            return "FILTHY";
        }
        if (cageCleanlinessLevel < 25) {
            return "DIRTY\t";
        }
        if (cageCleanlinessLevel < 35) {
            return "MESSY\t";
        }
        return "ok\t";
    }

    public void tick() {
        healthLevel -= 3;
        hungerLevel += 3;
        thirstLevel += 7;
        wasteLevel += 4;
        happinessLevel -= 6;
        activityLevel -= 9;
        cageCleanlinessLevel -= 4;
    }
}
