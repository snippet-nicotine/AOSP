package potager.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import commun.config.Parametres;
import utilisateur.entity.Jardinier;


/**
 * 
 * @author Nicolas LAMBERT
 * 
 * <p> Le potager est un terrain cultivable d’un jardinier. 
 * Il a une dimension <i>(longueur x largeur)</i> et peut être géré par un jardinier.
 * Il est décomposé en plusieurs {@link potager.entity.Carre Carres} de potager. </p>
 */
@Entity
@Table(name=Parametres.bddTablePotager)
public class Potager implements Serializable{

	private static final long serialVersionUID = -8065181790953611569L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int idPotager;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idProprietaire", unique=true)
	protected Jardinier  proprietaire;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinTable(name="aosp_potager_visiteur",
		joinColumns        = @JoinColumn(name="id_potager"),
		inverseJoinColumns = @JoinColumn(name="id_visiteur")	)
	protected List<Jardinier> visiteurs;
	
	protected LocalDate  dateCreation;	
	
	@OneToMany(mappedBy="potager", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	protected List<Carre> carres;
	
	@Column(length=20, nullable=false)
	private String nom;
	
	@Column(nullable=false)
	private int longueur;
	
	@Column(nullable=false)
	private int largeur;
	
	@Column(length=5, nullable=false)
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
			//visiteur.addPotagerPartage(this);
		}
	}
	
	public void clean(){
		
		proprietaire.clean();
		setCarres(    new ArrayList<Carre>( carres ) );		
		setVisiteurs( new ArrayList<Jardinier>( visiteurs ) );
		
		for(Jardinier visiteur : visiteurs){
			visiteur.clean();
		}
		
	}
	

}
