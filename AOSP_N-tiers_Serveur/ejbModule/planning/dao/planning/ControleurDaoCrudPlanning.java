package planning.dao.planning;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import planning.entity.Evenement;
import planning.entity.Planning;
import planning.exception.DaoException;
import planning.fabrique.FactoryPlanifier;
import planning.util.Utilitaire;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche dao qui gère la partie crud d'un planning.
 * Utilise les accés à la couche persistance.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurDaoCrudPlanning {

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;
	
	@EJB
	FactoryPlanifier factoryPlanifier;
	
	public ControleurDaoCrudPlanning() {
	}
	
	public void addPlanning(Planning planning) throws DaoException {
		if (planning == null) {
			throw new DaoException("ControleurDaoCrudPlanning creerPlanning : l'objet planning à créer est null");
		}
		else if (!Utilitaire.isEntierPositifNonNull(planning.getIdPlanning())) {
			throw new DaoException("L'id du planning est négatif ou nul");
		}else if (planning.getCarre() == null) {
			throw new DaoException("L'id du carré est négatif ou nul");
		}
		try {
			em.persist(planning);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning creerPlanning : Erreur de création d'un planning");
		}
	}
	
	public void delPlanning(int idPlanning) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idPlanning)) 
			throw new DaoException("L'id du planning est négatif ou nul");
		try {
			em.remove(getPlanning(idPlanning));
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning supprimerPlanning : Erreur de suppression d'un planning");
		}
	}
	
	public Planning getPlanning(int idPlanning) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idPlanning)) 
			throw new DaoException("L'id du planning est négatif ou nul");
		try {
			return em.find(Planning.class, idPlanning);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning getPlanning : Erreur sur la recherche d'un planning");
		}
	}

	public void updatePlanning(Planning planning) throws DaoException {
		if (planning == null) {
			throw new DaoException("ControleurDaoCrudPlanning modifierPlanning : l'objet planning à créer est null");
		}
		else if (!Utilitaire.isEntierPositifNonNull(planning.getIdPlanning())) {
			throw new DaoException("L'id du planning est négatif ou nul");
		}else if (planning.getCarre() == null) {
			throw new DaoException("L'id du carré est négatif ou nul");
		}
		try {
			em.merge(planning);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning modifierPlanning : Erreur de modification d'un planning");
		}
	}
	
	public Planning createPlanning() throws DaoException {
		Planning Planning = null;
		return factoryPlanifier.creationPlanning();
	}
	
}
