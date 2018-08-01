package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Créa_compte
 */
@WebServlet("/Crea_compte")
public class Crea_compte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Crea_compte() {
    	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String login = request.getParameter("Login");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		//Ajout a la base de donnes
		User us = new User(login, email, password);
		Boolean temp = us.enregistre();
		
		request.setAttribute("login2", login);
		request.setAttribute("email2", email);
		request.setAttribute("password2", password);
		
		if(temp)
		{
			RequestDispatcher rd = request.getRequestDispatcher("HomeCo.jsp");
			rd.forward(request, response);
			//response.sendRedirect("HomeCo.jsp");
		}
		else
		{
			System.out.println("Vous ne pouvez pas créer de compte !");
			response.sendRedirect("Creation_compte.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}