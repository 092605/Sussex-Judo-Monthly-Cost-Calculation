
//DEFINITION: This class gathers every single method in the package.
//            Create a single method that create an application (called in Main class)

//METHODS: registrationAthlete () | displayPaymentDetails () | displayAllDetails ()

class Manager extends DisplayInfo {

    Athlete athlete = new Athlete();
    TrainingPlan trainingPlan = new TrainingPlan();
    PrivateCoaching privateCoaching = new PrivateCoaching();
    EnterCompetition enterCompetition = new EnterCompetition();
    WeightCategory weightCategory = new WeightCategory(athlete); // mainly used to get the Athlete weight category (name)
    InputValidation valid = new InputValidation();


    private String athleteNameWeightCategory;


    void registrationAthlete() {
        //controls registration loop
        boolean registerNewAthlete = true; // Control the registration loop
        while (registerNewAthlete) { //while register new athlete is true

            //Welcome Messages
            System.out.println();
            System.out.print("--------------------");
            System.out.print("Welcome to North Sussex Judo Training ");
            System.out.println("--------------------");
            System.out.println("                         # of Athlete's Enrolled: " + Athlete.getNumberOfAthlete());


            //REGISTER NEW ATHLETE
            athlete.inputAthleteDetails();
            if (athlete.decisionRegisterAthlete.equalsIgnoreCase("no")) {
                registerNewAthlete = false; //END
            } else {

                //CHOOSE TRAINING PLAN
                boolean change = true; //check if the athlete wants to change training plan
                while (change) {
                    trainingPlan.addTrainingPlan(); //method for users to choose

                    // Enter competition
                    //for users who choose Beginner
                    if (trainingPlan.getUserTrainingPlan() == 1) {
                        valid.changeTrainingPlan();
                        if (valid.getDecisionChangeTrainingPlan().equalsIgnoreCase("no")) {
                            change = false;
                            athleteNameWeightCategory = weightCategory.identifyAthleteWeightCategory(); //gets the athlete name weight category in weight category class and use the details in existing athlete
                        }
                    }

                    //For users that are Intermediate/ Elite
                    else {
                        System.out.println();
                        valid.decisionEnterCompetition();
                        if (valid.getDecisionCompetition().equalsIgnoreCase("yes")) {
                            enterCompetition.addCompetition();
                            break;
                        }
                        else break;
                    }

                }

                privateCoaching.addPrivateCoaching();
                displayPaymentDetails();

                //PHASE 1 HOME PAGE
                valid.optionHomePage1();
                if (valid.getDecisionOptionHomePage1() == 1) {
                    displayAllDetails();

                    //PHASE 2 HOME PAGE
                    valid.optionHomePage2();
                    if (valid.getDecisionOptionHomePage2() == 2) {
                        System.out.println();
                        System.out.print("-----------------");
                        System.out.print("THANK YOU FOR CHOOSING SUSSEX JUDO TRAINING PLAN");
                        System.out.println("-----------------");
                        System.out.println("                       Number of Athletes Enrolled: " + Athlete.getNumberOfAthlete());
                        System.out.println();
                        registerNewAthlete = false;
                    }
                }
            }
        }
    }
    // end of method registrationAthlete ()

    void displayPaymentDetails() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("               Itemized Cost for the Month         ");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %-30s | $%.2f %n", "Training Plan Cost:", (double) trainingPlan.getCostTrainingPlan());
        System.out.printf("| %-30s | $%.2f %n", "Competition Cost:", (double) enterCompetition.getCostCompetition());
        System.out.printf("| %-30s | $%.2f %n", "Private Coaching Cost:", (double) privateCoaching.getCostPrivateCoaching());
        System.out.println("-----------------------------------------------------------------");

        double totalCost = trainingPlan.getCostTrainingPlan() +
                enterCompetition.getCostCompetition() +
                privateCoaching.getCostPrivateCoaching();

        System.out.printf("| %-30s | $%.2f %n", "Total Monthly Cost:", totalCost);
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
        System.out.printf("| %-30s | $%.2f %n", "Cost for Upcoming Competitions:", (double) enterCompetition.getPendingCostCompetition());
    }

    void displayAllDetails() {
        String weightCategory = (enterCompetition.getUserWeightCategory() == null) ? athleteNameWeightCategory : enterCompetition.getUserWeightCategory();
        double weight = athlete.getWeight();

        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                          ALL DETAILS        ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                      --Athlete Details--   ");
        System.out.println();
        System.out.printf("| %-40s | %s%n", "Athlete Name", athlete.getName());
        System.out.printf("| %-40s | %s (%.1f kg)%n", "Weight Category", weightCategory, weight);
        System.out.printf("| %-40s | %s%n", "Date Registered", athlete.getDate());
        System.out.printf("| %-40s | %s (%d session)%n", "Training Plan",
                trainingPlan.getNameTrainingPlan(),
                trainingPlan.getUsersNumberOfSession());
        System.out.printf("| %-40s | %s%n", "Competition Weight Category",
                (enterCompetition.getUsersCompetitionCategory() == null) ? "No competition weight category" : enterCompetition.getUsersCompetitionCategory());
        System.out.printf("| %-40s | %d (%s)%n", "Number of competitions this month",
                (enterCompetition.getUsersNumCompetition() > 0) ? 1 : 0,
                (enterCompetition.getUsersNumCompetition() > 0) ? "2nd Saturday of the Month" : "");
        System.out.printf("| %-40s | %d%n", "Upcoming Number of Competition",
                (enterCompetition.getUsersNumCompetition() > 1) ? (enterCompetition.getUsersNumCompetition() - 1) : 0);
        System.out.printf("| %-40s | %d hours%n", "Number of hours for Private Coaching",
                privateCoaching.getUsersNumPrivateCoach() * 4);
        System.out.println();
        System.out.println("                  --Itemized Cost for The Month--");
        System.out.println();
        System.out.printf("| %-40s | $%.2f%n", "Training Plan Cost", (double) trainingPlan.getCostTrainingPlan());
        System.out.printf("| %-40s | $%.2f%n", "Competition Cost", (double) enterCompetition.getCostCompetition());
        System.out.printf("| %-40s | $%.2f%n", "Private Coaching Cost", (double) privateCoaching.getCostPrivateCoaching());
        System.out.println("--------------------");
        System.out.printf("| %-40s | $%.2f%n", "Total Monthly Cost", (double) (trainingPlan.getCostTrainingPlan() + enterCompetition.getCostCompetition() + privateCoaching.getCostPrivateCoaching()));
        System.out.println("--------------------");
        System.out.println();
        System.out.printf("| %-40s | $%.2f%n", "Cost for upcoming competitions", (double) enterCompetition.getPendingCostCompetition());

    }
}






