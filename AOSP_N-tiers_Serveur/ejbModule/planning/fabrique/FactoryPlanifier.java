package planning.fabrique;

import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.entity.Evenement;
import planning.entity.Nutrition;
import planning.entity.Planning;

/**
 * La Design Pattern Factory utilis�e pour la
 * partie "Planifier".
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class FactoryPlanifier {
	
	public Evenement creationEvenement(){
		Evenement evenement = new Evenement();		
		return evenement;
	}
	
	/**
	 * Permet d'instancier un �v�nement uniquement avec un id �v�nement
	 * et un id planning
	 * @param idEvenement
	 * @param idPlanning
	 * @return �v�nement instanci�
	 */
	public Evenement creationEvenement(int idEvenement, int idPlanning){
		Evenement evenement = new Evenement();
		evenement.setIdEvenement(idEvenement);
		evenement.setIdPlanning(idPlanning);
		return evenement;
	}
	
	/**
	 * Permet d'instancier un �v�nement uniquement avec un id �v�nement
	 * et un id planning
	 * @param idEvenement
	 * @param idPlanning
	 * @return �v�nement instanci�
	 */
	public Evenement creationEvenement(int idEvenement, int idPlanning, int idAction,
			int idPlante, Nutrition nutrition, LocalDate localDate, String comAuto, String com){
		Evenement evenement = new Evenement();
		evenement.setIdEvenement(idEvenement);
		evenement.setIdPlanning(idPlanning);
		evenement.setIdAction(idAction);
		evenement.setIdPlante(idPlante);
		evenement.setIdPlanning(idPlanning);
		evenement.setNutrition(nutrition);
		evenement.setDateEvenement(localDate);
		evenement.setCommentaireAuto(comAuto);;
		evenement.setCommentaire(com);;
		return evenement;
	}
	
	public Planning creationPlanning(){
		Planning planning = new Planning();		
		return planning;
	}

}
