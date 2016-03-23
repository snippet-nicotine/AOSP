package planning.dao.follower;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import planning.entity.Follower;
import planning.entity.Planning;
import planning.exception.DaoException;
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
public class ControleurDaoCrudFollower {

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;
	
	public ControleurDaoCrudFollower() {
	}
	
	public void addFollower(Follower follower) throws DaoException {
		if (follower == null) {
			throw new DaoException("ControleurDaoCrudFollower creerFollower : l'objet follower à créer est null");
		}
		else if (!Utilitaire.isEntierPositifNonNull(follower.getIdFollower())) {
			throw new DaoException("L'id du follower est négatif ou nul");
		}
		try {
			em.persist(follower);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudFollower creerFollower : Erreur de création d'un follower");
		}
	}
	
	public void delFollower(int idFollower) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idFollower)) 
			throw new DaoException("L'id du Follower est négatif ou nul");
		try {
			em.remove(getFollower(idFollower));
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudFollower supprimerFollower : Erreur de suppression d'un Follower");
		}
	}
	
	public Follower getFollower(int idFollower) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idFollower)) 
			throw new DaoException("L'id du Follower est négatif ou nul");
		try {
			return em.find(Follower.class, idFollower);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudFollower getFollower : Erreur sur la recherche d'un Follower");
		}
	}

	public void updateFollower(Follower follower) throws DaoException {
		if (follower == null) {
			throw new DaoException("ControleurDaoCrudFollower modifierFollower : l'objet Follower à créer est null");
		}
		else if (!Utilitaire.isEntierPositifNonNull(follower.getIdFollower())) {
			throw new DaoException("L'id du planning est négatif ou nul");
		}
		try {
			em.merge(follower);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudPlanning modifierPlanning : Erreur de modification d'un planning");
		}
	}

	public void createFollower(Follower follower) {
		// TODO Auto-generated method stub
		
	}
	
}
