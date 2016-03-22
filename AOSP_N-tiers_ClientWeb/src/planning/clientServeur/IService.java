package planning.clientServeur;

import java.time.LocalDate;
import java.util.List;

import planning.entity.Evenement;
import planning.entity.Nutrition;
import planning.entity.Planning;
import planning.exception.ServiceException;

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
	public Evenement creationEvenement(int idEvenement, int idPlanning, int idAction,
			int idPlante, Nutrition nutrition, LocalDate localDate, String comAuto, String com);
}
