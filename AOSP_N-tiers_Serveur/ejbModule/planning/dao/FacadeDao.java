package planning.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import planning.dao.evenement.ControleurDaoCrudEvenement;
import planning.dao.evenement.ControleurDaoListerEvenement;
import planning.dao.planning.ControleurDaoCrudPlanning;
import planning.dao.planning.ControleurDaoListerPlanning;
import planning.entity.Evenement;
import planning.entity.Planning;
import planning.exception.DaoException;

/**
 * EJB session bean de type Stateless, Local : façade, unique
 * point d'entrée de la couche dao. Regroupe
 * l'ensemble des services (ici méhodes) que peut demander la
 * couche service. Méthodes contenues : crud + lister un planning et crud + lister
 * un évènement.
 * @author Didier
 *
 */
@Stateless
@Local(IDao.class)
public class FacadeDao implements IDao {

	@EJB
	private ControleurDaoCrudPlanning controleurDaoCrudPlanning;	
	@EJB
	private ControleurDaoListerPlanning controleurDaoListerPlanning;
	
	@EJB
	private ControleurDaoCrudEvenement controleurDaoCrudEvenement;
	@EJB
	private ControleurDaoListerEvenement controleurDaoListerEvenement;
	
		
	@Override
	public void creerPlanning(Planning planning) throws DaoException {
		controleurDaoCrudPlanning.creerPlanning(planning);
	}

	@Override
	public void supprimerPlanning(int idPlanning) throws DaoException {
		controleurDaoCrudPlanning.supprimerPlanning(idPlanning);
	}

	@Override
	public Planning getPlanning(int idPlanning) throws DaoException {
		return controleurDaoCrudPlanning.getPlanning(idPlanning);
	}

	@Override
	public void modifierPlanning(Planning planning) throws DaoException {
		controleurDaoCrudPlanning.modifierPlanning(planning);
	}

	@Override
	public List<Planning> rechercherAllPlanning(int idCarre) throws DaoException {
		System.out.println("dans FacadeDao");
		return controleurDaoListerPlanning.rechercherAllPlanning(idCarre);
	}

	@Override
	public void creerEvenement(Evenement evenement) throws DaoException {
		controleurDaoCrudEvenement.creerEvenement(evenement);
	}

	@Override
	public void supprimerEvenement(int idEvenement) throws DaoException {
		controleurDaoCrudEvenement.supprimerEvenement(idEvenement);
	}

	@Override
	public Evenement getEvenement(int idEvenement) throws DaoException {
		return controleurDaoCrudEvenement.getEvenement(idEvenement);
	}

	@Override
	public void modifierEvenement(Evenement evenement) throws DaoException {
		controleurDaoCrudEvenement.modifierEvenement(evenement);
	}

	@Override
	public List<Evenement> rechercherAllEvenement(int idPlanning) throws DaoException {
		return controleurDaoListerEvenement.rechercherAllEvenement(idPlanning);
	}

	
}
