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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdministracijaKorisnika  administracijaKorisnika = new AdministracijaKorisnika();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (administracijaKorisnika.isRegistered(username)) {
			if(administracijaKorisnika.isAuthenticated(username, password)) {
				User user = administracijaKorisnika.getUser(username);
				if(user!=null) {
					request.getSession().setAttribute("user", user);
				}
				if(user.getRole().equals(Roles.ADMIN)) {
					request.getRequestDispatcher("/vezbaSecurity/adminHomeServlet.html").forward(request, response);
				}else {
					request.getRequestDispatcher("/vezbaSecurity/homePageServlet.html").forward(request, response);
				}
				
			}else {
				request.getRequestDispatcher("/vezbaSecurity/pogresanPassword.html").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("/vezbaSecurity/notRegistered.html").forward(request, response);
		}
	}

}
