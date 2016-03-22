package potager.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utilisateur.entity.Jardinier;


/**
 * 
 * @author Nicolas LAMBERT
 * 
 * <p> Le potager est un terrain cultivable d’un jardinier. 
 * Il a une dimension <i>(longueur x largeur)</i> et peut être géré par un jardinier.
 * Il est décomposé en plusieurs {@link potager.entity.Carre Carres} de potager. </p>
 */

public class Potager implements Serializable{

	private static final long serialVersionUID = -8065181790953611569L;

	protected int idPotager;

	protected Jardinier  proprietaire;	
	protected List<Jardinier> visiteurs;
	
	protected LocalDate  dateCreation;	
	protected List<Carre> carres;
	private String nom;
	private int longueur;
	private int largeur;
	private String codePostal;
	
	private int nbCarresX;
	private int nbCarresY;	
	
	public Potager(){
		this.carres       = new ArrayList<Carre>();
		this.visiteurs    = new ArrayList<Jardinier>();
	}
	
	public Potager(String nom, int longueur, int largeur, String codePostal, Jardinier proprietaire){
		this();
		this.nom          = nom;
		this.longueur     = longueur;
		this.largeur      = largeur;
		this.codePostal   = codePostal;
		this.proprietaire = proprietaire;
		this.dateCreation = LocalDate.now();

	}
	
	public int getIdPotager() {
		return idPotager;
	}

	public void setIdPotager(int idPotager) {
		this.idPotager = idPotager;
	}

	public Jardinier getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Jardinier proprietaire) {
		this.proprietaire = proprietaire;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Carre> getCarres() {
		return carres;
	}

	public void setCarres(List<Carre> carres) {
		this.carres = carres;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public int getNbCarresX() {
		return nbCarresX;
	}

	public void setNbCarresX(int nbCarresX) {
		this.nbCarresX = nbCarresX;
	}

	public int getNbCarresY() {
		return nbCarresY;
	}

	public void setNbCarresY(int nbCarresY) {
		this.nbCarresY = nbCarresY;
	}

	public List<Jardinier> getVisiteurs() {
		return this.visiteurs;
	}

	public void setVisiteurs(List<Jardinier> visiteurs) {
		this.visiteurs = visiteurs;
	}
	
	public void addVisiteur(Jardinier visiteur){
		if(!visiteurs.contains(visiteur) ){
			visiteurs.add(visiteur);
			visiteur.addPotagerPartage(this);
		}
	}
	
	public void serialize(){
				
		if(carres != null){	
			ArrayList<Carre> serializedCarres = new ArrayList<Carre>();
			for(Carre carre: carres){
				System.out.println("serialize carre : " + carre);
				serializedCarres.add(carre);			
			}
			carres = serializedCarres;
		}
		
		if(visiteurs != null){
			ArrayList<Jardinier> serializedVisiteurs = new ArrayList<Jardinier>();
			for(Jardinier visiteur: visiteurs){
				System.out.println("serialize visiteur : " + visiteur);
				serializedVisiteurs.add(visiteur);
			}
			visiteurs = serializedVisiteurs;			
		}
		
	}



}
