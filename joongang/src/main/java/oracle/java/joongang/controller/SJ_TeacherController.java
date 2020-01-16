package oracle.java.joongang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oracle.java.joongang.model.Interview;
import oracle.java.joongang.service.SJService;
import oracle.java.joongang.service.Paging;

@Controller
public class SJ_TeacherController {
	
	@Autowired
	private SJService ss;
	
	@RequestMapping(value = "sjwriteInterviewForm")
	public String sjwriteInterviewForm(Model model) {
		System.out.println("sjwriteInterviewForm start");
		return "sjwriteInterviewForm";
	}
//	
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String write(Interview interview, Model model) {
		System.out.println("interview.getReg_date->"+interview.getReg_date());
		System.out.println("write start");
		int result = ss.insert(interview);
		if (result > 0) return "redirect:a.do";
		else {
			model.addAttribute("msg","입력 실패 확인해 보세요");
			return "forward:sjwriteInterviewForm.do";
		}
	}
	
	@RequestMapping(value = "list")
	public String list(Interview interview, Model model, String currentPage) {
		System.out.println("SJ_TeacherController list start");
		int total = ss.total();
		
		System.out.println("total=>" + total);
		System.out.println("currentPage=>" + currentPage);
		//                     14     NULL(0,1....)
		Paging pg = new Paging(total, currentPage);
		interview.setStart(pg.getStart());   // 시작시 1
		interview.setEnd(pg.getEnd());     // 시작시 10 
		List<Interview> list = ss.list(interview);

		model.addAttribute("list",list);
		model.addAttribute("pg",pg);
		return "list";
	}
	
	
}
