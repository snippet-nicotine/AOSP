package planning.dao.follower;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import planning.entity.Follower;
import planning.entity.Planning;
import planning.exception.DaoException;
import planning.util.Utilitaire;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche dao qui gère la partie lister d'un planning.
 * Utilise les accés à la couche persistance.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurDaoListerFollower {

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;

	public ControleurDaoListerFollower() {
	}

	public List<Follower> getAllFollower(int idPlanning) throws DaoException {
//		System.out.println("*** dans ControleurDaoListerFollower - planning : " + planning);
		if (!Utilitaire.isEntierPositifNonNull(idPlanning)) {
			throw new DaoException("ControleurDaoListerFollower rechercherAllFollower : la valeur est négative ou nul");
		}	
		try {
			Query query = em.createQuery("select f from Follower f where f.idPlanning = :idPlanning",Follower.class);
			query.setParameter("idPlanning", idPlanning);
//			@SuppressWarnings("unchecked")
			List<Follower> followers = (List<Follower>)query.getResultList();
			System.out.println("*** dans ControleurDaoListerFollower - followers : " + followers);
			
			return 	followers;		
		} catch (Exception e) {
			throw new DaoException("ControleurDaoListerFollower rechercherAllFollower : Erreur de recherche de la liste des followers");
		}
	}

}
