package com.skolamaric.servllets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skolamaric.model.Roles;
import com.skolamaric.model.User;
import com.skolamaric.servis.AdministracijaKorisnika;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/vezbaSecurity/loginServlet.html")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdministracijaKorisnika administracijaKorisnika = new AdministracijaKorisnika();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		handleIsExistingUser(request, response, username, password);
	}

	private void handleIsExistingUser(HttpServletRequest request, HttpServletResponse response, String username,
			String password) throws IOException {
		if (administracijaKorisnika.isRegistered(username)) {
			 
		} else {
			response.sendRedirect("/StudentWeb/vezbaSecurity/notRegistered.html");
			handleAutentication(request, response, username, password);

		}
	}

	private void handleAutentication(HttpServletRequest request, HttpServletResponse response, String username,
			String password) throws IOException {
		if (administracijaKorisnika.isAuthenticated(username, password)) {
			handleUserRole(request, response, username);

		} else {
			response.sendRedirect("/StudentWeb/vezbaSecurity/pogresanPassword.html");

		}
	}

	private void handleUserRole(HttpServletRequest request, HttpServletResponse response, String username)
			throws IOException {
		User user = administracijaKorisnika.getUser(username);
		 if (user != null) {
			request.getSession().setAttribute("user", user);
		 }
		
		switch (user.getRole()) {
		case ADMIN:	response.sendRedirect("/StudentWeb/vezbaSecurity/adminHomeServlet.html");
			        break;			
		case USER:	response.sendRedirect("/StudentWeb/vezbaSecurity/homePageServlet.html");
		            break;
		default:    response.sendRedirect("/StudentWeb/vezbaSecurity/notAuthorized.html");
		            break;
		}
		
	}

}
