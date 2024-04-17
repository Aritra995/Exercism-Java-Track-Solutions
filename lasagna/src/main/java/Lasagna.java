public class Lasagna {
    private static final int EXPECTED_MINUTES_IN_OVEN = 40;
    public int expectedMinutesInOven(){
        return EXPECTED_MINUTES_IN_OVEN;
    }

    public int remainingMinutesInOven(int actualMinutes){
        int expectedMinutes = expectedMinutesInOven();
        return expectedMinutes-actualMinutes;
    }

    public int preparationTimeInMinutes(int numberOfLayers){
        return numberOfLayers*2;
    }

    public int totalTimeInMinutes(int numberOfLayers, int actualMinutes){
        int preparationTimeForAllLayers = preparationTimeInMinutes(numberOfLayers);
        return preparationTimeForAllLayers+actualMinutes;
    }
    
}
