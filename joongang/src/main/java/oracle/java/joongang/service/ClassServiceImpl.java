package oracle.java.joongang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.joongang.dao.ClassDao;
import oracle.java.joongang.model.Class;

@Service
public class ClassServiceImpl implements ClassService {
	
	
	
	@Autowired
	private ClassDao cd;
	
	@Override
	public List<Class> class_list() {
		// TODO Auto-generated method stub
		System.out.println("class_list() start ......");
		List<Class> classList = cd.class_list();
		return classList;
	}

	@Override
	public Class classInfo(int class_num) {
		// TODO Auto-generated method stub
		return cd.classInfo(class_num);
	}

}
