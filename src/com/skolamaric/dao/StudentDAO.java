package com.skolamaric.dao;

import java.util.List;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;

public interface StudentDAO {
	
	Student create (Student student);
	Student read (String brojIndeksa) throws ResultNotFoundException;
	Student update (Student student);
	void delete (String brojIndeksa);
	List<Student> getAll() throws ResultNotFoundException;
	List<Student> getStudentiPrveGodine() throws ResultNotFoundException;
	List<Student> getStudentiDrugeGodine() throws ResultNotFoundException;
	List<Student> getStudentiTreceGodine() throws ResultNotFoundException;
	List<Student> getStudentiCetvrteGodine() throws ResultNotFoundException;
	List<Student> getStudentiApsolventi() throws ResultNotFoundException;
	
	int count ()throws ResultNotFoundException;
	List<Student> getAll(int pageNumber);
}
