package planning.dao;

import java.time.LocalDate;
import java.util.List;

import commun.config.ActionEvenement;
import planning.entity.Evenement;
import planning.entity.Follower;
import planning.entity.Nutrition;
import planning.entity.Planning;
import planning.entity.Plante;
import planning.exception.DaoException;
import potager.entity.Carre;

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
	public Planning creationPlanning(Carre carre) throws DaoException;
	
	public void creerEvenement(Evenement evenement) throws DaoException;
	public void supprimerEvenement(int idEvenement) throws DaoException;
	public void modifierEvenement(Evenement evenement) throws DaoException;
	public List<Evenement> rechercherAllEvenement(int idPlanning) throws DaoException;
	public Evenement getEvenement(int idEvenement) throws DaoException;
	public Evenement creationEvenement(Planning planning) throws DaoException;
	public Evenement creationEvenement(Planning planning, ActionEvenement action, Plante plante,
			Nutrition nutrition, LocalDate localDate, String comAuto, String com) throws DaoException;
	
	public void creerFollower(Follower follower) throws DaoException;
	public void supprimerFollower(int idFollower) throws DaoException;
	public Follower getFollower(int idFollower) throws DaoException;
	public void modifierFollower(Follower follower) throws DaoException;
	public List<Follower> rechercherAllFollower(int idPlanning) throws DaoException;
	public Follower creationFollower(String nom, String prenom) throws DaoException;
}
