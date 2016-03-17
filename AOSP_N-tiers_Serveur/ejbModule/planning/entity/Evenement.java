package planning.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * EJB Entity, classe Entity Serialisable la plus importante dans la
 * partie "Planifier". Actuellement et pour des raisons
 * pratiques, la propriété nutrition de type Nutrition
 * reste en Transient. Aucune méthode codée dans cette classe.
 * @author Didier
 *
 */
@Entity
public class Evenement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idEvenement;
	private int idPlanning;
	private int idAction;
	private int idPlante;
	@Transient
	private Nutrition nutrition;
	private LocalDate dateEvenement;
	private String commentaireAuto;
	private String commentaire;
	
	public Evenement() {
		super();
	}
	
	public Evenement(int idEvenement, int idPlanning, int idAction, int idPlante, Nutrition nutrition, LocalDate dateEvenement,
			String commentaireAuto, String commentaire) {
		super();
		this.idEvenement = idEvenement;
		this.idPlanning = idPlanning;
		this.idAction = idAction;
		this.idPlante = idPlante;
		this.nutrition = nutrition;
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
	public int getIdPlanning() {
		return idPlanning;
	}
	public void setIdPlanning(int idPlanning) {
		this.idPlanning = idPlanning;
	}
	public int getIdAction() {
		return idAction;
	}
	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}
	public int getIdPlante() {
		return idPlante;
	}
	public void setIdPlante(int idPlante) {
		this.idPlante = idPlante;
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
		return "Evenement [idEvenement=" + idEvenement + ", idPlanning=" + idPlanning + ", idAction=" + idAction
				+ ", idPlante=" + idPlante + ", nutrition=" + nutrition + ", dateEvenement=" + dateEvenement
				+ ", commentaireAuto=" + commentaireAuto + ", commentaire=" + commentaire + "]";
	}
}
