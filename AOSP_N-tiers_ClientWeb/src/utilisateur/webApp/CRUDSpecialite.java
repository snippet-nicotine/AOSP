package utilisateur.webApp;

import javax.naming.InitialContext;


import utilisateur.clientServeur.IServiceUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.util.Param;

/**
 * Classe implementant le bean action du CRUD des spécialités
 * @author Guillaume
 *
 */
public class CRUDSpecialite extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idSpecialite;
	private String libelle;

	private IServiceUtilisateur serviceUtilisateur;

	/**
	 * Constructeur initialisant le service EJB
	 */
	public CRUDSpecialite() {
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
		idSpecialite=0;
		libelle="";
	}

	@Override
	public String execute(){
		return SUCCESS;
	}


	public String affiche(){		
		return SUCCESS;
	}

	public String creation(){
		Specialite specialite;
		specialite = new Specialite(libelle);
		serviceUtilisateur.ajouterSpecialite(specialite);
		videControles();
		return SUCCESS;
	}
	public String modification(){	
		Specialite specialite;
		specialite = new Specialite(libelle);
		specialite.setIdSpecialite(idSpecialite);
		serviceUtilisateur.modifierSpecialite(specialite);
		videControles();
		return SUCCESS;
	}
	public String suppression(){
		Specialite specialite = new Specialite();
		specialite.setIdSpecialite(idSpecialite);
		serviceUtilisateur.supprimerSpecialite(specialite);
		videControles();
		return SUCCESS;
	}
	public String rechercherParId(){
		Specialite specialite = serviceUtilisateur.rechercherParIdSpecialite(idSpecialite);
		libelle = specialite.getLibelle();
		return SUCCESS;
	}

	public String remplir(){
		idSpecialite=0;
		libelle = "Libellé par défaut";
		return "remplirOK";
	}

	@Override
	public void validate(){

		if ((libelle!=null)&&(libelle.isEmpty()))		
			addFieldError("libelle", "Le libellé doit être renseigné");


	}



	//**************** GETTERS et SETTERS
	public int getIdSpecialite() {
		return idSpecialite;
	}


	public void setIdSpecialite(int idSpecialite) {
		this.idSpecialite = idSpecialite;
	}



	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}




}
