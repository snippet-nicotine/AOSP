package utilisateur.entity;

import java.io.Serializable;
import java.util.Collection;

public abstract class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idUtilisateur;

	EtatCivil etatCivil;

	private String mail;
	
	private String motPasse;
	
	Collection<DroitsUtilisateur> listeDroits;
	
	
	// ---- Ajouté par nicolas  -----
	public String getNom(){
		return getEtatCivil().getNom();
	}
	
	public void setNom(String nom){
		EtatCivil etatCivil = new EtatCivil();
		etatCivil.setNom(nom);
		setEtatCivil(etatCivil);
	}
	
	// -----------------------------

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public EtatCivil getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(EtatCivil etatCivil) {
		this.etatCivil = etatCivil;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public Collection<DroitsUtilisateur> getListeDroits() {
		return listeDroits;
	}

	public void setListeDroits(Collection<DroitsUtilisateur> listeDroits) {
		this.listeDroits = listeDroits;
	}
	
	

}
