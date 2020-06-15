package com.skolamaric.servllets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;
import com.skolamaric.servis.AdministriranjeStudenata;

/**
 * Servlet implementation class ListajStudente
 */
@WebServlet("/ListajStudente")
public class ListajStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListajStudente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNumber = Integer.parseInt(request.getParameter("p"));
		AdministriranjeStudenata administracija = new AdministriranjeStudenata();
		List<Student> studenti = null;
		try {
			studenti = administracija.dajSveStudente(pageNumber);
		} catch (ResultNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listStudenata", studenti);
		request.setAttribute("pageNumber", pageNumber);
		request.getRequestDispatcher("/vezbaServleti/listajStudentePrikaz.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
