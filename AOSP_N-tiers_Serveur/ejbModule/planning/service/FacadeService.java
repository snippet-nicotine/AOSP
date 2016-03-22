package planning.service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import planning.clientServeur.IService;
import planning.entity.Evenement;
import planning.entity.Nutrition;
import planning.entity.Planning;
import planning.exception.ServiceException;
import planning.fabrique.FactoryPlanifier;
import planning.service.evenement.ControleurServiceCrudEvenement;
import planning.service.evenement.ControleurServiceListerEvenement;
import planning.service.planning.ControleurServiceCrudPlanning;
import planning.service.planning.ControleurServiceListerPlanning;

/**
 * EJB session bean de type Stateless, Remote : façade de la 
 * couche service, unique point d'entrée côté serveur Regroupe
 * l'ensemble des services (ici méhodes) que peut demander un
 * client (application avec ou sans interface graphique, un
 * bean, une servlet ou une JSP ou un autre EJB. Méthodes
 * contenues : crud + lister un planning et crud + lister
 * un évènement.
 * @author Didier
 *
 */
@Stateless
@Remote(IService.class)
public class FacadeService implements IService {

	@EJB
	private ControleurServiceCrudPlanning controleurServiceCrudPlanning;
	@EJB
	private ControleurServiceListerPlanning controleurServiceListerPlanning;
	
	@EJB
	private ControleurServiceCrudEvenement controleurServiceCrudEvenement;
	@EJB
	private ControleurServiceListerEvenement controleurServiceListerEvenement;
	
	@EJB
	private FactoryPlanifier factoryPlanifier;
	
	
	@Override
	public void creerPlanning(Planning planning) throws ServiceException {
		controleurServiceCrudPlanning.creerPlanning(planning);
	}

	@Override
	public void supprimerPlanning(int idPlanning) throws ServiceException {
		controleurServiceCrudPlanning.supprimerPlanning(idPlanning);
	}

	@Override
	public Planning getPlanning(int idPlanning) throws ServiceException {
		return controleurServiceCrudPlanning.getPlanning(idPlanning);
	}

	@Override
	public void modifierPlanning(Planning planning) throws ServiceException {
		controleurServiceCrudPlanning.modifierPlanning(planning);
		
	}

	@Override
	public List<Planning> rechercherAllPlanning(int idCarre) throws ServiceException {
		System.out.println("dans facade service");
		return controleurServiceListerPlanning.rechercherAllPlanning(idCarre);
	}

	@Override
	public void creerEvenement(Evenement evenement) throws ServiceException {
		controleurServiceCrudEvenement.creerEvenement(evenement);
		
	}

	@Override
	public void supprimerEvenement(int idEvenement) throws ServiceException {
		controleurServiceCrudEvenement.supprimerEvenement(idEvenement);
		
	}

	@Override
	public Evenement getEvenement(int idEvenement) throws ServiceException {

		return controleurServiceCrudEvenement.getEvenement(idEvenement);
	}

	@Override
	public void modifierEvenement(Evenement evenement) throws ServiceException {
		controleurServiceCrudEvenement.modifierEvenement(evenement);
		
	}

	@Override
	public List<Evenement> rechercherAllEvenement(int idPlanning) throws ServiceException {
		
		return controleurServiceListerEvenement.rechercherAllEvenement(idPlanning);
	}

	@Override
	public Planning creationPlanning() throws ServiceException {
		return factoryPlanifier.creationPlanning();
	}

	@Override
	public Evenement creationEvenement() throws ServiceException {
		return factoryPlanifier.creationEvenement();
	}

	@Override
	public Evenement creationEvenement(int idEvenement, int idPlanning, int idAction,
			int idPlante, Nutrition nutrition,
			LocalDate localDate, String comAuto, String com) {
		return factoryPlanifier.creationEvenement(idEvenement, idPlanning, idAction,
				idPlante, nutrition, localDate, comAuto, com);
	}

	
	
	

}
