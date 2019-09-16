package work.app.calendar;


public enum Day {
    SUNDAY("Sun", "Sunday"),
    MONDAY("Mon", "Monday"),
    TUESDAY("Tue", "Tuesday"),
    WEDNESDAY("Wed", "Wednesday"),
    THURSDAY("Thu", "Thursday"),
    FRIDAY("Fri", "Friday"),
    SATURDAY("Sat", "Saturday");

    private String abbreviation;
    private String fullName;
    
    Day(String abbreviation, String fullName) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
    }

    public static String getFullName(String abbreviation) {
       for(Day day : Day.values()) {
           if(day.abbreviation.equalsIgnoreCase(abbreviation)) {
               return day.fullName;
           }
       }
       return abbreviation;
    }

    @Override
    public String toString() {
        return this.fullName;
    }
}