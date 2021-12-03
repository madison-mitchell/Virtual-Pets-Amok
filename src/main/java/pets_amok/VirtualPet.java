package pets_amok;

public abstract class VirtualPet {
    protected String petName;
    protected String petSize;
    protected String petColor;
    protected String petType;
    protected String petSpecies;
    protected int healthLevel;
    protected int happinessLevel;
    protected int activityLevel;

    public VirtualPet(String inputPetName, String inputPetSize, String inputPetColor, String petType, String petSpecies, int healthLevel, int happinessLevel, int activityLevel) {
        this.petName = inputPetName;
        this.petSize = inputPetSize;
        this.petColor = inputPetColor;
        this.petType = petType;
        this.petSpecies = petSpecies;
        this.healthLevel = healthLevel;
        this.happinessLevel = happinessLevel;
        this.activityLevel = activityLevel;
    }

    public String getName() {
        return petName;
    }

    public String getSize() {
        return petSize;
    }

    public String getColor() {
        return petColor;
    }

    public abstract String getType();

    public abstract String getSpecies();

    public abstract String getDescription();

    public abstract int getHealthLevel();

    public int getHappinessLevel() {
        if (happinessLevel > 200) {
            happinessLevel = 200;
        }
        if (happinessLevel < -10) {
            happinessLevel = -10;
        }
        if (healthLevel > 150) {
            happinessLevel += 5;
        }
        return happinessLevel;
    }

    public int getActivityLevel() {
        if (activityLevel > 150) {
            activityLevel = 150;
        }
        if (activityLevel < 0) {
            activityLevel = 0;
        }
        return activityLevel;
    }

    public abstract void play();

    public abstract void playTogether(VirtualPet petToPlayWith);

    public abstract void cuddle();

    public abstract void tick();

    public abstract String healthStatus();

    public String activityStatus() {
        if (activityLevel <= 30) {
            return "IDLE\t";
        }
        if (activityLevel < 55) {
            return "BORED\t";
        }
        return "ok\t";
    }

    public String happinessStatus() {
        if (happinessLevel <= 10) {
            return "MISERABLE";
        }
        if (happinessLevel < 25) {
            return "JOYLESS";
        }
        if (happinessLevel < 35) {
            return "UNHAPPY";
        }
        return "ok\t";
    }
}
