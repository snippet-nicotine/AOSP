package potager.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerModificationException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.dao.exception.DaoPotagerSuppressionException;

/**
 * @author Nicolas Lambert
 * 
 * Classe de gestion Dao generique.
 * Permet de créer / modifier / supprimer n'importe quel type d'entité
 * TODO: Trouver un moyen de récupérer la classe du type générique pour permettre de faire un <E>.class
 *
 * J'ai crée cette classe pour faciliter la création des dao en réutilisant au maximum le code ( principe du DRY )
 *
 * @param <E> E doit de préference être de type Entity
 */

abstract public class AbastractDao<E> implements Crud<E>{

	@PersistenceContext(unitName="AOSP_Hibernate")
	EntityManager em;

	/**
	 * 
	 * @param entity
	 * @return
	 * @throws DaoPotagerAjoutException si l'instance existe dejà, n'est pas valide, ou problème de transaction
	 */
	@Override
	public E create(E entity) throws DaoPotagerAjoutException  {
		
		try{
			em.persist(entity);
			em.flush();
			
			return entity; 
		}
		catch(EntityExistsException e){
			e.printStackTrace();
			throw new DaoPotagerAjoutException( "L'instance à ajouter existe dejà." );
		}
		catch(IllegalArgumentException e){
			throw new DaoPotagerAjoutException( "L'instance à ajouter n'est pas valide." );
		}
		catch(TransactionRequiredException e){
			throw new DaoPotagerAjoutException( "Un problème de transaction est survenue.Veuillez reesayer dans quelques minutes." );
		}	
		
	}

	@Override
	abstract public E read(int id) throws DaoPotagerGetException;

	@Override
	public E update(E entity) throws DaoPotagerModificationException {
		
		try{
			em.merge(entity);	
			em.flush();	
		}
		catch(IllegalArgumentException  e){
			throw new DaoPotagerModificationException( "L'instance à modifier n'est pas valide, ou a été supprimée." );
		}
		catch(TransactionRequiredException e){
			throw new DaoPotagerModificationException( "Un problème de transaction est survenue.Veuillez reesayer dans quelques minutes." );
		}
		
		return entity;
	}

	@Override
	public void delete(int id) throws DaoPotagerSuppressionException  {
		
		try{
			em.remove( read(id) );
			
		}
		catch(IllegalArgumentException  e){
			throw new DaoPotagerSuppressionException( "L'instance à supprimer n'existe pas." );
		}
		catch(TransactionRequiredException e){
			throw new DaoPotagerSuppressionException( "Un problème de transaction est survenue.Veuillez reesayer dans quelques minutes." );
		}
		catch(DaoPotagerGetException e){
			throw new DaoPotagerSuppressionException( "L'instance est déjà supprimée" );
		}
		
	}

	@Override
	abstract public List<E> lister() throws DaoPotagerQueryException;
	

}
