package oracle.java.joongang.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
