package planning.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
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
import planning.util.ConstanteString;

/**
 * Contrôleur secondaire Crud planifier de l'application
 */
@WebServlet(
		name = "CntrlSecondaireCrudPlanifier", 
		description = "Controlleur secondaire de planifier", 
		urlPatterns = {"/crudPlanifier/*"}
		)
public class CtrlSecondaireCrudPlanifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// EJB Message déclaration des variables
	private QueueConnection	connection 	= null;
	private QueueSession 	session 	= null;
	private QueueSender     sender		= null;
	
	private IService iService;

	public CtrlSecondaireCrudPlanifier() {
		super();
	}

	public void init() throws ServletException {
//		System.out.println("CtrlSecondaireCrudPlanifier init() : on y est enfin !!!");
		/*
		 * Si on instancie EJB stateful dans init(), alors la meme instance est conservée d'appel en appel (la servlet perdure)
		 * 	=> le résultat du stateful évolue
		 * 
		 *  Si on instancie le stateful à chaque appel (dans doGet()), alors un nouveau bean est crée et il repart à 0
		 *  => le résultat du stateful n'évolue pas
		 *  
		 *  Pour l'EJB Stateless, tout dépend de l'instance conservée dans le serveur d'application
		 */
		super.init();
		// instanciation de la couche [service]
		getEJB();
		// EJB Message : initialisation de l'EJB Message
		initialisationQueueMessage();
		// instanciation de la couche [dao]
		// rien pour le moment
	}

	/**
	 * Initialisation de la Queue Message
	 */
	private void initialisationQueueMessage() {  
		try {         
			Context ctx = new InitialContext();
			QueueConnectionFactory connectionFactory = (QueueConnectionFactory) ctx.lookup(ConstanteString.DESTINATION_NAME); 
			connection  = connectionFactory.createQueueConnection(ConstanteString.JMS_USERNAME, ConstanteString.JMS_PASSWORD); 
			session 	= connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) ctx.lookup(ConstanteString.JMS_QUEUE_JNDI);
			sender 	    = session.createSender(queue);
			connection.start();
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

	private void getEJB() {
		// instanciation de la couche [service]
		InitialContext initialContext;

		try {
			initialContext = new InitialContext();
			iService = (IService) initialContext.lookup(ConstanteString.INITIAL_CONTEXTE_EJB);
		}
		catch (NamingException e) {
			System.out.println("CtrlSecondaireCrudPlanifier getEJB : Erreur acces EJB : " + e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// on recupere la methode d'envoi de la requete
		String methode = request.getMethod().toLowerCase();
		// on recupere l'action a executer
		String action  = request.getPathInfo();
		String gtcontxtpath = request.getContextPath();

//		String pathDestination;		
		String messageErreur = null;

//		System.out.println("dans le controleur secondaire dopost : " + request.toString());
//		System.out.println("methode : " + methode);
//		System.out.println("action : " + action);
//		System.out.println("gtcontxtpath : " + gtcontxtpath);

		// action ?
		if (action == null) {
			action = "/accueilCrudPlanifier";
		}

		if (action.equals("/creer")) {
			LocalDate maDate = LocalDate.now();
//			System.out.println("** CtrlSecondaireCrudPlanifier - creer ");
			
			// recuperation des parametres saisis de l'évènement
			String s_idEvenement 	= request.getParameter("idEvenement");
			String s_idPlanning		= request.getParameter("idPlanning");
			String s_idAction		= request.getParameter("idAction");
			String s_idPlante		= request.getParameter("idPlante");
			String s_dateEvenement	= request.getParameter("dateEvenement");
			String s_commentaireAuto= request.getParameter("comAuto");
			String s_commentaire 	= request.getParameter("com");
			
//			if (s_idEvenement.matches("^[1-9]+$|^[1-9]+[0-9]*$")) {
//				System.out.println("DDDDDDDDDDDDDDD s_idEvenement est bien un entier");
//			}
			System.out.println("s_dateEvenement : ." + s_dateEvenement + ".");
			if ((s_dateEvenement.equals(null)) || (s_dateEvenement.equals("")) || (s_dateEvenement.equals(" "))) {
				maDate = LocalDate.now();
			}
			else {
				System.out.println("Pas nuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			    maDate = LocalDate.parse(s_dateEvenement, formatter);
			    System.out.printf("Bascule parsed String %s, date is %s%n", s_dateEvenement, maDate);
			}
			
			// création de l'évènement / envoi au serveur
			
// DM			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
//		    LocalDate myDayLocalDate = LocalDate.parse(myDayString, formatter);
			
//			public Evenement(int idEvenement, int idPlanning, int idAction, int idPlante, Nutrition nutrition, LocalDate dateEvenement,
//					String commentaireAuto, String commentaire) {
		
			Evenement evenement = iService.creationEvenement(Integer.parseInt(s_idEvenement),Integer.parseInt(s_idPlanning)
					,Integer.parseInt(s_idAction),Integer.parseInt(s_idPlante)
					,null,maDate,s_commentaireAuto,s_commentaire);
			
			// evenement = null;
			System.out.println("new Evenement fait");
			System.out.println("Evenement : " + evenement);
			
			try {
				iService.creerEvenement(evenement);
			} catch (NumberFormatException | ServiceException e) {
//				System.out.println("**DM catch iService.creerEvenement(evenement)");
				messageErreur = e.getMessage();
				//				e.printStackTrace();
			}
			PrintWriter out 	= response.getWriter();
			TextMessage message;
			try {
				message = session.createTextMessage("CREATION EVENEMENT EFFECTUEE - **************************************  Message du sender");
//				int i=0;
//				for (i = 0; i < 1000; i++) {
					sender.send(message);
//				}

				out.println("Message envoye au provider JMS ");
				
			} catch (JMSException e) {
				e.printStackTrace();
			}

			System.out.println("avant return");
			if (messageErreur != null){
				
//				WorkerServlet ws = new WorkerServlet();
//				ws.envoyer("Création d'un évènement");
//				PrintWriter out 	= response.getWriter();
//				out.println("Message envoye au provider JMS ");
				
//				messageErreur = messageErreur + " toto";
//				System.out.println(messageErreur);
				request.setAttribute("messageErreur", messageErreur);
			}

			System.out.println("** CtrlSecondaireCrudPlanifier - Fin creer");
			request.getRequestDispatcher("/planif/").forward(request, response);
		}
		else if (action.equals("/modifier")) {
			// recuperation des parametres saisis de l'évènement
			String s_idEvenement 	= request.getParameter("idEvenement");
			String s_idPlanning		= request.getParameter("idPlanning");
			String s_idAction		= request.getParameter("idAction");
			String s_idPlante		= request.getParameter("idPlante");
			String s_commentaireAuto= request.getParameter("comAuto");
			String s_commentaire 	= request.getParameter("com");
			// System.out.println("modification MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
			// création de l'évènement / envoi au serveur
			try {
				// System.out.println("on est dans le tryyyyyyyyyyyyyyyyyyyyyyyyy");
				Evenement monEvenement = iService.creationEvenement();
				monEvenement.setIdEvenement(Integer.parseInt(s_idEvenement));
				monEvenement.setIdPlanning(Integer.parseInt(s_idPlanning));
				monEvenement.setIdAction(Integer.parseInt(s_idAction));
				monEvenement.setIdPlante(Integer.parseInt(s_idPlante));
				monEvenement.setNutrition(null);
//				monEvenement.setDateEvenement(null);
				monEvenement.setCommentaireAuto(s_commentaireAuto);
				monEvenement.setCommentaire(s_commentaire);

				iService.modifierEvenement(monEvenement);
			} catch (NumberFormatException | ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//			System.out.println("avant return");
			response.sendRedirect(request.getContextPath() + "/");
		}
		else if (action.equals("/supprimer")) {
			// recuperation des parametres saisis de l'évènement
			String s_idEvenement 	= request.getParameter("idEvenement");
			// System.out.println("suppression SUPSUPSUPSUPSUPSUPSUPSUPSUPSUP");
			// suppression de l'évènement / envoi au serveur
			try {
				iService.supprimerEvenement(Integer.parseInt(s_idEvenement));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//			System.out.println("avant return");
			response.sendRedirect(request.getContextPath() + "/");	
		}
		else {
			//			System.out.println("ça marche pas !!! à verifier");
			response.sendRedirect(request.getContextPath() + "/");	
		}
	}
	private void afficherAccueil(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//		System.out.println("CtrlPrincipal : on est dans le afficherAccueil ");

		String s_idPlanningActive = request.getParameter("idPlanningActive"); // on récupère l'id du planning
		// qui est sur la ligne active du tableau
		//		System.out.println("s_idPlanningActive : " + s_idPlanningActive);																	  // nécessaire pour recharger l'ensemble de la fenêtre
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
		request.setAttribute("mesEvenements", mesEvenements); // mise à disposition de l'arrayList mesEvenements

		ArrayList<Planning> mesPlannings = new ArrayList<Planning>();
		try {
			mesPlannings = (ArrayList<Planning>) iService.rechercherAllPlanning(9);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("mesPlannings", mesPlannings); // mise à disposition de l'arrayList mesPlannings

		//		System.out.println("CtrlPrincipal : mesPlannings : " + mesPlannings);	
	}
}
