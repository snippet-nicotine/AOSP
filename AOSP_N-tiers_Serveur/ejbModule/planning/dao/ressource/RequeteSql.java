package planning.dao.ressource;

public class RequeteSql {
	
	public final static String strNomDriver = "oracle.jdbc.driver.OracleDriver";
	public final static String dbURL ="jdbc:oracle:thin:stag13/stag13pw@junon:1521:AFPA";
	
//	public final static String strNomDriver = "oracle.jdbc.driver.OracleDriver";
//	public final static String dbURL ="jdbc:oracle:thin:didier/dolphy@localhost:1521:xe";

	public final static String INSERT_EVENEMENT =
	"insert into aosp_evenement (idevenement, idPlanning, idAction, idPlante, nutrition, dateEvenement, "
	+ "commentaireAuto, commentaire) "
	+ "values (?,?,?,?,?,?,?,?)";   
	
	public final static String UPDATE_EVENEMENT =
			"update aosp_evenement set idPlanning = ?, idAction = ?, idPlante = ?, "
			+ "nutrition = ?, dateEvenement = ?, commentaireAuto = ?, commentaire = ? "
			+ "where idevenement = ?";
	
	public final static String DELETE_EVENEMENT =
			"delete aosp_evenement where idevenement = ?";
	
	public final static String SELECT_ALL_EVENEMENT =
			"select idevenement, idPlanning, idAction, idPlante, nutrition, dareEvenement, commentaireAuto, commentaire "
			+ "from aosp_evenement, aosp_planning "
			+ "where aosp_evenement.idPlanning = aosp_parcelle.idPlanning "
			+ "order by idevenement";
	
//	public final static String SELECT_ALL__CARRE_DE_PARCELLE =
//			"select id_carre, aosp_carre_potager.id_parcelle, aosp_carre_potager.coord_x, aosp_carre_potager.coord_y, aosp_carre_potager.longueur, aosp_carre_potager.largeur, dt_creation, description "
//			+ "from aosp_carre_potager, aosp_parcelle "
//			+ "where aosp_carre_potager.id_parcelle = aosp_parcelle.id_parcelle and aosp_carre_potager.id_parcelle = ? "
//			+ "order by id_carre";
	
	public final static String SELECT_UN_EVENEMENT =
			"select idEvenement, idPlanning, idAction, idPlante, nutrition, dareEvenement, commentaireAuto, commentaire "
			+ "from aosp_evenement, aosp_planning "
			+ "where  idEvenement = ? "
			+ "and aosp_evenement.idPlanning = aosp_planning.idPlanning";
	
//	public final static String SELECT_ALL__PARCELLE =
//			"select id_parcelle, nom, coord_x, coord_y, longueur, largeur, id_terrain "
//			+ "from aosp_parcelle "
//			+ "order by nom";
//	
//	public final static String SELECT_UNE__PARCELLE =
//			"select id_parcelle, nom, coord_x, coord_y, longueur, largeur, id_terrain "
//			+ "from aosp_parcelle "
//			+ "where id_parcelle = ?";
//	
}


