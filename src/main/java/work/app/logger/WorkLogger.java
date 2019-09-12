package work.app.logger;

import java.util.Date;

public class WorkLogger {
    private long epoch;

    public WorkLogger() {}

    public long getEpoch() {
        return this.epoch;
    }

    public Date getDateTimeFromEpoch() {
        return new Date(this.epoch);
    }
}