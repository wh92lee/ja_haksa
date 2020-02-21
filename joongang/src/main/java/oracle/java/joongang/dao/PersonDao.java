package oracle.java.joongang.dao;

import java.util.List;

import oracle.java.joongang.model.City;
import oracle.java.joongang.model.Person;

public interface PersonDao {

	int join(Person person);

	int login(Person person);

	Person gubun(Person person);

	String aliveChk(Person person);

	List<City> b_city();

	List<City> getmcity(int b_city);

	int idcheck(String pid);

	int addstudent(Person person);
	
}