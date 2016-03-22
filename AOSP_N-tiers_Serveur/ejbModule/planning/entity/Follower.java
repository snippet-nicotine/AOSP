package planning.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import commun.config.Parametres;
import planning.util.Parametre;

@Entity
@Table(name = Parametres.bddPrefix + Parametres.bddSeparator + Parametre.NOM_TABLE_FOLLOWER + Parametres.bddSuffix)
public class Follower implements Serializable{

	@Version
	private static final long serialVersionUID = 8754664668653019633L;
	
	@Id
	@Column(name="idFollower", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "followerSequence")
	@SequenceGenerator(name = "followerSequence", sequenceName = "follower_sequence",
	initialValue = 1, allocationSize = 30)
	private int idFollower;
	
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length = 30, nullable = false)	
	private String prenom;
	
	@ManyToMany( mappedBy = "followers", fetch=FetchType.EAGER)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFollower;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((plannings == null) ? 0 : plannings.hashCode());
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
		if (plannings == null) {
			if (other.plannings != null)
				return false;
		} else if (!plannings.equals(other.plannings))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}





}
