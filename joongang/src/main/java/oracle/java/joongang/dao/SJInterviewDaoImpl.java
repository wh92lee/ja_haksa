package oracle.java.joongang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.joongang.model.Interview;
@Repository
public class SJInterviewDaoImpl implements SJInterviewDao {
	
	@Autowired
	private SqlSession session;
		
	
	public int insert(Interview interview) {
		System.out.println("SJInterviewDaoImpl insert start");
		return session.insert("insert",interview);
	}


	
	public List<Interview> list(Interview interview) {
		System.out.println("SJInterviewDaoImpl list start");
		return session.selectList("list", interview);
	}



	public int total() {
		System.out.println("SJInterviewDaoImpl total start");
		return session.selectOne("total");
	}

}
