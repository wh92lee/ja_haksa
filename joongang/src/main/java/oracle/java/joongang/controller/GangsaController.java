package oracle.java.joongang.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import oracle.java.joongang.model.Person;
import oracle.java.joongang.model.Program;
import oracle.java.joongang.service.SJService;

@Controller
public class GangsaController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private SJService ss;
	
	@RequestMapping(value="gangsa_main")
    public String gangsa_main(Person person, Model model) {
		return "gangsa_main";
    }
	
	@RequestMapping(value="a")
    public String a(HttpServletRequest request/*, MultipartFile file*/, Program program, Model model) throws IOException, Exception {
//		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/file/");
//		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
//		logger.info("savedName1: " + uploadPath+savedName);
//		model.addAttribute("savedName", savedName);
    	return "a";
    }
	
    @RequestMapping(value="file_upload")
    public String file_upload(HttpServletRequest request, MultipartFile file, Program program, Model model) throws IOException, Exception {
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/file/");
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		logger.info("savedName1: " + uploadPath+savedName);
		model.addAttribute("savedName", savedName);		
    	return "forward:gangsa_main.do";
    }
	
	@RequestMapping(value = "class_file")
	public String class_file(/*HttpServletRequest request, MultipartFile file,*/ Program program, Model model) throws IOException, Exception {
		System.out.println("gangsaController class_file start .....");
//		System.out.println("pprofile1 =>" + file.getOriginalFilename());
//		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/file/");
//		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
//		logger.info("savedName1: " + uploadPath+savedName);
//		program.setSave_name(savedName);
		
		int result = ss.c_f(program); 
		//System.out.println("result->"+result);
		if (result > 0) {
//			model.addAttribute("savedName", savedName);	
//			model.addAttribute("uploadPath", uploadPath+savedName);	
			return "forward:gangsa_main.do";
		}
		else { 
			return "forward:sjlist.do"; 
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
			System.out.println("업로드용 폴더 생성1 : " + uploadPath);
		}

		String savedName = time1.toString() + "_" + originalName;
		// String path1 =
		// "C:\\spring\\springSrc39\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sMybatis\\resources\\image";
		File target = new File(uploadPath, savedName);
		// File target = new File(requestPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	
}	
