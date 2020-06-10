package com.skolamaric.servis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.skolamaric.dao.StudentDAO;
import com.skolamaric.dao.StudentDBDAO;
import com.skolamaric.dao.StudentFileSystemDAO;
import com.skolamaric.dao.StudentInMemoryDAOImpl;
import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;
import com.skolamaric.utils.KONSTANTE;
import com.skolamaric.utils.PrikaziUtils;

public class AdministriranjeStudenata {
		private static final double PRAG_RASPODJELE_STUDENATA = 0.5;

	private StudentDAO studentDAO;
	//You can never instantiate an interface in java. 
	

	public AdministriranjeStudenata() {
		//You can, however, refer to an object that implements an interface by the type of the interface.
		studentDAO = new StudentDBDAO();
	}

	public List<Student> generisanje() {
		List<Student> studenti = new ArrayList<Student>();
		
		try {
			Student poslednjiUpisaniStudent = null;
			for (int i = 0; i < 100; i++) {
				//String brojIndeksa = "";
				Student student = new Student();
				student.setBrojIndeksa(String.valueOf(System.currentTimeMillis()));				
				student.setAktivanStudent(Math.random()> PRAG_RASPODJELE_STUDENATA);
				poslednjiUpisaniStudent = studentDAO.create(student);

			}
			
			System.out.println("Upisanih studenta: " + studentDAO.count());
			poslednjiUpisaniStudent = studentDAO.read(poslednjiUpisaniStudent.getBrojIndeksa());
			System.out.println("Poslednji upisani student " + poslednjiUpisaniStudent);
			studenti = studentDAO.getAll();
			Student ucitaniStudent = studentDAO.read(poslednjiUpisaniStudent.getBrojIndeksa());
			System.out.println(ucitaniStudent);
			studenti = studentDAO.getAll();
		} catch (ResultNotFoundException e) {

			System.out.println(e.getMessage());
			System.out.println("OBRISAN!!!");
		}

		return studenti;
	}

	public List<Student> dajSveStudente() throws ResultNotFoundException {
		return studentDAO.getAll();
	}
	public List<Student> dajSveStudente(int pageNumber) throws ResultNotFoundException {
		return studentDAO.getAll(pageNumber);
	}
	public Student dajStudenta(String brojIndeksa) throws ResultNotFoundException {
		return studentDAO.read(brojIndeksa);
	}
	public void obrisiStudenta(String brojIndeksa) {
		studentDAO.delete(brojIndeksa);
	}

	/*
	 * Metoda za odvajanje liste studenata prve godine return List studenti prve
	 * godine
	 */
	public List<Student> studentiPrveGodine() throws ResultNotFoundException {
		List<Student> student1 = studentDAO.getStudentiPrveGodine();
		return student1;

	}

	/*
	 * Metoda za odvajanje liste studenata druge godine return List studenti druge
	 * godine
	 */
	public List<Student> studentiDrugeGodine() throws ResultNotFoundException {
		List<Student> student2 = studentDAO.getStudentiDrugeGodine();
		return student2;

	}

	/*
	 * Metoda za odvajanje liste studenata trece godine return List studenti trece
	 * godine
	 */
	public List<Student> studentiTreceGodine() throws ResultNotFoundException {
		List<Student> student3 = studentDAO.getStudentiTreceGodine();
		return student3;

	}

	/*
	 * Metoda za odvajanje liste studenata cetvrte godine return List studenti cetvrte
	 * godine
	 */
	public List<Student> studentiCetvrteGodine() throws ResultNotFoundException {
		List<Student> student4 = studentDAO.getStudentiCetvrteGodine();
		return student4;

	}

	/*
	 * Metoda za odvajanje liste apsolvenata return List apsolventi
	 */
	public List<Student> studentiApsolventi() throws ResultNotFoundException {
		List<Student> student5 = studentDAO.getStudentiApsolventi();
		return student5;
	}
	public void deleteAll() throws ResultNotFoundException {
		for(Student student: studentDAO.getAll()) {
			studentDAO.delete(student.getBrojIndeksa());
		}
		
	}

}
