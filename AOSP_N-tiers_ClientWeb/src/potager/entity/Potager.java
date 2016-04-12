package potager.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

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
	
	@Expose	protected int idPotager;
	@Expose protected Jardinier  proprietaire;	
	@Expose protected List<Jardinier> visiteurs;
	
	@Expose protected LocalDate  dateCreation;	
	@Expose protected List<Carre> carres;
	@Expose private String nom;
	@Expose private int longueur;
	@Expose private int largeur;
	@Expose private String codePostal;
	
	@Expose private int nbCarresX;
	@Expose private int nbCarresY;	
	
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
		return visiteurs;
	}

	public void setVisiteurs(List<Jardinier> visiteurs) {
		this.visiteurs = visiteurs;
	}


}
