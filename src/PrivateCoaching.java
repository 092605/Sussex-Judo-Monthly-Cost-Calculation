import java.util.Scanner;

class PrivateCoaching {


    Scanner Input = new Scanner(System.in);
    InputValidation get = new InputValidation();
    DisplayInfo info = new DisplayInfo();

    //ATTRIBUTES
    int usersNumPrivateCoach;
    int costPrivateCoaching;

    //GETTERS
    public int getUsersNumPrivateCoach() {
        return usersNumPrivateCoach;
    }

    public int getCostPrivateCoaching() {
        return costPrivateCoaching;
    }


    // METHOD ADD PRIVATE COACHING
    void addPrivateCoaching() {
        info.privateCoaching(); //display infor
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
        costPrivateCoaching= (usersNumPrivateCoach * 4) * 9;
        System.out.println();
    }

}
