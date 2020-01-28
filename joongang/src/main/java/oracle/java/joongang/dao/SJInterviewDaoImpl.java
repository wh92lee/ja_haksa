package oracle.java.joongang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.joongang.model.Interview;
import oracle.java.joongang.model.Program;
import oracle.java.joongang.model.Person;
@Repository
public class SJInterviewDaoImpl implements SJInterviewDao {
	
	@Autowired
	private SqlSession session;
		
	
	public int insert_i(Interview interview) {
		System.out.println("SJInterviewDaoImpl interview insert_i start");
		return session.insert("insert_i",interview);
	}
	
	public int update_s(Person person) {
		System.out.println("SJInterviewDaoImpl interview update_s start");
		return session.insert("update_s",person);
	}

	public List<Interview> list_i1(Interview interview) {
		System.out.println("SJInterviewDaoImpl list_i1 start");
		return session.selectList("list_i1", interview);
	}
	
	public List<Interview> list(Interview interview) {
		System.out.println("SJInterviewDaoImpl list start");
		return session.selectList("list", interview);
	}



	public int total() {
		System.out.println("SJInterviewDaoImpl total start");
		return session.selectOne("total1");
	}


	@Override
	public int insert(Program program) {
		System.out.println("SJInterviewDaoImpl program insert start");
		return session.insert("insert1",program);
	}

	@Override
	public String PNum(int pnum) {
		// TODO Auto-generated method stub
		return session.selectOne("TKdeptName", pnum);
	}

	



}
