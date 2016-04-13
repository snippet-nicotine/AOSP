package planning.service.follower;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.dao.IDao;
import planning.entity.Follower;
import planning.entity.Planning;
import planning.exception.DaoException;
import planning.exception.ServiceException;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche service qui gère la partie lister d'un planning.
 * Permet de rediriger l'action dans la couche dao.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurServiceListerFollower {

	@EJB
	private IDao iDao;

	public List<Follower> rechercherAllFollower(int idPlanning) throws ServiceException {
		System.out.println("dans ControleurServiceListerFollower");
		try {
			return iDao.rechercherAllFollower(idPlanning);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceListerFollower rechercherAllFollower : Erreur de recherche des Followers");
		}

	}
}
