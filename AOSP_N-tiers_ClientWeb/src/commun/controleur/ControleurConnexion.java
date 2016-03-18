package commun.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utilisateur.entity.Jardinier;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ControlleurConnexion")
public class ControleurConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		boolean isLogged = ControleurConnexion.isLogged(request);
		
		if( isLogged ){
			response.sendRedirect(request.getContextPath()+"/aosp/potagers");
		}
		else{
			response.sendRedirect(request.getContextPath()+"/commun/html/connexion.jsp");			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login    = request.getParameter("login");
		
		//Todo: Gérer le user en base avec un check password
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		Jardinier jardinier = null;
		
		if( !login.isEmpty() ){
			jardinier = new Jardinier();
			jardinier.setNom(login);
		}		
		
		session.setAttribute("user", jardinier);		
		doGet(request, response);
	}
	
	public static boolean isLogged(HttpServletRequest request){
		
		boolean isLogged = false;		
		HttpSession session = request.getSession(true);		
		Object user = (Object) session.getAttribute("user");
		
		if(user != null) isLogged = true;
		
		return isLogged;
		
	}

}
