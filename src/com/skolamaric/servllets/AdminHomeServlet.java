 package com.skolamaric.servllets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Roles;
import com.skolamaric.model.Student;
import com.skolamaric.servis.AdministriranjeStudenata;
import com.skolamaric.utils.KONSTANTE;

/**
 * Servlet implementation class AdminHomeServlet
 */

@WebServlet("/vezbaSecurity/adminHomeServlet.html")
public class AdminHomeServlet extends BaseAutorization {
	private static final long serialVersionUID = 1L;
	private static final String CONTRO_TABLE_COOKIE = "rowsInTable";
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHomeServlet() {
		super();
		this.assignedRole = Roles.ADMIN;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);	
		int pageNumber = 1;
		try {
		pageNumber = Integer.parseInt(request.getParameter("p"));
		}catch (NumberFormatException e) {
			pageNumber = 1;
		}
		
		int rowsInTable = getRowsInTable(request);
		AdministriranjeStudenata administracija = new AdministriranjeStudenata();
		List<Student> studenti = null;
		try {
			studenti = administracija.dajSveStudente(pageNumber);
		} catch (ResultNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaStudenata", studenti);
		request.setAttribute("pageNumber", pageNumber);
			request.getRequestDispatcher("/vezbaSecurity/pages/adminHomePage.jsp").forward(request, response);
		}


	private int getRowsInTable(HttpServletRequest request) {
		  Cookie[] cookies = request.getCookies();
		  if(cookies != null) {
		      for (int i = 0; i < cookies.length; i++) {
		          Cookie cookie=cookies[i];
		          String cookieName = cookie.getName();
		          
		        if(CONTRO_TABLE_COOKIE.equals(cookieName))  
		         return Integer.parseInt(cookie.getValue());
		       }
		   }
		return KONSTANTE.BROJ_PRIKAZA_PO_STRANICI;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
