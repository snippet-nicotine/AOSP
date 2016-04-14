package planning.beanAction;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;

import planning.appli.GestionPlanning;
import planning.entity.Evenement;
import planning.entity.Follower;
import planning.entity.Planning;
import planning.exception.ServiceException;

public class GestionPlanningFormAction extends  ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GestionPlanning gp = new GestionPlanning();
	
	private Planning planning;
	private Collection<Planning> plannings;
	private Evenement evenement;
//	private Collection<Evenement> evenements;
	private Collection<Evenement> evenements;
	private Follower follower;
	private Collection<Follower> followers;
	
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("dans execute()");
		DateTimeFormatter formatFr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate dat = LocalDate.parse(dtNai,formatFr);
		
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD***** GestionPersonneAction - validate()");
		System.out.println("private Collection<Evenement> evenements = gp.listeEvenement(1); : " + evenements);
//		if (document.getAuteur() == null) 
//			addFieldError("personne.userName", "Le nom doit être renseigné");

//		if (dateSaisie.isEmpty())  
//			addFieldError("dateSaisie", getText("date.obligatoire"));
//		else if (!transfertDateSaisieToPersonne())  
//			addFieldError("dateSaisie", getText("date.format"));

//		if (!transfertAgeSaisieToPersonne()) {
//			addFieldError("ageSaisie", getText("age.format"));
//		}
		
		
		// System.out.println(getFieldErrors());
//		if ( hasFieldErrors()) {
//			addActionError(  "actionError   : Vous faites n''importe quoi !!! - Niveau erreur ");
//			addActionMessage("actionMessage : Veuillez vérifier votre saisie  - Niveau information");
////			addActionError(  "actionError2  : Vous faites n''importe quoi !!! - Niveau erreur ");
////			addActionMessage("actionMessage2: Faites donc un peu attention    - Niveau information");
//		}
	}


	public String accueilBiblio()  throws Exception {
		System.out.println("Je suis dans l'accueilBiblio = ");
		return "acc";
	}

	public String affichePlanning()  throws Exception {
		System.out.println("Je rentre dans : affichePlanning = ");
		int idPlanning=0;
		// *** on récupère l'id du planning qui est sur la ligne active du tableau
		// nécessaire pour recharger l'ensemble de la fenêtre
		String s_idPlanningActive = null; 
//		System.out.println("s_idPlanningActive : ." + s_idPlanningActive + ".");	
//		try {
//			idPlanning = Integer.parseInt(s_idPlanningActive);
//		} catch (NumberFormatException nfe) {
////			System.out.println("Pas d'idPlanningActive !!!!!!!!!!!!!!!!!!!!!!");
//			idPlanning=1;
//		}
//		try {
//			evenements = 
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}

		plannings = gp.listePlanning(1);
		evenements = gp.listeEvenement(1);

		if (s_idPlanningActive == null) {
			s_idPlanningActive = "par défaut (N°:1).";
		}	
		
		return "gest";
	}

	public String afficheDocument()  throws Exception {
		System.out.println("avant themes = gc.themeParNom();");

		System.out.println("Je rentre dans : Document = ");
		return "afficheGestDocument";
	}
	public String afficheTheme()  throws Exception {
		System.out.println("Je rentre dans : Theme = ");
		return "afficheGestTheme";
	}

	public String creationAuteur()  throws Exception {
		System.out.println("Je crée : Auteur = ");
		DateTimeFormatter formatFr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate dat = LocalDate.parse(dtNai,formatFr);
//		GestionDocument gd = new GestionDocument();
//		gd.creerAuteur2(idAuteur, nom, prenom, nationalite,dat);
		return "gest";
	}
	public String creationDocument()  throws Exception {
		System.out.println("Je crée : Document");
		System.out.println("longueur des themes");
	//	document.setAuteur(gd.rechercherAuteur(selectAuteur));
//		gd.creerDocument(document);
//		gd.creer(document.getCote(), document.getTitre(), document.getDescriptif(), document.getNbExemplaireDispo(), document.getLocalisation().getLieu(), document.getLocalisation().getEmp(), selectAuteur, selectTheme);
		return "gest";
	}

	public String creationTheme()  throws Exception {
		System.out.println("Je crée : Theme");
		return "gest";
	}

	public String modifAuteur()  throws Exception {
		System.out.println("Je modif : auteur = ");
		return "gest";
	}
	public String modifDocument()  throws Exception {
		System.out.println("Je modif : Document");
		return "gest";
	}

	public String modifTheme()  throws Exception {
		System.out.println("Je modif : Theme");
		return "gest";
	}

	public String populateAuteur()  throws Exception {
		System.out.println("Je populate : auteur = ");
		return "cat";
	}
	public String populateDocument()  throws Exception {
		System.out.println("Je populate : Document");
		return "cat";
	}
	public String populateTheme()  throws Exception {
		System.out.println("Je populate : Theme");
		return "cat";
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public Collection<Planning> getPlannings() {
		return plannings;
	}

	public void setPlannings(Collection<Planning> plannings) {
		this.plannings = plannings;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public Collection<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Collection<Evenement> evenements) {
		this.evenements = evenements;
	}

	public Follower getFollower() {
		return follower;
	}

	public void setFollower(Follower follower) {
		this.follower = follower;
	}

	public Collection<Follower> getFollowers() {
		return followers;
	}

	public void setFollowers(Collection<Follower> followers) {
		this.followers = followers;
	}

}
