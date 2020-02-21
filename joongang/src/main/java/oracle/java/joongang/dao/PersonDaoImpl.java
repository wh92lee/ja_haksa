package oracle.java.joongang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.joongang.model.City;
import oracle.java.joongang.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public int join(Person person) {
		// TODO Auto-generated method stub
		return session.insert("student_join", person);
	}

	@Override
	public int login(Person person) {
		// TODO Auto-generated method stub
		return session.selectOne("login", person);
	}

	@Override
	public Person gubun(Person person) {
		// TODO Auto-generated method stub
		return session.selectOne("gubun", person);
	}

	@Override
	public String aliveChk(Person person) {
		// TODO Auto-generated method stub
		return session.selectOne("aliveChk", person);
	}

	@Override
	public List<City> b_city() {
		// TODO Auto-generated method stub
		return session.selectList("b_city");
	}

	@Override
	public List<City> getmcity(int b_city) {
		// TODO Auto-generated method stub
		return session.selectList("m_city", b_city);
	}

	@Override
	public int idcheck(String pid) {
		// TODO Auto-generated method stub
		return session.selectOne("idcheck", pid);
	}

	@Override
	public int addstudent(Person person) {
		// TODO Auto-generated method stub
		return session.update("addstudent", person);
	}

}

