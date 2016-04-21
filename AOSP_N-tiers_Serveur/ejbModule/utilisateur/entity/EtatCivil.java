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
 * Entit� qui impl�mente l'�tat civil de l'utilisateur
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

	// id g�n�r�e automatiquement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ref_etat_civil")
	private int idEtatCivil;		// id de l'�tat civil

	@Column(name="nom", length = 30, nullable = true)
	private String nom;				// nom de l'utilisateur

	@Column(name="prenom", length = 30, nullable = true)
	private String prenom;			// pr�nom de l'utilisateur

	/**
	 * Constructeur par d�faut
	 */
	public EtatCivil() {
		super();
	}


	/**
	 * constructeur initialisant les propri�t�s de l'�tat civil, sauf l'id qui sera g�n�r�e automatiquement
	 * @param nom nom de l'utilisateur
	 * @param prenom pr�nom de l'utilisateur
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
