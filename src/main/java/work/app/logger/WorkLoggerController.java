package work.app.logger;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WorkLoggerController {
    @Autowired
    private WorkLoggerService workLoggerService;

    @PostMapping("/log")
    public void enter(@RequestBody WorkLogger workLogger) {
        workLoggerService.enter(workLogger);
    }

    @PutMapping("/log")
    public void exit(@RequestBody WorkLogger workLogger) throws ParseException {
        workLoggerService.exit(workLogger);
    }

    @GetMapping("/")
    public boolean checkIfInOffice(@RequestParam String dateString) {
        return workLoggerService.checkIfInOffice(dateString);
    }

    @GetMapping("/log")
    public void generateCSVFile(@RequestParam String dateString) throws IOException, MessagingException {
        workLoggerService.generateCSVFile(dateString);
    }
}