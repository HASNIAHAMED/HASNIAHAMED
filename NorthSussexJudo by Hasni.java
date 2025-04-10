import java.util.Scanner;

public class NorthSussexJudo {
    // Declaration of class variables
    static String athleteName;
    static String trainingPlan;
    static double weeklyFee;
    static double athleteWeight;
    static String weightCategory;
    static int nCompetitions;
    static int nCoachHours;
    static double monthlyFee;
    static double coachingFee;
    static double competitionFee;
    static double totalCost;

    // Constants for tuition per hour and competition entry fee
    final static double TUTION_PER_HOUR = 9.50;  // GBP
    final static double COMP_ENTRY_FEE = 22.00;  // GBP

    // Function to get the training plan selected by the athlete
    // Takes a Scanner object as input
    public static String getTrainingPlan(Scanner scanner) {
        String trainingPlan = "";
        String inString;
        int planNo;

        // Loop until a valid option is selected
        do {
            System.out.println("                          TRAINING OPTIONS                            ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("      1 - Beginner       -  2 Sessions per week  - GBP 25.00 per week ");
            System.out.println("      2 - Intermediate   -  3 Sessions per week  - GBP 30.00 per week ");
            System.out.println("      3 - Elite          -  5 Sessions per week  - GBP 35.00 per week ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Select your option....");

            inString = scanner.nextLine();

        } while (!(inString.matches("[1-3]") && inString.length() > 0));

        planNo = Integer.parseInt(inString);
        switch(planNo) {
            case 1:
                trainingPlan = "Beginner";
                weeklyFee = 25;
                break;
            case 2:
                trainingPlan = "Intermediate";
                weeklyFee = 30;
                break;
            case 3:
                trainingPlan = "Elite";
                weeklyFee = 35;
                break;
        }

        return trainingPlan;
    }

    // Function to get the athlete's name
    // Takes a Scanner object as input
    public static String getAthleteName(Scanner scanner) {
        System.out.println("Enter Athlete Name");
        return scanner.nextLine();
    }

    // Function to get the athlete's weight
    // Takes a Scanner object as input
    public static double getAthleteWeight(Scanner scanner) {
        System.out.println("Enter Athlete Weight");
        return scanner.nextDouble();
    }

    // Function to get the weight category chosen by the athlete for competition
    // Takes a Scanner object as input
    public static String getWeightCategory(Scanner scanner) {
        String weightCategory = "";
        String inString;
        int category;

        scanner.nextLine(); // Clear the buffer

        // Loop until a valid option is selected
        do {
            System.out.println("               Competition Weight Category                            ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("          CATEGORY                   UPPER WEIGHT LIMIT               ");
            System.out.println("      1 - HEAVYWEIGHT       -         ABOVE 100KG                     ");
            System.out.println("      2 - LIGHT-HEAVYWEIGHT -         100KG                           ");
            System.out.println("      3 - MIDDLEWEIGHT      -          90KG                           ");
            System.out.println("      4 - LIGHT-MIDDLEWEIGHT-          81KG                           ");
            System.out.println("      5 - LIGHTWEIGHT       -          73KG                           ");
            System.out.println("      6 - FLYWEIGHT         -          66KG                           ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Select your option....");

            inString = scanner.nextLine();

        } while (!(inString.matches("[1-6]") && inString.length() > 0));

        category = Integer.parseInt(inString);

        // Assign the chosen weight category
        switch(category) {
            case 1:
                weightCategory = "HEAVYWEIGHT";
                break;
            case 2:
                weightCategory = "LIGHT-HEAVYWEIGHT";
                break;
            case 3:
                weightCategory = "MIDDLEWEIGHT";
                break;
            case 4:
                weightCategory = "LIGHT-MIDDLEWEIGHT";
                break;
            case 5:
                weightCategory = "LIGHTWEIGHT";
                break;
            case 6:
                weightCategory = "FLYWEIGHT";
                break;
        }
        return weightCategory;
    }

    // Function to get the number of competitions the athlete plans to participate in
    // Takes a Scanner object as input
    public static int getNoCompetitions(Scanner scanner) {
        System.out.println("Enter Number of Competitions");
        return scanner.nextInt();
    }

    // Function to get the number of private coaching hours needed by the athlete
    // Takes a Scanner object as input
    public static int getNoCoachHours(Scanner scanner) {
        System.out.println("Enter Number of Private Coaching hours needed");
        return scanner.nextInt();
    }

    // Function to perform the calculation of monthly fees, coaching fees, competition fees, and total cost
    public static void doCalculation() {
        monthlyFee = weeklyFee * 4;
        coachingFee = nCoachHours * TUTION_PER_HOUR;
        competitionFee = nCompetitions * COMP_ENTRY_FEE;
        totalCost = monthlyFee + coachingFee + competitionFee;
    }

    // Function to display the final cost report
    public static void displayReport() {
        System.out.println("Athlete Name: " + athleteName);
        System.out.println("Monthly Fee: GBP " + monthlyFee);
        System.out.println("Coaching Fee: GBP " + coachingFee);
        System.out.println("Competition Fee: GBP " + competitionFee);
        System.out.println("Total Cost For The Month: GBP " + totalCost);
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Call functions to get athlete details
        athleteName = getAthleteName(scanner);
        trainingPlan = getTrainingPlan(scanner);
        athleteWeight = getAthleteWeight(scanner);
        weightCategory = getWeightCategory(scanner);
        nCompetitions = getNoCompetitions(scanner);
        nCoachHours = getNoCoachHours(scanner);

        // Perform calculation and display report
        doCalculation();
        displayReport();

        // Display athlete details for verification
        System.out.println(athleteName + " " + trainingPlan + " " +
                athleteWeight + " " + weightCategory +
                " " + nCompetitions + " " + nCoachHours);
    }
}