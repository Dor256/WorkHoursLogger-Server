package work.app.logger;

import static work.app.utils.Utils.validateUserEmail;

public class WorkLogger {
    private String dateString;
    private String userEmail;

    public WorkLogger() {}

    public String getDateString() {
        return this.dateString;
    }

    public String getUserEmail() {
        if(validateUserEmail(this.userEmail)) {
            return this.userEmail;
        }
        throw new IllegalArgumentException("Must use TechSee email!");
    }
}