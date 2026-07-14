//OFFICER CLASS - stores information about an officer and calculates information related to that officer //

/* FIELDS - These fields support both the engagement score and the Officer Badge
 */

public class Officer {
    //Basic Information
    private String name;
    private String position;
    private boolean completedOnboarding;

    //Attendance
    private int meetingsAttended;
    private int meetingsOffered;

    //Responsibilities
    private int roleTasksCompleted;
    private int roleTasksAssigned;

    //Events
    private int eventsParticipated;
    private int eventsAvailable;

    //Contributions & Initiative
    private int initiativeActivities;


    /* CONSTRUCTOR - The constructor allows us to create an officer and provide their information
     */

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

    /// ////////

    public void setCompletedOnboarding(boolean completedOnboarding) {
        this.completedOnboarding = completedOnboarding;
    }

    public void setMeetingsAttended(int meetingsAttended) {
        this.meetingsAttended = meetingsAttended;
    }

    public void setMeetingsOffered(int meetingsOffered) {
        this.meetingsOffered = meetingsOffered;
    }

    public void setRoleTasksCompleted(int roleTasksCompleted) {
        this.roleTasksCompleted = roleTasksCompleted;
    }

    public void setRoleTasksAssigned(int roleTasksAssigned) {
        this.roleTasksAssigned = roleTasksAssigned;
    }

    public void setEventsParticipated(int eventsParticipated) {
        this.eventsParticipated = eventsParticipated;
    }

    public void setEventsAvailable(int eventsAvailable) {
        this.eventsAvailable = eventsAvailable;
    }

    public void setInitiativeActivities(int initiativeActivities) {
        this.initiativeActivities = initiativeActivities;
    }

    /* METHODS - action items and evaluations */

    //this calculates the percentage of executive meetings the officer attended
//formula - Meetings Attended / Meetings Offered x 100
    public double calculateMeetingAttendance() {
        if (meetingsOffered == 0) {
            return 0;
        }
        return (double) meetingsAttended / meetingsOffered * 100;
    }

    //this measures how many assigned responsibilities were completed
//formula - Role Tasks Completed ÷ Role Tasks Assigned × 100
    public double calculateRoleCompletion() {
        if (roleTasksAssigned == 0) {
            return 0;
        }
        return (double) roleTasksCompleted / roleTasksAssigned * 100;
    }

    //this measures the officer's participation in available AIS events
//formula - Events Participated In ÷ Events Available × 100
    public double calculateEventParticipation() {
        if (eventsAvailable == 0) {
            return 0;
        }
        return (double) eventsParticipated / eventsAvailable * 100;
    }

    //this measures the officer’s progress toward the leadership and professional-growth target
//formula - Growth Activities Completed ÷ Growth Target × 100
    public double calculateInitiativePercentage() {
        int contributionTarget = 2;

        double percentage =
                (double) initiativeActivities
                        / contributionTarget * 100;

        if (percentage > 100) {
            percentage = 100;
        }
        return percentage;
    }

    //this method combines the four individual percentages into one overall engagement score
/*Meeting Attendance = 80%
Role Completion = 90%
Event Participation = 75%
Initiative = 100%
 */
    public double calculateEngagementScore() {

        double meetingScore = calculateMeetingAttendance() * 0.25;

        double roleScore = calculateRoleCompletion() * 0.40;

        double eventScore = calculateEventParticipation() * 0.20;

        double initiativeScore = calculateInitiativePercentage() * 0.15;

        return meetingScore + roleScore + eventScore + initiativeScore;
    }

    //this method converts numbers into words
/*Business Rules:
Score	Level
85–100	Exceptional Engagement
70–84	Highly Engaged
50–69	Developing Engagement
Below 50	Leadership Check-In Recommended
 */
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

    //this method prints everything about one officer
    public void displayOfficerSummary() {
        System.out.println("=================================");
        System.out.println("          AIS ELEVATE            ");
        System.out.println("        Officer Summary          ");
        System.out.println("=================================");

        System.out.println("Officer: " + name);
        System.out.println("Position: " + position);

        System.out.println("Meeting Attendance: "
                + calculateMeetingAttendance() + "%");

        System.out.println("Role Completion: "
                + calculateRoleCompletion() + "%");

        System.out.println("Event Participation: "
                + calculateEventParticipation() + "%");

        System.out.println("Initiative: "
                + calculateInitiativePercentage() + "%");

        System.out.println("Engagement Score: "
                + calculateEngagementScore());

        System.out.println("Engagement Level: "
                + calculateEngagementLevel());

    }
}
