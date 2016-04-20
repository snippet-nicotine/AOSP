package potager.dao;

import java.util.List;

/**
 * 
 * @author Nicolas Lambert
 * 
 * Définie les méthodes de base d'un crud 
 *
 * @param <E>
 */
public interface Crud<E> {

	
	public E create(E entity)  throws Exception;
	public E read(int id)      throws Exception; 
	public E update(E entity)  throws Exception;
	public void delete(int id) throws Exception;
	
	public List<E> lister() throws Exception;
	
}
