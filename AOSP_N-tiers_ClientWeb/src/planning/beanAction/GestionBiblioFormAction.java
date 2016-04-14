package planning.beanAction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opensymphony.xwork2.ActionSupport;

public class GestionBiblioFormAction extends  ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idAuteur;
	private String nom;
	private String prenom;
	private String nationalite;
	private String dtNai;
	private String choix;
//	private GestionCatalogue gc = new GestionCatalogue();
//	private Document document;
//	private Collection<ThemeDoc>  themes= gc.themeParNom();
//	private Collection<Auteur> auteurs = gc.auteurParNom();
//	private GestionDocument gd = new GestionDocument();
	
	// private Auteur auteur;
	private String selectAuteur;
	
	private String[] selectTheme;

	
	
	@Override
	public String execute() throws Exception {
		DateTimeFormatter formatFr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dat = LocalDate.parse(dtNai,formatFr);
		
//		gd.creerAuteur2(idAuteur, nom, prenom, nationalite,dat);

		//		Auteur auteur = new Auteur();
		//		setIdAuteur(auteur.getId());
		//		setNom(auteur.getNom());
		//		setPrenom(auteur.getPrenom());
		//		setNationalite(auteur.getNationalite());
		//		setDtNai(formatFr.format(auteur.getDateNaissance()));
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		System.out.println("DM ***** GestionPersonneAction - validate()");
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

	public String afficheAuteur()  throws Exception {
		System.out.println("Je rentre dans : Auteur = " + idAuteur + nom);
		return "afficheGestAuteur";
	}

	public String afficheDocument()  throws Exception {
		System.out.println("avant themes = gc.themeParNom();");

		System.out.println("Je rentre dans : Document = " + idAuteur + nom);
		return "afficheGestDocument";
	}
	public String afficheTheme()  throws Exception {
		System.out.println("Je rentre dans : Theme = " + idAuteur + nom);
		return "afficheGestTheme";
	}

	public String creationAuteur()  throws Exception {
		System.out.println("Je crée : Auteur = " + idAuteur + nom);
		DateTimeFormatter formatFr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dat = LocalDate.parse(dtNai,formatFr);
//		GestionDocument gd = new GestionDocument();
//		gd.creerAuteur2(idAuteur, nom, prenom, nationalite,dat);
		return "gest";
	}
	public String creationDocument()  throws Exception {
		System.out.println("Je crée : Document");
		System.out.println("longueur des themes" + selectTheme.length);
//		document.setAuteur(gd.rechercherAuteur(selectAuteur));
//		gd.creerDocument(document);
//		gd.creer(document.getCote(), document.getTitre(), document.getDescriptif(), document.getNbExemplaireDispo(), document.getLocalisation().getLieu(), document.getLocalisation().getEmp(), selectAuteur, selectTheme);
		return "gest";
	}

	public String creationTheme()  throws Exception {
		System.out.println("Je crée : Theme");
		return "gest";
	}

	public String modifAuteur()  throws Exception {
		System.out.println("Je modif : auteur = " + idAuteur + nom);
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
		System.out.println("Je populate : auteur = " + idAuteur + nom);
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

	public String getIdAuteur() {
		return idAuteur;
	}
	public void setIdAuteur(String idAuteur) {
		this.idAuteur = idAuteur;
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
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	//	public LocalDate getDtNai() {
	//		return dtNai;
	//	}
	//	public void setDtNai(LocalDate dtNai) {
	//		this.dtNai = dtNai;
	//	}


	public String getDtNai() {
		return dtNai;
	}


	public void setDtNai(String dtNai) {
		this.dtNai = dtNai;
	}

	public String getChoix() {
		return choix;
	}


	public void setChoix(String choix) {
		this.choix = choix;
	}


	public String getSelectAuteur() {
		return selectAuteur;
	}


	public void setSelectAuteur(String selectAuteur) {
		this.selectAuteur = selectAuteur;
	}


	public String[] getSelectTheme() {
		return selectTheme;
	}


	public void setSelectTheme(String[] selectTheme) {
		this.selectTheme = selectTheme;
	}


}
