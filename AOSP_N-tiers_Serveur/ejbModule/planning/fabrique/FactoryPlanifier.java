package planning.fabrique;

import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.entity.Evenement;
import planning.entity.Nutrition;
import planning.entity.Planning;

/**
 * La Design Pattern Factory utilisée pour la
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
	 * Permet d'instancier un évènement uniquement avec un id évènement
	 * et un id planning
	 * @param idEvenement
	 * @param idPlanning
	 * @return évènement instancié
	 */
	public Evenement creationEvenement(int idEvenement, int idPlanning){
		Evenement evenement = new Evenement();
		evenement.setIdEvenement(idEvenement);
		evenement.setIdPlanning(idPlanning);
		return evenement;
	}
	
	/**
	 * Permet d'instancier un évènement uniquement avec un id évènement
	 * et un id planning
	 * @param idEvenement
	 * @param idPlanning
	 * @return évènement instancié
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
