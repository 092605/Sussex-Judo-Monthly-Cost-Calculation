class DisplayInfo {


    void trainingPlan (){
        System.out.print("--------------------");
        System.out.print("TRAINING PLAN DETAILS");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Enter 1: ");
        System.out.println("BEGINNER (2 session per week): " + "$" + 25.00);
        System.out.println("Enter 2: ");
        System.out.println("INTERMEDIATE (3 session per week): " + "$" + 30.00 );
        System.out.println("Enter 3: ");
        System.out.println("ELITE (5 session per week): " + "$" + 35.00  );
        System.out.println();
        System.out.println("NOTE:");
        System.out.println("You'll have 4 weeks in a month--");
        System.out.println();
    }

    void weightCategory (){
        System.out.println();
        System.out.print("--------------------");
        System.out.print("Weight Category (maximum)");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Enter 1: ");
        System.out.println("Flyweight: up to 66kg");
        System.out.println("Enter 2: ");
        System.out.println("Lightweight: up to 73kg");
        System.out.println("Enter 3: ");
        System.out.println("Light-Middleweight: up to 81kg");
        System.out.println("Enter 4: ");
        System.out.println("Middleweight: up to 90kg");
        System.out.println("Enter 5: ");
        System.out.println("Light-Heavyweight: up to 100kg");
        System.out.println("Enter 6: ");
        System.out.println("Heavyweight: more than 100kg");
        System.out.println();
    }

    void competitionDetails () {
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

    void privateCoaching (){
        System.out.println();
        System.out.print("--------------------");
        System.out.print("Enter Private Coaching: $9.00");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Note: You only have maximum of 5 hours per week for Private Coaching ");
        System.out.println();
    }


}
