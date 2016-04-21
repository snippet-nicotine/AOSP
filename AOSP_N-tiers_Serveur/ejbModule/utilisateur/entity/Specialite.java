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
 * Entit� impl�mentant les sp�cialit�s
 * @author Guillaume
 *
 */
@Entity
@Table(name=Param.TABLE_AOSP_SPECIALITE)
public class Specialite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// id g�n�r�e automatiquement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSpecialite;		// id de la sp�cialit�
	
	@Column(length = 30, nullable = true)
	private String libelle;			// libell� de la sp�cialit�
		
	/**
	 * constructeur par d�faut
	 */
	public Specialite() {
		super();
	}
	
	/**
	 * constructeur initialisant le libell� mais pas isSpecialite qui sera g�n�r� automatiquement
	 * @param libelle libell� de la sp�cialit�
	 */
	public Specialite(String libelle) {
		super();
		this.libelle = libelle;
	}

	//******************************* GETTERS et SETTERS

	public int getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(int idSpecialite) {
		this.idSpecialite = idSpecialite;
	}


	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "Specialite [idSpecialite=" + idSpecialite + ", libelle=" + libelle + "]";
	}


}
