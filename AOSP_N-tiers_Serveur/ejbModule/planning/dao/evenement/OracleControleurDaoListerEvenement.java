package planning.dao.evenement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;

import planning.dao.ressource.AccesBdd;
import planning.dao.ressource.RequeteSql;
import planning.entity.Evenement;
import planning.entity.Nutrition;
import planning.exception.DaoException;

/**
 * Ne sert pas pour l'instant
 * @author Didier
 *
 */
public class OracleControleurDaoListerEvenement {

	/**
	 * Initialisation de la base
	 */
	public void init() {
		AccesBdd connect    = new AccesBdd();
	}

	public ArrayList<Evenement> rechercherAllEvenement(int idPlanning) throws DaoException {
		ArrayList<Evenement> evenements    = new ArrayList<Evenement>();
		AccesBdd connect = new AccesBdd();
		if      ( idPlanning == 0)
			throw new DaoException("DaoCarrePotager : listAllCarresDeParcelle :l'id  de la parcelle est à 0");
		else {				
			String sql       = RequeteSql.SELECT_ALL_EVENEMENT;
			PreparedStatement ps = connect.getPreparedStatement(sql);

			try {
				ps.setInt(1,idPlanning);

				ResultSet rs = (ResultSet) connect.executeQuery(ps);	

				while (rs.next()) {
					int idEvenement = rs.getInt(1);
					//	int idPlanning = rs.getInt(2);
					int idAction = rs.getInt(3);
					int idPlante = rs.getInt(4);
					int n = rs.getInt(5);
					int p = rs.getInt(6);
					int k = rs.getInt(7);
					LocalDate dtCreation = rs.getDate(8).toLocalDate();
					String commentaireAuto = rs.getString(9);
					String commentaire = rs.getString(10);

					Nutrition nutrition = new Nutrition(n, p, k);
					Evenement evenement = new Evenement(idEvenement, idPlanning,
							idAction, idPlante, nutrition, dtCreation, commentaireAuto, commentaire );
					evenements.add(evenement);
				}

			} catch (SQLException e) {
				new DaoException("ControleurDaoListerEvenement rechercherAllEvenement : erreur ...");
			}

			connect.close();
			connect = null;
			return evenements;
		}
	}
	public Evenement getEvenement(int idEvenement) throws DaoException {
		Evenement evenement = null;

		if      ( idEvenement == 0) 		throw new DaoException("L'id de l'évènement est 0 ! pas bien !");
		else {				
			String sql       = RequeteSql.SELECT_UN_EVENEMENT;
			AccesBdd connect = new AccesBdd();
			PreparedStatement ps = connect.getPreparedStatement(sql);

			try {
				ps.setInt(1,idEvenement);
				ResultSet rs = connect.executeQuery(ps);
				rs.next();
				int idPlanning = rs.getInt(2);
				int idAction = rs.getInt(3);
				int idPlante = rs.getInt(4);
				int n = rs.getInt(5);
				int p = rs.getInt(6);
				int k = rs.getInt(7);
				LocalDate dtCreation = rs.getDate(8).toLocalDate();
				String commentaireAuto = rs.getString(9);
				String commentaire = rs.getString(10);
				

				Nutrition nutrition = new Nutrition(n, p, k);
				evenement = new Evenement(idEvenement, idPlanning, idAction, idPlante, nutrition, dtCreation, commentaireAuto, commentaire);
		
			} catch (SQLIntegrityConstraintViolationException e) {
				throw new DaoException("Cet identifiant existe déjà");
			} catch (SQLException e) {
				System.out.println("DaoCarrePotager : erreur getUnCarre()");
				e.printStackTrace();
			}

			connect.close();
			connect = null;
		}
		return evenement;
	}

}
