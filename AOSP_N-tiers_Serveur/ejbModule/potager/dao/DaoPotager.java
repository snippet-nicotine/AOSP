package potager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.entity.Potager;
import utilisateur.entity.Jardinier;

@Singleton
@LocalBean
public class DaoPotager extends AbastractDao<Potager>{
	
	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;
	
	
	@Override
	public Potager read(int idPotager) throws DaoPotagerGetException {
		
		try{
			Potager potager = em.find(Potager.class, idPotager);
			
			if(potager == null) throw new DaoPotagerGetException("Impossible de trouver le potager demandé.");
			
			return potager;
		}
		catch(IllegalArgumentException  e){
			throw new DaoPotagerGetException("Impossible de trouver le potager demandé.");
		}
	}

	/**
	 * Renvoie une List de potager ordonnée par id
	 * @return
	 * @throws DaoPotagerQueryException si la requête n'est pas valide
	 */
	@Override
	public List<Potager> lister() throws DaoPotagerQueryException {

		try{
			ArrayList<Potager> potagers = (ArrayList<Potager>) em.createQuery("SELECT p FROM Potager p ORDER BY p.nom").getResultList();
			
			return potagers;	

		}
		catch(IllegalArgumentException e){
			throw new DaoPotagerQueryException("La requête: " + "SELECT p FROM Potager p ORDER BY p.idPotager" + " n'est pas valide");
		}
	}

	public List<Potager> lister(Jardinier proprietaire) throws DaoPotagerQueryException {
		try{
			
			ArrayList<Potager> potagers = (ArrayList<Potager>) em.createQuery("SELECT p FROM Potager p WHERE p.proprietaire.idUtilisateur=:idProprio  ORDER BY p.nom ")
					.setParameter("idProprio", proprietaire.getIdUtilisateur() )
					.getResultList();			
			
			return potagers;	

		}
		catch(IllegalArgumentException e){
			throw new DaoPotagerQueryException("La requête: " + "SELECT p FROM Potager p ORDER BY p.idPotager" + " n'est pas valide");
		}
	}

	public List<Potager> lister(String codePostal) throws DaoPotagerQueryException {
			
		try{
			
			ArrayList<Potager> potagers = (ArrayList<Potager>) em.createQuery("SELECT p FROM Potager p WHERE p.codePostal=:codePostal  ORDER BY p.nom ")
					.setParameter("codePostal", codePostal )
					.getResultList();			
			
			return potagers;	

		}
		catch(IllegalArgumentException e){
			throw new DaoPotagerQueryException("La requête: " + "SELECT p FROM Potager p ORDER BY p.idPotager" + " n'est pas valide");
		}
	}

}
