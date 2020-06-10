package com.skolamaric.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.skolamaric.dao.datasource.C3poDataSource;
import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;
import com.skolamaric.utils.KONSTANTE;
import com.skolamaric.utils.PrikaziUtils;

public class StudentDBDAO implements StudentDAO {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	@Override
	public Student create(Student student) {
		student.setIme(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo());
		student.setPrezime(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo()); 
		student.setGodinaFakulteta(PrikaziUtils.godinaStudija());
		try {
			// create a mysql database connection
			Connection conn = getConnection();

			// the mysql insert statement
			String query = " insert into studenti (ime, prezime, godinaFakulteta, aktivanStudent, brojIndeksa)"
					+ " values (?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, student.getIme());
			preparedStmt.setString(2, student.getPrezime());
			preparedStmt.setInt(3, student.getGodinaFakulteta());
			preparedStmt.setBoolean(4, student.isAktivanStudent());
			preparedStmt.setString(5, student.getBrojIndeksa());

			// execute the preparedstatement
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return student;
	}

	@Override
	public Student read(String brojIndeksa) throws ResultNotFoundException {
		Student student = new Student();
		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = " select * from studenti where brojIndeksa=?";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, brojIndeksa);

			// process the results
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {

				student.setIme(rs.getString("ime"));
				student.setPrezime(rs.getString("prezime"));
				student.setGodinaFakulteta(rs.getInt("godinaFakulteta"));
				student.setAktivanStudent(rs.getBoolean("aktivanStudent"));
				student.setBrojIndeksa(brojIndeksa);
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return student;
	}

	@Override
	public Student update(Student student) {
		try {
			// create a mysql database connection
			Connection conn = getConnection();

			// the mysql insert statement
			String query = " update studenti set ime =?, prezime=?, godinaFakulteta=?, aktivanStudent=? where  brojIndeksa=?";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, student.getIme());
			preparedStmt.setString(2, student.getPrezime());
			preparedStmt.setInt(3, student.getGodinaFakulteta());
			preparedStmt.setBoolean(4, student.isAktivanStudent());
			preparedStmt.setString(5, student.getBrojIndeksa());

			// execute the preparedstatement
			preparedStmt.executeUpdate();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return student;
	}

	@Override
	public void delete(String brojIndeksa) {
		Student student = new Student();
		try {
			// create the mysql database connection
			Connection conn = getConnection();

			String query = "delete from studenti where brojIndeksa =?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, brojIndeksa);

			// execute the preparedstatemen
			preparedStmt.execute();
			
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

	@Override
	public List<Student> getAll() throws ResultNotFoundException {
		List<Student> studenti = new ArrayList<Student>();
		
		try {			
			// create a mysql database connection
			Connection conn = getConnection();
			// the mysql insert statement
			String query = "select * from studenti";
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);			
			// process the results
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setIme(rs.getString("ime"));
				student.setPrezime(rs.getString("prezime"));
				student.setGodinaFakulteta(rs.getInt("godinaFakulteta"));
				student.setAktivanStudent(rs.getBoolean("aktivanStudent"));
				student.setBrojIndeksa(rs.getString("brojIndeksa"));
				studenti.add(student);
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return studenti;
	}

	@Override
	public List<Student> getStudentiPrveGodine() throws ResultNotFoundException {
		List<Student> studenti1 = new ArrayList<Student>();

		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = " select * from studenti where godinaFakulteta =? ";
			

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, KONSTANTE.STUDENT_PRVE_GODINE);
			// process the results
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setIme(rs.getString("ime"));
				student.setPrezime(rs.getString("prezime"));
				student.setGodinaFakulteta(rs.getInt("godinaFakulteta"));
				student.setAktivanStudent(rs.getBoolean("aktivanStudent"));
				student.setBrojIndeksa(rs.getString("brojIndeksa"));
				studenti1.add(student);
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return studenti1;
	}

	@Override
	public List<Student> getStudentiDrugeGodine() throws ResultNotFoundException {
		List<Student> studenti2 = new ArrayList<Student>();

		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
		String query = " select * from studenti where godinaFakulteta =?  ";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, KONSTANTE.STUDENT_DRUGE_GODINE);
			// process the results
			ResultSet rs = preparedStmt.executeQuery();
			

			while (rs.next()) {
				Student student = new Student();
				student.setIme(rs.getString("ime"));
				student.setPrezime(rs.getString("prezime"));
				student.setGodinaFakulteta(rs.getInt("godinaFakulteta"));
				student.setAktivanStudent(rs.getBoolean("aktivanStudent"));
				student.setBrojIndeksa(rs.getString("brojIndeksa"));
				studenti2.add(student);
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return studenti2;
	}

	@Override
	public List<Student> getStudentiTreceGodine() throws ResultNotFoundException {
		List<Student> studenti3 = new ArrayList<Student>();

		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = " select * from studenti where godinaFakulteta = ? ";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, KONSTANTE.STUDENT_TRECE_GODINE);
			// process the results
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setIme(rs.getString("ime"));
				student.setPrezime(rs.getString("prezime"));
				student.setGodinaFakulteta(rs.getInt("godinaFakulteta"));
				student.setAktivanStudent(rs.getBoolean("aktivanStudent"));
				student.setBrojIndeksa(rs.getString("brojIndeksa"));
				studenti3.add(student);
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return studenti3;
	}

	@Override
	public List<Student> getStudentiCetvrteGodine() throws ResultNotFoundException {
		List<Student> studenti4 = new ArrayList<Student>();

		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = " select * from studenti where godinaFakulteta = ? ";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, KONSTANTE.STUDENT_CETVRTE_GODINE);
			// process the results
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setIme(rs.getString("ime"));
				student.setPrezime(rs.getString("prezime"));
				student.setGodinaFakulteta(rs.getInt("godinaFakulteta"));
				student.setAktivanStudent(rs.getBoolean("aktivanStudent"));
				student.setBrojIndeksa(rs.getString("brojIndeksa"));
				studenti4.add(student);
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return studenti4;
	}

	@Override
	public List<Student> getStudentiApsolventi() throws ResultNotFoundException {
		List<Student> studenti5 = new ArrayList<Student>();

		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = " select * from studenti where godinaFakulteta = ? ";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, KONSTANTE.STUDENT_APSOLVENT);
			
			// process the results
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setIme(rs.getString("ime"));
				student.setPrezime(rs.getString("prezime"));
				student.setGodinaFakulteta(rs.getInt("godinaFakulteta"));
				student.setAktivanStudent(rs.getBoolean("aktivanStudent"));
				student.setBrojIndeksa(rs.getString("brojIndeksa"));
				studenti5.add(student);
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return studenti5;
	}

	@Override
	public int count() throws ResultNotFoundException {

		int count = 0;
		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = " select count(*)as broj from studenti";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);

			// process the results
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("broj");
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return count;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(KONSTANTE.myDriver);
		return C3poDataSource.getConnection();
		//return DriverManager.getConnection(KONSTANTE.myUrl, "root", "root");
	}

	@Override
	public List<Student> getAll(int pageNumber) {
		List<Student> studenti = new ArrayList<Student>();
		
		try {			
			// create a mysql database connection
			Connection conn = getConnection();
			int brojPrvogSloga = (pageNumber - 1)*KONSTANTE.BROJ_PRIKAZA_PO_STRANICI +1;
			// the mysql insert statement
			String query = "select * from studenti LIMIT "+ brojPrvogSloga +  " ," +  KONSTANTE.BROJ_PRIKAZA_PO_STRANICI;
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);			
			// process the results
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setIme(rs.getString("ime"));
				student.setPrezime(rs.getString("prezime"));
				student.setGodinaFakulteta(rs.getInt("godinaFakulteta"));
				student.setAktivanStudent(rs.getBoolean("aktivanStudent"));
				student.setBrojIndeksa(rs.getString("brojIndeksa"));
				studenti.add(student);
			}
			rs.close();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return studenti;
	}

}
