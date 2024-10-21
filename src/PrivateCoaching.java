

//DEFINITION: This class consist a method to handle private coaching
//METHODS: addPrivateCoaching () | costPrivateCoaching ()

class PrivateCoaching {

    InputValidation valid = new InputValidation();
    DisplayInfo info = new DisplayInfo();

    //ATTRIBUTES
    private int usersNumPrivateCoach;
    private int costPrivateCoaching;

    //GETTERS
    public int getUsersNumPrivateCoach() {
        return usersNumPrivateCoach;
    }

    public int getCostPrivateCoaching() {
        return costPrivateCoaching;
    }


    // Main method to add private coaching--can be called in Manager Class
    void addPrivateCoaching() {
        info.printPrivateCoaching(); //display info
        valid.inputNumPrivateCoaching();
        System.out.println();
        usersNumPrivateCoach=valid.getHoursOfPrivateCoaching();
        costPrivateCoaching();
    }

    void costPrivateCoaching () {
        costPrivateCoaching=(usersNumPrivateCoach * 4) * 9;
    }

}
