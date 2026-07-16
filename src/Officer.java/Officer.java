public class Officer {

    // =========================================
    // FIELDS
    // =========================================

    // Basic information
    private String name;
    private String position;
    private boolean completedOnboarding;

    // Executive meeting attendance
    private int meetingsAttended;
    private int meetingsOffered;

    // Role responsibilities
    private int roleTasksCompleted;
    private int roleTasksAssigned;

    // AIS event participation
    private int eventsParticipated;
    private int eventsAvailable;

    // Contributions beyond assigned responsibilities
    private int initiativeActivities;


    // =========================================
    // CONSTRUCTOR
    // =========================================

    public Officer(String name, String position) {
        this.name = name;
        this.position = position;

        completedOnboarding = false;

        meetingsAttended = 0;
        meetingsOffered = 0;

        roleTasksCompleted = 0;
        roleTasksAssigned = 0;

        eventsParticipated = 0;
        eventsAvailable = 0;

        initiativeActivities = 0;
    }


    // =========================================
    // GETTERS
    // =========================================

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public boolean getCompletedOnboarding() {
        return completedOnboarding;
    }


    // =========================================
    // SETTERS
    // =========================================

    public void setCompletedOnboarding(
            boolean completedOnboarding) {

        this.completedOnboarding = completedOnboarding;
    }

    public void setMeetingsAttended(
            int meetingsAttended) {

        this.meetingsAttended = meetingsAttended;
    }

    public void setMeetingsOffered(
            int meetingsOffered) {

        this.meetingsOffered = meetingsOffered;
    }

    public void setRoleTasksCompleted(
            int roleTasksCompleted) {

        this.roleTasksCompleted = roleTasksCompleted;
    }

    public void setRoleTasksAssigned(
            int roleTasksAssigned) {

        this.roleTasksAssigned = roleTasksAssigned;
    }

    public void setEventsParticipated(
            int eventsParticipated) {

        this.eventsParticipated = eventsParticipated;
    }

    public void setEventsAvailable(
            int eventsAvailable) {

        this.eventsAvailable = eventsAvailable;
    }

    public void setInitiativeActivities(
            int initiativeActivities) {

        this.initiativeActivities = initiativeActivities;
    }


    // =========================================
    // ENGAGEMENT CALCULATIONS
    // =========================================

    // Meetings attended ÷ meetings offered × 100
    public double calculateMeetingAttendance() {

        if (meetingsOffered == 0) {
            return 0;
        }

        return (double) meetingsAttended
                / meetingsOffered * 100;
    }


    // Role tasks completed ÷ role tasks assigned × 100
    public double calculateRoleCompletion() {

        if (roleTasksAssigned == 0) {
            return 0;
        }

        return (double) roleTasksCompleted
                / roleTasksAssigned * 100;
    }


    // Events participated in ÷ events available × 100
    public double calculateEventParticipation() {

        if (eventsAvailable == 0) {
            return 0;
        }

        return (double) eventsParticipated
                / eventsAvailable * 100;
    }


    // Two initiative activities represent 100%
    public double calculateInitiativePercentage() {

        int initiativeTarget = 2;

        double percentage =
                (double) initiativeActivities
                        / initiativeTarget * 100;

        if (percentage > 100) {
            percentage = 100;
        }

        return percentage;
    }


    /*
     Engagement weights:

     Executive meeting attendance = 25%
     Role responsibility completion = 40%
     Event participation = 20%
     Initiative = 15%
     */
    public double calculateEngagementScore() {

        double meetingScore =
                calculateMeetingAttendance() * 0.25;

        double roleScore =
                calculateRoleCompletion() * 0.40;

        double eventScore =
                calculateEventParticipation() * 0.20;

        double initiativeScore =
                calculateInitiativePercentage() * 0.15;

        return meetingScore
                + roleScore
                + eventScore
                + initiativeScore;
    }


    public String calculateEngagementLevel() {

        double score = calculateEngagementScore();

        if (score >= 85) {
            return "Exceptional Engagement";
        } else if (score >= 70) {
            return "Highly Engaged";
        } else if (score >= 50) {
            return "Developing Engagement";
        } else {
            return "Leadership Check-In Recommended";
        }
    }


    // =========================================
    // OFFICER SUMMARY
    // =========================================

    public void displayOfficerSummary() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("          AIS ELEVATE");
        System.out.println("        Officer Summary");
        System.out.println("=================================");

        System.out.println("Officer: " + name);
        System.out.println("Position: " + position);

        System.out.printf(
                "Meeting Attendance: %.1f%%%n",
                calculateMeetingAttendance());

        System.out.printf(
                "Role Completion: %.1f%%%n",
                calculateRoleCompletion());

        System.out.printf(
                "Event Participation: %.1f%%%n",
                calculateEventParticipation());

        System.out.printf(
                "Initiative: %.1f%%%n",
                calculateInitiativePercentage());

        System.out.printf(
                "Engagement Score: %.1f%n",
                calculateEngagementScore());

        System.out.println(
                "Engagement Level: "
                        + calculateEngagementLevel());
    }
}