package oracle.java.joongang.dao;

import java.util.List;

import oracle.java.joongang.model.Class;

public interface ClassDao {

	List<Class> class_list();

	Class classInfo(int class_num);

}
