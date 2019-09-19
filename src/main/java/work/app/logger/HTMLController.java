package work.app.logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HTMLController {

    @GetMapping("/")
    public String sendHomePage() {
        return "index.html";
    }
}