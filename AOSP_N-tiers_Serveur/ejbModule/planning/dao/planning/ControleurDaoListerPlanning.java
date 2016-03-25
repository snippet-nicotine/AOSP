package planning.dao.planning;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
public class ControleurDaoListerPlanning {

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;

	public ControleurDaoListerPlanning() {
	}

	public List<Planning> getAllPlanning(int idCarre) throws DaoException {
//		System.out.println("*** dans ControleurDaoListerPlanning - idCarre : " + idCarre);
		if (!Utilitaire.isEntierPositifNonNull(idCarre)) {
			throw new DaoException("ControleurDaoListerPlanning rechercherAllPlanning : la valeur est négative ou nul");
		}	
		try {
			Query query = em.createQuery("select p from Planning p where p.idCarre = :idCarre",Planning.class);
			query.setParameter("idCarre", idCarre);
//			@SuppressWarnings("unchecked")
			List<Planning> plannings = (List<Planning>)query.getResultList();
			System.out.println("*** dans ControleurDaoListerPlanning - plannings : " + plannings);
			
			return 	plannings;		
		} catch (Exception e) {
			throw new DaoException("ControleurDaoListerPlanning rechercherAllPlanning : Erreur de recherche de la liste des plannings");
		}
	}

}
