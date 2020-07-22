package com.skolamaric.servllets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Roles;
import com.skolamaric.model.Student;
import com.skolamaric.servis.AdministriranjeStudenata;

/**
 * Servlet implementation class AdminHomeServlet
 */

@WebServlet(value = "/vezbaSecurity/adminHomeServlet.html")
public class AdminHomeServlet extends BaseAutorization {
	private static final long serialVersionUID = 1L;
	

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
		if (isAuthorized(request, response)){
			int pageNumber = 1;
			try {
				pageNumber = Integer.parseInt(request.getParameter("p"));
			}catch (NumberFormatException e) {
				pageNumber = 1;
			}
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
