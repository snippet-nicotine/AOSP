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
	
	public List<Evenement> rechercherAllEvenement(int idPlanning) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idPlanning)) {
			throw new DaoException("ControleurDaoListerEvenement rechercherAllEvenement : la valeur est négative ou nul");
		}
		try {
			TypedQuery<Evenement> query = em.createQuery("select e from Evenement e where e.idPlanning = :idPlanning",Evenement.class);
			query.setParameter("idPlanning", idPlanning);
			List<Evenement> evenements = query.getResultList();
			return evenements;			
		} catch (Exception e) {
			throw new DaoException("ControleurDaoListerEvenement rechercherAllEvenement : Erreur lors de la recherche de tous les évènements");
		}
	}

}
