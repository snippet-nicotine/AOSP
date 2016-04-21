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
 * Entit� qui impl�mente les droits utilisateurs
 * @author Guillaume
 *
 */
@Entity
@Table(name = Param.TABLE_AOSP_DROIT)
public class DroitUtilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id g�n�r�e automatiquement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDroit;			// id du droit

	@Column(length = 30, nullable = true)
	private String libelle;			// libell� du droit

	/**
	 * Constructeur par d�faut
	 */
	public DroitUtilisateur() {
		super();
	}	

	/**
	 * Contructeur qui initialise le libell� du droit mais pas l'id qui sera g�n�r�e automatiquement
	 * @param libelle
	 */
	public DroitUtilisateur(String libelle) {
		super();
		this.libelle = libelle;
	}

	//******************** GETTERS et SETTERS

	public int getIdDroit() {
		return idDroit;
	}

	public void setIdDroit(int idDroit) {
		this.idDroit = idDroit;
	}


	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	// toString
	@Override
	public String toString() {
		return "DroitUtilisateur [idDroit=" + idDroit + ", libelle=" + libelle + "]";
	}

}
