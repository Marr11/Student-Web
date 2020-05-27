package com.skolamaric.utils;

public class KONSTANTE {
	public static final int MIN_BROJ_GODINE_STUDIJA = 1;
	public static final int MAX_BROJ_GODINE_STUDIJA = 5;
	public static final int MIN_BROJ_ZA_INDEKS = 1;
	public static final int MAX_BROJ_ZA_INDEKS = 999;
	public static final int STUDENT_PRVE_GODINE = 1;
	public static final int STUDENT_DRUGE_GODINE = 2;
	public static final int STUDENT_TRECE_GODINE = 3;
	public static final int STUDENT_CETVRTE_GODINE = 4;
	public static final int STUDENT_APSOLVENT = 5;
	public static final String myDriver = "com.mysql.cj.jdbc.Driver";
	public static final String myUrl = "jdbc:mysql://localhost:3306/student?tz=useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";

	private static final int SLOVO_A = 65;
	private static final int SLOVO_Z = 90;

	public static String slucajnoSlovo() {
		char c = (char) slucajanBrojUintervalu(SLOVO_A, SLOVO_Z);
		return String.valueOf(c);
	}

	public static int slucajanBrojUintervalu(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}
}
