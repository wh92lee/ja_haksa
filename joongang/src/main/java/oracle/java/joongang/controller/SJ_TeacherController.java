package oracle.java.joongang.controller;

import java.io.File;
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

//		System.out.println("total=>" + total);
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
			
		@RequestMapping(value = "upLoadFormStart")
		public String upLoadFormStart(Model model) {
			System.out.println("upLoadFormStart Start");
			return "upLoadFormStart";
		}
		
//		@RequestMapping(value = "uploadForm", method = RequestMethod.POST)
//		public String uploadForm(Program program,HttpServletRequest request, MultipartFile file, String path, Model model)
//				throws Exception {
//			String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
//			System.out.println("uploadForm POST Start");
//			logger.info("originalName: " + file.getOriginalFilename());
//			logger.info("size: " + file.getSize());
//			//logger.info("contentType: " + file.getContentType());
//			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
//			logger.info("savedName: " + savedName);
//			
//			
//			//System.out.println("file.getSize()->"+file.getSize());
//			//System.out.println("file.getContentType()->"+file.getContentType());
//			
//			String savefile_name = savedName;
//			System.out.println("savefile_name->"+savefile_name);
//			String original_name = file.getOriginalFilename();
//			System.out.println("original_name->"+original_name);
//			int result = ss.insert(program);
//			model.addAttribute("savedName", savedName);
//			System.out.println("result->"+result);
//			if (result > 0) {
//				System.out.println("result2->"+result);
//				return "forward:uploadResult.do"; 
//			} else {
//				model.addAttribute("msg", "입력 실패 확인해 보세요");
//				return "forward:upLoadFormStart.do";
//			}
////			return "uploadResult"; 
//		}

		 @RequestMapping(value = "uploadForm", method = RequestMethod.POST)
		  public String uploadForm( HttpServletRequest request, Program program, MultipartFile file, String path, Model model) 
				  throws Exception {
			String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
			System.out.println("uploadForm POST Start");
		    logger.info("originalName: " + file.getOriginalFilename());
		    logger.info("size: " + file.getSize());
//		    logger.info("contentType: " + file.getContentType());
		    String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		    String savefile_name = savedName;
		    System.out.println("savefile_name->"+savefile_name);
		    String original_name = file.getOriginalFilename();
			System.out.println("original_name->"+original_name);
			String real_path = uploadPath+savefile_name;
			System.out.println("real_path->"+real_path);
		    logger.info("savedName: " + savedName);
		    model.addAttribute("savedName", savedName);
//		    int result = ss.insert();
//		    int result = ss.insert(program);
//		    System.out.println("result->"+result);
//			if (result > 0) {
//				System.out.println("result2->"+result);
//				return "forward:uploadResult"; 
//				return "uploadResult";
//			} else {
//				model.addAttribute("msg", "입력 실패 확인해 보세요");
//				return "forward:upLoadFormStart";
//			}
		    return "uploadResult";
		  }
		
		  @RequestMapping(value = "uploadForm1", method = RequestMethod.POST)
		  public String uploadForm1( HttpServletRequest request, MultipartFile file, Model model) 
				  throws Exception {
			System.out.println("uploadForm POST Start");
		    logger.info("originalName: " + file.getOriginalFilename());
		    String original_name = file.getOriginalFilename();
			System.out.println("original_name->"+original_name);
			logger.info("1 : "+request.getParameter("file"));
			
			//logger.info("2 : "+request.getParameter("path"));
			String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);  
			System.out.println("uploadPath->"+uploadPath);
			System.out.println("savedName->"+savedName);
			String real_path = uploadPath+savedName;
			System.out.println("real_path->"+real_path);
			
			return "uploadResult";
		  }
		 
		private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {
			UUID uid = UUID.randomUUID();
			// requestPath = requestPath + "/resources/image";
			System.out.println("uploadPath->" + uploadPath);
			// Directory 생성
			File fileDirectory = new File(uploadPath);
			if (!fileDirectory.exists()) {
				fileDirectory.mkdirs();
				System.out.println("업로드용 폴더 생성 : " + uploadPath);
			}

			String savedName = uid.toString() + "_" + originalName;
			// String path1 =
			// "C:\\spring\\springSrc39\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sMybatis\\resources\\image";
			File target = new File(uploadPath, savedName);
			// File target = new File(requestPath, savedName);
			FileCopyUtils.copy(fileData, target);
			return savedName;
		}

		@RequestMapping(value = "uploadResult", method = RequestMethod.POST)
		public String uploadResult( HttpServletRequest request, MultipartFile file, Model model) {
			System.out.println("uploadResult start");
//			//System.out.println("1 originalName => "+file.getOriginalFilename());
//			/*System.out.println("uploadResult start");
//			int result = ss.insert(program);
//			System.out.println("result1->"+result);
//			if (result > 0) {
//				System.out.println("result2->"+result);
//				return "forward:uploadForm.do"; 
//			} else {
//				model.addAttribute("msg", "입력 실패 확인해 보세요");
//				return "forward:upLoadFormStart.do";
//			}*/
	//
////			program.setUpload_num(program.getUpload_num());
////			program.setClass_num(program.getClass_num());
////			program.setFile(file.getOriginalFilename());
////			program.setOriginal_name(program.getOriginal_name());
////			program.setRoom_num(program.getRoom_num());
////			program.setReg_date(program.getReg_date());
////			program.setClass_name(program.getClass_name());
//			//int result = ss.insert();
//			
//			//int result = ss.insert(program);
//			//System.out.println("result1->"+result);
////			if (result > 0) {
////				System.out.println("result2->"+result);
////				return "redirect:uploadResult.do"; 
////			} else {
////				model.addAttribute("msg", "입력 실패 확인해 보세요");
////				return "forward:upLoadFormStart.do";
////			}
	//
	//
	//
			return "uploadResult";
	//
		}
		
//		// Ajax  Test  
//		@RequestMapping(value = "getContent1")
//		@ResponseBody
//		public Interview getContent1(int pnum, Model model) {
//			System.out.println("Ajax getContent1 pnum2->"+pnum);
//			return ss.Content1(pnum);
//		}
		
}
