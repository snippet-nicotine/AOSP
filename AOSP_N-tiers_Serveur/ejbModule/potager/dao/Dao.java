package potager.dao;

import java.util.List;

import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerModificationException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.dao.exception.DaoPotagerSuppressionException;
import potager.entity.Carre;
import potager.entity.Potager;
import utilisateur.entity.Jardinier;


public interface Dao {
	
	// Potager
	public Potager ajouterPotager(Potager potager) throws DaoPotagerAjoutException;
	public Potager getPotager(int idPotager) throws DaoPotagerGetException;
	public Potager modifierPotager(Potager potager) throws DaoPotagerModificationException;
	public void    supprimerPotager(int idPotager) throws DaoPotagerSuppressionException, DaoPotagerGetException;
	
	public List<Potager> listerPotager() throws DaoPotagerQueryException;
	public List<Potager> listerPotager(Jardinier proprietaire) throws DaoPotagerQueryException;
	public List<Potager> listerPotager(String codePostal) throws DaoPotagerQueryException;
	
	// Carre
	public Carre creerCarre(Carre carre) throws DaoPotagerAjoutException;
	
	
	
	
}
