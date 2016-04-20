package potager.service.controlleurs;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import potager.dao.Dao;
import potager.dao.exception.DaoPotagerAjoutException;
import potager.entity.Carre;

@Stateless
@LocalBean
public class ControlleurCarre {
	
	@EJB
	Dao daoGestionPotager;

	public Carre creerCarre(Carre carre) throws DaoPotagerAjoutException {
		
		return daoGestionPotager.creerCarre(carre);
		
	}

}
