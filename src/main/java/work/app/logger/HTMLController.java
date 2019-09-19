package work.app.logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins="https://work-logger-app.herokuapp.com")
@Controller
public class HTMLController {

    @GetMapping("/")
    public String sendHomePage() {
        return "index.html";
    }
}