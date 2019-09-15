package work.app.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import static work.app.utils.Utils.millisecondsToHours;
import static work.app.utils.Utils.getDay;
import static work.app.utils.Utils.getMonth;
import static work.app.utils.Utils.getYear;
import static work.app.utils.Utils.getWeekDay;
import static work.app.utils.Utils.getTime;
import static work.app.constants.Constants.CSV_FILE_PATH;
import static work.app.constants.Constants.DATE;
import static work.app.constants.Constants.DAY;
import static work.app.constants.Constants.START;
import static work.app.constants.Constants.FINISH;
import static work.app.constants.Constants.EMAIL_SUBJECT;
import static work.app.constants.Constants.TIME_FORMAT;
import static work.app.constants.HiddenConstants.MY_MAIL;

@Service
public class WorkLoggerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JavaMailSender emailSender;

    public WorkLoggerService() throws SQLException {};

    public void connect() {
        jdbcTemplate.execute("DROP TABLE LOG");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS LOG(Year INT, Month VARCHAR(50), Weekday INT, Day VARCHAR(50), Start VARCHAR(100), Finish VARCHAR(100), Hours FLOAT)");
    }

    public void enter(WorkLogger workLogger) throws SQLException {
        String dateString = workLogger.getDateString();
        String monthString = getMonth(dateString);
        String dayString = getDay(dateString);
        int weekDay = getWeekDay(dateString);
        int year = getYear(dateString);
        jdbcTemplate.update("INSERT INTO LOG(year, month, day, weekday, start) VALUES (?, ?, ?, ?, ?)", 
                        year, monthString, dayString, weekDay, dateString);
    }

    public void exit(WorkLogger workLogger) throws SQLException, ParseException {
        String dateString = workLogger.getDateString();
        double workHours = Double.parseDouble(String.format("%.2f", calculateWorkHours(workLogger)));
        int weekDay = getWeekDay(dateString);
        String month = getMonth(dateString);
        jdbcTemplate.update("UPDATE LOG SET finish = ?, hours = ? WHERE weekday = ? AND month = ?", 
                        dateString, workHours, weekDay, month);
    }

    public void generateCSVFile(String dateString) throws IOException, MessagingException {
        int year = getYear(dateString);
        String monthString = getMonth(dateString);
        List<WorkEntry> workEntries = queryForWorkEntries(monthString, year);
        writeToCSVFile(workEntries);
        emailCSV(monthString);
    }

    private List<WorkEntry> queryForWorkEntries(String month, int year) {
        return jdbcTemplate.query("SELECT day, start, finish FROM LOG WHERE month = ? AND year = ?",
                new Object[]{ month, year }, (resultSet, rowNum) -> new WorkEntry(resultSet.getString("day"),
                        resultSet.getString("start"), resultSet.getString("finish")));
    }

    private void writeToCSVFile(List<WorkEntry> workEntries) throws IOException {
        FileWriter csvWriter = new FileWriter(CSV_FILE_PATH);
        csvWriter.write(String.format("%s,%s,%s,%s\n", DATE, DAY, START, FINISH));
        for (WorkEntry entry : workEntries) {
            csvWriter.write(String.format("%s,%s,%s,%s\n", entry.getDateForCSV(), entry.getDay(),
                    entry.getTimeStringForCSV(entry.getStart()), entry.getTimeStringForCSV(entry.getFinish())));
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

    private double calculateWorkHours(WorkLogger workLogger) throws SQLException, ParseException {
        String exitString = workLogger.getDateString();
        int weekDay = getWeekDay(exitString);
        String month = getMonth(exitString);
        String enterString = jdbcTemplate.queryForObject("SELECT start FROM LOG WHERE weekday = ? AND month = ?", 
                                                            new Object[]{weekDay, month}, String.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        Date enterDate = dateFormat.parse(getTime(enterString));
        Date exitDate = dateFormat.parse(getTime(exitString));
        return millisecondsToHours(exitDate.getTime() - enterDate.getTime());
    }
}