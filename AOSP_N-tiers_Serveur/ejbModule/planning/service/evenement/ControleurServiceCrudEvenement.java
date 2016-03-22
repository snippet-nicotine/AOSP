package planning.service.evenement;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.dao.IDao;
import planning.entity.Evenement;
import planning.exception.DaoException;
import planning.exception.ServiceException;
import planning.util.Utilitaire;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche service qui g�re la partie crud d'un �v�nement.
 * Permet de rediriger l'action dans la couche dao.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurServiceCrudEvenement {

	@EJB
	private IDao iDao;

	public void creerEvenement(Evenement evenement) throws ServiceException {
		if (evenement == null) {
			throw new ServiceException("ControleurServiceCrudEvenement creerEvenement : l'objet �v�nement � cr�er est null");
		}
		else if (!Utilitaire.isEntierPositifNonNull(evenement.getIdEvenement())) {
			throw new ServiceException("L'id de l'�v�nement est n�gatif ou nul");
		}else if (evenement.getPlanning() == null) {
			throw new ServiceException("Le planning est nul");
		} else if (evenement.getAction() == null) {
			throw new ServiceException("L'action est ou nul");
		} else if (evenement.getPlante() == null) {
			throw new ServiceException("la plante est nul");
		}
		try {
			iDao.creerEvenement(evenement);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		
		}
	}

	public void supprimerEvenement(int idEvenement) throws ServiceException {
		if (!Utilitaire.isEntierPositifNonNull(idEvenement)) {
			throw new ServiceException("ControleurServiceCrudEvenement supprimerEvenement : la valeur est n�gative ou nul");
		}
		try {
			iDao.supprimerEvenement(idEvenement);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudEvenement supprimerEvenement : Erreur de suppression d'evenement");
		}
	}
	
	public Evenement getEvenement(int idEvenement) throws ServiceException {
		if (!Utilitaire.isEntierPositifNonNull(idEvenement)) {
			throw new ServiceException("ControleurServiceCrudEvenement getEvenement : la valeur est n�gative ou nul");
		}
		try {
			return iDao.getEvenement(idEvenement);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudEvenement getEvenement : Erreur de recuperation evenement");
		}
	}

	public void modifierEvenement(Evenement evenement) throws ServiceException {
		if (evenement == null) {
			throw new ServiceException("ControleurServiceCrudEvenement modifierEvenement : l'objet �v�nement � cr�er est null");
		}
		else if (!Utilitaire.isEntierPositifNonNull(evenement.getIdEvenement())) {
			throw new ServiceException("L'id de l'�v�nement est n�gatif ou nul");
		}else if (evenement.getPlanning() == null) {
			throw new ServiceException("Le planning est nul");
		} else if (evenement.getAction() == null) {
			throw new ServiceException("L'action est ou nul");
		} else if (evenement.getPlante() == null) {
			throw new ServiceException("la plante est nul");
		}
		try {
			iDao.modifierEvenement(evenement);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceCrudEvenement modifierEvenement : Erreur de modification d'evenement");
		}
	}

}
