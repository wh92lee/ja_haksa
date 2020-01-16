package oracle.java.joongang.dao;

import java.util.List;

import oracle.java.joongang.model.Interview;

public interface SJInterviewDao {

	int insert(Interview interview);

	List<Interview> list(Interview interview);

	int total();
	

}
