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
		System.out.println("1 ->"+person.getGubun());
		System.out.println("2 ->"+person.getYymm());
		System.out.println("3 ->"+person.getPnum());
		System.out.println("4 ->"+person.getPid());
		System.out.println("5 ->"+person.getPpw());
		System.out.println("6 ->"+person.getPbirth());
		System.out.println("7 ->"+person.getAge());
		System.out.println("8 ->"+person.getPemail());
		System.out.println("9 ->"+person.getPaddress());
		System.out.println("10 ->"+person.getPname());
		System.out.println("11 ->"+person.getPtel());
		System.out.println("12 ->"+person.getPgender());
		System.out.println("13 ->"+person.getAlive());
		System.out.println("14 ->"+person.getReg_date());
		
		return pd.join(person);
	}

}
