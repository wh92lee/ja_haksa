package oracle.java.joongang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.joongang.dao.BoardDao;
import oracle.java.joongang.model.Board;
import oracle.java.joongang.model.Cont;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao bd;

	@Override
	public List<Board> list(Board board) {
		System.out.println("BoardServiceImpl.list() start...");
		List<Board> boardList =bd.list(board);
		System.out.println(boardList);
		
		return boardList;
	}
	
	@Override
	public List<Cont> clist(int b_no, Cont cont) {
		System.out.println("BoardServiceImpl.clist() start...");
		List<Cont> contList =bd.clist(b_no, cont);
		System.out.println(contList);
		
		return contList;
	}

	


	@Override
	public int total() {
		System.out.println("BoardServiceImpl.total() start...");
		return bd.total();
	}

	@Override
	public Board detail(int b_no) {
		System.out.println("BoardServiceImpl.detail() start...");
		
		Board board = bd.detail(b_no);
		
		return board;
	}

	@Override
	public int insert(Board board) {
		System.out.println("BoardServiceImpl.insert() start...");
		
		return bd.insert(board);
	}

	@Override
	public int upHit(int b_no) {
		System.out.println("BoardServiceImpl.upHit() start...");
		
		return bd.upHit(b_no);
	}

	@Override
	public int modify(Board board) {
		System.out.println("BoardServiceImpl.modify() start...");
		
		int upDateCnt = bd.modify(board);
		
		return upDateCnt;
	}

	@Override
	public void delete(int b_no) {
		System.out.println("BoardServiceImpl.delete() start...");
		
		bd.delete(b_no);
		
	}

	@Override
	public int reply(Board board) {
		System.out.println("BoardServiceImpl.reply() start...");
		
		
		
		int replyCnt = bd.reply(board);
		
		return replyCnt;
	}

	@Override
	public int replycon(Cont cont) {
		System.out.println("BoardServiceImpl.replycon() start...");
		System.out.println(cont.getB_no());
		System.out.println(cont.getC_name());
		System.out.println(cont.getC_content());
		int replyconCnt = bd.replycon(cont);
		
		return replyconCnt;
	}

	@Override
	public String comodify(int c_no) {
		System.out.println("BoardServiceImpl.replycon() start...");
		String c_content = bd.comodify(c_no);
		
		return c_content;
	}

	@Override
	public int replyconupdt(Cont cont) {
		System.out.println("BoardServiceImpl.replyconupdt() start...");
		int replyconCnt = bd.replyconupdt(cont);
		
		return replyconCnt;
	}

	@Override
	public void comdelet(int c_no) {
		System.out.println("BoardServiceImpl.comdelet() start...");
		
		bd.comdelet(c_no);
	}



	

}
