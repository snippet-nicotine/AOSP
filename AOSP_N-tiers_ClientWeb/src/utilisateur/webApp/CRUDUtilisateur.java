package utilisateur.webApp;


import java.util.Collection;
import java.util.List;

import javax.naming.InitialContext;

import utilisateur.clientServeur.IServiceUtilisateur;
import utilisateur.clientServeur.NonTrouveServiceException;
import utilisateur.clientServeur.TypeUtilisateur;
import utilisateur.entity.Administrateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.EtatCivil;
import utilisateur.entity.Jardinier;
import utilisateur.entity.Specialiste;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;
import utilisateur.util.Param;

/**
 * Classe d'action du formulaire utilisateur
 * @author Guillaume
 *
 */
public class CRUDUtilisateur extends MyActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String messageNonTrouve;

	private String type;					// valeur du bouton radio sélectionné pour le type d'utilisateur
	private int idUtilisateur;
	private String nom;
	private String prenom;
	private String mail;
	private String motPasse;
	private String codePostal;
	private int intSpecialite;
	private List<Specialite> lesSpecialites;

	private String[] selectionDroit;
	private List<DroitUtilisateur> lesDroits;


	private int idListUtilisateur;
	private List<Utilisateur> lesUtilisateurs;

	private Utilisateur utilisateurSelectionne;
	private Collection<DroitUtilisateur> lesDroitsSelectionnes;

	private IServiceUtilisateur serviceUtilisateur;


	/**
	 * Constructeur initialisant le service EJB, le type d'utilisateur par au lancement du formulaire et les listes
	 */
	public CRUDUtilisateur() {

		InitialContext initialContext;
		try {
			initialContext 		= new InitialContext();			
			serviceUtilisateur  	= (IServiceUtilisateur)  initialContext.lookup(Param.EJB_SERVICE_UTILISATEUR);																   
		}
		catch (Exception e) {
			System.err.println("Erreur lors de la liaison des EJB");
			System.err.println(e);
		}	
		lesSpecialites = serviceUtilisateur.getListeSpecialite();
		lesDroits=serviceUtilisateur.getListeDroit();
		lesUtilisateurs=serviceUtilisateur.listerUtilisateurParId();
		type="Administrateur";		
	}

	/**
	 *  Methode permettant de vider les champs de saisie
	 */
	private void videChamps(){
		type=Param.STR_ADMINISTRATEUR;
		idUtilisateur=0;
		nom="";
		prenom="";
		mail="";
		motPasse="";
		codePostal="";
		intSpecialite=0;
		selectionDroit=null;
	}

	@Override
	public String execute(){
		return SUCCESS;
	} 


	public String affiche(){		
		return SUCCESS;
	}

	/**
	 * Méthode permettant de créer un utilisateur de type différent selon la valeur de la propriété type sélectionnée
	 * par les boutons radio.
	 * @return utilisateur du type voulu
	 */
	private Utilisateur creerUtilisateur(){
		TypeUtilisateur typeUtilisateur = null;;
		Utilisateur utilisateur = null;
		EtatCivil etatCivil = new EtatCivil(nom, prenom);
		Collection<DroitUtilisateur>  listeDroits = serviceUtilisateur.tabToListe(selectionDroit);		
		switch (type){
		case Param.STR_ADMINISTRATEUR : typeUtilisateur = TypeUtilisateur.administrateur; break;
		case Param.STR_JARDINIER : typeUtilisateur = TypeUtilisateur.jardinier; break;
		case Param.STR_SPECIALISTE : typeUtilisateur = TypeUtilisateur.specialiste;break;
		}
		Specialite specialite = serviceUtilisateur.rechercherParIdSpecialite(intSpecialite);
		utilisateur=serviceUtilisateur.serviceFabriqueUtilisateur(
				typeUtilisateur, etatCivil, mail, motPasse, listeDroits, codePostal, specialite);		

		return utilisateur;
	}

	/**
	 * Création d'un l'utilisateur 
	 * @return le return de l'action (SUCCESS)
	 */
	public String creation(){
		Utilisateur utilisateur;
		utilisateur=creerUtilisateur();
		serviceUtilisateur.ajouterUtilisateur(utilisateur);
		videChamps();
		lesUtilisateurs=serviceUtilisateur.listerUtilisateurParId();
		return SUCCESS;
	}

	/**
	 * Méthode sélectionnant le type de l'utilisateur correspondant à l'idUtilisateur
	 */
	private void setTypeUtilisateur(){
		Utilisateur utilisateur = null;
		try {
			utilisateur = serviceUtilisateur.rechercherParIdUtilisateur(idUtilisateur);
		} catch (NonTrouveServiceException e) {

			messageNonTrouve = e.getMessagePerso();
		}

		// Selon le type de l'utilisateur retourné, on set la valeur de type
		if(utilisateur instanceof Administrateur)
			type=Param.STR_ADMINISTRATEUR;
		else if(utilisateur instanceof Jardinier)
			type=Param.STR_JARDINIER;
		else if (utilisateur instanceof Specialiste)
			type=Param.STR_SPECIALISTE;
	}

	/**
	 * Modification de l'utilisateur
	 * @return le return de l'action (SUCCESS)
	 */
	public String modification(){	
		Utilisateur utilisateur;
		try{
			utilisateur=serviceUtilisateur.rechercherParIdUtilisateur(idUtilisateur);
			setTypeUtilisateur();
			utilisateur=creerUtilisateur();
			utilisateur.setIdUtilisateur(idUtilisateur);
			serviceUtilisateur.modifierUtilisateur(utilisateur);
			
			lesUtilisateurs=serviceUtilisateur.listerUtilisateurParId();
		}
		catch (NonTrouveServiceException e){
			messageNonTrouve = e.getMessagePerso();
		}
		videChamps();
		return SUCCESS;
	}

	/**
	 * Suppression de l'utilisateur
	 * @return e return de l'action (SUCCESS)
	 */
	public String suppression(){
		setTypeUtilisateur();
		Utilisateur utilisateur = creerUtilisateur();
		utilisateur.setIdUtilisateur(idUtilisateur);
		serviceUtilisateur.supprimerUtilisateur(utilisateur);
		videChamps();
		lesUtilisateurs=serviceUtilisateur.listerUtilisateurParId();
		return SUCCESS;
	}


	/**
	 * 
	 * Methode permettant d'obtenir les propriétés d'un utilisateur à partir de son id
	 * @return
	 */
	public String rechercherParId(){
		Utilisateur utilisateur = null;
		try {
			utilisateur = serviceUtilisateur.rechercherParIdUtilisateur(idUtilisateur);
			nom=utilisateur.getEtatCivil().getNom();
			prenom=utilisateur.getEtatCivil().getPrenom();
			mail=utilisateur.getMail();
			motPasse=utilisateur.getMotPasse();
			type=Param.STR_ADMINISTRATEUR;
			if((utilisateur instanceof Jardinier)){
				codePostal=((Jardinier)(utilisateur)).getCodePostal();
				type=Param.STR_JARDINIER;
			}
			Specialite specialite;
			if(utilisateur instanceof Specialiste){
				specialite=((Specialiste)(utilisateur)).getSpecialite();
				codePostal=((Specialiste)(utilisateur)).getCodePostal();
				intSpecialite=specialite.getIdSpecialite();
				type=Param.STR_SPECIALISTE;
			}
		} catch (NonTrouveServiceException e) {
			messageNonTrouve = e.getMessagePerso();
		}

		return SUCCESS;
	}

	/**
	 * Méthode permettant de remplir les propriétés avec des valeurs par défaut
	 * @return
	 */
	public String remplir(){
		idUtilisateur=0;
		nom = "nom par défaut";
		prenom = "prénom par défaut";
		mail = "mail par défaut";
		motPasse="Mot de passe par défaut";
		codePostal="13013";
		intSpecialite=0;
		return "remplirOK";
	}

	/**
	 * Méthode de validation des données
	 */
	@Override
	public void validate(){

		if ((nom!=null)&&(nom.isEmpty()))		
			addFieldError("nom", "Le nom doit être renseignée");
		if ((prenom!=null)&&(prenom.isEmpty()))		
			addFieldError("prenom", "Le prénom doit être renseignée");
		if ((mail!=null)&&(mail.isEmpty()))		
			addFieldError("mail", "Le mail doit être renseignée");
		if ((motPasse!=null)&&(motPasse.isEmpty()))		
			addFieldError("motPasse", "Le mot de passe doit être renseignée");

	}

	public String detail(){

		try {
			utilisateurSelectionne = serviceUtilisateur.rechercherParIdUtilisateur(idListUtilisateur);
		} catch (NonTrouveServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lesDroitsSelectionnes=utilisateurSelectionne.getListeDroits();
		return "detail";
	}


	//************************** Getters et Setters

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public int getStrSpecialite() {
		return intSpecialite;
	}

	public void setStrSpecialite(int strSpecialite) {
		this.intSpecialite = strSpecialite;
	}

	public List<Specialite> getLesSpecialites() {
		return lesSpecialites;
	}

	public void setLesSpecialites(List<Specialite> lesSpecialites) {
		this.lesSpecialites = lesSpecialites;
	}

	public String[] getSelectionDroit() {
		return selectionDroit;
	}

	public void setSelectionDroit(String[] selectionDroit) {
		this.selectionDroit = selectionDroit;
	}

	public List<DroitUtilisateur> getLesDroits() {
		return lesDroits;
	}

	public void setLesDroits(List<DroitUtilisateur> lesDroits) {
		this.lesDroits = lesDroits;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIntSpecialite() {
		return intSpecialite;
	}

	public void setIntSpecialite(int intSpecialite) {
		this.intSpecialite = intSpecialite;
	}

	public int getIdListUtilisateur() {
		return idListUtilisateur;
	}

	public void setIdListUtilisateur(int idListUtilisateur) {
		this.idListUtilisateur = idListUtilisateur;
	}

	public List<Utilisateur> getLesUtilisateurs() {
		return lesUtilisateurs;
	}

	public void setLesUtilisateurs(List<Utilisateur> lesUtilisateurs) {
		this.lesUtilisateurs = lesUtilisateurs;
	}

	public Utilisateur getUtilisateurSelectionne() {
		return utilisateurSelectionne;
	}

	public void setUtilisateurSelectionne(Utilisateur utilisateurSelectionne) {
		this.utilisateurSelectionne = utilisateurSelectionne;
	}

	public Collection<DroitUtilisateur> getLesDroitsSelectionnes() {
		return lesDroitsSelectionnes;
	}

	public void setLesDroitsSelectionnes(Collection<DroitUtilisateur> lesDroitsSelectionnes) {
		this.lesDroitsSelectionnes = lesDroitsSelectionnes;
	}

	public String getMessageNonTrouve() {
		return messageNonTrouve;
	}

	public void setMessageNonTrouve(String messageNonTrouve) {
		this.messageNonTrouve = messageNonTrouve;
	}




}
