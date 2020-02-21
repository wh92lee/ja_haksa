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

	public List<Person> list_i(Person person) {
//		System.out.println("SJInterviewDaoImpl list_i start");
		return session.selectList("list_i", person);
	}
	
	public List<Person> list(Person person) {
//		System.out.println("SJInterviewDaoImpl list start");
		return session.selectList("list", person);
	}



	public int total() {
//		System.out.println("SJInterviewDaoImpl total start");
		return session.selectOne("total1");
	}


	@Override
	public int insert(Program program) {
		System.out.println("SJInterviewDaoImpl program insert start");
		return session.insert("insert1",program);
	}

	@Override
	public Person PNum(int pnum) {
		//System.out.println("SJInterviewDaoImpl Person PNum start");
		return session.selectOne("Person", pnum);
	}
	
	@Override
	public Interview Content1(int pnum) {
//		System.out.println("SJInterviewDaoImpl Interview Content start");
		return session.selectOne("Interview1", pnum);
	}
	@Override
	public Interview Content2(int pnum) {
		return session.selectOne("Interview2", pnum);
	}	
	@Override
	public Interview Content3(int pnum) {
		return session.selectOne("Interview3", pnum);
	}

	@Override
	public Person i_ch(int pnum) {
		// TODO Auto-generated method stub
		return session.selectOne("i_ch", pnum);
	}

	@Override
	public Person eval(int pnum) {
		// TODO Auto-generated method stub
		return session.selectOne("eval", pnum);
	}

	@Override
	public int c_f(Program program) {
		System.out.println("SJInterviewDaoImpl program c_f start");
		return session.insert("class_file", program);
	}

}
