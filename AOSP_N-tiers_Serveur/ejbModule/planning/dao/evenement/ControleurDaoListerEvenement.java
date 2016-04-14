package planning.dao.evenement;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import planning.entity.Evenement;
import planning.exception.DaoException;
import planning.util.Utilitaire;



/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche dao qui gère la partie lister d'un évènement.
 * Utilise les accés à la couche persistance.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurDaoListerEvenement {

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;

	public ControleurDaoListerEvenement() {
	}
	
	public List<Evenement> getAllEvenement(int idPlanning) throws DaoException {
		System.out.println("query = em.createQuery 0000000000000000000000000000000");
		if (!Utilitaire.isEntierPositifNonNull(idPlanning)) {
			throw new DaoException("ControleurDaoListerEvenement getAllEvenement : la valeur est négative ou nul");
		}
		try {
//			TypedQuery<Evenement> query = em.createQuery("select e from Evenement e join e.idPlanning p where p.idPlanning = :idPlanning",Evenement.class);
			TypedQuery<Evenement> query = em.createQuery("select e from Evenement e where e.planning.idPlanning = :idPlanning",Evenement.class);
			System.out.println("query = em.createQuery 1111111111111111111111111111");
			query.setParameter("idPlanning", idPlanning);
			List<Evenement> evenements = query.getResultList();
			for (Evenement evenement : evenements) {
				System.out.println(evenement.getPlanning().getIdPlanning());
			}
			System.out.println(" XXXXXXXXXXXXXXXXXXXXXXXXXX   dans ControleurDaoListerEvenement getAllEvenement : dddddddddddddddddddd evenements : " + evenements);
			return evenements;			
		} catch (Exception e) {
			System.out.println("query = em.createQuery 22222222222222222222222222222222");
			throw new DaoException("ControleurDaoListerEvenement getAllEvenement : Erreur lors de la recherche de tous les évènements");
		}
	}

}
