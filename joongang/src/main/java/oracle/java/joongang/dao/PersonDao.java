package oracle.java.joongang.dao;

import oracle.java.joongang.model.Person;

public interface PersonDao {

	int join(Person person);

	int login(Person person);

	Person gubun(Person person);
	
}
