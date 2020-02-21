package oracle.java.joongang.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import oracle.java.joongang.model.ClassFile;
import oracle.java.joongang.model.Person;
import oracle.java.joongang.model.Program;
import oracle.java.joongang.service.ClassFileService;

@Controller
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private ClassFileService classFileService;

	@RequestMapping(value = "student_main")
	public String student_main(Person person, Model model) {
		int classNum = 1;
		List<ClassFile> classFilesList = classFileService.selectClassFileListByClassNum(classNum);
		model.addAttribute("classFilesList", classFilesList);
		return "student_main";

	}
	@RequestMapping(value = "self_introduction")
	public String self_introduction(Person person, Model model) {
		
		return "self_introduction";
	

	@RequestMapping(value="student_main")
    public String student_main(Model model) {
//		model.addAttribute("person", person);
//		System.out.println("student_main 1 ->" + person.getPid());
//		System.out.println("student_main 2 ->" + person.getPpw());
//		System.out.println("student_main 3 ->" + person.getGubun());
//		System.out.println("student_main 4 ->" + person.getYymm());
//		System.out.println("student_main 5 ->" + person.getPnum());
    	return "student_main";
    }
	

	@RequestMapping(value = "/downloadClassFile2")
	public ModelAndView download(@RequestParam(value = "classFileSeq") int classFileSeq,
			@RequestParam(value = "classNum") int classNum) throws Exception {

		ClassFile classFile = new ClassFile();
		classFile.setClassFileSeq(classFileSeq);
		classFile.setClassNum(classNum);
		classFile = classFileService.selectOneClassFile(classFile);

		if (classFile == null) {
			throw new Exception("파일이 존재 하지 않습니다.");
		}

		StringBuffer sb = new StringBuffer();
		sb.append(classFile.getFilePath()).append("/").append(classFile.getPhysicalName());
		// .append(".")
		// .append(classFile.getExt());

		// String fullPath = path + "\\" + fileName;
		String filePath = sb.toString();
		File file = new File(filePath + "." + classFile.getExt());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("file", file);
		map.put("classFile", classFile);

		return new ModelAndView("downloadView", "map", map);
	}

	 //강의 자료 다운로드 하는 곳.
	@RequestMapping(value= "/JaryodownloadClassFile2")
	public ModelAndView jaryodownload(@RequestParam(value="classFileSep")int classFileSeq,
			@RequestParam(value="classNum")int classNum)throws Exception{
		
		ClassFile classFile = new ClassFile();
		classFile.setClassFileSeq(classFileSeq);
		classFile.setClassNum(classNum);
		classFile = classFileService.selectOneClassFile(classFile);
		
		if (classFile == null) {
			throw new Exception("파일이 존재 하지 않습니다.");
		}

		StringBuffer sb = new StringBuffer();
		sb.append(classFile.getFilePath()).append("/").append(classFile.getPhysicalName());
		// .append(".")
		// .append(classFile.getExt());

		// String fullPath = path + "\\" + fileName;
		String filePath = sb.toString();
		File file = new File(filePath + "." + classFile.getExt());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("file", file);
		map.put("classFile", classFile);

		return new ModelAndView("downloadView", "map", map);
	}


}
