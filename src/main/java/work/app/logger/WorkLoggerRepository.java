package work.app.logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import work.app.calendar.Day;
import work.app.calendar.Month;

import static work.app.constants.Constants.END_OF_MONTH;

@Repository
public class WorkLoggerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertEntry(int year, Month month, Day day, int weekDay, String dateString, String userEmail) {
        jdbcTemplate.update(
            "INSERT INTO LOG(year, month, day, weekday, start, inside, email) VALUES (?, ?, ?, ?, ?, ?, ?)", 
            year, month.toString(), day.toString(), weekDay, dateString, true, userEmail
        );
    }

    public void updateExit(String dateString, double workHours, int weekDay, Month month, String userEmail) {
        jdbcTemplate.update(
            "UPDATE LOG SET finish = ?, hours = ?, inside = ? WHERE weekday = ? AND month = ? AND inside = ? AND email = ?", 
            dateString, workHours, false, weekDay, month.toString(), true, userEmail
        );
    }

    public String getSingleEntryDate(int weekDay, Month month, String userEmail) {
        return jdbcTemplate.queryForObject(
                    "SELECT start FROM LOG WHERE weekday = ? AND month = ? AND email = ?", 
                    new Object[]{weekDay, month.toString(), userEmail}, 
                    String.class
                );
    }

    public List<WorkEntry> queryForWorkEntries(Month month, int year, String userEmail) {
        Month previousMonth = Month.getPreviousMonth(month);
        return jdbcTemplate.query(
            "SELECT day, start, finish FROM LOG WHERE (month = ? AND weekday <= ?) OR (month = ? AND weekday > ?) AND year = ? AND email = ?",
            new Object[]{ month.toString(), END_OF_MONTH, previousMonth.toString(), END_OF_MONTH, year, userEmail }, 
            (resultSet, rowNum) ->  new WorkEntry(resultSet.getString("day"), resultSet.getString("start"), resultSet.getString("finish")));
    }

    public WorkEntry getEntryByDate(int weekDay, Month month, int year, String userEmail) {
        return jdbcTemplate.queryForObject(
                    "SELECT day, start, finish FROM LOG WHERE weekday = ? AND month = ? AND year = ? AND email = ?", 
                    new Object[]{ weekDay, month.toString(), year, userEmail },
                    WorkEntry.class
                );
    }

    public boolean isInside(String userEmail) {
        return jdbcTemplate.queryForObject(
                        "SELECT inside FROM LOG WHERE inside = ? AND email = ?",
                        new Object[]{ true, userEmail },
                        Boolean.class
                    );
    }
}