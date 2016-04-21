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
 * Classe implémentant la création d'un jeu d'essai
 * @author Afpa
 *
 */
@Stateless
@LocalBean
public class DaoJeuEssai {

	@PersistenceContext(unitName = Param.UNIT_NAME)
	EntityManager em;

	@EJB
	DaoListerUtilisateur daoLister;		// EJB qui permet de lister les droits et les spécialités

	/**
	 * Méthode qui crée un jeu d'essai
	 */
	public void creerJeuEssai(){

		//		Query query = em.createQuery("delete from Utilisateur");
		//		query.executeUpdate();

		// on crée les spécialités
		em.persist(new Specialite("Plantes"));
		em.persist(new Specialite("Fruits"));
		em.persist(new Specialite("Engrais"));
		em.persist(new Specialite("Arrosage"));
		em.persist(new Specialite("Ensoleillement"));

		// on crée les droits utilisateur
		em.persist(new DroitUtilisateur("Créer"));
		em.persist(new DroitUtilisateur("Modifier"));
		em.persist(new DroitUtilisateur("Supprimer"));
		em.persist(new DroitUtilisateur("Lister"));		

		em.flush();

		// On récupère la liste des droits et la liste des spécialités
		Collection<DroitUtilisateur> listeDroit = daoLister.getListeDroit();
		List<Specialite> listeSpecialite = daoLister.getListeSpecialite();
		
		// on crée un administrateur avec tous les droits
		em.persist(new Administrateur(new EtatCivil("nom 1","prénom 1"), "mail 1", "pass 1", listeDroit));

		// on crée un jardinier avec tous les droits
		em.persist(new Jardinier(new EtatCivil("nom 2","prénom 2"), "mail 2", "pass 2", listeDroit,"13014"));

		// on crée un spécialiste avec tous les droits et la spécialite Engrais
		em.persist(new Specialiste(new EtatCivil("nom 3","prénom 3"), "mail 3", "pass 3", listeDroit,"13015",
				listeSpecialite.get(1)));

		// on supprime tous les droits sauf 1
		listeDroit.remove(3);
		listeDroit.remove(2);
		listeDroit.remove(1);

		// on crée un administrateur avec 1 droit
		em.persist(new Administrateur(new EtatCivil("nom 4","prénom 4"), "mail 4", "pass 4", listeDroit));

		// on crée un jardinier avec aucun droit
		em.persist(new Jardinier(new EtatCivil("nom 5","prénom 5"), "mail 5", "pass 5", null,"13016"));

		// on crée un spécialiste avec 1 droit et aucune spécialite
		em.persist(new Specialiste(new EtatCivil("nom 6","prénom 6"), "mail 6", "pass 6", listeDroit,"13001", null));
		em.flush();
	}

}
