package work.app.logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLController {

    @GetMapping("/")
    public String sendHomePage() {
        return "index.html";
    }
}