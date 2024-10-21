class TrainingPlan {

    //DEFINITION: This class create method to handle Training plan
    //METHODS: costTrainingPlan () | numberOfSession () | addTrainingPlan ()

    DisplayInfo info = new DisplayInfo();
    InputValidation valid = new InputValidation();

    //ATTRIBUTES
    private int userTrainingPlan; // stores (1-3)
    private int usersNumberOfSession;
    private int costTrainingPlan;
    String nameTrainingPlan; // stores the name of the training plan

    //GETTERS
     String getNameTrainingPlan() {
        if (userTrainingPlan == 1)
            nameTrainingPlan = "Beginner";
        else if (userTrainingPlan == 2)
            nameTrainingPlan = "Intermediate";
        else
            nameTrainingPlan = "Elite";
        return nameTrainingPlan;
    }

    public int getCostTrainingPlan() {
        return costTrainingPlan;
    }

    public int getUserTrainingPlan() {
        return userTrainingPlan;
    }

    public int getUsersNumberOfSession() {
        return usersNumberOfSession;
    }

    //METHODS

    // method to calculate the cost of athletes chosen training plan
        void costTrainingPlan() {
            if(userTrainingPlan ==1)
                this.costTrainingPlan =25*4;
            else if(userTrainingPlan ==2)
                this.costTrainingPlan =30*4;
            else
                this.costTrainingPlan =35*4;
        }

    //number of session
  void numberOfSessions() {
        if (userTrainingPlan==1)
            usersNumberOfSession = 2 * 4;
        else if (userTrainingPlan==2 * 4)
            usersNumberOfSession = 3 * 4;
        else
            usersNumberOfSession = 5 * 4;

    }

    //Main method to add Training Plan-- can be called in Manager Class
    void addTrainingPlan() {

        info.printTrainingPlan(); //display training plan info
        valid.chooseTrainingPlan(); // user choose a training plan
        userTrainingPlan = valid.getTrainingPlan(); // store the training plan
        numberOfSessions();
        costTrainingPlan();
    }
}





