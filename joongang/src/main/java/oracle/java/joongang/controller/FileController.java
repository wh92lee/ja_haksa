package oracle.java.joongang.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@RequestMapping(value = "upLoadFormStart")
	public String upLoadFormStart(Model model) {
		System.out.println("upLoadFormStart Start!");
		return "upLoadFormStart";
	}
	
	@RequestMapping(value = "uploadForm", method = RequestMethod.GET)
	public void iploadForm() {
		System.out.println("uploadForm GET Start");
	}
	
	@RequestMapping(value ="uploadForm", method = RequestMethod.POST)
	public String uploadForm(HttpServletRequest reqest, MultipartFile file, String path, Model model) throws Exception{
		String uploadPath = reqest.getSession().getServletContext().getRealPath("/upload/");
		System.out.println("uploadForm POST Start");
		logger.info("originalName: "+file.getOriginalFilename());
		logger.info("size: "+file.getSize());
		logger.info("contentType: "+ file.getContentType());
		String saveName = uploadFile(file.getOriginalFilename(), file.getBytes(), uploadPath);
		logger.info("saveName: "+saveName);
		model.addAttribute("saveName", saveName);
		return "uploadResult";
	}
	
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception{
		UUID uid = UUID.randomUUID();
		System.out.println("uploadPath: "+ uploadPath);
		File fileDirectory = new File(uploadPath);
		if(!fileDirectory.exists()) {
			fileDirectory.mkdir();
			System.out.println("���ε�� ���� ����: " + uploadPath);
		}
		
		String saveName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath, saveName);
		FileCopyUtils.copy(fileData, target);
		return saveName;
	}
	
}

