package kevat25.tehtava1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class tehtavaController {

    @RequestMapping("/index")
    @ResponseBody
    public String returnIndexMessage() {
        return "This is the main page";
    }

    @RequestMapping("/contact")
    @ResponseBody
    public String returnContactMessage() {
        return "This is the contact page";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String returnHelloMessage(@RequestParam (name="location") String yourLocation, @RequestParam (name="name") String yourName) {
        return "Welcome to the " + yourLocation + " " + yourName + "!";
    }
}
