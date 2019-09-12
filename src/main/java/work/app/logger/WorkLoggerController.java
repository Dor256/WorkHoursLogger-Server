package work.app.logger;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkLoggerController {
    @Autowired
    private WorkLoggerService workLoggerService;

    @PostMapping("/log")
    public void enter(@RequestBody WorkLogger workLogger) throws SQLException {
        workLoggerService.enter(workLogger);
    }

    @PutMapping("/log")
    public void exit(@RequestBody WorkLogger workLogger) throws SQLException {
        workLoggerService.exit(workLogger);
    }
}