package oracle.java.joongang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.joongang.dao.SJInterviewDao;
import oracle.java.joongang.model.Interview;
import oracle.java.joongang.model.Person;
import oracle.java.joongang.model.Program;

@Service
public class SJServiceImpl implements SJService {

	@Autowired
	private SJInterviewDao sd;
	
	@Override
	public int insert_i(Interview interview) {
		System.out.println("SJServiceImpl insert_i start");
		return sd.insert_i(interview);
	}
	
	@Override
	public int update_s(Person person) {
		System.out.println("SJServiceImpl update_s  start");
		return sd.update_s(person);
	}
	
	@Override
	public List<Interview> list(Interview interview) {
		System.out.println("SJServiceImpl list start");
		return sd.list(interview);
	}

	@Override
	public int total() {
		System.out.println("SJServiceImpl total start");
		return sd.total();
	}

	@Override
	public int insert(Program program) {
		System.out.println("SJServiceImpl program insert start");
		return sd.insert(program);
	}


	@Override
	public String PNum(int pnum) {
		// TODO Auto-generated method stub
		return sd.PNum(pnum);
	}

	@Override
	public List<Interview> list_i1(Interview interview) {
		System.out.println("SJServiceImpl list_i1 start");
		return sd.list_i1(interview);
	}




}
