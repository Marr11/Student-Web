package com.skolamaric.servllets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolamaric.servis.AdministriranjeStudenata;

/**
 * Servlet implementation class ObrisiStudenta
 */
@WebServlet("/obrisiStudenta")
public class ObrisiStudenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObrisiStudenta() {
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
		String brojIndeksa ="1";
		brojIndeksa = request.getParameter("id");
			
		AdministriranjeStudenata administracija = new AdministriranjeStudenata();
		administracija.obrisiStudenta(brojIndeksa);
		request.setAttribute("brojIndeksa", brojIndeksa);
		request.getRequestDispatcher("/vezbaServleti/obrisiStudentaPrikaz.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
