package work.app.logger;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static work.app.utils.Utils.validateUserEmail;

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

    @PostMapping("/check")
    public boolean checkIfInOffice(@RequestBody String userEmail) {
        if(validateUserEmail(userEmail)){
            return workLoggerService.checkIfInOffice(userEmail);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/send")
    public void generateCSVFile(@RequestBody WorkLogger workLogger) throws IOException, MessagingException {
        workLoggerService.generateCSVFile(workLogger);
    }
}