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
	
	Collection<DroitUtilisateur> listeDroits;

	public Utilisateur() {
		super();
	}

	public Utilisateur(EtatCivil etatCivil, String mail, String motPasse, Collection<DroitUtilisateur> listeDroits) {
		super();
		this.etatCivil = etatCivil;
		this.mail = mail;
		this.motPasse = motPasse;
		this.listeDroits = listeDroits;
	}
	
	
	
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

	public Collection<DroitUtilisateur> getListeDroits() {
		return listeDroits;
	}

	public void setListeDroits(Collection<DroitUtilisateur> listeDroits) {
		this.listeDroits = listeDroits;
	}
	
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", etatCivil=" + etatCivil + ", mail=" + mail
				+ ", motPasse=" + motPasse + ", listeDroits=" + listeDroits + "]";
	}

}
