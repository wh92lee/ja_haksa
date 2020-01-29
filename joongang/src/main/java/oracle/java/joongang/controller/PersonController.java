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
	
	@Autowired
	private PersonService ps;
	
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
   // 단어 하나값만 가져오는게 아닐때에는 produces 사용시 값을 가져오지 않는다.
    @RequestMapping(value="getClassInfo")
    @ResponseBody
   	public Class getClassInfo(int class_num, Model model) {
    	
   		return cs.classInfo(class_num);
   	}
    
    @RequestMapping(value="joinPro")
    public String joinPro(Person person, Model model) {
    	System.out.println("PersonController joinPro start .....");
    	int result = ps.join(person);
		if (result > 0) return "redirect:login.do";
		else {
			model.addAttribute("msg","회원가입 실패 확인해 보세요");
			return "forward:joinForm.do";
		}
    }
    
    @RequestMapping(value="loginPro")
    public String loginPro(Person person, Model model) {
    	System.out.println("PersonController joinPro start .....");
    	Person gubun = null;
    	int result = ps.login(person);
		if (result > 0) {
			gubun = ps.gubun(person);
			int usergubun = gubun.getGubun();
			switch (usergubun) {
			case 1:
				System.out.println("usergubun =>" + usergubun);
				return "redirect:student_main.do";
			case 2: 
				System.out.println("usergubun =>" + usergubun);
				return "redirect:gangsa_main.do";
			case 3:
				System.out.println("usergubun =>" + usergubun);
				return "redirect:insa_main.do";
			default:
				break;
			}
		} 
		else {
			model.addAttribute("msg","로그인 실패 확인해 보세요");
			return "forward:login.do";
		}
		return null;
    }
    
   
}
