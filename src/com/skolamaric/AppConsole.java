package com.skolamaric;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;
import com.skolamaric.servis.AdministriranjeStudenata;
import com.skolamaric.utils.PrikaziUtils;

public class AppConsole {
	/*
	 * Konzolna aplikacija Graphical user interface(GUI)
	 */
	static AdministriranjeStudenata administriranjeStudenata = new AdministriranjeStudenata();

	public static void main(String[] args) throws ResultNotFoundException, IOException {
		Date date = new Date();
		System.out.println("Pocetak rada aplikacije: " + date);
		administriranjeStudenata.generisanje();
		Scanner in = new Scanner(System.in);

		while (1 == 1) {
			System.out.println("-----------------GLAVNA PETLJA------------------");
			prikaziOpcije();
			String s = in.nextLine();
			switch (s) {
			case "0":
				Opcija0();
				break;
			case "1":
				Opcija1();
				break;
			case "2":
				Opcija2();
				break;
			case "3":
				Opcija3();
				break;
			case "4":
				Opcija4();
				break;
			case "5":
				Opcija5();
				break;
			case "6":
				Opcija6();
				break;
			}
			if ("kraj".equals(s)) {
				System.out.println("Uneli ste komandu za kraj.");
				System.out.println("Program je izvrsen. Hvala!!!");
				break;
			}
		}
	}

	private static void Opcija0() throws ResultNotFoundException, IOException {
		List<Student> studenti = administriranjeStudenata.dajSveStudente();
		System.out.println("--------------------------------------------");
		System.out.println("Ukupan broj studenata: " + studenti.size());
		PrikaziUtils.IzlistajStudente(studenti);
		//PrikaziUtils.izlistajStudenteIzDatoteke();
	}

	private static void Opcija1() throws ResultNotFoundException {
		List<Student> student1 = administriranjeStudenata.studentiPrveGodine();	
		System.out.println("--------------------------------------------");
		System.out.println("Ukupan broj studenata prve godine: " + student1.size());
		PrikaziUtils.IzlistajStudente(student1);
	}

	private static void Opcija2() throws ResultNotFoundException {
		List<Student> student2 = administriranjeStudenata.studentiDrugeGodine();
		System.out.println("--------------------------------------------");
		System.out.println("Ukupan broj studenata druge godine: " + student2.size());
		PrikaziUtils.IzlistajStudente(student2);
	}

	private static void Opcija3() throws ResultNotFoundException {
		List<Student> student3 = administriranjeStudenata.studentiTreceGodine();
		System.out.println("--------------------------------------------");
		System.out.println("Ukupan broj studenata trece godine: " + student3.size());
		PrikaziUtils.IzlistajStudente(student3);
	}

	private static void Opcija4() throws ResultNotFoundException {
		List<Student> student4 = administriranjeStudenata.studentiCetvrteGodine();
		System.out.println("--------------------------------------------");
		System.out.println("Ukupan broj studenata cetvrte godine: " + student4.size());
		PrikaziUtils.IzlistajStudente(student4);
	}

	private static void Opcija5() throws ResultNotFoundException {
		List<Student> student5 = administriranjeStudenata.studentiApsolventi();
		System.out.println("--------------------------------------------");
		System.out.println("Ukupan broj studenata apsolvenata: " + student5.size());
		PrikaziUtils.IzlistajStudente(student5);
		
	}
	private static void Opcija6() throws ResultNotFoundException {
		administriranjeStudenata.deleteAll();
		System.out.println("SVI STUDENTI OBRISANI!!!");
		}
	
	private static void prikaziOpcije() {
		System.out.println("opcija 0 - izlistaj sve studente");
		System.out.println("opcija 1 - izlistaj studente prve godine");
		System.out.println("opcija 2 - izlistaj studente druge godine");
		System.out.println("opcija 3 - izlistaj studente trece godine");
		System.out.println("opcija 4 - izlistaj studente cetvrte godine");
		System.out.println("opcija 5 - izlistaj studente apsolvente");
		System.out.println("opcija 6 - obrisi sve");
	}
}
