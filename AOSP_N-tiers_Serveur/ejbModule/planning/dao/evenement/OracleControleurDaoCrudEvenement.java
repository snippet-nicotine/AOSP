package planning.dao.evenement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import planning.dao.ressource.AccesBdd;
import planning.dao.ressource.RequeteSql;
import planning.entity.Evenement;
import planning.exception.DaoException;

/**
 * Ne sert pas pour l'instant
 * @author Didier
 *
 */
public class OracleControleurDaoCrudEvenement {

	/**
	 * Initialisation de la base
	 */
	public void init() {
		AccesBdd connect    = new AccesBdd();
	}

	public void creerEvenement(Evenement evenement) throws DaoException {
		if      ( evenement == null)
			throw new DaoException("CreerEvenement : L'evenement est null");
		else {				
			String sql       = RequeteSql.INSERT_EVENEMENT;
			AccesBdd connect = new AccesBdd();
			PreparedStatement ps = connect.getPreparedStatement(sql);

			try {
				ps.setInt(1,evenement.getIdEvenement());
				ps.setInt(2,evenement.getIdPlanning());
				ps.setInt(3,evenement.getIdAction());
				ps.setInt(4,evenement.getIdPlante());
				ps.setInt(5,evenement.getNutrition().getN());
				ps.setInt(6,evenement.getNutrition().getP());
				ps.setInt(7,evenement.getNutrition().getK());
				ps.setDate(8, java.sql.Date.valueOf(evenement.getDateEvenement()));
				ps.setString(9,evenement.getCommentaireAuto());
				ps.setString(10,evenement.getCommentaire());

				connect.executeUpdate(ps);

			} catch (SQLIntegrityConstraintViolationException e) {
				throw new DaoException("Cet identifiant existe déjà");
			} catch (SQLException e) {
				throw new DaoException("ControleurDaoCrudEvenement creerEvenement : erreur creerEvenement");
			}

			connect.close();
			connect = null;
		}

	}
	
	public void supprimerEvenement(int idEvenement) throws DaoException {
		if      ( idEvenement == 0) 		throw new DaoException("supprimerEvenement : Pas d'annulation : id à 0");
		else {				
			String sql       = RequeteSql.DELETE_EVENEMENT;
			AccesBdd connect = new AccesBdd();
			PreparedStatement ps = connect.getPreparedStatement(sql);

			try {
				ps.setInt(1,idEvenement);

				connect.executeUpdate(ps);

			} catch (SQLIntegrityConstraintViolationException e) {
				throw new DaoException("Cet identifiant existe déjà");
			} catch (SQLException e) {
				throw new DaoException("ControleurDaoCrudEvenement supprimerEvenement : erreur annulation evenement)");
			}

			connect.close();
			connect = null;
		}
	}
	
	public void modifierEvenement(Evenement evenement) throws DaoException {
		if      ( evenement == null)
			throw new DaoException("modifierEvenement : L'evenement est null");
		else {				
			String sql       = RequeteSql.UPDATE_EVENEMENT;
			AccesBdd connect = new AccesBdd();
			PreparedStatement ps = connect.getPreparedStatement(sql);

			try {
				ps.setInt(1,evenement.getIdEvenement());
				ps.setInt(2,evenement.getIdPlanning());
				ps.setInt(3,evenement.getIdAction());
				ps.setInt(4,evenement.getIdPlante());
				ps.setInt(5,evenement.getNutrition().getN());
				ps.setInt(6,evenement.getNutrition().getP());
				ps.setInt(7,evenement.getNutrition().getK());
				ps.setDate(8, java.sql.Date.valueOf(evenement.getDateEvenement()));
				ps.setString(9,evenement.getCommentaireAuto());
				ps.setString(10,evenement.getCommentaire());

				connect.executeUpdate(ps);

			} catch (SQLIntegrityConstraintViolationException e) {
				throw new DaoException("Cet identifiant existe déjà");
			} catch (SQLException e) {
				throw new DaoException("ControleurDaoCrudEvenement modifierEvenement : erreur creerEvenement");
			}

			connect.close();
			connect = null;
		}
	
	}

}
