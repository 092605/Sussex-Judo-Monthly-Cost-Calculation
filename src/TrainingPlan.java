class TrainingPlan  {

    DisplayInfo info = new DisplayInfo();
    InputValidation inputValidation = new InputValidation();

    //ATTRIBUTES
    int userTrainingPlan;
    int usersNumberOfSession;
    int costTrainingPlan;


    String nameTrainingPlan;

    //GETTERS
    public String getNameTrainingPlan() {
        if (userTrainingPlan==1)
            nameTrainingPlan= "Beginner";
        else if (userTrainingPlan==2)
            nameTrainingPlan= "Intermediate";
        else
            nameTrainingPlan= "Elite";
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

    //ADD TRAINING PLAN METHOD
    void addTrainingPlan() {

        info.trainingPlan(); //display training plan info
        inputValidation.askTrainingPLan(); // user choose a training plan
        userTrainingPlan = inputValidation.getTrainingPlan(); // store the training plan

        if (userTrainingPlan == 1)
            this.costTrainingPlan = 25 * 4;
        else if (userTrainingPlan == 2)
            this.costTrainingPlan = 30 * 4;
        else
            this.costTrainingPlan = 35 * 4;
    }


    //number of session
    int numberOfSessions() {
        if (userTrainingPlan==1)
            usersNumberOfSession = 2;
        else if (userTrainingPlan==2)
            usersNumberOfSession = 3;
        else
            usersNumberOfSession = 5;
        return usersNumberOfSession;

    }
}


