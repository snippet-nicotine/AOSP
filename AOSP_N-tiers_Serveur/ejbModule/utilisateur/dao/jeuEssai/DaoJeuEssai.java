package utilisateur.dao.jeuEssai;

import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utilisateur.dao.lister.DaoListerUtilisateur;
import utilisateur.entity.Administrateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.EtatCivil;
import utilisateur.entity.Jardinier;
import utilisateur.entity.Specialiste;
import utilisateur.entity.Specialite;

import utilisateur.util.Param;


/**
 * Classe impl�mentant la cr�ation d'un jeu d'essai
 * @author Afpa
 *
 */
@Stateless
@LocalBean
public class DaoJeuEssai {

	@PersistenceContext(unitName = Param.UNIT_NAME)
	EntityManager em;

	@EJB
	DaoListerUtilisateur daoLister;		// EJB qui permet de lister les droits et les sp�cialit�s

	/**
	 * M�thode qui cr�e un jeu d'essai
	 */
	public void creerJeuEssai(){

		//		Query query = em.createQuery("delete from Utilisateur");
		//		query.executeUpdate();

		// on cr�e les sp�cialit�s
		em.persist(new Specialite("Plantes"));
		em.persist(new Specialite("Fruits"));
		em.persist(new Specialite("Engrais"));
		em.persist(new Specialite("Arrosage"));
		em.persist(new Specialite("Ensoleillement"));

		// on cr�e les droits utilisateur
		em.persist(new DroitUtilisateur("Cr�er"));
		em.persist(new DroitUtilisateur("Modifier"));
		em.persist(new DroitUtilisateur("Supprimer"));
		em.persist(new DroitUtilisateur("Lister"));		

		em.flush();

		// On r�cup�re la liste des droits et la liste des sp�cialit�s
		Collection<DroitUtilisateur> listeDroit = daoLister.getListeDroit();
		List<Specialite> listeSpecialite = daoLister.getListeSpecialite();
		
		// on cr�e un administrateur avec tous les droits
		em.persist(new Administrateur(new EtatCivil("nom 1","pr�nom 1"), "mail 1", "pass 1", listeDroit));

		// on cr�e un jardinier avec tous les droits
		em.persist(new Jardinier(new EtatCivil("nom 2","pr�nom 2"), "mail 2", "pass 2", listeDroit,"13014"));

		// on cr�e un sp�cialiste avec tous les droits et la sp�cialite Engrais
		em.persist(new Specialiste(new EtatCivil("nom 3","pr�nom 3"), "mail 3", "pass 3", listeDroit,"13015",
				listeSpecialite.get(1)));

		// on supprime tous les droits sauf 1
		listeDroit.remove(3);
		listeDroit.remove(2);
		listeDroit.remove(1);

		// on cr�e un administrateur avec 1 droit
		em.persist(new Administrateur(new EtatCivil("nom 4","pr�nom 4"), "mail 4", "pass 4", listeDroit));

		// on cr�e un jardinier avec aucun droit
		em.persist(new Jardinier(new EtatCivil("nom 5","pr�nom 5"), "mail 5", "pass 5", null,"13016"));

		// on cr�e un sp�cialiste avec 1 droit et aucune sp�cialite
		em.persist(new Specialiste(new EtatCivil("nom 6","pr�nom 6"), "mail 6", "pass 6", listeDroit,"13001", null));
		em.flush();
	}

}
