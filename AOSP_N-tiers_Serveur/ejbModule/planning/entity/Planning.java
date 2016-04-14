
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

//	@Override
//	public String toString() {
//		return "Planning [idPlanning=" + idPlanning + ", idCarre=" + carre + ", dateCreation=" + dateCreation
//				+ ", evenements=" + evenements + ", followers=" + followers + "]";
//	}

	
	// utilise pout obtenir un data Transfert Object
	// Neccessaire pour transformer un proxy (hibernate) en objet transiant (pas dans le contexte)
	// lors de la communication avec l'application cliente
	// sinon, hibernate gère les collections dans un type persistentBag propre a hibernate
	// Pour eviter la propagation du persistentBag (ArrayList<Theme>) dans la couche cliente qui ne le connait pas
	// Il faut le transformer en ArrayList
	public Planning getDto () {

		Planning planDto = new Planning(this.getIdPlanning(), null, this.getDateCreation(),
				null, this.getFollowers());

		if (this.getCarre() != null) planDto.setCarre(this.getCarre());


		//		// on ajoute les themes du persistantBag dans le nouveau docDto
		if (this.getEvenements() != null) {
			ArrayList<Evenement> listeDto = new ArrayList<>();
			for (Evenement evenement : this.getEvenements()) {
				Evenement evenementDto = evenement;
				// Theme themeDto = new Theme(theme.getId(), theme.getNom(), theme.getDescription());
				// themeDto.setDocuments(theme.getDocuments()); => persistentBag (la liste des documents dans le theme)
				listeDto.add(evenementDto);
			}
			planDto.setEvenements(listeDto);
		}
		return planDto;
	}
	
	public Planning getDtoSansFollowerSansEvennement () {

		Planning planDto = new Planning(this.getIdPlanning(), null, this.getDateCreation(),
				null, null);
		
		if (this.getCarre() != null) planDto.setCarre(this.getCarre());
		
		return planDto;
	}

	@Override
	public String toString() {
		return "Planning [idPlanning=" + idPlanning + ", carre=" + carre + ", dateCreation=" + dateCreation
				+ ", evenements="  + ", followers=" +  "]";
	}

}
