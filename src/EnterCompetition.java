    import java.util.Scanner;


    //DEFINITION : This is a class which gather methods from other class to create a single method
    //             Can be called when the user wants to add competition

    //METHODS:
    //addCompetition () : Manage the adding of competition. User choose competition weight category, number of competitions, & costing
    // handleWeightChange () : a method where user can change competition weight category if it doesn't match with their current weight
    //getNameCompetitionCategory () : method to get the name of the chosen competition weight category


    class EnterCompetition extends InputValidation {

        //OBJECTS NEEDED
        Scanner Input = new Scanner(System.in);
        DisplayInfo display = new DisplayInfo();
        TrainingPlan getTrainingPlan= new TrainingPlan();
        Athlete athlete= new Athlete();


        //MAIN ATTRIBUTES
        private int usersNumCompetition;
        private int costCompetition;
        private int pendingCostCompetition;
        private String userNameWeightCategory;
        private String usersNameCompetitionCategory;

        //OTHER ATTRIBUTES
        String changeCompetitionWeightCategory; // user's decision to change (yes/no)
        int usersCW; //Competition Weight Category (stores 1-6)
        int comparison; // Identify WITHIN LIMIT | GAIN | LOSE (stores 1-3)
        boolean changeCompetition; // controls the loop

        //GETTERS

        public int getPendingCostCompetition() {
            return pendingCostCompetition;
        }

        public String getUserWeightCategory() {
            return userNameWeightCategory;
        }

        public int getUsersNumCompetition() {
            return usersNumCompetition;
        }

        public String getUsersCompetitionCategory() {
            return usersNameCompetitionCategory;
        }

        public int getCostCompetition() {
            return costCompetition;
        }


        //Method to add competition -- can be called in Manager Class
        public void addCompetition() {
            WeightCategory get = new WeightCategory(athlete);
            display.printCompetitionDetails(); // Display competition details
            display.printWeightCategory(); // Display weight category


            changeCompetition = true;
            while (changeCompetition) {
                chooseCompetitionWeightCategory(); // User chooses a competition weight category
                usersCW = getCompetitionWeightCategory(); // Store user competition weight category (numbers)
                comparison = get.compare_Weight_Category(usersCW); // Comparing the user's category and chosen competition category


                // Determine competition category (words)
                usersNameCompetitionCategory = getNameCompetitionCategory(usersCW);

                //NOTE: (1) Within Limit (2) need to gain weight (3) need to lose weight
                switch (comparison) {
                    case 1:
                        System.out.println("----------------------------------------");
                        System.out.println("Competition Weight Category Accepted!");
                        System.out.println("----------------------------------------");
                        inputNumCompetition(); // ask user for number of competition (0-no limit--but only 1 competition will be calculated in monthly cost, the rest will be upcoming and pending)
                        usersNumCompetition = getNumberOfCompetition(); // store user number of competition
                        changeCompetition = false; // exit loop for (change competition)
                        break;

                    //handleWeightChange () is a method for prompting decision to change competition weight category
                    case 2:
                        handleWeightChange("gain");
                        break;

                    case 3:
                        handleWeightChange("lose");
                        break;

                }

            }
            // Calculate cost based on number of competitions
            costCompetition();
            pendingCostCompetition();

            userNameWeightCategory = get.identifyAthleteWeightCategory();
        }

        private void costCompetition (){
            costCompetition = (usersNumCompetition > 0 ? 1 : 0) * 22; // if number of competition > 0, (costCompetition) will compute only 1 competition
        }
        private void pendingCostCompetition () {
            pendingCostCompetition = (usersNumCompetition > 1 ? ((usersNumCompetition-1)*22) : 0); // this will compute the pending costs
        }

        // Method to handle weight change prompts
        private void handleWeightChange(String action) {
            System.out.println("Sorry, you need to " + action + " weight to enter this competition weight category");

            boolean validDecisionChangeCompetitionCategory = false;
            while (!validDecisionChangeCompetitionCategory) {
                System.out.print("Do you want to change competition weight category? (yes/no): ");
                changeCompetitionWeightCategory = Input.nextLine();

                if (changeCompetitionWeightCategory.equalsIgnoreCase("yes")) {
                    // User wants to change the weight category
                    validDecisionChangeCompetitionCategory = true;
                    changeCompetition=true; //prompt user to change competition weight category
                } else if (changeCompetitionWeightCategory.equalsIgnoreCase("no")) {
                    //users chosen competition weight category will be accepted but will tale a note to gain weight
                    usersNameCompetitionCategory = "(" + getNameCompetitionCategory(usersCW) + ")" + " Need to " + action + " weight before competition starts";
                    System.out.println("----------------------------------------");
                    System.out.println("Competition Weight Category Accepted!");
                    System.out.println("----------------------------------------");
                    inputNumCompetition(); // the user will now proceed to input number of competition
                    usersNumCompetition = getNumberOfCompetition();
                    validDecisionChangeCompetitionCategory = true;
                    changeCompetition=false;

                } else {
                    System.out.println("Invalid input, please choose (yes/no) only...)");
                }
            }
        }

        // Method to get name of competition category based on usersCW
        private String getNameCompetitionCategory(int usersCW) {
            if (getTrainingPlan.getUserTrainingPlan()==1) {
                return "No Competition Category";
            } else {
                return switch (usersCW) {
                    case 1 -> "Flyweight";
                    case 2 -> "Lightweight";
                    case 3 -> "Light-Middleweight";
                    case 4 -> "Middleweight";
                    case 5 -> "Light-Heavyweight";
                    default -> "Heavyweight";
                };
            }
        }
    }























