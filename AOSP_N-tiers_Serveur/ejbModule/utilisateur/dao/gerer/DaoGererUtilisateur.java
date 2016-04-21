package utilisateur.dao.gerer;



import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import utilisateur.dao.lister.DaoListerUtilisateur;
import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;
import utilisateur.exception.NonTrouveDAOException;
import utilisateur.util.Param;

@Stateless
@LocalBean

public class DaoGererUtilisateur {

	@EJB
	DaoListerUtilisateur daoLister;

	@PersistenceContext(unitName = Param.UNIT_NAME)
	EntityManager em;

	public void ajouterUtilisateur(Utilisateur utilisateur){

		em.persist(utilisateur);
		em.flush();

	}

	public void modifierUtilisateur(Utilisateur utilisateur){
		em.merge(utilisateur);
	}

	public void supprimerUtilisateur(Utilisateur utilisateur){
		em.remove(em.contains(utilisateur)? utilisateur : em.merge(utilisateur));		
	}

	public Utilisateur rechercherParIdUtilisateur(int idUtilisateur) throws NonTrouveDAOException{
		Utilisateur utilisateur = null;
		
		utilisateur = em.find(Utilisateur.class, idUtilisateur);
		if(utilisateur==null) throw new NonTrouveDAOException("Id non trouvée");
		
		return utilisateur;

	}
	
	public void ajouterSpecialite(Specialite specialite){

		em.persist(specialite);
		em.flush();

	}

	public void modifierSpecialite(Specialite specialite){
		em.merge(specialite);
		em.flush();
	}

	public void supprimerSpecialite(Specialite specialite){
		em.remove(em.contains(specialite)? specialite : em.merge(specialite));
	}

	public Specialite rechercherParIdSpecialite(int idSpecialite){
		Specialite specialite = null;

		specialite = em.find(Specialite.class, idSpecialite);
		return specialite;

	}
	
	public void ajouterDroitUtilisateur(DroitUtilisateur droitUtilisateur){

		em.persist(droitUtilisateur);
		em.flush();

	}

	public void modifierDroitUtilisateur(DroitUtilisateur droitUtilisateur){
		em.merge(droitUtilisateur);
	}

	public void supprimerDroitUtilisateur(DroitUtilisateur droitUtilisateur){		
		em.remove(em.contains(droitUtilisateur)? droitUtilisateur : em.merge(droitUtilisateur));		
	}
	
	public DroitUtilisateur rechercherParIdDroit(int idDroit){
		DroitUtilisateur droitUtilisateur = null;

		droitUtilisateur = em.find(DroitUtilisateur.class, idDroit);
		return droitUtilisateur;

	}
	
	

	

}
