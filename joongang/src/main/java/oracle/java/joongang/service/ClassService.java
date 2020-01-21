package oracle.java.joongang.service;

import java.util.List;

import oracle.java.joongang.model.Class;

public interface ClassService {

	List<Class> class_list();
	Class classInfo(int class_num);

}
