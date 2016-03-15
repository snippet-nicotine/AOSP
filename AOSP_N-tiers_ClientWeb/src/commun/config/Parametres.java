package commun.config;

public class Parametres {
	
	public static final String IHM_ACCUEIL = "";
	
	public static final String CONTROLLEUR_GESTION_POTAGER = "potager";
	public static final String CONTROLLEUR_GESTION_CARRE   = "carre";
	
	
	public static final String IHM_GESTION_POTAGER = "/" + CONTROLLEUR_GESTION_POTAGER + "/gestionPotager.jsp";	
	public static final String IHM_GESTION_CARRE   = "/" + CONTROLLEUR_GESTION_CARRE   + "/gestionCarre.jsp";
	
	public static final String EJB_SERVICE_GESTION_POTAGER = "ejb:/AOSP_N-tiers_Serveur/FacadeServiceGestionPotager!potager.clientServeur.ServiceGestionPotager";

}
