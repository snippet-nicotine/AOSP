package utilisateur.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aosp_etat_civil")
public class EtatCivil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ref_etat_civil")
	private int idEtatCivil;
	
	@Column(name="nom", length = 30, nullable = true)
	private String nom;
	
	@Column(name="prenom", length = 30, nullable = true)
	private String prenom;
	
	
	public EtatCivil() {
		super();
	}
	
	

	public EtatCivil(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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

	public int getIdEtatCivil() {
		return idEtatCivil;
	}

	public void setIdEtatCivil(int idEtatCivil) {
		this.idEtatCivil = idEtatCivil;
	}

	

	

}
