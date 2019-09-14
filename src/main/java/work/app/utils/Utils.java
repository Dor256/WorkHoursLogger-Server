package work.app.utils;

import static work.app.constants.Constants.MILLIS_TO_HOURS_DIVISOR;


import work.app.calendar.Day;
import work.app.calendar.Month;

public class Utils {

    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static double millisecondsToHours(long milliseconds) {
        return (milliseconds / MILLIS_TO_HOURS_DIVISOR);
    }

    public static int getYear(String dateString) {
        int year = Integer.parseInt(dateString.split(" ")[3]);
        return year;
    }

    public static String getMonth(String dateString) {
        String month = dateString.split(" ")[1];
        return capitalize(Month.getFullName(month));
    }

    public static int getWeekDay(String dateString) {
        int weekDay = Integer.parseInt(dateString.split(" ")[2]);
        return weekDay;
    }

    public static String getDay(String dateString) {
        String day = dateString.split(" ")[0];
        return capitalize(Day.getFullName(day));
    }

    public static String getTime(String dateString) {
        String time = dateString.split(" ")[4];
        return time;
    }   
}