package oracle.java.joongang.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import oracle.java.joongang.model.City;
import oracle.java.joongang.model.Class;
import oracle.java.joongang.model.Person;
import oracle.java.joongang.service.ClassService;
import oracle.java.joongang.service.PersonService;


@Controller
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService ps;

	@Autowired
	private ClassService cs;


	@RequestMapping(value = "login")
	public String login() {
		System.out.println("............ main login Start .........");
		return "login";
	}

	@RequestMapping(value = "warning")
	public String warning() {
		System.out.println("............ main warning Start .........");
		return "warning";
	}

	@RequestMapping(value = "joinForm")
	public String joinForm(Model model) {
		System.out.println("............ JoinForm Start ...........");
		List<Class> class_list = cs.class_list();
		List<City> b_city = ps.b_city();
		System.out.println("b_city ->"+ b_city);
		System.out.println("class_list ->" + class_list);
		model.addAttribute("classlist", class_list);
		model.addAttribute("b_city", b_city);
		return "joinForm";
	}

	@RequestMapping(value = "idCheck")
	@ResponseBody
	public int idCheck(String pid) {
		System.out.println(".......... idCheck Start .............");
		int idcheck = ps.idcheck(pid);
		System.out.println("idcheck =>" + idcheck);
		return idcheck;
	}
	@RequestMapping(value="getMcity")
	@ResponseBody
	public List<City> getMcity(int b_city, Model model){
		System.out.println("........... getMcity Start ..............");
		List<City> m_city = ps.getmcity(b_city);
		System.out.println("m_city List => " + m_city);
		//model.addAttribute("m_city", m_city);
		return m_city;
	}
	// @RequestMapping(value="getClassInfo",
	// produces="application/text;charset=UTF-8")
	// 단어 하나값만 가져오는게 아닐때에는 produces 사용시 값을 가져오지 않는다.
	@RequestMapping(value = "getClassInfo")
	@ResponseBody
	public Class getClassInfo(int class_num, Model model) {

		return cs.classInfo(class_num);
	}

	@RequestMapping(value = "joinPro", method = RequestMethod.POST)
	public String joinPro(HttpServletRequest request, MultipartFile profile, Person person, Model model) throws IOException, Exception {
		System.out.println("PersonController joinPro start .....");
		System.out.println("pprofile =>" + profile.getOriginalFilename());
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/profile/");
		String savedName = uploadFile(profile.getOriginalFilename(), profile.getBytes(), uploadPath);
		logger.info("savedName: " + savedName);
		person.setPprofile(savedName);
		int result = ps.join(person); // 가입
		if (result > 0) {
			int addStudent = ps.addstudent(person); // 가입시 강의 현재인원에 +1 기능
			return "redirect:login.do";
		}else { 
			return "forward:joinForm.do"; 
		}
	}

	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddHHmmss");		
		Date time = new Date();
		String time1 = format1.format(time);
		System.out.println(time1);
		
		/*UUID uid = UUID.randomUUID();
		*/// requestPath = requestPath + "/resources/image";
		System.out.println("uploadPath->" + uploadPath);
		// Directory 생성
		File fileDirectory = new File(uploadPath);
		if (!fileDirectory.exists()) {
			fileDirectory.mkdirs();
			System.out.println("업로드용 폴더 생성 : " + uploadPath);
		}

		String savedName = time1.toString() + "_" + originalName;
		// String path1 =
		// "C:\\spring\\springSrc39\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sMybatis\\resources\\image";
		File target = new File(uploadPath, savedName);
		// File target = new File(requestPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}

	@RequestMapping(value = "loginPro")
	public String loginPro(Person person, Model model, HttpServletRequest request) {
		System.out.println("PersonController joinPro start .....");
		Person gubun = null;
		int result = ps.login(person);
		System.out.println("result ->" + result);
		if (result > 0) {
			String alive = ps.aliveChk(person);
			model.addAttribute("alive", alive);
			if (alive.equals("A")) {
				System.out.println(person.getPid()+"/"+person.getPpw()+"/"+person.getPname());
				HttpSession session = request.getSession();
				session.setAttribute("pid", person.getPid());
				session.setAttribute("ppw", person.getPpw());
				gubun = ps.gubun(person);
				int usergubun = gubun.getGubun();

				switch (usergubun) {
				case 1:
					System.out.println("usergubun =>" + usergubun);
					return "forward:student_main.do";
				case 2:
					System.out.println("usergubun =>" + usergubun);
					return "forward:gangsa_main.do";
				case 3:
					System.out.println("usergubun =>" + usergubun);
					return "forward:insa_main.do";
				default:
					break;
				}
			} else if (alive.equals("R")) {
				System.out.println("useralive =>" + alive);
				return "login_denial";
			} else {
				System.out.println("useralive =>" + alive);
				return "login_denial";
			}
		} else {
			return "redirect:login.do";
		}
		return null;
	}

	@RequestMapping(value = "nav_menu")
	public String nav_menu() {
		return "test";
	}

}
