package potager.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.entity.Carre;
import potager.entity.Potager;

@Singleton
@LocalBean
public class DaoCarre extends AbastractDao<Carre>{

	@Override
	public Carre read(int id) throws DaoPotagerGetException {
		
		try{
			Carre carre = em.find(Carre.class, id);
			
			if(carre == null) throw new DaoPotagerGetException("Impossible de trouver le carré demandé.");
			
			return carre;
		}
		catch(IllegalArgumentException  e){
			throw new DaoPotagerGetException("Impossible de trouver le carré demandé.");
		}
		
	}

	@Override
	public List<Carre> lister() throws DaoPotagerQueryException {
		// TODO Auto-generated method stub
		return null;
	}

		
	
}
