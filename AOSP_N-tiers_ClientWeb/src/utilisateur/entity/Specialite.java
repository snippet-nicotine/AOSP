package utilisateur.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Specialite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private int idSpecialite;
	
	
	private String libelle;

	
	
	public Specialite() {
		super();
	}

	public Specialite(String libelle) {
		super();
		this.libelle = libelle;
	}

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

}
