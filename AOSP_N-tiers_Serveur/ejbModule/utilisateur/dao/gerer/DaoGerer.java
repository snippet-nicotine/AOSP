package utilisateur.dao.gerer;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import utilisateur.dao.lister.DaoLister;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;

@Stateless
@LocalBean

public class DaoGerer {
	
	@EJB
	DaoLister daoLister;

	@PersistenceContext(unitName = "AOSP_Hibernate")
	EntityManager em;

	public void ajouter(Utilisateur utilisateur){

		em.persist(utilisateur);
		em.flush();

	}

	public void modifier(Utilisateur utilisateur){
		em.merge(utilisateur);
	}

	public void supprimer(Utilisateur utilisateur){
		em.remove(em.contains(utilisateur)? utilisateur : em.merge(utilisateur));
	}

	public void ajouterSpecialite(Specialite specialite){

		em.persist(specialite);
		em.flush();

	}

	public void modifierSpecialite(Specialite specialite){
		em.merge(specialite);
		em.flush();
	}

//	public void supprimerAuteur(Specialite specialite){
//		List<Utilisateur> listeUtilisateur = daoLister.listerParTitre();
//		for(Utilisateur utilisateur : listeUtilisateur) if(utilisateur.getAuteur()!=null && utilisateur.getAuteur().getIdAuteur()==auteur.getIdAuteur())
//			utilisateur.set(null);
//		em.remove(em.contains(specialite)? specialite : em.merge(specialite));
//		em.flush();
//		
//		
//	}
//	
//	public void addTheme(Theme theme){
//		em.persist(theme);
//		em.flush();
//	}
//	
//	public void modifierTheme(Theme theme){
//		em.merge(theme);
//		em.flush();
//	}
//	
//	public void deleteTheme(Theme theme){
//		em.remove(em.contains(theme)? theme : em.merge(theme));
//	}

}
