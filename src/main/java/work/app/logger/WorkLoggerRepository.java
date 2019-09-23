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

    public void insertEntry(int year, Month month, Day day, int weekDay, String dateString) {
        jdbcTemplate.update(
            "INSERT INTO LOG(year, month, day, weekday, start) VALUES (?, ?, ?, ?, ?)", 
            year, month.toString(), day.toString(), weekDay, dateString
        );
    }

    public void updateExit(String dateString, double workHours, int weekDay, Month month) {
        jdbcTemplate.update(
            "UPDATE LOG SET finish = ?, hours = ? WHERE weekday = ? AND month = ?", 
            dateString, workHours, weekDay, month.toString()
        );
    }

    public String getSingleEntryDate(int weekDay, Month month) {
        return jdbcTemplate.queryForObject(
                    "SELECT start FROM LOG WHERE weekday = ? AND month = ?", 
                    new Object[]{weekDay, month.toString()}, String.class
                );
    }

    public List<WorkEntry> queryForWorkEntries(Month month, int year) {
        Month previousMonth = Month.getPreviousMonth(month);
        return jdbcTemplate.query(
            "SELECT day, start, finish FROM LOG WHERE (month = ? AND weekday <= ?) OR (month = ? AND weekday > ?) AND year = ?",
            new Object[]{ month.toString(), END_OF_MONTH, previousMonth.toString(), END_OF_MONTH, year }, 
            (resultSet, rowNum) ->  new WorkEntry(resultSet.getString("day"), resultSet.getString("start"), resultSet.getString("finish")));
    }

    public WorkEntry getEntryByDate(int weekDay, Month month, int year) {
        return jdbcTemplate.queryForObject(
                    "SELECT day, start, finish FROM LOG WHERE weekday = ? AND month = ? AND year = ?", 
                    new Object[]{ weekDay, month.toString(), year },
                    WorkEntry.class
                );
    }
}