
import java.util.Scanner;


//DEFINITION: This class consists of user input validation methods.

//METHODS---

//SETTERS: setValidName () | setValidWeight () | setValidDate ()
//SETTERS VALIDATION-- isValidMonth () | isValidName () | getDaysInMonth () |
// DECISIONS: askTrainingPlan () | chooseCompetitionWeightCategory () | decisionRegisterAthlete () |
//OTHER METHODS : numberOfCompetition () | numberOfPrivateCoaching ()

class InputValidation {
    Scanner input = new Scanner(System.in);


    //ATTRIBUTES -- stores the valid input decisions
    private String answerRegisterAthlete;
    private String decisionChangeTrainingPlan;
    private String decisionCompetition;
    private int decisionOptionHomePage1;
    private int decisionOptionHomePage2;
    private int trainingPlan;
    private int competitionWeightCategory;
    private int numberOfCompetition;
    private int hoursOfPrivateCoaching;


    //PERSONAL DETAILS
    private String validName;
    private Double validWeight;
    private String validMonth;
    private int validDay;
    private int validYear;

    //GETTERS | PERSONAL DETAILS
    public String getValidName() {
        return validName;
    }

    public Double getValidWeight() {
        return validWeight;
    }

    public String getValidMonth() {
        return validMonth;
    }

    public int getValidDay() {
        return validDay;
    }

    public int getValidYear() {
        return validYear;
    }

    public String getDate() {
        return validMonth + " " + validDay + ", " + validYear;
    }


    //GETTERS | ATTRIBUTES -- stores the valid input decisions
    public String getAnswerRegisterAthlete() {
        return answerRegisterAthlete;
    }

    public String getDecisionChangeTrainingPlan() {
        return decisionChangeTrainingPlan;
    }

    public String getDecisionCompetition() {
        return decisionCompetition;
    }

    public int getDecisionOptionHomePage1() {
        return decisionOptionHomePage1;
    }

    public int getDecisionOptionHomePage2() {
        return decisionOptionHomePage2;
    }

    public int getTrainingPlan() {
        return trainingPlan;
    }

    public int getCompetitionWeightCategory() {
        return competitionWeightCategory;
    }


    public int getNumberOfCompetition() {
        return numberOfCompetition;
    }

    public int getHoursOfPrivateCoaching() {
        return hoursOfPrivateCoaching;
    }


    //USER DETAILS CHECK VALIDATION METHODS

    // CHECK NAME
    public void setValidName() {
        while (true) {
            System.out.print("Enter your name: ");
            validName = input.nextLine();
            if (isValidName(validName)) {
                break;
            } else {
                System.out.println("Invalid name. Please enter a name without numbers.");
            }
        }
    }


    //CHECK WEIGHT
    public void setValidWeight() {
        while (true) {
            System.out.print("Enter your weight (kg): ");

            // Check if the input is a valid double
            if (input.hasNextDouble()) {
                validWeight = input.nextDouble();
                input.nextLine();
                // Check if the weight is a positive value
                if (validWeight > 0) {
                    break;
                } else {
                    System.out.println("Invalid weight. Please enter a positive value.");
                }
            } else {
                // Handle the case where input is not a valid double
                System.out.println("Invalid input. Please enter a numeric value for weight.");
                input.next();
            }
        }
    }

    //DATE
    public void setValidDate() {

        //MONTH
        while (true) {
            System.out.print("Enter month: ");
            validMonth = input.nextLine().trim().toLowerCase(); // Read and format the input (remove whitespace, convert to lowercase)
            if (isValidMonth(validMonth)) {
                break; // Valid month entered
            } else {
                System.out.println("Invalid month. Please enter a valid month name.");
            }
        }

        // DAY
        while (true) {
            System.out.print("Enter day: ");
            if (input.hasNextInt()) {
                validDay = input.nextInt();
                input.nextLine();
                //check specific number of specific month 30 | 31 days
                if (validDay >= 1 && validDay <= getDaysInMonth(validMonth)) {
                    break; // Valid day entered
                } else {
                    System.out.println("Invalid day. Please enter a valid day for " + validMonth + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value for the day.");
                input.next(); // Consume the invalid input
            }
        }

        // YEAR
        while (true) {
            System.out.print("Enter year: ");
            if (input.hasNextInt()) {
                validYear = input.nextInt();
                input.nextLine();
                if (validYear > 0) {
                    break; // Valid year entered
                } else {
                    System.out.println("Invalid year. Please enter a valid year.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value for the year.");
                input.next(); // Consume the invalid input
            }
        }
    }


    //ASK TRAINING PLAN --VOID
    void optionHomePage1() {
        boolean validDecision = false;
        while (!validDecision) {
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("                           HOME PAGE     ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println();
            System.out.println("Enter (1): View All Details ");
            System.out.println("Enter (2): Register New Athlete");
            System.out.println();
            System.out.print("Enter: ");
            decisionOptionHomePage1 = input.nextInt();
            input.nextLine();
            if (decisionOptionHomePage1 > 0 && decisionOptionHomePage1 < 3) { //validate user training plan
                validDecision = true;
            } else
                System.out.println("Please choose numbers (1-2) only");
        }
    }

    void optionHomePage2() {
        boolean validDecision = false;
        while (!validDecision) {
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("                           HOME PAGE     ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println();
            System.out.println("Enter (1): Register New Athlete");
            System.out.println("Enter (2): Quit");
            System.out.println();
            System.out.print("Enter: ");
            decisionOptionHomePage2 = input.nextInt();
            input.nextLine();
            if (decisionOptionHomePage2 > 0 && decisionOptionHomePage2 < 3) { //validate user training plan
                validDecision = true;
            } else
                System.out.println("Please choose numbers (1-2) only");
        }
    }

    void chooseTrainingPlan() {
        boolean validTrainingPlan = false;
        while (!validTrainingPlan) {
            System.out.print("Choose a Training Plan: ");
            this.trainingPlan = input.nextInt();
            input.nextLine();
            if (this.trainingPlan > 0 && this.trainingPlan < 4) { //validate user training plan
                validTrainingPlan = true;
            } else
                System.out.println("Please choose numbers (1-3) only");
        }
    }

    //CHOOSE COMPETITION WEIGHT CATEGORY -- VOID
    void chooseCompetitionWeightCategory() {
        boolean validCompetitionWeightCategory = false;
        while (!validCompetitionWeightCategory) {
            System.out.print("Please choose a competition weight category: ");
            this.competitionWeightCategory = input.nextInt();
            input.nextLine();
            if (this.competitionWeightCategory > 0 && this.competitionWeightCategory < 7) { //validate user chosen competition weight category
                validCompetitionWeightCategory = true;
            } else
                System.out.println("Please choose numbers (1-6) only");
        }
    }

    //DECISION IF THE USER WANTS TO REGISTER A TRAINING PLAN
    void decisionRegisterAthlete() {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Do you want to register a training plan? ");
            this.answerRegisterAthlete = input.nextLine();
            if (this.answerRegisterAthlete.equalsIgnoreCase("yes")) {
                this.answerRegisterAthlete = "yes";
                validInput = true;
            } else if (this.answerRegisterAthlete.equalsIgnoreCase("no")) {
                this.answerRegisterAthlete = "no";
                validInput = true;
            } else {
                System.out.println("Invalid input, please choose (yes/no) only...)");
            }

        }
    }


    void inputNumCompetition() {
        while (true) {
            System.out.print("How many competition do you want to enter? ");
            if (input.hasNextInt()) {
                this.numberOfCompetition = input.nextInt();
                input.nextLine(); // Clear the buffer
                break;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next(); // Consume the invalid input
            }
        }
    }

    void inputNumPrivateCoaching() {
        while (true) {
            System.out.print("How many hours of private coaching do you want? ");
            if (input.hasNextInt()) {
                this.hoursOfPrivateCoaching = input.nextInt();
                input.nextLine();
                if (hoursOfPrivateCoaching > 5) {
                    System.out.println("You exceed to the maximum number of hours. Please input again: ");
                } else if (hoursOfPrivateCoaching < 0) {
                    System.out.println("Invalid input. Please enter a positive number.");
                } else break;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next(); //

            }
        }
    }

        void changeTrainingPlan () {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Beginners cannot compete. Do you want to change training plan?");
                decisionChangeTrainingPlan = input.nextLine();
                if (decisionChangeTrainingPlan.equalsIgnoreCase("yes")) {
                    decisionChangeTrainingPlan = "yes";
                    validInput = true;
                } else if (decisionChangeTrainingPlan.equalsIgnoreCase("no")) {
                    decisionChangeTrainingPlan = "no";
                    validInput = true;
                } else {
                    System.out.println("Invalid input, please choose (yes/no) only...)");
                }

            }

        }
        void decisionEnterCompetition () {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to enter competition? ");
                decisionCompetition = input.nextLine();
                if (decisionCompetition.equalsIgnoreCase("yes")) {
                    decisionCompetition = "yes";
                    validInput = true;
                } else if (decisionCompetition.equalsIgnoreCase("no")) {
                    decisionCompetition = "no";
                    validInput = true;
                } else {
                    System.out.println("Invalid input, please choose (yes/no) only...)");
                }

            }

        }


        //PRIVATE METHODS

        private static boolean isValidMonth (String month){
            String[] validMonths = {
                    "january", "february", "march", "april", "may", "june",
                    "july", "august", "september", "october", "november", "december"
            };
            for (String validMonth : validMonths) {
                if (validMonth.equals(month)) {
                    return true;
                }
            }
            return false;
        }


        private static int getDaysInMonth (String month){
            return switch (month) {
                case "january", "march", "may", "july", "august", "october", "december" -> 31;
                case "april", "june", "september", "november" -> 30;
                case "february" -> 28; // Ignoring leap years for simplicity
                default -> 0; // Invalid month
            };
        }


        private static boolean isValidName (String name){
            return name != null && name.matches("[a-zA-Z ]+"); // Allow only letters and spaces
        }

}






