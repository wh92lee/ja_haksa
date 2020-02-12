package oracle.java.joongang.controller;
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import oracle.java.joongang.model.ClassFile;
import oracle.java.joongang.model.Person;
import oracle.java.joongang.model.Program;
import oracle.java.joongang.service.ClassFileService;
import oracle.java.joongang.service.SJService;


@Controller
public class GangsaController2 {
	
	@Autowired
	private ClassFileService classFileService;
	
	@Autowired
	private SJService ss;
	
	
	private static final Logger logger = LoggerFactory.getLogger(GangsaController2.class);

	private static String UPLOAD_PATH = "C:/upload/classFile";
	
//	@RequestMapping(value = "gangsa_main")
//	public String gangsa_main(Person person, Model model) {
//		return "gangsa_main";
//	}
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/uploadClass", method = RequestMethod.GET)
	public void uploadClass() {
		// uploadClass.jsp 로 포워딩
	}
	
	@RequestMapping(value = "/uploadClassPage")
	public String uploadClassPage() {
		return "uploadClassPage";
	}
	
	@RequestMapping(value = "/selectClassFileList")
	@ResponseBody
	public List<ClassFile> selectClassFileList(@RequestParam(value="classNum") int classNum) {
		return classFileService.selectClassFileListByClassNum(classNum);
	}
	
	@RequestMapping(value = "/downloadClassFile")
    public ModelAndView download(
    		@RequestParam(value="classFileSeq") int classFileSeq,    		
    		@RequestParam(value="classNum") int classNum
    		) throws Exception{
		
		ClassFile classFile = new ClassFile();
		classFile.setClassFileSeq(classFileSeq);
		classFile.setClassNum(classNum);
		classFile  = classFileService.selectOneClassFile(classFile);
		
		if( classFile == null) {
			throw new Exception("파일이 존재하지 않습니다1.");
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(classFile.getFilePath())
		  .append("/")
		  .append(classFile.getPhysicalName());
		  //.append(".")
		  //.append(classFile.getExt());
		
		
        //String fullPath = path + "\\" + fileName;
		String filePath = sb.toString();
        File file = new File(filePath);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("file", file);
        map.put("classFile", classFile);
        
        return new ModelAndView("downloadView", "map", map);
    }
	
	@RequestMapping(value = "/uploadClassFile")
	@ResponseBody
	public String uploadClassFile(
					@RequestParam(value="ban") int classNum,
					@RequestParam(value="file") List<MultipartFile> files,
					@RequestParam(value="deleteFileSeqList") List<Integer> deleteFileSeqList) throws Exception {
	 
		List<ClassFile> classFileList = new ArrayList<ClassFile>();
		for(MultipartFile file : files) {
			
			ClassFile  classFile  = new ClassFile();
			
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddHHmmss");		
			Date time = new Date();
			String time1 = format1.format(time);
			//System.out.println(time1);
			
			String physicalName = time1.toString() + "_" + file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			classFile.setExt(extension);
			
			//UUID uuid = UUID.randomUUID();
			//String physicalName = System.currentTimeMillis() + uuid.toString().replace("-", "");
			
			
			classFile.setPhysicalName(physicalName);
			classFile.setClassNum(classNum);
			classFile.setFileSize(file.getSize());
			classFile.setLogicalName(file.getOriginalFilename());
			classFile.setFilePath(UPLOAD_PATH);
			
			//classFile.setRegDt(regDt); << DB에서 처리
			classFile.setFile(file);
			classFileList.add(classFile);	
		
		}
		
		List<ClassFile>  deleteClassFileList = new ArrayList<ClassFile>();
		for( Integer deleteFileSeq : deleteFileSeqList) {
			ClassFile deleteClassFile = new ClassFile();
			deleteClassFile.setClassFileSeq(deleteFileSeq);
			deleteClassFile.setClassNum(classNum);
			deleteClassFileList.add( deleteClassFile);
		}
		
		classFileService.saveClassFile(classFileList, deleteClassFileList);
		//insertClassFile(classFileList);

		return "SUCCESS";
	}
	@RequestMapping(value="gangsa_main")
    public String gangsa_main(Person person, Model model) {
		return "gangsa_main";
    }
	
    @RequestMapping(value="file_upload")
    public String file_upload(Person person, Model model) {
		return "file_upload";
    }
	
	@RequestMapping(value = "class_file", method = RequestMethod.POST)
	public String class_file(HttpServletRequest request, MultipartFile file, Program program, Model model) throws IOException, Exception {
		System.out.println("gangsaController class_file start .....");
		System.out.println("pprofile1 =>" + file.getOriginalFilename());
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/file/");
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		logger.info("savedName1: " + savedName);
//		program.setFile(savedName);
		
		int result = ss.c_f(program); 
		//System.out.println("result->"+result);
		if (result > 0) {
			model.addAttribute("uploadPath", uploadPath);	
			return "redirect:gangsa_main.do";
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

