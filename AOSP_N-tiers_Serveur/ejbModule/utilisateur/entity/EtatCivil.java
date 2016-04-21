package utilisateur.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import utilisateur.util.Param;

/**
 * Entité qui implémente l'état civil de l'utilisateur
 * @author Guillaume
 *
 */
@Entity
@Table(name=Param.TABLE_AOSP_ETAT_CIVIL)
public class EtatCivil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id générée automatiquement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ref_etat_civil")
	private int idEtatCivil;		// id de l'état civil

	@Column(name="nom", length = 30, nullable = true)
	private String nom;				// nom de l'utilisateur

	@Column(name="prenom", length = 30, nullable = true)
	private String prenom;			// prénom de l'utilisateur

	/**
	 * Constructeur par défaut
	 */
	public EtatCivil() {
		super();
	}


	/**
	 * constructeur initialisant les propriétés de l'état civil, sauf l'id qui sera générée automatiquement
	 * @param nom nom de l'utilisateur
	 * @param prenom prénom de l'utilisateur
	 */
	public EtatCivil(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	//************** GETTERS et SETTERS

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

	// toString

	@Override
	public String toString() {
		return "EtatCivil [idEtatCivil=" + idEtatCivil + ", nom=" + nom + ", prenom=" + prenom + "]";
	}





}
