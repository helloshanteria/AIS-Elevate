import java.util.ArrayList;
import java.util.Scanner;

public class AISElevate {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Officer> officers =
                new ArrayList<>();


        // =========================================
        // APPLICATION TITLE
        // =========================================

        System.out.println("=================================");
        System.out.println("          AIS ELEVATE");
        System.out.println("   Officer Recognition Review");
        System.out.println("=================================");


        // =========================================
        // COLLECT OFFICER DATA
        // =========================================

        int numberOfOfficers =
                readPositiveInt(
                        input,
                        "How many officers would you like "
                                + "to review? ");

        for (int i = 1; i <= numberOfOfficers; i++) {

            System.out.println();
            System.out.println(
                    "-------- Officer " + i + " --------");

            System.out.print("Enter officer name: ");
            String name = input.nextLine().trim();

            System.out.print("Enter officer position: ");
            String position = input.nextLine().trim();

            Officer officer =
                    new Officer(name, position);

            boolean completedOnboarding =
                    askYesNo(
                            input,
                            "Completed onboarding?");

            int meetingsAttended =
                    readNonNegativeInt(
                            input,
                            "Meetings attended: ");

            int meetingsOffered =
                    readNonNegativeInt(
                            input,
                            "Meetings offered: ");

            int roleTasksCompleted =
                    readNonNegativeInt(
                            input,
                            "Role tasks completed: ");

            int roleTasksAssigned =
                    readNonNegativeInt(
                            input,
                            "Role tasks assigned: ");

            int eventsParticipated =
                    readNonNegativeInt(
                            input,
                            "Events participated in: ");

            int eventsAvailable =
                    readNonNegativeInt(
                            input,
                            "Events available: ");

            int initiativeActivities =
                    readNonNegativeInt(
                            input,
                            "Initiative activities completed: ");


            // Store the values in the Officer object.
            officer.setCompletedOnboarding(
                    completedOnboarding);

            officer.setMeetingsAttended(
                    meetingsAttended);

            officer.setMeetingsOffered(
                    meetingsOffered);

            officer.setRoleTasksCompleted(
                    roleTasksCompleted);

            officer.setRoleTasksAssigned(
                    roleTasksAssigned);

            officer.setEventsParticipated(
                    eventsParticipated);

            officer.setEventsAvailable(
                    eventsAvailable);

            officer.setInitiativeActivities(
                    initiativeActivities);


            // Add the officer to the list.
            officers.add(officer);
        }


        // =========================================
        // DISPLAY OFFICER SUMMARIES
        // =========================================

        System.out.println();
        System.out.println("=================================");
        System.out.println("       ENGAGEMENT SUMMARIES");
        System.out.println("=================================");

        for (Officer officer : officers) {
            officer.displayOfficerSummary();
        }


        // =========================================
        // RECOGNITION CATEGORY MENU
        // =========================================

        System.out.println();
        System.out.println("=================================");
        System.out.println("      RECOGNITION CATEGORIES");
        System.out.println("=================================");
        System.out.println("1. AIS Officer Badge");
        System.out.println("2. Leadership & Service Badge");
        System.out.println("3. AIS Networking Badge");
        System.out.println("4. Operational Excellence Badge");
        System.out.println("5. Professional Development Badge");
        System.out.println("6. Exit");

        int badgeChoice =
                readMenuChoice(
                        input,
                        "Select the category to review: ",
                        1,
                        6);


        if (badgeChoice == 6) {

            System.out.println(
                    "Recognition review ended.");

            input.close();
            return;
        }


        // =========================================
        // EVALUATE ALL OFFICERS
        // =========================================

        BadgeEvaluator badgeEvaluator =
                new BadgeEvaluator();

        ArrayList<Officer> qualifiedOfficers =
                new ArrayList<>();

        String selectedBadge =
                badgeEvaluator.getBadgeName(badgeChoice);

        System.out.println();
        System.out.println("=================================");
        System.out.println(
                selectedBadge.toUpperCase() + " REVIEW");
        System.out.println("=================================");

        for (Officer officer : officers) {

            boolean qualifies =
                    badgeEvaluator.evaluateSelectedBadge(
                            officer,
                            badgeChoice,
                            input);

            if (qualifies) {
                qualifiedOfficers.add(officer);
            }
        }


        // =========================================
        // DISPLAY RECOGNITION RESULTS
        // =========================================

        System.out.println();
        System.out.println("=================================");
        System.out.println("        RECOGNITION RESULTS");
        System.out.println("=================================");
        System.out.println("Category: " + selectedBadge);
        System.out.println();

        if (qualifiedOfficers.isEmpty()) {

            System.out.println(
                    "No officers currently meet "
                            + "the requirements.");

        } else {

            System.out.println("Qualified Officers:");

            for (Officer officer : qualifiedOfficers) {

                System.out.println(
                        "- "
                                + officer.getName()
                                + " | "
                                + officer.getPosition());
            }
        }

        System.out.println();
        System.out.println(
                "Leadership approval is required "
                        + "before recognition is awarded.");

        input.close();
    }


    // =========================================
    // INPUT HELPER METHODS
    // =========================================

    public static boolean askYesNo(
            Scanner input,
            String question) {

        while (true) {

            System.out.print(question + " (Yes/No): ");
            String response = input.nextLine().trim();

            if (response.equalsIgnoreCase("Yes")
                    || response.equalsIgnoreCase("Y")) {

                return true;
            }

            if (response.equalsIgnoreCase("No")
                    || response.equalsIgnoreCase("N")) {

                return false;
            }

            System.out.println(
                    "Please enter Yes or No.");
        }
    }


    public static int readNonNegativeInt(
            Scanner input,
            String prompt) {

        while (true) {

            System.out.print(prompt);
            String response = input.nextLine().trim();

            try {
                int number = Integer.parseInt(response);

                if (number >= 0) {
                    return number;
                }

                System.out.println(
                        "Please enter zero or a positive number.");

            } catch (NumberFormatException exception) {

                System.out.println(
                        "Please enter a valid whole number.");
            }
        }
    }


    public static int readPositiveInt(
            Scanner input,
            String prompt) {

        while (true) {

            int number =
                    readNonNegativeInt(input, prompt);

            if (number > 0) {
                return number;
            }

            System.out.println(
                    "Please enter at least 1.");
        }
    }


    public static int readMenuChoice(
            Scanner input,
            String prompt,
            int minimum,
            int maximum) {

        while (true) {

            int choice =
                    readNonNegativeInt(input, prompt);

            if (choice >= minimum
                    && choice <= maximum) {

                return choice;
            }

            System.out.println(
                    "Please select a number from "
                            + minimum
                            + " through "
                            + maximum
                            + ".");
        }
    }
}