package planning.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.InitialContext;
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
 * Contr�leur secondaire Lister planifier de l'application
 */
@WebServlet(
		name = "CntrlSecondaireLister", 
		description = "Controlleur section lister", 
		urlPatterns = {"/listerPlanifier/*"}
		)
public class CtrlSecondaireListerPlanifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IService iService;
	
	public CtrlSecondaireListerPlanifier() {
		super();
	}
	
	public void init() throws ServletException {
		
		/*
		 * Si on instancie EJB stateful dans init(), alors la meme instance est conserv�e d'appel en appel (la servlet perdure)
		 * 	=> le r�sultat du stateful �volue
		 * 
		 *  Si on instancie le stateful � chaque appel (dans doGet()), alors un nouveau bean est cr�e et il repart � 0
		 *  => le r�sultat du stateful n'�volue pas
		 *  
		 *  Pour l'EJB Stateless, tout d�pend de l'instance conserv�e dans le serveur d'application
		 */
		// instanciation de la couche [service]
		getEJB();
	
		
		// instanciation de la couche [dao]
		
		// rien pour le moment
		
	}

	private void getEJB() {
			// instanciation de la couche [service]
			InitialContext initialContext;
			System.out.println("dans CtrlSecondaireListerPlanifier .................................");
			// acces JNDI
			try {
				initialContext = new InitialContext();
				iService = (IService) initialContext.lookup("ejb:/AOSP_N-tiers_Serveur/FacadeService!planning.clientServeur.IService");
				//			bonbonStateful  = (IGestionBonbon) initialContext.lookup("ejb:/Exo3Calculette/CalculetteBeanStateful!clientServeur.ICalculette?stateful");
				
			}
			catch (Exception e) {
				System.out.println("Erreur acces EJB : " + e);
			}
			
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// on recupere la methode d'envoi de la requete
		String methode = request.getMethod().toLowerCase();
		
		// on recupere l'action a executer
		String action  = request.getPathInfo();
		
		// action ?
		if (action == null) {
			action = "/accueilListerPlanifier";
		}
		

		afficherAccueil(request, response);
	}

	// affichage page Accueil
	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/planification/html_jsp/planifier_depart.jsp");
	}
	
	private void afficherAccueil(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//		System.out.println("CtrlPrincipal : on est dans le afficherAccueil ");

		String s_idPlanningActive = request.getParameter("idPlanningActive"); // on r�cup�re l'id du planning
		// qui est sur la ligne active du tableau
		//		System.out.println("s_idPlanningActive : " + s_idPlanningActive);																	  // n�cessaire pour recharger l'ensemble de la fen�tre
		// verif param
		int idPlanning=1;
		try {
			idPlanning = Integer.parseInt(s_idPlanningActive);
		} catch (NumberFormatException nfe) {
		}
		ArrayList<Evenement> mesEvenements = new ArrayList<Evenement>();
		try {
			mesEvenements = (ArrayList<Evenement>) iService.rechercherAllEvenement(idPlanning);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("mesEvenements", mesEvenements); // mise � disposition de l'arrayList mesEvenements

		ArrayList<Planning> mesPlannings = new ArrayList<Planning>();
		try {
			mesPlannings = (ArrayList<Planning>) iService.rechercherAllPlanning(9);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("mesPlannings", mesPlannings); // mise � disposition de l'arrayList mesPlannings
		request.setAttribute("planningActif", s_idPlanningActive); // mise � disposition du num�ro du planning actif

		//		System.out.println("CtrlPrincipal : mesPlannings : " + mesPlannings);	
		request.getRequestDispatcher("/planif/").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
