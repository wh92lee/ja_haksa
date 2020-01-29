package oracle.java.joongang.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {

	void FileUpload(Map<String, Object>map, HttpServletRequest request) throws Exception;
	
}
