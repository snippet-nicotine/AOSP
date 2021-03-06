package planning.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import commun.config.ActionEvenement;
import planning.dao.evenement.ControleurDaoCrudEvenement;
import planning.dao.evenement.ControleurDaoListerEvenement;
import planning.dao.follower.ControleurDaoCrudFollower;
import planning.dao.follower.ControleurDaoListerFollower;
import planning.dao.planning.ControleurDaoCrudPlanning;
import planning.dao.planning.ControleurDaoListerPlanning;
import planning.entity.Evenement;
import planning.entity.Follower;
import planning.entity.Nutrition;
import planning.entity.Planning;
import planning.entity.Plante;
import planning.exception.DaoException;
import potager.entity.Carre;

/**
 * EJB session bean de type Stateless, Local : fa�ade, unique
 * point d'entr�e de la couche dao. Regroupe
 * l'ensemble des services (ici m�hodes) que peut demander la
 * couche service. M�thodes contenues : crud + lister un planning et crud + lister
 * un �v�nement.
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
	
	@EJB
	private ControleurDaoCrudFollower controleurDaoCrudFollower;
	@EJB
	private ControleurDaoListerFollower controleurDaoListerFollower;
	
		
	@Override
	public void creerPlanning(Planning planning) throws DaoException {
		controleurDaoCrudPlanning.addPlanning(planning);
	}

	@Override
	public void supprimerPlanning(int idPlanning) throws DaoException {
		controleurDaoCrudPlanning.delPlanning(idPlanning);
	}

	@Override
	public Planning getPlanning(int idPlanning) throws DaoException {
		return controleurDaoCrudPlanning.getPlanning(idPlanning);
	}

	@Override
	public void modifierPlanning(Planning planning) throws DaoException {
		controleurDaoCrudPlanning.updatePlanning(planning);
	}

	@Override
	public List<Planning> rechercherAllPlanning(int idCarre) throws DaoException {
		System.out.println("dans FacadeDao");
		return controleurDaoListerPlanning.getAllPlanning(idCarre);
	}

	@Override
	public Planning creationPlanning(Carre carre) throws DaoException {
		return controleurDaoCrudPlanning.createPlanning(carre);
	}

	@Override
	public void creerEvenement(Evenement evenement) throws DaoException {
		controleurDaoCrudEvenement.addEvenement(evenement);
	}

	@Override
	public void supprimerEvenement(int idEvenement) throws DaoException {
		controleurDaoCrudEvenement.delEvenement(idEvenement);
	}

	@Override
	public Evenement getEvenement(int idEvenement) throws DaoException {
		return controleurDaoCrudEvenement.getEvenement(idEvenement);
	}

	@Override
	public void modifierEvenement(Evenement evenement) throws DaoException {
		controleurDaoCrudEvenement.updateEvenement(evenement);
	}

	@Override
	public List<Evenement> rechercherAllEvenement(int idPlanning) throws DaoException {
		return controleurDaoListerEvenement.getAllEvenement(idPlanning);
	}

	@Override
	public Evenement creationEvenement(Planning planning) throws DaoException {
		return controleurDaoCrudEvenement.createEvenement(planning);
	}


	@Override
	public Evenement creationEvenement(Planning planning, ActionEvenement action, Plante plante, Nutrition nutrition,
			LocalDate localDate, String comAuto, String com) throws DaoException {

		return controleurDaoCrudEvenement.createEvenement(planning, action, plante, nutrition, localDate, comAuto, com);
	}

	@Override
	public void creerFollower(Follower follower) throws DaoException {
		controleurDaoCrudFollower.addFollower(follower);
	}

	@Override
	public void supprimerFollower(int idFollower) throws DaoException {
		controleurDaoCrudFollower.delFollower(idFollower);		
	}

	@Override
	public void modifierFollower(Follower follower) throws DaoException {
		controleurDaoCrudFollower.updateFollower(follower);
	}

	@Override
	public List<Follower> rechercherAllFollower(int idPlanning) throws DaoException {
		return controleurDaoListerFollower.getAllFollower(idPlanning);
	}

	@Override
	public Follower creationFollower(String nom, String prenom) throws DaoException {
		return controleurDaoCrudFollower.createFollower(nom, prenom);
	}

	@Override
	public Follower getFollower(int idFollower) throws DaoException {
		return controleurDaoCrudFollower.getFollower(idFollower);
	}
	
}
