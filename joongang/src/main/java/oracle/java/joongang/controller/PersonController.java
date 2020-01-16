package oracle.java.joongang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.java.joongang.model.Class;
import oracle.java.joongang.model.Person;
import oracle.java.joongang.service.ClassService;
import oracle.java.joongang.service.PersonService;



@Controller
public class PersonController {
	
//	@Autowired
//	private PersonService ps;
	
	@Autowired
	private ClassService cs;
    
    @RequestMapping(value="login")
    public String login() {
    	System.out.println("............ main login Start .........");
    return "login"; 	
    }
    
    @RequestMapping(value="joinForm")
    public String joinForm(Model model) {
    	System.out.println("............ JoinForm Start ...........");
    List<Class> class_list = cs.class_list();
    System.out.println("class_list ->"+ class_list);
    model.addAttribute("classlist", class_list);
    return "joinForm"; 	
    }
    
    
    @RequestMapping(value="idCheck")
    public int idCheck(String id) {
    	
    	
    	return 0;
    }
        
   // @RequestMapping(value="getClassInfo", produces="application/text;charset=UTF-8")
    @RequestMapping(value="getClassInfo")
    @ResponseBody
   	public Class getClassInfo(int class_num, Model model) {
    	/*System.out.println("classnum ->" + classnum);
    	int class_num = Integer.parseInt(classnum);*/
    	
    	/*Class  cls = null; 
    	
    	cls=cs.classInfo(class_num);*/
   		return cs.classInfo(class_num);
   	}
   
}
