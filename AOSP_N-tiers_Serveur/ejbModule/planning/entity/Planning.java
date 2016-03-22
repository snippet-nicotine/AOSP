package planning.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * EJB Entity, classe Entity Serialisable. Actuellement et
 * pour des raisons pratiques, la propriété evenements de type
 * ArrayList<Evenement> reste en Transient. Aucune méthode 
 * codée dans cette classe.
 * @author Didier
 *
 */
@Entity
public class Planning implements Serializable {


	@Version
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idPlanning", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "planningSequence")
	@SequenceGenerator(name = "planningSequence", sequenceName = "planning_sequence",
							initialValue = 1, allocationSize = 30)
	private int idPlanning;
	
	private Carre idCarre;
	private LocalDate dateCreation;
	@Transient
	private ArrayList<Evenement> evenements;

	public Planning() {
		super();
	}

	public Planning(int idPlanning, int idCarre, LocalDate dateCreation, ArrayList<Evenement> evenements) {
		super();
		this.idPlanning   = idPlanning;
		this.idCarre      = idCarre;
		this.dateCreation = dateCreation;
		this.evenements   = evenements;
	}

	public int getIdPlanning() {
		return idPlanning;
	}

	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}

	public int getIdCarre() {
		return idCarre;
	}

	public void setIdCarre(int idCarre) {
		this.idCarre = idCarre;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public ArrayList<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(ArrayList<Evenement> evenements) {
		this.evenements = evenements;
	}

	@Override
	public String toString() {
		return "Planning [idPlanning=" + idPlanning + ", idCarre=" + idCarre + ", dateCréation=" + dateCreation
				+ ", evenements=" + evenements + "]";
	}




}
