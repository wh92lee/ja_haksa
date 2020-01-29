package oracle.java.joongang.service;

import java.util.Iterator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import oracle.java.joongang.dao.FileUploadDAO;

public class FileUploadServiceImpl implements FileUploadService {
	
	
	@Override
	public void FileUpload(Map<String, Object> map, HttpServletRequest request) throws Exception {
		FileUploadDAO.FileUpload(map);
		
		MultipartHttpServletRequest multipartHttpServletRequest =(MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while(iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				System.out.println("------file Start -------");
				System.out.println("name: "+multipartFile.getName());
				System.out.println("filename: "+multipartFile.getOriginalFilename());
				System.out.println("size: "+multipartFile.getSize());
				System.out.println("--------file end------------\n");
			}
		}
	}

}
