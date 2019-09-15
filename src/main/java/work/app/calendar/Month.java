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
    OCTOBER("Oct", "October"),
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

    public static Month getPreviousMonth(Month month) {
        switch(month) {
            case JANUARY:
                return DECEMBER;
            case FEBUARY:
                return JANUARY;
            case MARCH:
                return FEBUARY;
            case APRIL:
                return MARCH;
            case MAY:
                return APRIL;
            case JUNE:
                return MAY;
            case JULY:
                return JUNE;
            case AUGUST:
                return JULY;
            case SEPTEMBER:
                return AUGUST;
            case OCTOBER:
                return SEPTEMBER;
            case NOVEMBER:
                return OCTOBER;
            case DECEMBER:
                return NOVEMBER;
            default:
                return month;
        }
    }

    @Override
    public String toString() {
        return this.fullName;
    }
}