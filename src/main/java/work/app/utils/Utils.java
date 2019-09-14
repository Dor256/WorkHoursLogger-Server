package work.app.utils;

import static work.app.constants.Constants.MILLIS_TO_HOURS_DIVISOR;
import static work.app.constants.Constants.SATURDAY;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;;

public class Utils {
    
    public static String capitalize(String str) {
       return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static int millisecondsToHours(long milliseconds) {
        return (int)(milliseconds / MILLIS_TO_HOURS_DIVISOR);
    }

    public static Date getDateTimeFromEpoch(long epoch) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
        // calendar.setTimeInMillis(epoch);
        return calendar.getTime();
    }

    public static String getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
        // calendar.setTime(date);
        Month month = Month.of(calendar.get(Calendar.MONTH) + 1);
        return capitalize(month.toString());
    }

    public static String getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
        // calendar.setTime(date);
        int numericalDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        numericalDayOfWeek = numericalDayOfWeek == 0 ? SATURDAY : numericalDayOfWeek;
        DayOfWeek day = DayOfWeek.of(numericalDayOfWeek);
        return capitalize(day.toString());
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+3:00"));
        // calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return year;
    }
}