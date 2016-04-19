package utilisateur.dao.lister;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import utilisateur.entity.DroitUtilisateur;
import utilisateur.entity.Specialite;
import utilisateur.entity.Utilisateur;
import utilisateur.util.Param;




@Stateless
@LocalBean
public class DaoListerUtilisateur {

	@PersistenceContext(unitName = Param.UNIT_NAME)
	EntityManager em;	



	@SuppressWarnings("unchecked")
	public List<Utilisateur> listerUtilisateurParId(){
		Query query = em.createQuery("select u from Utilisateur u order by u.idUtilisateur");
		return query.getResultList();		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Specialite> getListeSpecialite(){
		Query query = em.createQuery("select s from Specialite s order by s.libelle");
		
		return query.getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<DroitUtilisateur> getListeDroit(){
		Query query = em.createQuery("select d from DroitUtilisateur d order by d.libelle");
		
		return query.getResultList();		
	}

}
