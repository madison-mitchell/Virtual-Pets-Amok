package pets_amok;

public abstract class RobotPet extends VirtualPet {
    protected int oilLevel;
    protected String petType = "robotic";
    private boolean isFunctioning = true;

    public RobotPet(String inputPetName, String inputPetSize, String inputPetColor, String petType, String petSpecies, int healthLevel, int oilLevel, int happinessLevel, int activityLevel) {
        super(inputPetName, inputPetSize, inputPetColor, petType, petSpecies, healthLevel, happinessLevel, activityLevel);
        this.oilLevel = oilLevel;
    }

    public String getType() {
        return petType;
    }

    public int getHealthLevel() {
        if (oilLevel <= 10) {
            healthLevel -= 10;
        }
        if (happinessLevel <= 10) {
            healthLevel -= 5;
        }
        if (happinessLevel >= 200) {
            healthLevel += 5;
        }
        return healthLevel;
    }

    public int getOilLevel() {
        return oilLevel;
    }

    public boolean isPetFunctioning() {
        if (healthLevel <= 0) {
            isFunctioning = false;
        }
        if (oilLevel <= 0) {
            isFunctioning = false;
        }
        return isFunctioning;
    }

    public void addOil() {
        oilLevel += 30;
    }

    public void repair() {
        healthLevel = 100;
    }

    public void play() {
        happinessLevel += 15;
        activityLevel += 35;
        oilLevel -= 13;
    }

    public void playTogether(VirtualPet petToPlayWith) {
        happinessLevel += 25;
        activityLevel += 25;
    }

    public void cuddle() {
        happinessLevel += 27;
        oilLevel -= 6;
    }

    public String healthStatus() {
        if (healthLevel <= 50 || oilLevel <= 20) {
            return "DAMAGED";
        }
        if (healthLevel < 60 || oilLevel < 30) {
            return "GLITCHING";
        }
        if (healthLevel < 70 || oilLevel < 45) {
            return "LAGGING";
        }
        return "ok\t";
    }

    public String getOilStatus() {
        if (oilLevel <= 20) {
            return "CRITICAL";
        }
        if (oilLevel < 30) {
            return "LOW\t";
        }
        if (oilLevel < 45) {
            return "TOP OFF";
        }
        return "ok\t";
    }
}
