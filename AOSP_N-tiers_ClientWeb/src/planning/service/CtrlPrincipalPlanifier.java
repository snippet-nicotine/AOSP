package planning.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import planning.clientServeur.IService;
import planning.entity.Evenement;
import planning.entity.Planning;
import planning.exception.ServiceException;

/**
 * Contrôleur principal de la partie planifier
 */
@WebServlet(
		name = "CntrlPrincipalPlanifier", 
		description = "Controlleur principal de la partie planifier", 
		urlPatterns = {"/planif/*"}
		)
public class CtrlPrincipalPlanifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IService iService;

	public CtrlPrincipalPlanifier() {
		super();
	}

	public void init() throws ServletException {
		InitialContext initialContext;
		try {
			initialContext = new InitialContext();
			iService = (IService) initialContext.lookup("ejb:/AOSP_N-tiers_Serveur/FacadeService!planning.clientServeur.IService");
		}
		catch (NamingException e) {
			//			System.out.println("CtrlPrincipalPlanifier init : Erreur acces EJB : " + e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// on recupere la methode d'envoi de la requete
		String methode = request.getMethod().toLowerCase();	
		// on recupere l'action a executer
		String action  = request.getPathInfo();
		System.out.println("action  servlet principale: " + action);
		String gtcontxtpath = request.getContextPath();

		//		String cheminEnvoi = "/planification/html_jsp/planifier_depart.jsp";
		// action ?
		//		if (action == "/") {  // au lancement de l'application
		//			action = "/accueil";
		//		}

//		System.out.println("*** dans le controleur principal doget :  : " + request.toString());
//		System.out.println("gtcontxtpath : " + gtcontxtpath);
		//		System.out.println("methode : " + methode + " action : " + action + " cheminEnvoi : " + cheminEnvoi);


		if (  action.equals("/crudPlanifier/creer")     || action.equals("/crudPlanifier/modifier") || 
				action.equals("/crudPlanifier/supprimer") || action.equals("/listerPlanifier/lister")) {
			System.out.println("on doit être bon la ....");
			//			cheminEnvoi = action;
			request.getRequestDispatcher(action).forward(request, response);
		}
		else if (action.equals("/")) {	
			// page accueil
			//			System.out.println("c'est bien un /");
			afficherAccueil(request, response);
		}
		else {  // autres cas
			System.out.println("CtrlPrincipalPlanifier : doGet : c'est pas du tout un /");
			afficherAccueil(request, response);
		}

		//	request.getRequestDispatcher("/planification/html_jsp/planifier_depart.jsp").forward( request,response);
	}

	/**
	 * affichage de la page Accueil de planifier
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void afficherAccueil(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//		System.out.println("CtrlPrincipal : on est dans le afficherAccueil ");

		int idPlanning=0;
		ArrayList<Evenement> mesEvenements = new ArrayList<Evenement>();
		ArrayList<Planning> mesPlannings = new ArrayList<Planning>();
		// *** on récupère l'id du planning qui est sur la ligne active du tableau
		// nécessaire pour recharger l'ensemble de la fenêtre
		String s_idPlanningActive = request.getParameter("idPlanningActive"); 
//		System.out.println("s_idPlanningActive : ." + s_idPlanningActive + ".");	
		try {
			idPlanning = Integer.parseInt(s_idPlanningActive);
		} catch (NumberFormatException nfe) {
//			System.out.println("Pas d'idPlanningActive !!!!!!!!!!!!!!!!!!!!!!");
			idPlanning=1;
		}
		try {
			mesEvenements = (ArrayList<Evenement>) iService.rechercherAllEvenement(idPlanning);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		try {
			mesPlannings = (ArrayList<Planning>) iService.rechercherAllPlanning(9);
		} catch (ServiceException e) {
			e.printStackTrace();
		}		
		//		System.out.println("CtrlPrincipal : mesPlannings : " + mesPlannings);

		request.setAttribute("mesEvenements", mesEvenements); // mise à disposition de l'arrayList mesEvenements
		request.setAttribute("mesPlannings", mesPlannings); // mise à disposition de l'arrayList mesPlannings
//		System.out.println("début planning3 bis");
		if (s_idPlanningActive == null) {
			s_idPlanningActive = "par défaut (N°:1).";
		}	
		request.setAttribute("planningActif", s_idPlanningActive); // mise à disposition du numéro du planning actif
		
		// on redirige
		request.getRequestDispatcher("/planification/html_jsp/planifier_depart.jsp").forward( request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
