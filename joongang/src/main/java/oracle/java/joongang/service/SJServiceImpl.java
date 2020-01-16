package oracle.java.joongang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.joongang.dao.SJInterviewDao;
import oracle.java.joongang.model.Interview;

@Service
public class SJServiceImpl implements SJService {

	@Autowired
	private SJInterviewDao sd;
	
	@Override
	public int insert(Interview interview) {
		System.out.println("SJServiceImpl interview start");
		return sd.insert(interview);
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

	

}
