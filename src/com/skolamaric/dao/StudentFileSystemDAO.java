package com.skolamaric.dao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;
import com.skolamaric.utils.KONSTANTE;
import com.skolamaric.utils.PrikaziUtils;

public class StudentFileSystemDAO implements StudentDAO {
	
	private static String EXTENZIJA = ".xml";
	private static String FILE_ROOT = "c:/tmpST/";

	@Override
	public Student create(Student student) {
		  student.setBrojIndeksa(String.valueOf(System.currentTimeMillis()));
		  student.setIme(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo());
		  student.setPrezime(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo()); // poboljsaj, preko metoda i for petlje
		  student.setGodinaFakulteta(PrikaziUtils.godinaStudija());
		  
		  XMLEncoder encoder=null;
			try{
			encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILE_ROOT  + student.getBrojIndeksa() + EXTENZIJA)));
			}catch(FileNotFoundException fileNotFound){
				System.out.println("ERROR: While Creating or Opening the File dvd.xml");
			}
			encoder.writeObject(student);
			encoder.close();
		return student;
	}

	@Override
	public Student read(String brojIndeksa) throws ResultNotFoundException {
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName(brojIndeksa))));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File student not found");
		}
		Student student = (Student)decoder.readObject();
		
		return student;
	}

	@Override
	public Student update(Student student) {
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName(student.getBrojIndeksa()))));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(student);
		encoder.close();
	return student;
	}

	@Override
	public void delete(String brojIndeksa) {
		File file = new File(fileName(brojIndeksa));
        file.delete();
	}

	@Override
	public List<Student> getAll() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		List<Student> studenti = new ArrayList<Student>();
		File[] files = new File(FILE_ROOT).listFiles();
		
		for(File file : files) {
			if(file.isFile()) {
				String fileName = file.getName();
				String brojIndeksa = fileName.substring(0, fileName.lastIndexOf("."));
				studenti.add(this.read(brojIndeksa));
			}
		}
		return studenti;
	}

	@Override
	public List<Student> getStudentiPrveGodine() throws ResultNotFoundException {
		return this.getAll().stream().filter(s -> s.getGodinaFakulteta() == KONSTANTE.STUDENT_PRVE_GODINE)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiDrugeGodine() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return this.getAll().stream().filter(s -> s.getGodinaFakulteta() == KONSTANTE.STUDENT_DRUGE_GODINE)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiTreceGodine() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return this.getAll().stream().filter(s -> s.getGodinaFakulteta() == KONSTANTE.STUDENT_TRECE_GODINE)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiCetvrteGodine() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return this.getAll().stream().filter(s -> s.getGodinaFakulteta() == KONSTANTE.STUDENT_CETVRTE_GODINE)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiApsolventi() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return this.getAll().stream().filter(s -> s.getGodinaFakulteta() == KONSTANTE.STUDENT_APSOLVENT)
				.collect(Collectors.toList());
	}

	@Override
	public int count() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return this.getAll().size();
	}
	
	private String fileName(String brojIndeksa) {
		return FILE_ROOT  + brojIndeksa + EXTENZIJA;
	}

}
