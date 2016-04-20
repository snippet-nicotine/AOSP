package utilisateur.entity;

import java.io.Serializable;

public class EtatCivil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idEtatCivil;

	private String nom;
	
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

	private String prenom;


	public void setIdEtatCivil(int idEtatCivil) {
		this.idEtatCivil = idEtatCivil;
	}

	public int getIdEtatCivil() {
		return idEtatCivil;
	}

}
