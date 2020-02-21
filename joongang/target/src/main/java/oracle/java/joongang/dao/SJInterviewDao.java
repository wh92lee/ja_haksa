package oracle.java.joongang.dao;

import java.util.List;

import oracle.java.joongang.model.Interview;
import oracle.java.joongang.model.Program;
import oracle.java.joongang.model.Person;

public interface SJInterviewDao {

	int insert_i(Interview interview);
	
	int update_s(Person person);

	List<Person> list(Person person);

	int total();

	int insert(Program program);

	Person PNum(int pnum);

	List<Person> list_i(Person person);

	Interview Content1(int pnum);
	Interview Content2(int pnum);
	Interview Content3(int pnum);

	Person i_ch(int pnum);

	Person eval(int pnum);

	int c_f(Program program);
	

	

}
