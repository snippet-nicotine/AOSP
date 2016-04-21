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
import utilisateur.exception.CodePostalNullException;
import utilisateur.util.Param;
import utilisateur.util.VerifCodePostal;

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

	private String messageNonTrouve;		// message d'erreur au cas où l'utilisateur demandé n'existe pas

	private String typeUtil;					// valeur du select sélectionné pour le type d'utilisateur
	private int idUtilisateur;				// id de l'utilisateur
	private String nom;						// nom de l'utilisateur
	private String prenom;					// prénom de l'utilisateur
	private String mail;					// mail de l'utilisateur
	private String motPasse;				// mot de passse de l'utilisateur
	private String codePostal;				// code postal de l'utilisateur si c'est un jardinier ou un spécialiste
	private int intSpecialite;				// spécialité de l'utilisateur si c'est un spécialiste
	private List<Specialite> lesSpecialites;// Liste des spécialités

	private String[] selectionDroit;			// le tableau de String des droits sélectionnés
	private List<DroitUtilisateur> lesDroits;	// Liste des droits Utilisateur


	private int idListUtilisateur;				// l'id de l'utilisateur sélectionné dans la liste des utilisateurs
	private List<Utilisateur> lesUtilisateurs;	// Liste de tous les uilisateurs

	private Utilisateur utilisateurSelectionne;	// utilisateur sélectionné dans la liste des utilisateurs pour AJAX
	private Collection<DroitUtilisateur> lesDroitsSelectionnes; // la liste des droits de l'utilisateur sélectionné (AJAX)

	private IServiceUtilisateur serviceUtilisateur; // service offrant toutes les fonctionnalité du serveur


	/**
	 * Constructeur initialisant le service EJB, le type d'utilisateur et les listes
	 */
	public CRUDUtilisateur() {

		// initialisation du service utilisateur
		InitialContext initialContext;
		try {
			initialContext 			= new InitialContext();			
			serviceUtilisateur  	= (IServiceUtilisateur)  initialContext.lookup(Param.EJB_SERVICE_UTILISATEUR);																   
		}
		catch (Exception e) {
			System.err.println("Erreur lors de la liaison des EJB");
			System.err.println(e);
		}	

		// initialisations
		init();

	}

	/**
	 * Méthode initialisant les listes et le type d'utilisateur
	 */
	private void init(){
		// chargement des listes (spécialités, droits, utilisateurs) 
		lesSpecialites 	= serviceUtilisateur.getListeSpecialite();
		lesDroits		= serviceUtilisateur.getListeDroit();
		lesUtilisateurs	= serviceUtilisateur.listerUtilisateurParId();

		// initialisation du type d'utilisateur
		typeUtil="Administrateur";	
	}

	/**
	 *  Methode permettant de vider les champs de saisie
	 */
	private void videChamps(){
		typeUtil		= Param.STR_ADMINISTRATEUR;
		idUtilisateur	= 0;
		nom				= "";
		prenom			= "";
		mail			= "";
		motPasse		= "";
		codePostal		= "";
		intSpecialite	= 0;
		selectionDroit	= null;
	}

	@Override
	public String execute(){
		return SUCCESS;
	} 


	public String affiche(){		
		return SUCCESS;
	}

	/**
	 * Méthode qui permet de créer un jeu d'essai à partir de tables vides
	 * @return
	 */
	public String jeuEssai(){		
		serviceUtilisateur.creerJeuEssai();
		init();
		return SUCCESS;
	}

	/**
	 * Méthode permettant de créer un utilisateur de type différent selon la valeur de la propriété type sélectionnée
	 * par les boutons radio.
	 * @return utilisateur du type voulu
	 */
	private Utilisateur creerUtilisateur(){
		TypeUtilisateur typeUtilisateur = null;;
		Utilisateur 	utilisateur 	= null;
		EtatCivil 		etatCivil 		= new EtatCivil(nom, prenom);

		// création de la liste des droits à partir du tableau de String
		Collection<DroitUtilisateur>  listeDroits = serviceUtilisateur.tabToListe(selectionDroit);	

		// on détermine le type d'utilisateur en fonction du bouton radio sélectionné
		switch (typeUtil){
		case Param.STR_ADMINISTRATEUR : typeUtilisateur = TypeUtilisateur.administrateur; 	break;
		case Param.STR_JARDINIER : 		typeUtilisateur = TypeUtilisateur.jardinier; 		break;
		case Param.STR_SPECIALISTE : 	typeUtilisateur = TypeUtilisateur.specialiste;		break;
		}

		// affectation de la spécialité
		Specialite specialite = serviceUtilisateur.rechercherParIdSpecialite(intSpecialite);

		// création de l'utilisateur du type demandé par la fabrique
		utilisateur=serviceUtilisateur.serviceFabriqueUtilisateur(
				typeUtilisateur, etatCivil, mail, motPasse, listeDroits, codePostal, specialite);		

		return utilisateur;
	}

	/**
	 * Création d'un l'utilisateur 
	 * @return le return de l'action (SUCCESS)
	 */
	public String creation(){
		Utilisateur utilisateur = creerUtilisateur();
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

		// on essaye de rechercher l'utilisateur
		try {
			utilisateur = serviceUtilisateur.rechercherParIdUtilisateur(idUtilisateur);
		} catch (NonTrouveServiceException e) {
			// si pas trouvé: message d'erreur
			messageNonTrouve = e.getMessagePerso();
		}

		// Selon le type de l'utilisateur retourné, on set la valeur de type
		if(utilisateur instanceof Administrateur)
			typeUtil=Param.STR_ADMINISTRATEUR;
		else if(utilisateur instanceof Jardinier)
			typeUtil=Param.STR_JARDINIER;
		else if (utilisateur instanceof Specialiste)
			typeUtil=Param.STR_SPECIALISTE;
	}

	/**
	 * Modification de l'utilisateur
	 * @return le return de l'action (SUCCESS)
	 */
	public String modification(){	
		Utilisateur utilisateur;

		// on essaye de rechercher l'utilisateur
		try{
			utilisateur=serviceUtilisateur.rechercherParIdUtilisateur(idUtilisateur);
			// si l'utilisateur a été trouvé on le modifie en créant un utilisateur du bon type			
			setTypeUtilisateur();
			utilisateur=creerUtilisateur();
			// on affect l'id de l'utilisateur pour l'identifier en base
			utilisateur.setIdUtilisateur(idUtilisateur);
			serviceUtilisateur.modifierUtilisateur(utilisateur);

			// on charge la nouvelle liste d'utilisateur
			lesUtilisateurs=serviceUtilisateur.listerUtilisateurParId();
		}
		catch (NonTrouveServiceException e){

			// si pas trouvé: message d'erreur
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

		// on essaye de trouver l'utilisateur par son id
		try {
			utilisateur = serviceUtilisateur.rechercherParIdUtilisateur(idUtilisateur);

			// on renseigne les propriété avec celles de l'utilisateur trouvé
			nom=utilisateur.getEtatCivil().getNom();
			prenom=utilisateur.getEtatCivil().getPrenom();
			mail=utilisateur.getMail();
			motPasse=utilisateur.getMotPasse();
			selectionDroit = serviceUtilisateur.listeToTab(utilisateur.getListeDroits());

			// on met par défaut "Administrateur" dans type 
			typeUtil=Param.STR_ADMINISTRATEUR;

			// si l'utilisateur est un jardinier, on renseigne le code postal du formulaire, et on met le bouton 
			// radio sur Jardinier
			if((utilisateur instanceof Jardinier)){
				codePostal=((Jardinier)(utilisateur)).getCodePostal();
				typeUtil=Param.STR_JARDINIER;
			}

			// si l'utilisateur est un spécialiste, on renseigne le code postal et la spécialité du formulaire ,
			// et on met le bouton radio sur Spécialiste
			Specialite specialite;
			if(utilisateur instanceof Specialiste){
				specialite=((Specialiste)(utilisateur)).getSpecialite();
				codePostal=((Specialiste)(utilisateur)).getCodePostal();
				intSpecialite=specialite.getIdSpecialite();
				typeUtil=Param.STR_SPECIALISTE;
			}
		} catch (NonTrouveServiceException e) {
			// si pas trouvé : message d'erreur
			messageNonTrouve = e.getMessagePerso();
		}

		return SUCCESS;
	}

	/**
	 * Méthode permettant de remplir les propriétés avec des valeurs par défaut
	 * @return le retour qui correspond à la jsp chargé par l'action
	 */
	public String remplir(){
		idUtilisateur 	= 0;
		nom 			= "nom par défaut";
		prenom 			= "prénom par défaut";
		mail 			= "mail par défaut";
		motPasse 		= "Mot de passe par défaut";
		codePostal 		= "13013";
		intSpecialite 	= 0;
		selectionDroit 	= null;
		
		return "remplirOK";
	}

	/**
	 * Méthode de validation des données
	 */
	@Override
	public void validate(){

		if ((nom!=null) && (nom.isEmpty()))		
			addFieldError("nom", "Le nom doit être renseignée");
		if ((prenom!=null) && (prenom.isEmpty()))		
			addFieldError("prenom", "Le prénom doit être renseignée");
		if ((mail!=null) && (mail.isEmpty()))		
			addFieldError("mail", "Le mail doit être renseignée");
		if ((motPasse!=null) && (motPasse.isEmpty()))		
			addFieldError("motPasse", "Le mot de passe doit être renseignée");

		// code qui ne marche pas, typeUtil semble ne pas être renseigné correctement
		if((typeUtil == Param.STR_JARDINIER) || (typeUtil == Param.STR_SPECIALISTE)){
			try {
				boolean verifOK = VerifCodePostal.verifCode(codePostal);
				if(!verifOK) addFieldError("codePostal", "Code postal invalide");

			} catch (CodePostalNullException e) {
				addFieldError("codePostal", "Code postal invalide");
			}
		}
	}

	/**
	 * Action correspondant à la requete AJAX
	 * @return "detail" qui permet d'associer la jsp reponseAjax.jsp à cette action
	 */
	public String detail(){

		try {
			utilisateurSelectionne 	= serviceUtilisateur		.rechercherParIdUtilisateur(idListUtilisateur);
			lesDroitsSelectionnes	= utilisateurSelectionne	.getListeDroits();			
			// ce catch ne sers à rien puisque on a sélectionné dans la liste un utilisateur existant
		} catch (NonTrouveServiceException e) {
			e.printStackTrace();
		}
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

	public String getTypeUtil() {
		return typeUtil;
	}

	public void setTypeUtil(String typeUtil) {
		this.typeUtil = typeUtil;
	}




}
