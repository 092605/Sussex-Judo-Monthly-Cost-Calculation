import java.util.Scanner;

//DEFINITION: This class gathers every single method in the package.
//            Create a single method that create an application (called in Main class)

//METHODS: registrationAthlete () | displayPaymentDetails () | displayAllDetails ()

class Manager extends DisplayInfo {
    Scanner Input = new Scanner(System.in);
    Athlete athlete = new Athlete();
    TrainingPlan register = new TrainingPlan();
    PrivateCoaching avail = new PrivateCoaching();
    EnterCompetition enter = new EnterCompetition();
    WeightCategory get= new WeightCategory(athlete); // mainly used to get the Athlete weight category (name)


    int choice1; //options in Home Page Phase 1
    int choice2; //option ins Home Page Phase 2
    boolean registerNewAthlete; //controls registration loop
    String decisionCompetition;
    String changeTrainingPlan;
    String athleteNameWeightCategory;


    void registrationAthlete() {
        registerNewAthlete = true; // Control the registration loop
        while (registerNewAthlete) { //while register new athlete is true

            //Welcome Messages
            System.out.println();
            System.out.print("--------------------");
            System.out.print("Welcome to North Sussex Judo Training ");
            System.out.println("--------------------");
            System.out.println("                         # of Athlete's Enrolled: " + Athlete.getNumberOfAthlete());


            //REGISTER NEW ATHLETE
            athlete.registerAthlete();
            if (athlete.decisionRegisterAthlete.equalsIgnoreCase("no")){
                registerNewAthlete=false; //END
            } else {

                //CHOOSE TRAINING PLAN
                boolean change = true; //check if the athlete wants to change training plan
                while (change) {
                    register.addTrainingPlan(); //method for users to choose

                    // Enter competition

                    //for users who choose Beginner
                    if (register.getUserTrainingPlan() == 1) {
                        boolean validInputChangeTP = false; //ensure to answer (yes/no) only
                        while (!validInputChangeTP) {
                            System.out.print("Beginners cannot compete. Do you want to change training plan?");
                            changeTrainingPlan = Input.nextLine();
                            if (changeTrainingPlan.equalsIgnoreCase("yes")) {
                                validInputChangeTP=true;
                            } else if (changeTrainingPlan.equalsIgnoreCase("no")) {
                                validInputChangeTP = true;
                                change = false;
                                 athleteNameWeightCategory=get.identifyAthleteWeightCategory(); //gets the athlete name weight category in weight category class and use the details in existing athlete

                            } else {
                                System.out.println("Invalid input, please choose (yes/no) only...");
                            }
                        }

                    //For users that are Intermediate/ Elite
                    } else {
                        boolean validDecisionCompetition= false;
                        while (!validDecisionCompetition) {
                            System.out.println();
                            System.out.print("Do you want to enter competition? ");
                            decisionCompetition = Input.nextLine();
                            if (decisionCompetition.equalsIgnoreCase("yes")) {
                                validDecisionCompetition=true;
                                enter.addCompetition();
                                change= false;
                            } else if (!decisionCompetition.equalsIgnoreCase("no")) {
                                System.out.println("Invalid input, please choose (yes/no) only...");
                            }
                        }
                    }
                }

                //ADD PRIVATE COACHING
                avail.addPrivateCoaching();

                //DISPLAY PAYMENT DETAILS
                displayPaymentDetails();

                //PHASE 1 HOME PAGE
                boolean validInput1 = false;
                while (!validInput1) {
                    System.out.println();
                    System.out.print("--------------------");
                    System.out.print("HOME PAGE");
                    System.out.println("--------------------");
                    System.out.println();
                    System.out.println("Enter (1): View All Details ");
                    System.out.println("Enter (2): Register New Athlete");

                    System.out.print("Enter: ");
                    choice1 = Input.nextInt();
                    Input.nextLine();
                    System.out.println();

                    if (choice1 == 1) {
                       displayAllDetails();
                        validInput1 = true;
                    } else if (choice1 == 2) {
                        validInput1 = true;
                    } else System.out.println("Invalid input, please choose (1/2) only...");
                }

                //PHASE 2 HOME PAGE
                if (choice1 == 1) {
                    boolean validInput2 = false;
                    while (!validInput2) {
                        System.out.println();
                        System.out.print("--------------------");
                        System.out.print("HOME PAGE");
                        System.out.println("--------------------");
                        System.out.println();
                        System.out.println("Enter (1): Register New Athlete ");
                        System.out.println("Enter (2): Quit");

                        System.out.print("Enter: ");
                        choice2 = Input.nextInt();
                        Input.nextLine();

                        if (choice2 == 1) {
                            validInput2 = true;
                        } else if (choice2 == 2) {
                            System.out.println();
                            System.out.print("-----------------");
                            System.out.print("THANK YOU FOR CHOOSING SUSSEX JUDO TRAINING PLAN");
                            System.out.println("-----------------");
                            System.out.println("                       Number of Athletes Enrolled: " + Athlete.getNumberOfAthlete());
                            System.out.println();
                            validInput2 = true;
                            registerNewAthlete = false;
                        } else
                            System.out.println("Invalid input, please choose (1/2) only...");

                    }
                }
            }

        }

    }


    void displayPaymentDetails() {
        System.out.println();
        System.out.print("--------------------");
        System.out.print("Itemized Cost for the Month");
        System.out.println("--------------------");
        System.out.println();
        System.out.println();
        System.out.printf("Training Plan Cost: $%.2f %n", (double) register.getCostTrainingPlan());
        System.out.printf("Competition Cost: $%.2f %n", (double) enter.getCostCompetition());
        System.out.printf("Private Coaching Cost: $%.2f %n", (double) avail.getCostPrivateCoaching());
        System.out.println("--------------------");
        System.out.printf("Total Monthly Cost: $%.2f %n", (double) (register.getCostTrainingPlan() + enter.getCostCompetition() + avail.getCostPrivateCoaching()));
        System.out.println("--------------------");
        System.out.println();
        System.out.printf("Cost for upcoming competitions: $%.2f %n", (double) enter.getPendingCostCompetition());
    }

    void displayAllDetails() {
        System.out.print("--------------------");
        System.out.print("ALL DETAILS");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("          --Athlete Details--");
        System.out.println();
        System.out.println("Athlete Name:----------------------------" + athlete.getName());
        System.out.println("Weight Category:-------------------------- " + ((enter.getUserWeightCategory()==null) ?athleteNameWeightCategory : enter.getUserWeightCategory()  ) + " (" + athlete.getWeight() + "kg" + ")");
        System.out.println("Date Registered:-------------------------- " + athlete.getDate());
        System.out.println("Training Plan:---------------------------- " + (register.getNameTrainingPlan()) + "(" + register.getUsersNumberOfSession() + " session" + " )");
        System.out.println("Competition Weight Category:-------------- " + ((enter.getUsersCompetitionCategory()==null) ? "No competition weight category" : enter.getUsersCompetitionCategory()));
        System.out.println("Number of competition this month:--------- " + ((enter.getUsersNumCompetition() > 0 ? (1 +" (2nd Saturday of the Month)") : 0)) );
        System.out.println("Upcoming Number of Competition:----------- " + ((enter.getUsersNumCompetition()>1) ? (enter.getUsersNumCompetition()-1) : 0));
        System.out.println("Number of hours for Private Coaching:----- " + avail.getUsersNumPrivateCoach() * 4);
        System.out.println();
        System.out.println("          --Itemized Cost for The Month--");
        System.out.println();
        System.out.printf("Training Plan Cost: $%.2f %n", (double) register.getCostTrainingPlan());
        System.out.printf("Competition Cost: $%.2f %n", (double) enter.getCostCompetition());
        System.out.printf("Private Coaching Cost: $%.2f %n", (double) avail.getCostPrivateCoaching());
        System.out.println("--------------------");
        System.out.printf("Total Monthly Cost: $%.2f %n", (double) (register.getCostTrainingPlan() + enter.getCostCompetition() + avail.getCostPrivateCoaching()));
        System.out.println("--------------------");
        System.out.println();
        System.out.printf("Cost for upcoming competitions: $%.2f %n", (double) enter.getPendingCostCompetition());
    }
}



