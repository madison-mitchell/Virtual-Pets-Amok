package pets_amok;

public class OrganicCat extends OrganicPet implements Cat {
    private final String petSpecies = "cat";
    private int litterBoxCleanlinessLevel;

    public OrganicCat(String inputPetName, String inputPetSize, String inputPetColor, String petType, String petSpecies, int healthLevel, int hungerLevel, int thirstLevel, int wasteLevel, int litterBoxCleanlinessLevel, int happinessLevel, int sleepinessLevel, int activityLevel) {
        super(inputPetName, inputPetSize, inputPetColor, petType, petSpecies, healthLevel, hungerLevel, thirstLevel, wasteLevel, happinessLevel, sleepinessLevel, activityLevel);
    this.litterBoxCleanlinessLevel = litterBoxCleanlinessLevel;
    }

    public String getSpecies() {
        return petSpecies;
    }

    public String getDescription(){
        return petSize + " " + petColor + " " + petType + " " + petSpecies;
    }

    public int getLitterBoxCleanlinessLevel() {
        if (wasteLevel >= 150) {
            litterBoxCleanlinessLevel -= 49;
            wasteLevel -= 21;
        }
        else if (wasteLevel >= 100) {
            litterBoxCleanlinessLevel -= 17;
        }
        else if (litterBoxCleanlinessLevel < -15) {
            litterBoxCleanlinessLevel = -15;
        }
        return litterBoxCleanlinessLevel;
    }

    public void playWithCatToy(){
        happinessLevel += 25;
        activityLevel += 15;
    }

    public void playTogether(VirtualPet petToPlayWith) {
        happinessLevel += 15;
        activityLevel += 25;
    }

    public void cleanLitterBox() {
        litterBoxCleanlinessLevel = 100;
    }

    public String sleepinessStatus() {
        if (sleepinessLevel >= 140) {
            return "EXHAUSTED";
        }
        if (sleepinessLevel > 100) {
            return "TRIED\t";
        }
        return "ok\t";
    }

    public String litterBoxStatus() {
        if (litterBoxCleanlinessLevel <= 15) {
            return "FILTHY";
        }
        if (litterBoxCleanlinessLevel < 25) {
            return "DIRTY\t";
        }
        if (litterBoxCleanlinessLevel < 35) {
            return "MESSY\t";
        }
        return "ok\t";
    }

    public void tick() {
        healthLevel -=2;
        hungerLevel += 6;
        thirstLevel += 5;
        wasteLevel += 4;
        happinessLevel -= 5;
        activityLevel -= 2;
        litterBoxCleanlinessLevel -= 3;
    }
}
