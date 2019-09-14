package work.app.logger;

public class WorkEntry {
    private String day;
    private String start;
    private String finish;

    public WorkEntry(){};

    public WorkEntry(String day, String start, String finish) {
        this.day = day;
        this.start = start;
        this.finish = finish;
    }

    public String getDay() {
        return this.day;
    }

    public String getStart() {
        return this.start;
    }

    public String getFinish() {
        return this.finish;
    }

    public String getDateForCSV() {
        StringBuilder dateBuilder = new StringBuilder();
        String[] dateString = this.start.split(" ");
        dateBuilder.append(String.format("%s %s %s", dateString[2], dateString[1], dateString[3]));
        return dateBuilder.toString();
    }

    public String getTimeStringForCSV(String dateString) {
        String[] minuteAccurateTime = dateString.split(" ")[4].split(":");
        return minuteAccurateTime[0] + ":" + minuteAccurateTime[1];
    }
}