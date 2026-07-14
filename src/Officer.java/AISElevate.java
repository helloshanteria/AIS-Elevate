public class AISElevate {

    public static void main(String[] args) {

        Officer officer1 =
                new Officer("Maya Johnson", "Marketing Officer");

        officer1.setCompletedOnboarding(true);

        officer1.setMeetingsAttended(4);
        officer1.setMeetingsOffered(5);

        officer1.setRoleTasksCompleted(7);
        officer1.setRoleTasksAssigned(8);

        officer1.setEventsParticipated(3);
        officer1.setEventsAvailable(4);

        officer1.setInitiativeActivities(2);

        officer1.displayOfficerSummary();
    }
}