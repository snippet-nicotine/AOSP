package utilisateur.webApp;

import javax.naming.InitialContext;

import utilisateur.clientServeur.IServiceUtilisateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.util.Param;

/**
 * Classe d'action du formulaire Droits
 * @author Guillaume
 *
 */
public class CRUDDroits extends MyActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idDroit;
	private String libelle;
	
	private IServiceUtilisateur serviceUtilisateur;

	
	/**
	 * Constructeur initialisant le service EJB
	 */
	public CRUDDroits() {
		
		InitialContext initialContext;
		try {
			initialContext 		= new InitialContext();			
			serviceUtilisateur  	= (IServiceUtilisateur)  initialContext.lookup(Param.EJB_SERVICE_UTILISATEUR);																   
		}
		catch (Exception e) {
			System.err.println("Erreur lors de la liaison des EJB");
			System.err.println(e);
		}	
	}
	
	/**
	 * Methode permettant de vider les champs de saisie
	 */
	private void videControles(){
		idDroit=0;
		libelle="";
	}
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	public String affiche(){		
		return SUCCESS;
	}
	
	/**
	 * Méthode de création d'un droit utilisateur
	 * @return le return de l'action (SUCCESS)
	 */
	public String creation(){
		DroitUtilisateur droitUtilisateur;
		droitUtilisateur = new DroitUtilisateur(libelle);
		serviceUtilisateur.ajouterDroitUtilisateur(droitUtilisateur);
		videControles();
		return SUCCESS;
	}
	
	/**
	 * Méthode de modification d'un droit utilisateur
	 * @return le return de l'action (SUCCESS)
	 */
	public String modification(){	
		DroitUtilisateur droitUtilisateur;
		droitUtilisateur = new DroitUtilisateur(libelle);
		droitUtilisateur.setIdDroit(idDroit);
		serviceUtilisateur.modifierDroitUtilisateur(droitUtilisateur);
		videControles();
		return SUCCESS;
	}
	
	/**
	 * Méthode de suppression d'un droit utilisateur
	 * @return  le return de l'action (SUCCESS)
	 */
	public String suppression(){
		DroitUtilisateur droitUtilisateur = new DroitUtilisateur();
		droitUtilisateur.setIdDroit(idDroit);
		serviceUtilisateur.supprimerDroitUtilisateur(droitUtilisateur);
		videControles();
		return SUCCESS;
	}
	public String rechercherParId(){
		DroitUtilisateur droitUtilisateur = serviceUtilisateur.rechercherParIdDroit(idDroit);
		libelle = droitUtilisateur.getLibelle();
		return SUCCESS;
	}
	
	public String remplir(){
		idDroit=0;
		libelle = "Libellé par défaut";
		return "remplirOK";

		
	}
	
	@Override
	public void validate(){
		
			if ((libelle!=null)&&(libelle.isEmpty()))		
				addFieldError("libelle", "Le libellé doit être renseigné");		
	}
	
	
	
	
	
	
	//*************************** Getters et Setters
	
	public int getIdDroit() {
		return idDroit;
	}

	public void setIdDroit(int idDroit) {
		this.idDroit = idDroit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
