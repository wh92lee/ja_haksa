package oracle.java.joongang.service;

import java.util.List;

import oracle.java.joongang.model.Interview;

public interface SJService {

	int insert(Interview interview);

	List<Interview> list(Interview interview);

	int total();
	
}
