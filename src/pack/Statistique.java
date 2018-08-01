package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation class Statistique **/
@WebServlet("/Statistique")
public class Statistique extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Statistique() {
        super();
    }

	/** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/Statistique.jsp").forward(request, response);
	}

	/** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}