package planning.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Follower implements Serializable{

	private static final long serialVersionUID = 8754664668653019633L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int idFollower;
	private String nom;
	private String prenom;
	
	public Follower(){

	}

	public Follower(int idFollower, String nom, String prenom) {
		super();
		this.idFollower = idFollower;
		this.nom = nom;
		this.prenom = prenom;
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

	@Override
	public String toString() {
		return "Follower [idFollower=" + idFollower + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFollower;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Follower other = (Follower) obj;
		if (idFollower != other.idFollower)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}



}
