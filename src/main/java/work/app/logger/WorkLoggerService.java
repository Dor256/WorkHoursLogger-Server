package work.app.logger;

import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import static work.app.utils.Utils.capitalize;
import static work.app.utils.Utils.millisecondsToHours;
import static work.app.constants.Constants.SATURDAY;

@Service
public class WorkLoggerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WorkLoggerService() throws SQLException {};

    public void enter(WorkLogger workLogger) throws SQLException {
        String monthString = getMonth(workLogger.getDateTimeFromEpoch()); 
        String dayString = getDay(workLogger.getDateTimeFromEpoch());   
        jdbcTemplate.update("INSERT INTO LOG(month, day, enter) VALUES (?, ?, ?)", monthString, dayString, workLogger.getEpoch());
    }

    public void exit(WorkLogger workLogger) throws SQLException {
        int workHours = calculateWorkHours(workLogger);
        String dayString = getDay(workLogger.getDateTimeFromEpoch());
        jdbcTemplate.update("UPDATE LOG SET exit = ?, hours = ? WHERE day = ?", workLogger.getEpoch(), workHours, dayString);
    }

    private int calculateWorkHours(WorkLogger workLogger) throws SQLException {
        String dayString = getDay(workLogger.getDateTimeFromEpoch());
        Long enterTime = jdbcTemplate.queryForObject("SELECT enter FROM LOG WHERE day = ?", new Object[]{dayString}, Long.class);
        long exitTime = workLogger.getEpoch();
        return millisecondsToHours(exitTime - enterTime);
    }

    private String getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Month month = Month.of(calendar.get(Calendar.MONTH) + 1);
        return capitalize(month.toString());
    }

    private String getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int numericalDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        numericalDayOfWeek = numericalDayOfWeek == 0 ? SATURDAY : numericalDayOfWeek;
        DayOfWeek day = DayOfWeek.of(numericalDayOfWeek);
        return capitalize(day.toString());
    }
}