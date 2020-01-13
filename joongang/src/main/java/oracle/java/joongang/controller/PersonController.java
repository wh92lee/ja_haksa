package oracle.java.joongang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.java.joongang.model.Person;
import oracle.java.joongang.service.PersonService;



@Controller
public class PersonController {
	/*@Autowired
	private PersonService ps;*/
    
    @RequestMapping(value="login")
    public String login() {
    	System.out.println("............ main login Start .........");
    return "login"; 	
    }
    
    @RequestMapping(value="joinForm")
    public String joinForm() {
    	System.out.println("............ JoinForm Start ...........");
    return "joinForm"; 	
    }
}
