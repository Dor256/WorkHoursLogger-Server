package work.app.logger;

public class WorkEntry {
    private String day;
    private String date;
    private String start;
    private String finish;

    public WorkEntry(){};

    public WorkEntry(String day, String start, String finish) {
        this.day = day;
        this.date = getDateForDisplay(start);
        this.start = getTimeStringForDisplay(start);
        this.finish =  getTimeStringForDisplay(finish);
    }

    public String getDay() {
        return this.day;
    }

    public String getDate() {
        return this.date;
    }

    public String getStart() {
        return this.start;
    }

    public String getFinish() {
        return this.finish;
    }

    public String getDateForDisplay(String longDateString) {
        StringBuilder dateBuilder = new StringBuilder();
        String[] dateString = longDateString.split(" ");
        dateBuilder.append(String.format("%s %s %s", dateString[2], dateString[1], dateString[3]));
        return dateBuilder.toString();
    }

    public String getTimeStringForDisplay(String dateString) {
        String[] minuteAccurateTime = dateString.split(" ")[4].split(":");
        return minuteAccurateTime[0] + ":" + minuteAccurateTime[1];
    }
}