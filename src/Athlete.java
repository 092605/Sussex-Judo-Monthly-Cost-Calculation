

// DEFINITION: This class GATHERS the user input validation method from (Input Validation Class) into one method
//             This handles the input of the user (name, weight, date).
//             It is also the one who controls the loop when user wants to register an Athlete.

//METHOD : athlete () --

public class Athlete extends InputValidation {

    private static int numberOfAthlete = 6;

    //IMPORTANT ATTRIBUTES --user details
    private String name;
    private double weight;
    private String month;
    private int day;
    private int year;
    private String date;
    String decisionRegisterAthlete;


    //GETTERS

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }


    public static int getNumberOfAthlete() {
        return numberOfAthlete;
    }

    public String getDate() {
        date = month + " " + day + ", " + year;
        return date;
    }

    //method to input personal details of an Athlete (name, weight, date registered)
    public void inputAthleteDetails() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                      ATHLETE REGISTRAR     ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

            decisionRegisterAthlete(); //stores yes/no
            decisionRegisterAthlete = getAnswerRegisterAthlete();
            if (decisionRegisterAthlete.equalsIgnoreCase("yes")) {
                numberOfAthlete++;

                //

                // Input for name
                setValidName();
                name= getValidName();

                // Input for Weight
                setValidWeight();
                weight= getValidWeight();

                // Input for date
                setValidDate();
                month= getValidMonth();
                day= getValidDay();
                year= getValidYear();


            } else  {
                System.out.println("Okay! Hope to have you registered next time!");


            }
        }
    }

