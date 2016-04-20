package utilisateur.entity;

import java.io.Serializable;

public class DroitsUtilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idDroit;

	private String libelle;

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

}
