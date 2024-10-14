
import java.util.Scanner;


//DEFINITION: This class consists of user input validation methods.

//METHODS---

//SETTERS: setValidName () | setValidWeight () | setValidDate ()
//SETTERS VALIDATION-- isValidMonth () | isValidName () | getDaysInMonth () |
// DECISIONS: askTrainingPlan () | chooseCompetitionWeightCategory () | decisionRegisterAthlete () |
//OTHER METHODS : numberOfCompetition () | numberOfPrivateCoaching ()

class InputValidation {
    Scanner input= new Scanner(System.in);


    //ATTRIBUTES -- stores the valid input decisions
    String answerRegisterAthlete;
    String decisionEnterCompetition;
    String decisionPrivateCoaching;
    int trainingPlan;
    int competitionWeightCategory;
    int numberOfCompetition;
    int hoursOfPrivateCoaching;


    //PERSONAL DETAILS
    private String validName;
    private Double validWeight;
    String validMonth;
    int validDay;
    int validYear;



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


    //GETTERS | ATTRIBUTES -- stores the valid input decisions
    public String getAnswerRegisterAthlete() {
        return answerRegisterAthlete;
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
    void setValidName() {
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
    void setValidWeight() {
        while (true) {
            System.out.print("Enter your weight (kg): ");

            // Check if the input is a valid double
            if (input.hasNextDouble()) {
                validWeight = input.nextDouble();
                input.nextLine(); // Clear the buffer
                // Check if the weight is a positive value
                if (validWeight > 0) {
                    break;
                } else {
                    System.out.println("Invalid weight. Please enter a positive value.");
                }
            } else {
                // Handle the case where input is not a valid double
                System.out.println("Invalid input. Please enter a numeric value for weight.");
                input.next(); // Consume the invalid input
            }
        }
    }

    //DATE
     void setValidDate() {

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
                input.nextLine(); // Clear the buffer
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
                input.nextLine(); // Clear the buffer
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

    // METHOD TO CHECK THE MONTH INPUT
    private static boolean isValidMonth(String month) {
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

    // Method to get the number of days in a given month
    private static int getDaysInMonth(String month) {
        switch (month) {
            case "january":
            case "march":
            case "may":
            case "july":
            case "august":
            case "october":
            case "december":
                return 31;
            case "april":
            case "june":
            case "september":
            case "november":
                return 30;
            case "february":
                return 28; // Ignoring leap years for simplicity
            default:
                return 0; // Invalid month
        }
    }

    //VALID NAME
    private static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z ]+"); // Allow only letters and spaces
    }


    //ASK TRAINING PLAN --VOID
    void askTrainingPLan() {
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
                continue;
            }

        }
    }

    // INPUT NUMBER OF COMPETITION
    void numOfCompetition() {
        System.out.print("How many competition do you want to enter? ");
        this.numberOfCompetition = input.nextInt();
    }

    void numOfPrivateCoaching() {
        System.out.print("How many hours of private coaching do you want? ");
        this.hoursOfPrivateCoaching = input.nextInt();
    }





}






