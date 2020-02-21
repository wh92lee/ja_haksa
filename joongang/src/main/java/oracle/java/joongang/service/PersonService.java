package oracle.java.joongang.service;

import oracle.java.joongang.model.Person;

public interface PersonService {

	int join(Person person);

	int login(Person person);

	Person gubun(Person person);

	String aliveChk(Person person);
}
