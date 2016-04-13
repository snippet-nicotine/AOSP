package planning.dao.evenement;

import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import commun.config.ActionEvenement;
import planning.entity.Evenement;
import planning.entity.Nutrition;
import planning.entity.Planning;
import planning.entity.Plante;
import planning.exception.DaoException;
import planning.fabrique.FactoryPlanifier;
import planning.util.Utilitaire;

/**
 * EJB session bean de type Stateless, LocalBean : Controleur de
 * la couche dao qui g�re la partie crud d'un �v�nement.
 * Utilise les acc�s � la couche persistance.
 * @author Didier
 *
 */
@Stateless
@LocalBean
public class ControleurDaoCrudEvenement {

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;
	
	@EJB
	FactoryPlanifier factoryPlanifier;

	public ControleurDaoCrudEvenement() {
	}

	public void addEvenement(Evenement evenement) throws DaoException {
		
		if (evenement == null) {
			throw new DaoException("ControleurDaoCrudEvenement creerEvenement : l'objet �v�nement � cr�er est null");
		}
		Evenement monEvenement = getEvenement(evenement.getIdEvenement());
		if ( !(monEvenement == null)) {
			throw new DaoException("ControleurDaoCrudEvenement creerEvenement : l'objet Existe d�j� !!!");
		}else if (!Utilitaire.isEntierPositifNonNull(evenement.getIdEvenement())) {
			throw new DaoException("L'id de l'�v�nement est n�gatif ou nul");
		}else if (evenement.getPlanning() == null) {
			throw new DaoException("Pas de planning  !! c'est trop nul...");
		} else if (evenement.getAction() == null) {
			throw new DaoException("Pad d'action !!! c'est louche...");
		} else if (evenement.getPlante() == null) {
			throw new DaoException("Pas de plante !!! c'est space...");
		}
		try {
			em.persist(evenement);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudEvenement creerEvenement : Persistance : erreur de cr�ation d'un �v�nement");
		}

	}

	public void delEvenement(int idEvenement) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idEvenement)) {
			throw new DaoException("ControleurDaoCrudEvenement supprimerEvenement : la valeur est n�gative ou nul");
		}
		try {
			em.remove(getEvenement(idEvenement));
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudEvenement supprimerEvenement : Erreur de suppression d'un �v�nement");
		}
	}

	public Evenement getEvenement(int idEvenement) throws DaoException {
		if (!Utilitaire.isEntierPositifNonNull(idEvenement)) {
			throw new DaoException("ControleurDaoCrudEvenement getEvenement : la valeur est n�gative ou nul");
		}
		try {
			return em.find(Evenement.class, idEvenement);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudEvenement getEvenement : Erreur de recherche d'un �v�nement");
		}
	}

	public void updateEvenement(Evenement evenement) throws DaoException {
		if (evenement == null) {
			throw new DaoException("ControleurDaoCrudEvenement modifierEvenement : l'objet �v�nement � cr�er est null");
		}
		try {
			em.merge(evenement);
		} catch (Exception e) {
			throw new DaoException("ControleurDaoCrudEvenement modifierEvenement : Erreur de modification d'un �v�nement");
		}
	}
	
	public Evenement createEvenement(Planning planning) throws DaoException {
		Evenement evenement = null;
		return factoryPlanifier.creationEvenement(planning);
	}

	public Evenement createEvenement(Planning planning, ActionEvenement action, Plante plante, Nutrition nutrition,
			LocalDate localDate, String comAuto, String com) {
		Evenement evenement = null;
		return factoryPlanifier.creationEvenement(planning, action, plante, nutrition, localDate, comAuto, com);
	}

}
