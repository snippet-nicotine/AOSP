package planning.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

public class Planning implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idPlanning;
	private int idCarre;
	private LocalDate dateCréation;

	private ArrayList<Evenement> evenements;

	public Planning() {
		super();
	}

	public Planning(int idPlanning, int idCarre, LocalDate dateCréation, ArrayList<Evenement> evenements) {
		super();
		this.idPlanning   = idPlanning;
		this.idCarre      = idCarre;
		this.dateCréation = dateCréation;
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

	public LocalDate getDateCréation() {
		return dateCréation;
	}

	public void setDateCréation(LocalDate dateCréation) {
		this.dateCréation = dateCréation;
	}

	public ArrayList<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(ArrayList<Evenement> evenements) {
		this.evenements = evenements;
	}

	@Override
	public String toString() {
		return "Planning [idPlanning=" + idPlanning + ", idCarre=" + idCarre + ", dateCréation=" + dateCréation
				+ ", evenements=" + evenements + "]";
	}




}
