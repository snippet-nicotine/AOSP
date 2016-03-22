package planning.fabrique;

import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.entity.Evenement;
import planning.entity.Follower;
import planning.entity.Nutrition;
import planning.entity.Planning;
import planning.entity.Plante;
import planning.util.Action;

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
	 * @param planning
	 * @return �v�nement instanci�
	 */
	public Evenement creationEvenement(int idEvenement, Planning planning){
		Evenement evenement = new Evenement();
		evenement.setIdEvenement(idEvenement);
		evenement.setPlanning(planning);
		return evenement;
	}
	
	/**
	 * Permet d'instancier un �v�nement uniquement avec un id �v�nement
	 * et un id planning
	 * @param idEvenement
	 * @param planning
	 * @return �v�nement instanci�
	 */
	public Evenement creationEvenement(int idEvenement, Planning planning, Action action,
			Plante plante, Nutrition nutrition, LocalDate localDate, String comAuto, String com){
		Evenement evenement = new Evenement();
		evenement.setIdEvenement(idEvenement);
		evenement.setPlanning(planning);
		evenement.setAction(action);
		evenement.setPlante(plante);
		evenement.setPlanning(planning);
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

	public Follower creationFollower() {
		// TODO Auto-generated method stub
		return null;
	}

}
