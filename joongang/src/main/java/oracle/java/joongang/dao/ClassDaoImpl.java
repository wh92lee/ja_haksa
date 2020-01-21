package oracle.java.joongang.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.joongang.model.Class;

@Repository
public class ClassDaoImpl implements ClassDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Class> class_list() {
		// TODO Auto-generated method stub'
		System.out.println("ClassDaoImpl.class_list() start .....");
		List<Class> classList = null;
		try {
			classList = session.selectList("classList");
			System.out.println(classList);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception ->"+ e.getMessage());
		}
		return classList;
	}

	@Override
	public Class classInfo(int class_num) {
		// TODO Auto-generated method stub
		System.out.println("classInfo start .....");
		
		Class classinfo = null;
		try {
			classinfo = session.selectOne("classInfo", class_num);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(classinfo.getClass_start());
		System.out.println(classinfo.getClass_end());
		System.out.println(classinfo.getMax_person());
		System.out.println(classinfo.getNow_person());
		return classinfo;
	}

}
