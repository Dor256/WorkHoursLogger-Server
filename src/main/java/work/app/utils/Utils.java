package work.app.utils;

import static work.app.constants.Constants.MILLIS_TO_HOURS_DIVISOR;;

public class Utils {
    
    public static String capitalize(String str) {
       return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static int millisecondsToHours(long milliseconds) {
        return (int)(milliseconds / MILLIS_TO_HOURS_DIVISOR);
    }
}