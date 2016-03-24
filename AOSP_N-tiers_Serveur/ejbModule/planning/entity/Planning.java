
package planning.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import commun.config.Parametres;
import potager.entity.Carre;

/**
 * EJB Entity, classe Entity Serialisable.
 * 
 * @author Didier
 */
@Entity
@Table(name = Parametres.NOM_TABLE_PLANNING)
public class Planning implements Serializable {

	@Version
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idPlanning", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "planningSequence")
	@SequenceGenerator(name = "planningSequence", sequenceName = "planning_sequence",
	initialValue = 1, allocationSize = 30)
	private int idPlanning;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCarre", unique = true, nullable = false)
	private Carre carre;

	
	private LocalDate dateCreation;
	
	@OneToMany(mappedBy = "planning", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
	private List<Evenement> evenements = new ArrayList<Evenement>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name=Parametres.NOM_TABLE_PLANNING_FOLLOWER,
			joinColumns = @JoinColumn(name="idPlanning") ,
			inverseJoinColumns = @JoinColumn(name="idFollower") )
	private List<Follower> followers = new ArrayList<Follower>();
	
	public Planning() {
		super();
	}

	public Planning(int idPlanning, Carre carre, LocalDate dateCreation, List<Evenement> evenements,
			List<Follower> followers) {
		super();
		this.idPlanning = idPlanning;
		this.carre = carre;	
		if (dateCreation == null) {
			dateCreation = LocalDate.now();
		}
		this.dateCreation = dateCreation;
		this.evenements = evenements;
		this.followers = followers;
	}

	public int getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}

	public Carre getCarre() {
		return carre;
	}

	public void setCarre(Carre carre) {
		this.carre = carre;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	public List<Follower> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follower> followers) {
		this.followers = followers;
	}

	@Override
	public String toString() {
		return "Planning [idPlanning=" + idPlanning + ", idCarre=" + carre + ", dateCreation=" + dateCreation
				+ ", evenements=" + evenements + ", followers=" + followers + "]";
	}

	


}
