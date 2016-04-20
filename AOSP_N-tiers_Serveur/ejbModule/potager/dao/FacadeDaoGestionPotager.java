package potager.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerModificationException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.dao.exception.DaoPotagerSuppressionException;
import potager.entity.Carre;
import potager.entity.Potager;
import utilisateur.entity.Jardinier;

@Stateless
@Remote(Dao.class)
public class FacadeDaoGestionPotager implements Dao{
	
	@EJB
	DaoPotager daoPotager;
	
	@EJB
	DaoCarre daoCarre;

	@Override
	public Potager ajouterPotager(Potager potager) throws DaoPotagerAjoutException {
		return daoPotager.create(potager);		
	}
	
	@Override
	public Potager getPotager(int idPotager) throws DaoPotagerGetException {
		return daoPotager.read(idPotager);
	}

	@Override
	public Potager modifierPotager(Potager potager) throws DaoPotagerModificationException {
		return daoPotager.update(potager);
	}

	@Override
	public void supprimerPotager(int idPotager) throws DaoPotagerSuppressionException, DaoPotagerGetException {
		daoPotager.delete(idPotager);
		
	}

	@Override
	public List<Potager> listerPotager() throws DaoPotagerQueryException {
		return daoPotager.lister();
	}

	@Override
	public List<Potager> listerPotager(Jardinier proprietaire) throws DaoPotagerQueryException {
		return daoPotager.lister(proprietaire);
	}

	@Override
	public List<Potager> listerPotager(String codePostal) throws DaoPotagerQueryException {
		return daoPotager.lister(codePostal);
	}

	@Override
	public Carre creerCarre(Carre carre) throws DaoPotagerAjoutException {
		return daoCarre.create(carre);
	}

	



}
