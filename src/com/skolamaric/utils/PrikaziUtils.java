package com.skolamaric.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.skolamaric.model.Student;

public class PrikaziUtils {
	private static String FILE_ROOT = "c:/tmpST/izvestaj.txt";
	private static String  SEPARATOR= ";";
	
	public static void IzlistajStudente(List<Student> studenti){
		studenti.forEach(PrikaziUtils::printStudent);		
		}	
		
	public static void printStudent(Student student) {
		System.out.println(student.toString());
	}
	
	public static void izlistajStudenteUDatoteku(List<Student> studenti) throws IOException {
		//get the file reference
		Path path = Paths.get(FILE_ROOT); 
		//use try with resource to get autoclosable writer instance 
		try(BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
			for(Student s:studenti) {
				writer.write(s.toString());
				writer.newLine();
			}						
		}		
	}
	public static void izlistajStudenteIzDatoteke() throws IOException {
		Path path = Paths.get(FILE_ROOT);
		String thisLine = null; 
		try(BufferedReader reader = Files.newBufferedReader(path)){
			while((thisLine = reader.readLine()) != null) {
				System.out.println("+++++++++" + thisLine);
			}
		}
	  }
	public static int godinaStudija() {
		int broj;
		broj = (int) (Math.random() * ((KONSTANTE.MAX_BROJ_GODINE_STUDIJA - KONSTANTE.MIN_BROJ_GODINE_STUDIJA) + 1))
				+ KONSTANTE.MIN_BROJ_GODINE_STUDIJA;

		return broj;
	}
	}

