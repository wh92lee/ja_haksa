package oracle.java.joongang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.joongang.model.Person;

@Controller
public class InsaController2 {

	
	 @RequestMapping(value="insa_main")
	    public String insa_main(Person person, Model model) {
	    	return "insa_main";
	    }
}
