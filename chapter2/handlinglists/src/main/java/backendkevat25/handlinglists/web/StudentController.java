package backendkevat25.handlinglists.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import backendkevat25.handlinglists.domain.Students;

@Controller
public class StudentController {
    private List<Students> studentList = new ArrayList<>();

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String addStudent(@RequestParam(name="firstname") String firstName, @RequestParam(name="lastname") String lastName, Model model) {
        Students student = new Students();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentList.add(student);
        return "redirect:/studentlist";
    }

    @RequestMapping(value="/studentlist", method=RequestMethod.GET)
    public String studentList(Model model) {
        model.addAttribute("students", studentList);
        return "studentlist";
    }
}
