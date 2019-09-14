package work.app.calendar;


public enum Month {
    JANUARY("Jan", "January"),
    FEBUARY("Feb", "Febuary"),
    MARCH("Mar", "March"),
    APRIL("Apr", "April"),
    MAY("May", "May"),
    JUNE("Jun", "June"),
    JULY("Jul", "July"),
    AUGUST("Aug", "August"),
    SEPTEMBER("Sep", "September"),
    NOVEMBER("Nov", "November"),
    DECEMBER("Dec", "December");

    private String abbreviation;
    private String fullName;
    
    Month(String abbreviation, String fullName) {
        this.abbreviation = abbreviation;
        this.fullName = fullName;
    }

    public static String getFullName(String abbreviation) {
       for(Month month : Month.values()) {
           if(month.abbreviation.equalsIgnoreCase(abbreviation)) {
               return month.fullName;
           }
       }
       return abbreviation;
    }
}