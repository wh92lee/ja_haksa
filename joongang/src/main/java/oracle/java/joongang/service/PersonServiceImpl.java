package oracle.java.joongang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.joongang.dao.PersonDao;
import oracle.java.joongang.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao pd;

	@Override
	public int join(Person person) {
		// TODO Auto-generated method stub
		System.out.println("1 ->" + person.getGubun());
		System.out.println("2 ->" + person.getYymm());
		System.out.println("3 ->" + person.getPnum());
		System.out.println("4 ->" + person.getPid());
		System.out.println("5 ->" + person.getPpw());
		System.out.println("6 ->" + person.getPbirth());
		System.out.println("7 ->" + person.getAge());
		System.out.println("8 ->" + person.getPemail());
		System.out.println("9 ->" + person.getPaddress());
		System.out.println("10 ->" + person.getPname());
		System.out.println("11 ->" + person.getPtel());
		System.out.println("12 ->" + person.getPgender());
		System.out.println("15 ->" + person.getClass_num());
		System.out.println("13 ->" + person.getAlive());
		System.out.println("14 ->" + person.getReg_date());

		return pd.join(person);
	}

	@Override
	public int login(Person person) {
		System.out.println("1 ->" + person.getPid());
		System.out.println("2 ->" + person.getPpw());			
		return pd.login(person);
	}

	@Override
	public Person gubun(Person person) {
		System.out.println("1 ->" + person.getPid());
		System.out.println("2 ->" + person.getPpw());		
		return pd.gubun(person);
	}

	@Override
	public String aliveChk(Person person) {
		// TODO Auto-generated method stub
		return pd.aliveChk(person);
	}


	@Override
	public List<City> b_city() {
		// TODO Auto-generated method stub
		return pd.b_city();
	}

	@Override
	public List<City> getmcity(int b_city) {
		// TODO Auto-generated method stub
		return pd.getmcity(b_city);
	}

	@Override
	public int idcheck(String pid) {
		// TODO Auto-generated method stub
		return pd.idcheck(pid);
	}

	@Override
	public int addstudent(Person person) {
		// TODO Auto-generated method stub
		return pd.addstudent(person);
	}

}
