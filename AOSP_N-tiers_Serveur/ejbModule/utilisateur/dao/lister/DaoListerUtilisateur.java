package utilisateur.dao.lister;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import utilisateur.entity.Utilisateur;




@Stateless
@LocalBean
public class DaoListerUtilisateur {

	@PersistenceContext(unitName = "AOSP_Hibernate")
	EntityManager em;	

//	@SuppressWarnings("unchecked")
//	public List<Utilisateur> listerParTitre(){	
//		List<Utilisateur> liste;
//		Query query = em.createQuery("select d from  Utilisateur d order by ??????");
//		liste = query.getResultList();	
//		Hibernate.initialize(liste);
//		return liste;
//	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> listerUtilisateurParId(){
		Query query = em.createQuery("select u from Utilisateur u order by u.idUtilisateur");
		return query.getResultList();		
	}

//	@SuppressWarnings("unchecked")
//	public List<Auteur> listerAuteur(){
//		Query query = em.createQuery("select a from Auteur a order by a.nom");
//		return query.getResultList();
//	}

//	public Auteur trouveAuteur(int idAuteur){
//		return em.find(Auteur.class,idAuteur);
//	}

//	@SuppressWarnings("unchecked")
//	public List<Theme> listerTheme(){
//		Query query = em.createQuery("select t from Theme t order by t.libelleTheme");
//		return query.getResultList();
//	}



}
