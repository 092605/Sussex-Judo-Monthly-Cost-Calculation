import java.util.Scanner;

//DEFINITION: This class consist a method to handle private coaching
//METHODS: addPrivateCoaching () | costPrivateCoaching ()

class PrivateCoaching {


    Scanner Input = new Scanner(System.in);
    InputValidation get = new InputValidation();
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
        info.printPrivateCoaching(); //display infor
        boolean validInput = false;
        while (!validInput) {
            get.numOfPrivateCoaching(); // ask user
            usersNumPrivateCoach= get.getHoursOfPrivateCoaching(); // store user input
            if (get.hoursOfPrivateCoaching > 5) {
                System.out.println("You exceed to the maximum number of hours. Please input again: ");
            } else if (get.hoursOfPrivateCoaching < 0) {
                System.out.println("Invalid input. Please enter a positive number.");
            } else {
                validInput = true;
            }

        }
        costPrivateCoaching();
        System.out.println();
    }

    void costPrivateCoaching () {
            costPrivateCoaching=(usersNumPrivateCoach * 4) * 9;
    }

}
