package oracle.java.joongang.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import oracle.java.joongang.model.Person;
import oracle.java.joongang.model.Program;
import oracle.java.joongang.service.ClassFileService;


@Controller
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
/*	@Resource(name="ClassFileService")
	private ClassFileService classfileservice;*/
	
			@RequestMapping(value="student_main")
			public String student_main(Person person, Model model) {
			return "student_main";
    }
	
			
/*	//파일 다운로드
	@RequestMapping(value="download")
	public void classfiledown()
		
		*/
			
	

}
