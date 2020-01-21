package oracle.java.joongang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.joongang.model.Person;

@Controller
public class StudentController {

	
	@RequestMapping(value="student_main")
    public String student_main(Person person, Model model) {
    	return "student_main";
    }
}
