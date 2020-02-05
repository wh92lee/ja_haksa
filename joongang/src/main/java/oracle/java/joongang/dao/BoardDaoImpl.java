package oracle.java.joongang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.joongang.model.Board;
import oracle.java.joongang.model.Cont;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<Board> list(Board board) {
		System.out.println("EmpDaoImpl.list() start...");
		System.out.println("boardstart->" + board.getStart());
		System.out.println("boardEnd->" + board.getEnd());
		
		List<Board> list = null;
		
		try {
			list = session.selectList("listAll", board);
			System.out.println(list);
			
		} catch (Exception e) {
			System.out.println("Exception-> "+e.getMessage());
		}
		
		return list;
	}
	
	@Override
	public List<Cont> clist(int b_no, Cont cont) {
		System.out.println("EmpDaoImpl.clist() start...");
		List<Cont> clist = null;
		cont.setB_no(b_no);
		System.out.println("b_no ->"+ cont.getB_no());
		
		try {
			clist = session.selectList("clistAll", b_no);
			System.out.println(clist);
			
		} catch (Exception e) {
			System.out.println("Exception-> "+e.getMessage());
		}
		
		return clist;
	}
	
	
	@Override
	public int total() {
		System.out.println("BoardDaoImpl.total start...");

		return session.selectOne("total");
	}

	@Override
	public Board detail(int b_no) {
		System.out.println("BoardDaoImpl.detail() start...");
		
		Board board = null;
		
		try {
			board = session.selectOne("detail", b_no);
			System.out.println(board);
			
		} catch (Exception e) {
			System.out.println("BoardDaoImpl.detail() Exception-> "+e.getMessage());
		}
		
		return board;
	}

	@Override
	public int insert(Board board) {
		System.out.println("BoardDaoImpl.insert() start...");
		int insertCnt = 1;
		try {
			session.insert("insert", board);
		} catch (Exception e) {
			insertCnt = 0;
			System.out.println("BoardDaoImpl.insert() err->"+e.getMessage());
		}
		return insertCnt;
	}

	@Override
	public int upHit(int b_no) {
		System.out.println("BoardDaoImpl.upHit() start...");
		
		int upHitCnt = 1;
		try {
			session.insert("upHit", b_no);
		} catch (Exception e) {
			upHitCnt = 0;
			System.out.println("BoardDaoImpl.upHit() err->"+e.getMessage());
		}
		return upHitCnt;
	}

	@Override
	public int modify(Board board) {
		System.out.println("BoardDaoImpl.modify() start...");
		
		int updateCnt = 0;
		
		try {
			session.update("modify", board);//not return
			updateCnt = 1;
		}catch (Exception e) {
			System.out.println("BoardDaoImpl.modify() error->" + e.getMessage());
		}
		
		return updateCnt;
	}

	@Override
	public void delete(int b_no) {
		session.delete("delete", b_no);
		
	}

	@Override
	public int reply(Board board) {
		int replyeCnt = 0;
		
		try {
			session.update("replyShape", board);
			session.update("reply", board);//not return
			replyeCnt = 1;
		}catch (Exception e) {
			System.out.println("BoardDaoImpl.reply() error->" + e.getMessage());
		}
		return replyeCnt;
	}

	@Override
	public int replycon(Cont cont) {
		int replyconCnt = 0;
		
		try {
			session.insert("replycon", cont);
			replyconCnt = 1;
		}catch (Exception e) {
			System.out.println("BoardDaoImpl.replycon() error->" + e.getMessage());
		}
		return replyconCnt;
	}

	@Override
	public String comodify(int c_no) {
		
		String c_content = "";
		try {
			c_content = session.selectOne("comodify", c_no);
			System.out.println(c_content);
			
		} catch (Exception e) {
			System.out.println("BoardDaoImpl.detail() Exception-> "+e.getMessage());
		}
		
		return c_content;
	}

	@Override
	public int replyconupdt(Cont cont) {
		int replyconupdtCnt = 0;
		
		try {
			session.update("replyconupdt", cont);
			replyconupdtCnt = 1;
		}catch (Exception e) {
			System.out.println("BoardDaoImpl.replycon() error->" + e.getMessage());
		}
		return replyconupdtCnt;
	}

	@Override
	public void comdelet(int c_no) {
		session.delete("comdelet", c_no);
		
	}



	
	
}
