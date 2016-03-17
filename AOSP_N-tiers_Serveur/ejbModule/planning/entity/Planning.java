package planning.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

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


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idPlanning;
	private int idCarre;
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
