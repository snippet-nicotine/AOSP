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
 * Entité implémentant les spécialités
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
	
	// id générée automatiquement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSpecialite;		// id de la spécialité
	
	@Column(length = 30, nullable = true)
	private String libelle;			// libellé de la spécialité
		
	/**
	 * constructeur par défaut
	 */
	public Specialite() {
		super();
	}
	
	/**
	 * constructeur initialisant le libellé mais pas isSpecialite qui sera généré automatiquement
	 * @param libelle libellé de la spécialité
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
