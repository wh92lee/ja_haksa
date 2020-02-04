package oracle.java.joongang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.joongang.model.Person;
import oracle.java.joongang.service.SJService;

@Controller
public class GangsaController2 {
	
	@Autowired
	private SJService ss;
	
	@RequestMapping(value="gangsa_main")
    public String gangsa_main(Person person, Model model) {
		List<Person> photo = ss.photo(person);
		model.addAttribute("photo", photo);
		return "gangsa_main";
    }
}	
