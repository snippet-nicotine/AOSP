package planning.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Version;

public class Follower implements Serializable{

	@Version
	private static final long serialVersionUID = 8754664668653019633L;
	
	private int idFollower;
	private String nom;
	private String prenom;
	private List<Planning> plannings = new ArrayList<Planning>();
	
	public Follower(){

	}

	public Follower(int idFollower, String nom, String prenom, List<Planning> plannings) {
		super();
		this.idFollower = idFollower;
		this.nom = nom;
		this.prenom = prenom;
		this.plannings = plannings;
	}

	public int getIdFollower() {
		return idFollower;
	}

	public void setIdFollower(int idFollower) {
		this.idFollower = idFollower;
	}

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

	public List<Planning> getPlannings() {
		return plannings;
	}

	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}

	@Override
	public String toString() {
		return "Follower [idFollower=" + idFollower + ", nom=" + nom + ", prenom=" + prenom + ", plannings=" + plannings
				+ "]";
	}

}
