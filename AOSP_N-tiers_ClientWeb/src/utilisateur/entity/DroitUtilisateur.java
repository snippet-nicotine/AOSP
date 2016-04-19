package utilisateur.entity;

import java.io.Serializable;

public class DroitUtilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idDroit;
	
	private String libelle;

	public DroitUtilisateur() {
		super();
	}
	
	

	public DroitUtilisateur(String libelle) {
		super();
		this.libelle = libelle;
	}



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

	@Override
	public String toString() {
		return "DroitUtilisateur [idDroit=" + idDroit + ", libelle=" + libelle + "]";
	}
}
