package oracle.java.joongang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.joongang.model.Person;

@Controller
public class StudentController {

	
	@RequestMapping(value="student_main")
    public String student_main(Model model) {
//		model.addAttribute("person", person);
//		System.out.println("student_main 1 ->" + person.getPid());
//		System.out.println("student_main 2 ->" + person.getPpw());
//		System.out.println("student_main 3 ->" + person.getGubun());
//		System.out.println("student_main 4 ->" + person.getYymm());
//		System.out.println("student_main 5 ->" + person.getPnum());
    	return "student_main";
    }
}
