package oracle.java.joongang.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import oracle.java.joongang.model.Interview;
import oracle.java.joongang.model.Person;
import oracle.java.joongang.model.Program;
import oracle.java.joongang.service.SJService;
import oracle.java.joongang.controller.SJ_TeacherController;
import oracle.java.joongang.service.Paging;

@Controller
public class SJ_TeacherController {
	private static final Logger logger = LoggerFactory.getLogger(SJ_TeacherController.class);

	@Autowired
	private SJService ss;


	
	@RequestMapping(value = "sjwriteScoreForm")
	public String sjwriteScoreForm( Model model) {
		System.out.println("sjwriteScoreForm start");
		
		return "sjwriteScoreForm";
	}

	@RequestMapping(value = "sjwriteInterviewForm")
	public String sjwriteInterviewForm(Person person, Model model) {
//		System.out.println("sjwriteInterviewForm start");
		List<Person> list_i = ss.list_i(person);
		model.addAttribute("list_i", list_i);
		return "sjwriteInterviewForm";
	}
	
	
	
	@RequestMapping(value = "write_score", method = RequestMethod.POST)
	public String write_score(Person person, Model model) {
		System.out.println("write_score start");
		int result = ss.update_s(person);
		
		if (result > 0)
			return "redirect:sjlist.do";
		else {
			model.addAttribute("msg", "입력 실패 확인해 보세요");
			return "forward:sjwriteScoreForm.do";
		}
	}
	
	@RequestMapping(value = "write_interview", method = RequestMethod.POST)
	public String write_interview(Interview interview, Model model) {
		System.out.println("write_interview start");
		int result = ss.insert_i(interview);
		System.out.println("result->"+result);
		if (result > 0) {
			return "redirect:sjlist.do";
			}
		else {
			model.addAttribute("msg", "입력 실패 확인해 보세요");
			return "forward:sjwriteInterviewForm.do";
		}
	}
	
	@RequestMapping(value = "sjlist")
	public String sjlist(Person person, Interview interview, Model model, String currentPage) {
//		System.out.println("SJ_TeacherController list start");
		int total = ss.total();

		System.out.println("total=>" + total);
//		System.out.println("currentPage=>" + currentPage);
		// 14 NULL(0,1....)
		Paging pg = new Paging(total, currentPage);
		interview.setStart(pg.getStart()); // 시작시 1
		interview.setEnd(pg.getEnd()); // 시작시 10
		List<Person> list = ss.list(person);
		model.addAttribute("list", list);
		model.addAttribute("pg", pg);
		return "sjlist";
	}

	// Ajax  Test  
		@RequestMapping(value = "PNum")
		@ResponseBody
		public Person PNum(int pnum, Model model) {
			Person pv = ss.PNum(pnum);	
//			System.out.println("pnum1->"+pnum);
			return pv;
		}
		

		// Ajax  Test  
		@RequestMapping(value = "Content1")
		@ResponseBody
		public Interview Content1(int pnum, Model model) {
			Interview ic1 = ss.Content1(pnum);
//			System.out.println("Ajax getContent1 getPnum->"+iv.getPnum());
//			System.out.println("Ajax getContent1 getInterview_content->"+iv.getInterview_content());
			return ic1;
		}
		
		@RequestMapping(value = "Content2")
		@ResponseBody
		public Interview Content2(int pnum, Model model) {
			Interview ic2 = ss.Content2(pnum);
			return ic2;
		}
	
		@RequestMapping(value = "Content3")
		@ResponseBody
		public Interview Content3(int pnum, Model model) {
			Interview ic3 = ss.Content3(pnum);
			return ic3;
		}
		
		@RequestMapping(value = "eval")
		@ResponseBody
		public Person eval(int pnum, Model model) {
			Person ev = ss.eval(pnum);
			return ev;
		}	
		
		@RequestMapping(value = "i_ch")
		@ResponseBody
		public Person i_ch(int pnum, Model model) {
			Person iv4 = ss.i_ch(pnum);
			
			return iv4;
		}		

//		// Ajax  Test  
//		@RequestMapping(value = "getContent1")
//		@ResponseBody
//		public Interview getContent1(int pnum, Model model) {
//			System.out.println("Ajax getContent1 pnum2->"+pnum);
//			return ss.Content1(pnum);
//		}
		
}
