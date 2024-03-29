package work.app.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import work.app.calendar.Day;
import work.app.calendar.Month;

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

@Service
public class WorkLoggerService {
    @Autowired
    private WorkLoggerRepository workLoggerRepository;
    @Autowired
    private JavaMailSender emailSender;

    public WorkLoggerService() {};

    public void enter(WorkLogger workLogger) {
        String dateString = workLogger.getDateString();
        String userEmail = workLogger.getUserEmail();
        Month month = getMonth(dateString);
        Day day = getDay(dateString);
        int weekDay = getWeekDay(dateString);
        int year = getYear(dateString);
        try {
            workLoggerRepository.getEntryByDate(weekDay, month, year, userEmail);
        } catch(EmptyResultDataAccessException exception) {
            workLoggerRepository.insertEntry(year, month, day, weekDay, dateString, userEmail);
        }
    }

    public void exit(WorkLogger workLogger) throws ParseException {
        String dateString = workLogger.getDateString();
        String userEmail = workLogger.getUserEmail();
        double workHours = Double.parseDouble(String.format("%.2f", calculateWorkHours(workLogger)));
        int weekDay = getWeekDay(dateString);
        Month month = getMonth(dateString);
        workLoggerRepository.updateExit(dateString, workHours, weekDay, month, userEmail);
    }

    public boolean checkIfInOffice(String userEmail) {
        try {
            return workLoggerRepository.isInside(userEmail);
        } catch(IncorrectResultSizeDataAccessException exception) {
            return false;
        }
    }

    public List<WorkEntry> getMonthlyWorkEntries(WorkLogger workLogger) {
        String dateString = workLogger.getDateString();
        String userEmail = workLogger.getUserEmail();
        int year = getYear(dateString);
        Month month = getMonth(dateString);
        return workLoggerRepository.queryForWorkEntries(month, year, userEmail);
    }

    public void generateCSVFile(WorkLogger workLogger) throws IOException, MessagingException {
        List<WorkEntry> workEntries = getMonthlyWorkEntries(workLogger);
        writeToCSVFile(workEntries);
        String userEmail = workLogger.getUserEmail();
        String dateString = workLogger.getDateString();
        Month month = getMonth(dateString);
        emailCSV(month.toString(), userEmail);
    }

    private void writeToCSVFile(List<WorkEntry> workEntries) throws IOException {
        FileWriter csvWriter = new FileWriter(CSV_FILE_PATH);
        csvWriter.write(String.format("%s,%s,%s,%s\n", DATE, DAY, START, FINISH));
        for (WorkEntry entry : workEntries) {
            csvWriter.write(String.format("%s,%s,%s,%s\n", entry.getDate(), entry.getDay(),
                        entry.getStart(), entry.getFinish()));
        }
        csvWriter.close();
    }

    private void emailCSV(String monthToLog, String userEmail) throws MessagingException {
        MimeMessage emailMessage = emailSender.createMimeMessage();
        MimeMessageHelper mimeHelper = new MimeMessageHelper(emailMessage, true);
        mimeHelper.setTo(userEmail);
        mimeHelper.setSubject(EMAIL_SUBJECT + monthToLog);
        mimeHelper.setText(EMAIL_SUBJECT + monthToLog);
        File csvFile = new File(CSV_FILE_PATH);
        mimeHelper.addAttachment("Work Hours.csv", csvFile);
        emailSender.send(emailMessage);
    }

    private double calculateWorkHours(WorkLogger workLogger) throws ParseException {
        String exitString = workLogger.getDateString();
        String userEmail = workLogger.getUserEmail();
        int weekDay = getWeekDay(exitString);
        Month month = getMonth(exitString);
        String enterString = workLoggerRepository.getSingleEntryDate(weekDay, month, userEmail);
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        Date enterDate = dateFormat.parse(getTime(enterString));
        Date exitDate = dateFormat.parse(getTime(exitString));
        return millisecondsToHours(exitDate.getTime() - enterDate.getTime());
    }
}