class DisplayInfo {

    //DEFINITION: This class handles the display of information -- print only
    //METHODS : trainingPlan() | weightCategory () | competitionDetails () | privateCoaching ()

    public void printTrainingPlan() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                   TRAINING PLAN DETAILS     ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        System.out.printf("| %-5s | %-20s | %-20s | %-10s |%n", "Enter", "Plan", "Number of Sessions", "Cost");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-20s | $%-9.2f |%n", "  1", "BEGINNER", "2 sessions/week", 25.00);
        System.out.printf("| %-5s | %-20s | %-20s | $%-9.2f |%n", "  2", "INTERMEDIATE", "3 sessions/week", 30.00);
        System.out.printf("| %-5s | %-20s | %-20s | $%-9.2f |%n", "  3", "ELITE", "5 sessions/week", 35.00);
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
        System.out.println("NOTE:");
        System.out.println("You'll have 4 weeks in a month--");
        System.out.println();
    }

    public void printWeightCategory() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                COMPETITION WEIGHT CATEGORY (MAX)     ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        System.out.printf("| %-5s | %-25s | %-20s |%n", "Enter", "Category", "Maximum Weight");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %-5s | %-25s | %-20s |%n", "  1", "Flyweight", "up to 66kg");
        System.out.printf("| %-5s | %-25s | %-20s |%n", "  2", "Lightweight", "up to 73kg");
        System.out.printf("| %-5s | %-25s | %-20s |%n", "  3", "Light-Middleweight", "up to 81kg");
        System.out.printf("| %-5s | %-25s | %-20s |%n", "  4", "Middleweight", "up to 90kg");
        System.out.printf("| %-5s | %-25s | %-20s |%n", "  5", "Light-Heavyweight", "up to 100kg");
        System.out.printf("| %-5s | %-25s | %-20s |%n", "  6", "Heavyweight", "more than 100kg");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();
    }

    public void printCompetitionDetails() {
        System.out.println();
        System.out.print("--------------------");
        System.out.print("Enter Competition: $22.00");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Note: ");
        System.out.println("1.) Maximum number of competition every month is only 1");
        System.out.println("2.) Competitions are held every 2nd Saturday of the Month");
        System.out.println("3.) You are going to compete within the range of your current weight category.");
        System.out.println();
    }

    public void printPrivateCoaching(){
        System.out.println();
        System.out.print("--------------------");
        System.out.print("Enter Private Coaching: $9.00");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Note: You only have maximum of 5 hours per week for Private Coaching ");
        System.out.println();
    }


}
