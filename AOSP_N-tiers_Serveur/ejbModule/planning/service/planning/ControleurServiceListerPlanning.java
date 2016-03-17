package planning.service.planning;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import planning.dao.IDao;
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
public class ControleurServiceListerPlanning {

	@EJB
	private IDao iDao;

	public List<Planning> rechercherAllPlanning(int idCarre) throws ServiceException {
		System.out.println("dans ControleurServiceListerPlanning");
		try {
			return iDao.rechercherAllPlanning(idCarre);
		} catch (DaoException e) {
			throw new ServiceException("ControleurServiceListerPlanning rechercherAllPlanning : Erreur de recherche des plannings");
		}

	}
}
