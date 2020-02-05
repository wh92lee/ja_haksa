package oracle.java.joongang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.java.joongang.model.Board;
import oracle.java.joongang.model.Cont;
import oracle.java.joongang.service.BoardService;
import oracle.java.joongang.service.Paging;




@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@RequestMapping(value="list")
    public String list(Board board, Model model, String currentPage) {
		int total = bs.total();
		
		System.out.println("BoardController total->"+total);
		
		Paging pg = new Paging(total, currentPage);
		board.setStart(pg.getStart());
		board.setEnd(pg.getEnd());
		
		List<Board> list = bs.list(board);
		
		System.out.println("list->"+list);
		
		model.addAttribute("pg", pg);
		model.addAttribute("list", list);
		
		
    	return "list";
    }
	
	@RequestMapping(value="detail")
	public String detail(int b_no, Model model,Cont cont) {
		System.out.println("BoardController.detail Start...");
		
		Board board =bs.detail(b_no);
		List<Cont> clist = bs.clist(b_no, cont);
		int result = bs.upHit(b_no);
		if (result ==1) {
			System.out.println("hit count ++");
		}else {
			System.out.println("hit count err");
		}
		
		model.addAttribute("board", board);
		model.addAttribute("clist", clist);
		
		return "detail";
		
	}
	
	@RequestMapping(value="writeForm")
	public String writeForm(Model model) {
		System.out.println("BoardController.writeForm Start...");
		
		
		return "writeForm";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Board board,Model model) {
		
		int result = bs.insert(board);
		
		if(result > 0) {
			return "redirect:list.do";
		}else {
			model.addAttribute("msg", "입력에 실패했습니다.");
		}
		
		return "forward:writeForm.do";
	}
	
	@RequestMapping(value="modifyform", method=RequestMethod.POST)
	public String modifyform(int b_no, Model model) {
		System.out.println("BoardController.modifyform() Start...");
		
		Board board =bs.detail(b_no);
		model.addAttribute("board", board);
		
		return "modifyform";
		
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Board board, Model model) {
		System.out.println("BoardController.modify() Start...");
		
		int updateCnt = bs.modify(board);
		model.addAttribute("updateCnt", updateCnt);
		return "redirect:list.do";
	}
	
	@RequestMapping(value="delete")
	public String delete(int b_no, Model model) {
		bs.delete(b_no);
		return "redirect:list.do";
	}
	
	@RequestMapping(value="reply_view")
	public String reply_view(Model model, int b_no){
		System.out.println("reply_view()");
		
		Board board =bs.detail(b_no);
		model.addAttribute("board", board);
	
		return "reply_view";
	}
	
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(Board board,Model model) {
		
		int result = bs.reply(board);
		
		if(result > 0) {
			return "redirect:list.do";
		}else {
			model.addAttribute("msg", "입력에 실패했습니다.");
		}
		
		return "forward:reply_view.do";
	}
	@RequestMapping(value="replycon", method=RequestMethod.POST)
	public String replycon(Cont cont,Model model, int b_no) {
		System.out.println("BoardController.replycon() Start...");
		int result = bs.replycon(cont);
		
		if(result > 0) {
			return "forward:detail.do?b_no="+b_no;
		}else {
			model.addAttribute("msg", "입력에 실패했습니다.");
		}
		
		return "forward:detail.do?b_no="+b_no;
	}
	
	@RequestMapping(value="comodify", produces="application/text;charset=UTF-8")
	@ResponseBody
	public String comodify(Model model, int c_no) {
		System.out.println("BoardController.comodify() Start...");
		
		String c_content = bs.comodify(c_no);
		model.addAttribute("c_content", c_content);
		
		
		return c_content;
	}
	@RequestMapping(value="replyconupdt")
	public String replyconupdt(Model model, Cont cont, int b_no) {
		System.out.println("BoardController.replyconupdt() Start...");

		int result = bs.replyconupdt(cont);
		
		model.addAttribute("cont", cont);
		
		return "forward:detail.do?b_no="+b_no;
		
			
	}
	
	
	@RequestMapping(value="comdelet", produces="application/text;charset=UTF-8")
	@ResponseBody
	public String comdelet(int c_no, int b_no) {
		System.out.println("BoardController.comdelet() Start...");
		System.out.println("---------------------------");
		System.out.println(c_no);
		System.out.println(b_no);
		System.out.println("---------------------------");
		bs.comdelet(c_no);
		
		return "detail.do?b_no="+b_no;
	}
	
	
	

}
