package oracle.java.joongang.dao;

import java.util.List;

import oracle.java.joongang.model.Interview;
import oracle.java.joongang.model.Program;
import oracle.java.joongang.model.Person;

public interface SJInterviewDao {

	int insert_i(Interview interview);
	
	int update_s(Person person);

	List<Interview> list(Interview interview);

	int total();

	int insert(Program program);

	String PNum(int pnum);

	List<Interview> list_i1(Interview interview);

	

}
