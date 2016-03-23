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
import potager.entity.Carre;

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
	 * @param planning
	 * @return évènement instancié
	 */
	public Evenement creationEvenement(Planning planning){
		Evenement evenement = new Evenement();
		evenement.setPlanning(planning);
		return evenement;
	}
	
	/**
	 * Permet d'instancier un évènement uniquement avec un id évènement
	 * et un id planning
	 * @param idEvenement
	 * @param planning
	 * @return évènement instancié
	 */
	public Evenement creationEvenement(Planning planning, Action action,
			Plante plante, Nutrition nutrition, LocalDate localDate, String comAuto, String com){
		Evenement evenement = new Evenement();
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
	
	public Planning creationPlanning(Carre carre){
		Planning planning = new Planning();
		planning.setCarre(carre);
		return planning;
	}

	public Follower creationFollower() {
		Follower follower = new Follower();
		return follower;
	}
	
	public Follower creationFollower(String nom, String prenom) {
		Follower follower = new Follower();
		follower.setNom(nom);
		follower.setPrenom(prenom);
		return follower;
	}

}
