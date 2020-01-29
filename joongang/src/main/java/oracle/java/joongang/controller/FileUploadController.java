package oracle.java.joongang.controller;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {

	@RequestMapping(value="FileUpload.do")
	public ModelAndView FileUpload(CommandMap commandMap, HttpServletRequest request)throws Exception{
	 ModelAndView mv = new ModelAndView("redirect:FileUploadForm.do");

	FileUploadService.FileUpload(((Object) commandMap).getMap().request);
	
	return mv;

}
}
