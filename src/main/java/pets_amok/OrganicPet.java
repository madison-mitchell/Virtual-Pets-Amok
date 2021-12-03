package pets_amok;

public abstract class OrganicPet extends VirtualPet {
    protected int hungerLevel;
    protected int thirstLevel;
    protected int wasteLevel;
    protected int sleepinessLevel;
    protected String petType = "organic";
    private boolean isAlive = true;


    public OrganicPet(String inputPetName, String inputPetSize, String inputPetColor, String petType, String petSpecies, int healthLevel, int hungerLevel, int thirstLevel, int wasteLevel, int happinessLevel, int sleepinessLevel, int activityLevel) {
        super(inputPetName, inputPetSize, inputPetColor, petType, petSpecies, healthLevel, happinessLevel, activityLevel);
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.wasteLevel = wasteLevel;
        this.sleepinessLevel = sleepinessLevel;
    }

    public String getType() {
        return petType;
    }

    public int getHealthLevel() {
        if (healthLevel < 0) {
            healthLevel = 0;
        }
        if (hungerLevel <= 0) {
            healthLevel -= 10;
        }
        if (thirstLevel <= 0) {
            healthLevel -= 20;
        }
        if (sleepinessLevel >= 110) {
            healthLevel -= 10;
        }
        if (happinessLevel <= -10) {
            healthLevel -= 5;
        }
        if (happinessLevel >= 200) {
            healthLevel += 5;
        }
        return healthLevel;
    }

    public int getHungerLevel() {
        if (hungerLevel < 0) {
            hungerLevel = 0;
        }
        return hungerLevel;
    }

    public int getThirstLevel() {
        if (thirstLevel < 0) {
            thirstLevel = 0;
        }
        return thirstLevel;
    }

    public int getWasteLevel() {
        if (wasteLevel < 0) {
            wasteLevel = 0;
        }
        return wasteLevel;
    }

    public int getSleepinessLevel() {
        if (sleepinessLevel < -10) {
            sleepinessLevel = 0;
        }
        return sleepinessLevel;
    }

    public boolean isPetAlive() {
        if (hungerLevel > 250) {
            isAlive = false;
        }
        if (thirstLevel > 230) {
            isAlive = false;
        }
        if (healthLevel < 0) {
            isAlive = false;
        }
        if (sleepinessLevel > 170) {
            isAlive = false;
        }
        return isAlive;
    }

    public void feed() {
        if (hungerLevel > 200) {
            hungerLevel = 130;
            wasteLevel += 35;
        }
        hungerLevel -= 80;
        wasteLevel += 35;
    }

    public void water() {
        if (thirstLevel > 200) {
            thirstLevel = 130;
            wasteLevel += 35;
        }
        thirstLevel -= 80;
        wasteLevel += 35;
    }

    public void play() {
        activityLevel += 35;
        happinessLevel += 27;
        sleepinessLevel += 9;
        thirstLevel += 11;
        hungerLevel += 7;
    }

    public void playTogether(VirtualPet petToPlayWith) {
        if (petToPlayWith instanceof OrganicPet) {
            activityLevel += 35;
            happinessLevel += 15;
            sleepinessLevel += 9;
            thirstLevel += 11;
            hungerLevel += 7;
        } else {
            activityLevel += 35;
            happinessLevel += 15;
        }
    }

    public void cuddle() {
        happinessLevel += 13;
        sleepinessLevel += 15;
        activityLevel -= 12;
    }

    public void goPotty() {
        wasteLevel = 0;
    }

    public void goToVet() {
        healthLevel = 100;
        hungerLevel = 100;
        thirstLevel = 100;
        wasteLevel = 0;
        sleepinessLevel = 50;
    }

    public void sleep() {
        sleepinessLevel = 0;
        activityLevel = 80;
    }

    public String healthStatus() {
        if (healthLevel <= 50 || hungerLevel > 230 || thirstLevel > 220 || sleepinessLevel > 150) {
            return "DYING\t";
        }
        if (healthLevel < 60 || hungerLevel > 215 || thirstLevel > 205 || sleepinessLevel > 135) {
            return "SICK\t";
        }
        if (healthLevel < 70 || hungerLevel > 200 || thirstLevel > 190 || sleepinessLevel > 120) {
            return "UNWELL";
        }
        return "ok\t";
    }

    public String hungerStatus() {
        if (hungerLevel >= 150) {
            return "STARVING";
        }
        if (hungerLevel > 130) {
            return "RAVENOUS";
        }
        if (hungerLevel > 110) {
            return "HUNGRY";
        }
        return "ok\t";
    }

    public String thirstStatus() {
        if (thirstLevel >= 150) {
            return "DEHYDRATED";
        }
        if (thirstLevel > 130) {
            return "THIRSTY\t";
        }
        if (thirstLevel > 110) {
            return "PARCHED\t";
        }
        return "ok\t\t";
    }

    public String wasteStatus() {
        if (wasteLevel >= 150) {
            return "FULL TANK";
        }
        if (wasteLevel >= 100) {
            return "HALF TANK";
        }
        return "ok\t\t";
    }
}
