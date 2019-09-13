package work.app.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import static work.app.utils.Utils.millisecondsToHours;
import static work.app.utils.Utils.getDateTimeFromEpoch;
import static work.app.utils.Utils.getDay;
import static work.app.utils.Utils.getMonth;
import static work.app.utils.Utils.getYear;
import static work.app.constants.Constants.CSV_FILE_PATH;
import static work.app.constants.Constants.DATE;
import static work.app.constants.Constants.DAY;
import static work.app.constants.Constants.ENTER;
import static work.app.constants.Constants.EXIT;
import static work.app.constants.Constants.EMAIL_SUBJECT;
import static work.app.constants.HiddenConstants.MY_MAIL;

@Service
public class WorkLoggerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JavaMailSender emailSender;

    public WorkLoggerService() throws SQLException {
    };

    public void enter(WorkLogger workLogger) throws SQLException {
        long epoch = workLogger.getEpoch();
        String monthString = getMonth(getDateTimeFromEpoch(epoch));
        String dayString = getDay(getDateTimeFromEpoch(epoch));
        int year = getYear(getDateTimeFromEpoch(epoch));
        jdbcTemplate.update("INSERT INTO LOG(year, month, day, enter) VALUES (?, ?, ?, ?)", year, monthString,
                dayString, epoch);
    }

    public void exit(WorkLogger workLogger) throws SQLException {
        long epoch = workLogger.getEpoch();
        int workHours = calculateWorkHours(workLogger);
        String dayString = getDay(getDateTimeFromEpoch(epoch));
        jdbcTemplate.update("UPDATE LOG SET exit = ?, hours = ? WHERE day = ?", epoch, workHours, dayString);
    }

    public void generateCSVFile(long epoch) throws IOException, MessagingException {
        int year = getYear(getDateTimeFromEpoch(epoch));
        String monthString = getMonth(getDateTimeFromEpoch(epoch));
        List<WorkEntry> workEntries = queryForWorkEntries(monthString, year);
        writeToCSVFile(workEntries);
        emailCSV(monthString);
    }

    private List<WorkEntry> queryForWorkEntries(String month, int year) {
        return jdbcTemplate.query("SELECT day, enter, exit FROM LOG WHERE month = ? AND year = ?",
                new Object[]{month, year}, (resultSet, rowNum) -> new WorkEntry(resultSet.getString("day"),
                        resultSet.getLong("enter"), resultSet.getLong("exit")));
    }

    private void writeToCSVFile(List<WorkEntry> workEntries) throws IOException {
        FileWriter csvWriter = new FileWriter(CSV_FILE_PATH);
        csvWriter.write(String.format("%s,%s,%s,%s\n", DATE, DAY, ENTER, EXIT));
        for (WorkEntry entry : workEntries) {
            csvWriter.write(String.format("%s,%s,%s,%s\n", entry.getDateForCSV(), entry.getDay(),
                    entry.getTimeStringForCSV(entry.getEnter()), entry.getTimeStringForCSV(entry.getExit())));
        }
        csvWriter.close();
    }

    private void emailCSV(String monthToLog) throws MessagingException {
        MimeMessage emailMessage = emailSender.createMimeMessage();
        MimeMessageHelper mimeHelper = new MimeMessageHelper(emailMessage, true);
        mimeHelper.setTo(MY_MAIL);
        mimeHelper.setSubject(EMAIL_SUBJECT + monthToLog);
        mimeHelper.setText(EMAIL_SUBJECT + monthToLog);
        File csvFile = new File(CSV_FILE_PATH);
        mimeHelper.addAttachment("Work Hours", csvFile);
        emailSender.send(emailMessage);
    }

    private int calculateWorkHours(WorkLogger workLogger) throws SQLException {
        long exitTime = workLogger.getEpoch();
        String dayString = getDay(getDateTimeFromEpoch(exitTime));
        Long enterTime = jdbcTemplate.queryForObject("SELECT enter FROM LOG WHERE day = ?", new Object[]{dayString}, Long.class);
        return millisecondsToHours(exitTime - enterTime);
    }
}