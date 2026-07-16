import java.util.Scanner;

public class BadgeEvaluator {

    // =========================================
    // OFFICER BADGE
    // =========================================

    /*
     Requirements:
     - Complete onboarding
     - Attend at least 70% of executive meetings
     - Complete at least 75% of assigned role tasks
     */
    public boolean evaluateOfficerBadge(
            Officer officer) {

        return officer.getCompletedOnboarding()
                && officer.calculateMeetingAttendance() >= 70
                && officer.calculateRoleCompletion() >= 75;
    }


    // =========================================
    // LEADERSHIP & SERVICE BADGE
    // =========================================

    /*
     Complete any 2:
     - Volunteer at an AIS event
     - Lead a meeting or activity
     - Help organize event logistics
     - Mentor another member
     */
    public boolean evaluateLeadershipServiceBadge(
            boolean volunteeredAtEvent,
            boolean ledMeetingOrActivity,
            boolean organizedEventLogistics,
            boolean mentoredMember) {

        int completedRequirements = 0;

        if (volunteeredAtEvent) {
            completedRequirements++;
        }

        if (ledMeetingOrActivity) {
            completedRequirements++;
        }

        if (organizedEventLogistics) {
            completedRequirements++;
        }

        if (mentoredMember) {
            completedRequirements++;
        }

        return completedRequirements >= 2;
    }


    // =========================================
    // NETWORKING BADGE
    // =========================================

    /*
     Requirements:
     - Attend a networking event
     - Connect with at least 3 professionals or alumni
     - Participate in a speaker Q&A or coffee chat
     */
    public boolean evaluateNetworkingBadge(
            boolean attendedNetworkingEvent,
            int professionalConnections,
            boolean participatedInConversation) {

        return attendedNetworkingEvent
                && professionalConnections >= 3
                && participatedInConversation;
    }


    // =========================================
    // OPERATIONAL EXCELLENCE BADGE
    // =========================================

    /*
     Requirements:
     - Create workflow or process documentation
     - Contribute to an organizational system
     - Assist with planning, analytics, or operations
     */
    public boolean evaluateOperationalExcellenceBadge(
            boolean createdDocumentation,
            boolean contributedToSystem,
            boolean assistedOperations) {

        return createdDocumentation
                && contributedToSystem
                && assistedOperations;
    }


    // =========================================
    // PROFESSIONAL DEVELOPMENT BADGE
    // =========================================

    /*
     Complete any 2:
     - Resume workshop
     - LinkedIn workshop
     - Mock interview
     - Career panel
     - Internship workshop
     */
    public boolean evaluateProfessionalDevelopmentBadge(
            boolean resumeWorkshop,
            boolean linkedInWorkshop,
            boolean mockInterview,
            boolean careerPanel,
            boolean internshipWorkshop) {

        int completedRequirements = 0;

        if (resumeWorkshop) {
            completedRequirements++;
        }

        if (linkedInWorkshop) {
            completedRequirements++;
        }

        if (mockInterview) {
            completedRequirements++;
        }

        if (careerPanel) {
            completedRequirements++;
        }

        if (internshipWorkshop) {
            completedRequirements++;
        }

        return completedRequirements >= 2;
    }


    // =========================================
    // SELECTED RECOGNITION REVIEW
    // =========================================

    /*
     Evaluates one officer for the recognition
     category selected by leadership.
     */
    public boolean evaluateSelectedBadge(
            Officer officer,
            int badgeChoice,
            Scanner input) {

        System.out.println();
        System.out.println(
                "Reviewing: " + officer.getName());

        switch (badgeChoice) {

            case 1:
                // Officer Badge uses data already stored
                // inside the Officer object.
                return evaluateOfficerBadge(officer);


            case 2:
                System.out.println(
                        "--- Leadership & Service Review ---");

                boolean volunteeredAtEvent =
                        askYesNo(
                                input,
                                "Volunteered at an AIS event?");

                boolean ledMeetingOrActivity =
                        askYesNo(
                                input,
                                "Led a meeting or activity?");

                boolean organizedEventLogistics =
                        askYesNo(
                                input,
                                "Helped organize event logistics?");

                boolean mentoredMember =
                        askYesNo(
                                input,
                                "Mentored another member?");

                return evaluateLeadershipServiceBadge(
                        volunteeredAtEvent,
                        ledMeetingOrActivity,
                        organizedEventLogistics,
                        mentoredMember);


            case 3:
                System.out.println(
                        "--- Networking Review ---");

                boolean attendedNetworkingEvent =
                        askYesNo(
                                input,
                                "Attended a networking event?");

                int professionalConnections =
                        readNonNegativeInt(
                                input,
                                "Number of professional or "
                                        + "alumni connections: ");

                boolean participatedInConversation =
                        askYesNo(
                                input,
                                "Participated in a speaker Q&A "
                                        + "or coffee chat?");

                return evaluateNetworkingBadge(
                        attendedNetworkingEvent,
                        professionalConnections,
                        participatedInConversation);


            case 4:
                System.out.println(
                        "--- Operational Excellence Review ---");

                boolean createdDocumentation =
                        askYesNo(
                                input,
                                "Created workflow or process "
                                        + "documentation?");

                boolean contributedToSystem =
                        askYesNo(
                                input,
                                "Contributed to an AIS system "
                                        + "or workflow?");

                boolean assistedOperations =
                        askYesNo(
                                input,
                                "Assisted with planning, analytics, "
                                        + "or operations?");

                return evaluateOperationalExcellenceBadge(
                        createdDocumentation,
                        contributedToSystem,
                        assistedOperations);


            case 5:
                System.out.println(
                        "--- Professional Development Review ---");

                boolean resumeWorkshop =
                        askYesNo(
                                input,
                                "Completed a resume workshop?");

                boolean linkedInWorkshop =
                        askYesNo(
                                input,
                                "Completed a LinkedIn workshop?");

                boolean mockInterview =
                        askYesNo(
                                input,
                                "Completed a mock interview?");

                boolean careerPanel =
                        askYesNo(
                                input,
                                "Attended a career panel?");

                boolean internshipWorkshop =
                        askYesNo(
                                input,
                                "Completed an internship workshop?");

                return evaluateProfessionalDevelopmentBadge(
                        resumeWorkshop,
                        linkedInWorkshop,
                        mockInterview,
                        careerPanel,
                        internshipWorkshop);


            default:
                return false;
        }
    }


    // Returns the name of the category selected.
    public String getBadgeName(int badgeChoice) {

        switch (badgeChoice) {

            case 1:
                return "AIS Officer Badge";

            case 2:
                return "Leadership & Service Badge";

            case 3:
                return "AIS Networking Badge";

            case 4:
                return "Operational Excellence Badge";

            case 5:
                return "Professional Development Badge";

            default:
                return "Unknown Recognition Category";
        }
    }


    // =========================================
    // INPUT HELPER METHODS
    // =========================================

    private boolean askYesNo(
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


    private int readNonNegativeInt(
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
}