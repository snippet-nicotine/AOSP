package planning.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import commun.config.ActionEvenement;
import commun.config.Parametres;

/**
 * EJB Entity, classe Entity Serialisable la plus importante dans la
 * partie "Planifier".
 * @author Didier
 *
 */
@Entity
@Table(name = Parametres.NOM_TABLE_EVENEMENT)
public class Evenement implements Serializable {
	
	@Version
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idEvenement", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "evenementSequence")
	@SequenceGenerator(name = "evenementSequence", sequenceName = "evenement_sequence",
	initialValue = 1, allocationSize = 30)
	private int idEvenement;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPlanning", nullable = true)
	private Planning planning;
	
	private ActionEvenement action;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPlante", nullable = true)
	private Plante plante;
	
	@Embedded
	private Nutrition nutrition;
	
	private LocalDate dateEvenement;
	
	@Column(name = "commAuto", length = 30, nullable = true)
	private String commentaireAuto;
	
	@Column(name = "comm", length = 30, nullable = true)
	private String commentaire;
	
	public Evenement() {
		super();
	}

	public Evenement(int idEvenement, Planning planning, ActionEvenement action, Plante plante, Nutrition nutrition,
			LocalDate dateEvenement, String commentaireAuto, String commentaire) {
		super();
		this.idEvenement = idEvenement;
		this.planning = planning;
		this.action = action;
		this.plante = plante;
		this.nutrition = nutrition;
		if (dateEvenement == null) {
			dateEvenement = LocalDate.now();
		}
		this.dateEvenement = dateEvenement;
		this.commentaireAuto = commentaireAuto;
		this.commentaire = commentaire;
	}

	public int getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
	}

	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public ActionEvenement getAction() {
		return action;
	}

	public void setAction(ActionEvenement action) {
		this.action = action;
	}

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	public Nutrition getNutrition() {
		return nutrition;
	}

	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}

	public LocalDate getDateEvenement() {
		return dateEvenement;
	}

	public void setDateEvenement(LocalDate dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	public String getCommentaireAuto() {
		return commentaireAuto;
	}

	public void setCommentaireAuto(String commentaireAuto) {
		this.commentaireAuto = commentaireAuto;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Evenement [idEvenement=" + idEvenement + ", planning=" + planning + ", action=" + action + ", plante="
				+ plante + ", nutrition=" + nutrition + ", dateEvenement=" + dateEvenement + ", commentaireAuto="
				+ commentaireAuto + ", commentaire=" + commentaire + "]";
	}
	

}
