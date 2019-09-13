package work.app.logger;

import java.util.Date;

public class WorkEntry {
    private String day;
    private long enter;
    private long exit;

    public WorkEntry(){};

    public WorkEntry(String day, long enter, long exit) {
        this.day = day;
        this.enter = enter;
        this.exit = exit;
    }

    public String getDay() {
        return this.day;
    }

    public long getEnter() {
        return this.enter;
    }

    public long getExit() {
        return this.exit;
    }

    public String getDateForCSV() {
        StringBuilder dateBuilder = new StringBuilder();
        Date date = new Date(this.enter);
        String[] dateString = date.toString().split(" ");
        dateBuilder.append(String.format("%s %s %s", dateString[2], dateString[1], dateString[5]));
        return dateBuilder.toString();
    }

    public String getTimeStringForCSV(long epoch) {
        Date date = new Date(epoch);
        String[] minuteAccurateTime = date.toString().split(" ")[3].split(":");
        return minuteAccurateTime[0] + ":" + minuteAccurateTime[1];
    }
}