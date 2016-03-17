package planning.dao;

import java.util.List;

import planning.entity.Evenement;
import planning.entity.Planning;
import planning.exception.DaoException;

/**
 * Interface de la couche dao qui permet de définir l'ensemble
 * méthodes utilisées dans cette couche.
 * @author Didier
 *
 */
public interface IDao {

	public void creerPlanning(Planning planning) throws DaoException;
	public void supprimerPlanning(int idPlanning) throws DaoException;
	public void modifierPlanning(Planning planning) throws DaoException;
	public List<Planning> rechercherAllPlanning(int idCarre) throws DaoException;
	public Planning getPlanning(int idPlanning) throws DaoException;
	
	public void creerEvenement(Evenement evenement) throws DaoException;
	public void supprimerEvenement(int idEvenement) throws DaoException;
	public void modifierEvenement(Evenement evenement) throws DaoException;
	public List<Evenement> rechercherAllEvenement(int idPlanning) throws DaoException;
	public Evenement getEvenement(int idEvenement) throws DaoException;
	
}
