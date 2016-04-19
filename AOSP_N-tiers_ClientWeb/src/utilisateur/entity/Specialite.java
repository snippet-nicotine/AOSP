package utilisateur.entity;

import java.io.Serializable;

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

	@Override
	public String toString() {
		return "Specialite [idSpecialite=" + idSpecialite + ", libelle=" + libelle + "]";
	}
}
