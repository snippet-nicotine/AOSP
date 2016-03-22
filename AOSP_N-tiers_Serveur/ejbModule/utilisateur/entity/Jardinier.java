package utilisateur.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import commun.config.Parametres;
import potager.entity.Potager;

@Entity
@Table(name=Parametres.bddTableJardinier)
public class Jardinier implements Serializable{

	private static final long serialVersionUID = 8754664668653019633L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int idJardinier;
	
	@ManyToMany(mappedBy="visiteurs", 	fetch=FetchType.EAGER)
	private List<Potager> potagerPartages;
	
	private String nom;
	private String prenom;
	private String mail;
	private String motPasse;
	private String codePostal;
	
	public Jardinier(){
		this.nom = "Jardinier temp";
		this.potagerPartages = new ArrayList<Potager>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getIdJardinier() {
		return idJardinier;
	}

	public void setIdJardinier(int idJardinier) {
		this.idJardinier = idJardinier;
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


	public void setPotagerPartages(List<Potager> potagerPartages) {
		this.potagerPartages = potagerPartages;
	}

	public List<Potager> getPotagerPartages() {
		return potagerPartages;
	}

	public void addPotagerPartage(Potager potager) {
		
		if(!potagerPartages.contains(potager)){
			potagerPartages.add(potager);
		}
		
	}

	public void clean() {
		
		setPotagerPartages( new ArrayList<Potager>(potagerPartages) );
		
	}


}
