
//DEFINITION: Handle the weight category & competition weight category
// METHODS: identifyAthleteWeightCategory () | compareWeightCategory ()

class WeightCategory {
    private final Athlete athlete;

    public WeightCategory(Athlete athlete) {
        this.athlete = athlete; // Use the provided athlete instance
    }


    //IDENTIFY ATHLETE CATEGORY BASE ON INPUTTED WEIGHT
    String identifyAthleteWeightCategory() {
        double weight = athlete.getWeight();
        if (weight <= 66)
            return "Flyweight";
        else if (weight <= 73)
            return "Lightweight";
        else if (weight <= 81)
            return "Light-Middleweight";
        else if (weight <= 90)
            return "Middleweight";
        else if (weight <= 100)
            return "Light-Heavyweight";
        else
            return "Heavyweight";
    }


    //COMPARING USERS WEIGHT CATEGORY TO CHOSEN COMPETITION WEIGHT CATEGORY
    //NOTE: return (1) Within Limit (2) need to gain weight (3) need to lose weight
    int compare_Weight_Category(int userCW) {
        double weight = athlete.getWeight();

        switch (userCW) {
            case 1:
                return weight <= 66 ? 1 : 2;
            case 2:
                return (weight <= 73 && weight > 66) ? 1 : (weight < 66 ? 2 : 3);
            case 3:
                return (weight <= 81 && weight > 73) ? 1 : (weight < 73 ? 2 : 3);
            case 4:
                return (weight <= 90 && weight > 81) ? 1 : (weight < 81 ? 2 : 3);
            case 5:
                return (weight <= 100 && weight > 90) ? 1 : (weight < 90 ? 2 : 3);
            default:
                return weight > 100 ? 1 : 3;
        }
    }
}
