package oracle.java.joongang.dao;

import java.util.List;

import oracle.java.joongang.model.Board;
import oracle.java.joongang.model.Cont;

public interface BoardDao {

	int total();
	List<Board> list(Board board);
	Board detail(int b_no);
	int insert(Board board);
	int upHit(int b_no);
	int modify(Board board);
	void delete(int b_no);
	int reply(Board board);
	int replycon(Cont cont);
	List<Cont> clist(int b_no, Cont cont);
	String comodify(int c_no);
	int replyconupdt(Cont cont);
	void comdelet(int c_no);
	



}
