package potager.service.controlleurs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import potager.dao.DaoGestionPotager;
import potager.dao.exception.DaoPotagerAjoutException;
import potager.dao.exception.DaoPotagerGetException;
import potager.dao.exception.DaoPotagerModificationException;
import potager.dao.exception.DaoPotagerQueryException;
import potager.dao.exception.DaoPotagerSuppressionException;
import potager.entity.Potager;
import potager.service.command.CommandeSupprimer;
import potager.service.command.Historique;
import potager.service.command.IUndoCommand;
import potager.service.exception.CPPotagerException;
import potager.service.exception.DimensionPotagerException;
import potager.service.exception.NomPotagerException;
import potager.service.exception.ProprietairePotagerException;
import potager.service.logic.PotagerManager;

@Stateful
@LocalBean
public class ControlleurPotager {
	
	@EJB
	DaoGestionPotager daoGestionPotager;
	@EJB
	Historique historique;
	@EJB
	PotagerManager potagerManager;
	
	// TODO: Refactorer dans PotagerManager
	public Potager ajouterPotager(Potager potager) 
			throws NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException, DaoPotagerAjoutException{
				
		potagerManager.buildPotager(potager);	
		return daoGestionPotager.ajouterPotager(potager);
						
	}
	
	public Potager modifierPotager(Potager potager) throws DaoPotagerModificationException, NomPotagerException, CPPotagerException, ProprietairePotagerException, DimensionPotagerException{
		
		potagerManager.buildPotager(potager);
		return daoGestionPotager.modifierPotager(potager);
		
	}
	
	public void supprimerPotager(int idPotager) throws DaoPotagerSuppressionException, DaoPotagerGetException {
		
		try {
			IUndoCommand supprimer = new CommandeSupprimer();
			supprimer.execute(idPotager);
			historique.ajouter( supprimer );
			
		} catch (DaoPotagerSuppressionException | DaoPotagerGetException e) {
			throw e;
		}
		
	}
	
	public List<Potager> listerPotager() throws DaoPotagerQueryException{
		
		return daoGestionPotager.listerPotager();
		
	}

	public Potager getPotager(int idPotager) throws DaoPotagerGetException {
		return daoGestionPotager.getPotager(idPotager);
	}
	
	public void annuler() throws DaoPotagerAjoutException, DaoPotagerModificationException{
		historique.annuler();
	}

	public int getNombreAnnulations() {
		return historique.getNbAnnulations();
	}

	public Potager getPotager() {
		return new Potager();
	}
	
}
