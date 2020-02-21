package oracle.java.joongang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.joongang.model.Person;

@Controller
public class GangsaController2 {
	
	
	@RequestMapping(value="gangsa_main")
    public String gangsa_main(Person person, Model model) {
    	return "gangsa_main";
    }
}
