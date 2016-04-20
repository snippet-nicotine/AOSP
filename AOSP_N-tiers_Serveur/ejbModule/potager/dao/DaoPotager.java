package potager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerModificationException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.dao.exception.DaoPotagerSuppressionException;
import potager.entity.Potager;
import utilisateur.entity.Jardinier;

@Stateless
@LocalBean
public class DaoPotager{
	
	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;

	/**
	 * 
	 * @param potager
	 * @return
	 * @throws DaoPotagerAjoutException si le potager existe dej�, n'est pas valide, ou probl�me de transaction
	 */
	public Potager ajouterPotager(Potager potager) throws DaoPotagerAjoutException {
		
		try{
			em.persist(potager);
			em.flush();
			
			return potager; 
		}
		catch(EntityExistsException e){
			e.printStackTrace();
			throw new DaoPotagerAjoutException( "Le potager � ajouter existe dej�." );
		}
		catch(IllegalArgumentException e){
			throw new DaoPotagerAjoutException( "L'instance � ajouter n'est pas un potager valide." );
		}
		catch(TransactionRequiredException e){
			throw new DaoPotagerAjoutException( "Un probl�me de transction est survenue.Veuillez reesayer dans quellques minutes." );
		}	
		
	}

	/**
	 * 
	 * @param potager
	 * @return
	 * @throws DaoPotagerModificationException si le potager n'est pas valide, ou en cas de probl�me de transaction
	 */
	public Potager modifierPotager(Potager potager) throws DaoPotagerModificationException {
		
		try{
			em.merge(potager);	
			em.flush();	
		}
		catch(IllegalArgumentException  e){
			throw new DaoPotagerModificationException( "Le potager � modifier n'est pas valide, ou a �t� supprim�." );
		}
		catch(TransactionRequiredException e){
			throw new DaoPotagerModificationException( "Un probl�me de transction est survenue.Veuillez reesayer dans quellques minutes." );
		}
		
		
		return potager;
		
	}

	/**
	 * 
	 * @param idPotager
	 * @throws DaoPotagerSuppressionException
	 * @throws DaoPotagerGetException 
	 */
	public void supprimerPotager(int idPotager) throws DaoPotagerSuppressionException{
		
		try{
			em.remove( getPotager(idPotager) );
			
		}
		catch(IllegalArgumentException  e){
			throw new DaoPotagerSuppressionException( "Le potager � supprimer n'existe pas." );
		}
		catch(TransactionRequiredException e){
			throw new DaoPotagerSuppressionException( "Un probl�me de transaction est survenue.Veuillez reesayer dans quellques minutes." );
		}
		catch(DaoPotagerGetException e){
			throw new DaoPotagerSuppressionException( "Le potager est d�j� supprim�" );
		}
		
	}
	
	/**
	 * 
	 * @param potager
	 * @throws DaoPotagerSuppressionException
	 * @throws DaoPotagerGetException 
	 */
	public void supprimerPotager(Potager potager) throws DaoPotagerSuppressionException, DaoPotagerGetException{
		
		try{
			em.remove( potager );		
		}
		catch(IllegalArgumentException  e){
			throw new DaoPotagerSuppressionException( "Le potager � supprimer n'existe pas." );
		}
		catch(TransactionRequiredException e){
			throw new DaoPotagerSuppressionException( "Un probl�me de transaction est survenue.Veuillez reesayer dans quellques minutes." );
		}		
		
	}

	/**
	 * Renvoie une List de potager ordonn�e par id
	 * @return
	 * @throws DaoPotagerQueryException si la requ�te n'est pas valide
	 */
	public List<Potager> listerPotager() throws DaoPotagerQueryException {

		try{
			ArrayList<Potager> potagers = (ArrayList<Potager>) em.createQuery("SELECT p FROM Potager p ORDER BY p.nom").getResultList();
			
			return potagers;	

		}
		catch(IllegalArgumentException e){
			throw new DaoPotagerQueryException("La requ�te: " + "SELECT p FROM Potager p ORDER BY p.idPotager" + " n'est pas valide");
		}
	}

	public List<Potager> listerPotager(Jardinier proprietaire) throws DaoPotagerQueryException {
		try{
			
			ArrayList<Potager> potagers = (ArrayList<Potager>) em.createQuery("SELECT p FROM Potager p WHERE p.proprietaire.idUtilisateur=:idProprio  ORDER BY p.nom ")
					.setParameter("idProprio", proprietaire.getIdUtilisateur() )
					.getResultList();			
			
			return potagers;	

		}
		catch(IllegalArgumentException e){
			throw new DaoPotagerQueryException("La requ�te: " + "SELECT p FROM Potager p ORDER BY p.idPotager" + " n'est pas valide");
		}
	}

	public List<Potager> listerPotager(String codePostal) throws DaoPotagerQueryException {
			
		try{
			
			ArrayList<Potager> potagers = (ArrayList<Potager>) em.createQuery("SELECT p FROM Potager p WHERE p.codePostal=:codePostal  ORDER BY p.nom ")
					.setParameter("codePostal", codePostal )
					.getResultList();			
			
			return potagers;	

		}
		catch(IllegalArgumentException e){
			throw new DaoPotagerQueryException("La requ�te: " + "SELECT p FROM Potager p ORDER BY p.idPotager" + " n'est pas valide");
		}
	}
	
	public Potager getPotager(int idPotager) throws DaoPotagerGetException {
		
		try{
			Potager potager = em.find(Potager.class, idPotager);
			
			if(potager == null) throw new DaoPotagerGetException("Impossible de trouver le potager demand�.");
			
			return potager;
		}
		catch(IllegalArgumentException  e){
			throw new DaoPotagerGetException("Impossible de trouver le potager demand�.");
		}
	}
		

}
