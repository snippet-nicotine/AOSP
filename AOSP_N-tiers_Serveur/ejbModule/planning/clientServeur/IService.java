package planning.clientServeur;

import java.time.LocalDate;
import java.util.List;

import planning.entity.Evenement;
import planning.entity.Follower;
import planning.entity.Nutrition;
import planning.entity.Planning;
import planning.entity.Plante;
import planning.exception.ServiceException;
import planning.util.Action;

/**
 * Interface qui permet de définir l'ensemble des services
 * fournis par l'EJB session bean : FacadeService
 * @author Didier
 *
 */
public interface IService {

	public void creerPlanning(Planning planning) throws ServiceException;
	public void supprimerPlanning(int idPlanning) throws ServiceException;
	public void modifierPlanning(Planning planning) throws ServiceException;
	public List<Planning> rechercherAllPlanning(int idCarre) throws ServiceException;
	public Planning getPlanning(int idPlanning) throws ServiceException;
	public Planning creationPlanning() throws ServiceException;
		
	public void creerEvenement(Evenement evenement) throws ServiceException;
	public void supprimerEvenement(int idEvenement) throws ServiceException;
	public void modifierEvenement(Evenement evenement) throws ServiceException;
	public List<Evenement> rechercherAllEvenement(int idPlanning) throws ServiceException;
	public Evenement getEvenement(int idEvenement) throws ServiceException;
	public Evenement creationEvenement() throws ServiceException;
	public Evenement creationEvenement(Planning planning, Action action,
			Plante plante, Nutrition nutrition, LocalDate localDate, String comAuto, String com) throws ServiceException;
	
	public void creerFollower(Follower follower) throws ServiceException;
	public void supprimerFollower(int idFollower) throws ServiceException;
	public Follower getFollower(int idFollower) throws ServiceException;
	public void modifierFollower(Follower follower) throws ServiceException;
	public List<Follower> rechercherAllFollower(int idPlanning) throws ServiceException;
	public Follower creationFollower(String nom, String prenom) throws ServiceException;
	public Follower creationFollower() throws ServiceException;
}
