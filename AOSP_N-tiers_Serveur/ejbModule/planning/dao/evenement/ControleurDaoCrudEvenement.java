package planning.dao.evenement;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import planning.entity.Evenement;
import planning.exception.DaoException;
import planning.util.Utilitaire;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche dao qui gère la partie crud d'un évènement.
 * Utilise les accés à la couche persistance.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurDaoCrudEvenement {

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;

	public ControleurDaoCrudEvenement() {
	}

	public void creerEvenement(Evenement evenement) throws DaoException {
		
		if (evenement == null) {
			throw new DaoException("ControleurDaoCrudEvenement creerEvenement : l'objet évènement à créer est null");
		}
		Evenement monEvenement = getEvenement(evenement.getIdEvenement());
		if ( !(monEvenement == null)) {
			throw new DaoException("ControleurDaoCrudEvenement creerEvenement : l'objet Existe déjà !!!");
		}else if (!Utilitaire.isEntierPositifNonNull(evenement.getIdEvenement())) {
			throw new DaoException("L'id de l'évènement est négatif ou nul");
		}else if (!Utilitaire.isEntierPositifNonNull(evenement.getIdPlanning())) {
			throw new DaoException("L'id du planning est négatif ou nul");
		} else if (!Utilitaire.isEntierPositifNonNull(evenement.getIdAction())) {
			throw new DaoException("L'id de l'action est négatif ou nul");
		} else if (!Utilitaire.isEntierPositifNonNull(evenement.getIdPlante())) {
			throw new DaoException("l'id de la plante est négatif ou nul");
		}
		try {
			em.persist(evenement);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudEvenement creerEvenement : Persistance : erreur de création d'un évènement");
		}

	}

	public void supprimerEvenement(int idEvenement) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idEvenement)) {
			throw new DaoException("ControleurDaoCrudEvenement supprimerEvenement : la valeur est négative ou nul");
		}
		try {
			em.remove(getEvenement(idEvenement));
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudEvenement supprimerEvenement : Erreur de suppression d'un évènement");
		}
	}

	public Evenement getEvenement(int idEvenement) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idEvenement)) {
			throw new DaoException("ControleurDaoCrudEvenement getEvenement : la valeur est négative ou nul");
		}
		try {
			return em.find(Evenement.class, idEvenement);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudEvenement getEvenement : Erreur de recherche d'un évènement");
		}
	}

	public void modifierEvenement(Evenement evenement) throws DaoException {
		if (evenement == null) {
			throw new DaoException("ControleurDaoCrudEvenement modifierEvenement : l'objet évènement à créer est null");
		}
		try {
			em.merge(evenement);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudEvenement modifierEvenement : Erreur de modification d'un évènement");
		}
	}

}
