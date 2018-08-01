package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Controleur() {
    	super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("URL");
		
		// Transformer l'url complte en réduite
		Url urlTrans = new Url(url);
		urlTrans.setUrl(url);
		String urlRacc = urlTrans.transformURL();
				
		// Ajout a la base de donnes
		UserBD userBDD = new UserBD("","","");
		userBDD.addURL(url, urlRacc);
		
		request.setAttribute("url", url);
		request.setAttribute("urlRacc", urlRacc);
		
		//Redirection vers la page qui lui confirme que ca a fonctionn
		RequestDispatcher rd = request.getRequestDispatcher("interface2.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}